package open.source.tools.spring.scaffold.generate.source.repository;

import java.io.IOException;

import open.source.tools.spring.scaffold.generate.Layers;
import open.source.tools.spring.scaffold.generate.helpers.FileHelper;

public class RepositoryCleanGenerator extends FileHelper {

	@Override
	public String getLayer() {
		return Layers.REPOSITORY;
	}

	@Override
	public String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".repository")
				.replace("${className}", nameClass);
	}
	
	public static void main(String[] args) throws IOException {
		new RepositoryCleanGenerator().generate("User", null, "template-clean-repository.txt");
	}
	
}
