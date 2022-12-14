package open.source.tools.spring.scaffold.templates.config.jms_aws_sqs;

import open.source.tools.spring.scaffold.generator.core.Generator;
import open.source.tools.spring.scaffold.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class ProducerMessageGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public ProducerMessageGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    public File runGenerate() throws IOException {
        this.generatorOptions.setTemplatePath("/templates/config/template-producer-message.txt");
        this.generatorOptions.setName("ProducerMessage.java");
        return generate(this.generatorOptions);
    }

}
