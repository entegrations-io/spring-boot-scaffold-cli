package open.source.tools.spring.scaffold.command.model;

import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;

public class ModelCommand extends OptionParsingCommand {

	public ModelCommand(String name, String description, OptionHandler handler) {
		super(name, description, handler);
	}

	@Override
	public String getUsageHelp() {
		return "<entity> <attributes>";
	}
}
