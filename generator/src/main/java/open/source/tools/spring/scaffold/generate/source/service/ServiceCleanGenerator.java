package open.source.tools.spring.scaffold.generate.source.service;

import java.io.IOException;

import open.source.tools.spring.scaffold.generate.Layers;
import open.source.tools.spring.scaffold.generate.helpers.FileHelper;

public class ServiceCleanGenerator extends FileHelper {

	@Override
	public String getLayer() {
		return Layers.SERVICE;
	}

	@Override
	public String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${className}", nameClass);
	}

	public static void main(String[] args) throws IOException {
		new ServiceCleanGenerator().generate("User", null, "template-clean-service.txt");
	}
	
}

