package org.embulk.decoder.lzo;

import java.io.InputStream;
import java.io.IOException;

import com.google.common.base.Optional;

import org.embulk.config.Config;
import org.embulk.config.ConfigDefault;
import org.embulk.config.ConfigInject;
import org.embulk.config.ConfigSource;
import org.embulk.config.Task;
import org.embulk.config.TaskSource;
import org.embulk.spi.BufferAllocator;
import org.embulk.spi.DecoderPlugin;
import org.embulk.spi.FileInput;
import org.embulk.spi.util.FileInputInputStream;
import org.embulk.spi.util.InputStreamFileInput;

import org.anarres.lzo.LzopInputStream;

public class LzoDecoderPlugin
        implements DecoderPlugin
{
    public interface PluginTask
            extends Task
    {
        @ConfigInject
        public BufferAllocator getBufferAllocator();
    }

    @Override
    public void transaction(ConfigSource config, DecoderPlugin.Control control)
    {
        PluginTask task = config.loadConfig(PluginTask.class);

        control.run(task.dump());
    }

    @Override
    public FileInput open(TaskSource taskSource, FileInput fileInput)
    {
        final PluginTask task = taskSource.loadTask(PluginTask.class);


        // Write your code here :)
        //throw new UnsupportedOperationException("LzoDecoderPlugin.open method is not implemented yet");

        // If expect InputStream, you can use this code:

        final FileInputInputStream files = new FileInputInputStream(fileInput);
        
        return new InputStreamFileInput(
               task.getBufferAllocator(),
               new InputStreamFileInput.Provider() {
                   public InputStream openNext() throws IOException
                   {
                       if (!files.nextFile()) {
                           return null;
                       }
                       return LzoDecoderInputStream(task, files);
                   }
        
                   public void close() throws IOException
                   {
                       files.close();
                   }
               });
    }

    private static InputStream LzoDecoderInputStream(PluginTask task, InputStream file) throws IOException
    {
	LzopInputStream stream = new LzopInputStream(file);
	return stream;
    }
}
