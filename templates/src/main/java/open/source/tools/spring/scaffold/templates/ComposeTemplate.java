package open.source.tools.spring.scaffold.templates;


import open.source.tools.spring.scaffold.generator.core.Generator;

import java.io.IOException;
import java.util.List;

public class ComposeTemplate {

    public static void runAll(String pathPackage, List<Generator> generators) throws IOException {
        for (Generator generator : generators) {
            generator.runGenerate();
        }
    }

}
