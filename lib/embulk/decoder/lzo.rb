Embulk::JavaPlugin.register_decoder(
  "lzo", "org.embulk.decoder.lzo.LzoDecoderPlugin",
  File.expand_path('../../../../classpath', __FILE__))
