package open.source.tools.spring.scaffold.templates.entity;

import open.source.tools.spring.scaffold.generator.core.Generator;
import open.source.tools.spring.scaffold.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class EntityGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public EntityGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    @Override
    public File runGenerate() throws IOException {
        this.generatorOptions.setTemplatePath("/templates.entity/entity-template.txt");
        return generate(this.generatorOptions);
    }
}
