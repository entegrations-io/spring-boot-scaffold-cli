package open.source.tools.spring.scaffold.generate.test;

import open.source.tools.spring.scaffold.generate.Layers;
import open.source.tools.spring.scaffold.generate.source.repository.RepositoryGenerator;
import open.source.tools.spring.scaffold.generate.utils.LoadTemplateHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RepositoryGenerateTest {

    @Test
    public void repositoryGeneratorTest() throws IOException {
        RepositoryGenerator repositoryGenerator = new RepositoryGenerator();
        String javaStrings = repositoryGenerator.readTemplateFile("template-repository.txt");

        String expectedValue = new LoadTemplateHelper().loadDataset(Layers.REPOSITORY, "UserRepository.txt");
        String generatedValue = repositoryGenerator.operationGenerate(javaStrings, "User", "name:String");

        assertEquals(expectedValue, generatedValue);
    }

}
