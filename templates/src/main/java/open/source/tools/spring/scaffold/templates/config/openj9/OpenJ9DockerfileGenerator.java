package open.source.tools.spring.scaffold.templates.config.openj9;

import open.source.tools.spring.scaffold.generator.core.Generator;
import open.source.tools.spring.scaffold.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class OpenJ9DockerfileGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public OpenJ9DockerfileGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    @Override
    public File runGenerate() throws IOException {
        this.generatorOptions.setTemplatePath("/templates/config/openj9/dockerfile-template.txt");
        this.generatorOptions.setName("Dockerfile");
        return generate(this.generatorOptions);
    }

}
