package open.source.tools.spring.scaffold.generate.source.controller;

import java.io.IOException;

import open.source.tools.spring.scaffold.generate.Layers;
import open.source.tools.spring.scaffold.generate.helpers.FileHelper;

public class ControllerCleanGenerator extends FileHelper {

	@Override
	public String getLayer() {
		return Layers.CONTROLLER;
	}

	@Override
	public String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".controller")
				.replace("${path}", nameClass.toLowerCase())
				.replace("${className}", nameClass);
	}
	
	public static void main(String[] args) throws IOException {
		new ControllerCleanGenerator().generate("Credential", null, "template-clean-controller.txt");
	}
	
}
