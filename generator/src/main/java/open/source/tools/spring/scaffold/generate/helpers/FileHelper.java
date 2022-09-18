package open.source.tools.spring.scaffold.generate.helpers;

import open.source.tools.spring.scaffold.generate.Generator;
import open.source.tools.spring.scaffold.generate.validators.GenerateValidator;

import java.io.IOException;


public abstract class FileHelper extends Generator {

    public abstract String operationGenerate(String javaStrings, String nameClass, String parameters);

    private GenerateValidator validatorGenerate = new GenerateValidator();

    @Override
    public boolean generate(String nameClass, String parameters, String fileNameTemplate) throws IOException {
        if (validatorGenerate.validate(nameClass, parameters, getLayer())) {
            String javaStrings = readTemplateFile(fileNameTemplate);
            String newStrings = operationGenerate(javaStrings, nameClass, parameters);
            outPutFile(newStrings, nameClass);
            return true;
        }
        return false;
    }

    public void generateConfig(String filename, String pathTemplate) throws IOException {
        if (validatorGenerate.validate(filename, null, getLayer())) {
            String javaStrings = readConfigTemplate(pathTemplate);
            String newStrings = operationGenerate(javaStrings, null, null);
            outPutFile(newStrings, filename);
        }

    }

}
