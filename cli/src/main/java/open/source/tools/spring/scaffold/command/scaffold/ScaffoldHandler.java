package open.source.tools.spring.scaffold.command.scaffold;

import java.io.IOException;
import java.util.Arrays;

import open.source.tools.spring.scaffold.generate.source.controller.ControllerGenerator;
import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import open.source.tools.spring.scaffold.generate.source.model.ModelGenerator;
import open.source.tools.spring.scaffold.generate.source.repository.RepositoryGenerator;
import open.source.tools.spring.scaffold.generate.source.service.ServiceGenerator;
import open.source.tools.spring.scaffold.generate.thymeleaf.ThymeleafGenerator;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;


public class ScaffoldHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;

	@SuppressWarnings("unused")
	private OptionSpec<String> parametersEntity;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> language;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate scaffold").withRequiredArg();
		this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate scaffold").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String parametersClass = (String) options.valueOf("p");
		generateJava(nameClass.trim(), parametersClass);
		return ExitStatus.OK;
	}

	private void generateJava(String nameClass, String parametersClass) throws IOException {
		generateScaffoldJava(nameClass, parametersClass);
	}
	
	private void generateScaffoldJava(String nameClass, String parametersClass) throws IOException {
		try {
			if (new ModelGenerator().generate(nameClass, parametersClass, "template-model.txt")) {
				new RepositoryGenerator().generate(nameClass, null, "template-repository.txt");
				new ServiceGenerator().generate(nameClass, null, "template-service.txt");
				new ControllerGenerator().generate(nameClass, null, "template-controller.txt");
				new ThymeleafGenerator(nameClass, parametersClass);
				//new Migrations().create(nameClass, parametersClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
