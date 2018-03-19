module Embulk
  module Guess

    # TODO implement guess plugin to make this command work:
    #      $ embulk guess -g "lzo" partial-config.yml

    # class Lzo < GuessPlugin
    #   Plugin.register_guess("lzo", self)
    #
    #   FOO_BAR_HEADER = "\x1f\x8b".force_encoding('ASCII-8BIT').freeze
    #
    #   def guess(config, sample_buffer)
    #     if sample_buffer[0,2] == FOO_BAR_HEADER
    #       return {"decoders" => [{"type" => "lzo"}]}
    #     end
    #     return {}
    #   end
    # end

  end
end
