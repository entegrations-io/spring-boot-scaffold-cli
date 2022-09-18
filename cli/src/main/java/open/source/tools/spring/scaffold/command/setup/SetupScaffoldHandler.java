package open.source.tools.spring.scaffold.command.setup;

import open.source.tools.spring.scaffold.generate.resources.GeneratorProperties;
import open.source.tools.spring.scaffold.generate.setup.SetupGenerator;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import java.util.Arrays;


public class SetupScaffoldHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> namePackage;

	@SuppressWarnings("unused")
	private OptionSpec<String> dataBase;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> userDatabase;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> passwordDatabase;

	@SuppressWarnings("unused")
	private OptionSpec<String> springVersion;
	
	@Override
	protected void options() {
		this.namePackage = option(Arrays.asList("namePackage", "n"), "name of package to create scaffolds").withOptionalArg();
		this.dataBase = option(Arrays.asList("dataBaseName", "d"), "name of database").withOptionalArg();
		this.userDatabase = option(Arrays.asList("userDatabase", "u"), "username database for migrates").withOptionalArg();
		this.passwordDatabase = option(Arrays.asList("passwordDatabase", "p"), "password database for migrates").withOptionalArg();
		this.springVersion = option(Arrays.asList("springVersion", "s"), "spring version: 2.x").withOptionalArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String namePackage = (String) options.valueOf("n");
		String nameDataBase = (String) options.valueOf("d");
		String userNameDatabase = (String) options.valueOf("u");
		String passwordDatabase = (String) options.valueOf("p");
		String springVersion = (String) options.valueOf("s");
		
		namePackage = namePackage != null ? namePackage.trim() : namePackage;
		nameDataBase = nameDataBase != null ? nameDataBase.trim() : nameDataBase;
		userNameDatabase = userNameDatabase != null ? userNameDatabase.trim() : userNameDatabase;
		passwordDatabase = passwordDatabase != null ? passwordDatabase.trim() : passwordDatabase;
		springVersion = springVersion != null ? springVersion.trim() : springVersion;

		new SetupGenerator(namePackage, nameDataBase, userNameDatabase, passwordDatabase, springVersion);
		new GeneratorProperties();

		return ExitStatus.OK;
	}
	
}
