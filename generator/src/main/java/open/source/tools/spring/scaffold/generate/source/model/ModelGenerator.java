package open.source.tools.spring.scaffold.generate.source.model;

import open.source.tools.spring.scaffold.generate.Layers;
import open.source.tools.spring.scaffold.generate.helpers.FileHelper;
import open.source.tools.spring.scaffold.generate.helpers.ModelGenerateHelper;


public class ModelGenerator extends FileHelper {
	
	@Override
	public String getLayer() {
		return Layers.MODEL;
	}

	@Override
	public String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".model")
				.replace("${imports}", ModelGenerateHelper.generateImports(parameters))
				.replace("${className}", nameClass)
				.replace("${name_table}", nameClass.toLowerCase() + "s")
				.replace("${parameters}", generateParams(parameters))
				.replace("${getters}", ModelGenerateHelper.generateGettersAndSetters(parameters));
	}
	
	public String generateParams(String params) {
		String[] variablesSplits = params.split(" ");
		String finalParameters = "";
		for (int i = 0; i < variablesSplits.length; i++) {

			String [] typeAndNameVars = variablesSplits[i].split(":");

			String column = "    @Column(name = \"" + typeAndNameVars[0] + "\")";
			String lineVariables = "    private " + typeAndNameVars[1] + " " + typeAndNameVars[0] + ";";
			String lineClean = "\n";

			finalParameters += lineClean;
			finalParameters += column;
			finalParameters += lineClean;
			finalParameters += lineVariables;
			finalParameters += lineClean;
		}
		return finalParameters;
	}

}
