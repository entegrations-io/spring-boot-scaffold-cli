package open.source.tools.spring.scaffold.command;

import open.source.tools.spring.scaffold.command.controller.ControllerCommand;
import open.source.tools.spring.scaffold.command.controller.ControllerHandler;
import open.source.tools.spring.scaffold.command.repository.RepositoryCommand;
import open.source.tools.spring.scaffold.command.repository.RepositoryHandler;
import open.source.tools.spring.scaffold.command.template.TemplateCommand;
import open.source.tools.spring.scaffold.command.template.TemplateHandler;
import open.source.tools.spring.scaffold.command.model.ModelCommand;
import open.source.tools.spring.scaffold.command.model.ModelHandler;
import open.source.tools.spring.scaffold.command.scaffold.ScaffoldCommand;
import open.source.tools.spring.scaffold.command.scaffold.ScaffoldHandler;
import open.source.tools.spring.scaffold.command.service.ServiceCommand;
import open.source.tools.spring.scaffold.command.service.ServiceHandler;
import open.source.tools.spring.scaffold.command.setup.SetupScaffoldCommand;
import open.source.tools.spring.scaffold.command.setup.SetupScaffoldHandler;
import open.source.tools.spring.scaffold.generate.helpers.ScaffoldInfoHelper;
import org.springframework.boot.cli.command.Command;
import org.springframework.boot.cli.command.CommandFactory;

import java.util.Arrays;
import java.util.Collection;


public class ScaffoldFactoryCommands implements CommandFactory {

    public Collection<Command> getCommands() {
        ScaffoldInfoHelper scaffoldInfoHelper = new ScaffoldInfoHelper();
        return Arrays.<Command>asList(
                new ModelCommand("model", "generate entities", new ModelHandler(scaffoldInfoHelper)),
                new RepositoryCommand("repository", "generate repositories", new RepositoryHandler()),
                new ServiceCommand("service", "generate services", new ServiceHandler()),
                new ControllerCommand("controller", "generate controllers", new ControllerHandler()),
                new ScaffoldCommand("scaffold", "generate api scaffold", new ScaffoldHandler()),
                new SetupScaffoldCommand("setup:scaffold", "setup scaffold", new SetupScaffoldHandler()),
                new TemplateCommand("template", "generate setup project", new TemplateHandler(scaffoldInfoHelper)));
    }

}
