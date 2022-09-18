package open.source.tools.spring.scaffold.generate.test;

import open.source.tools.spring.scaffold.generate.Layers;
import open.source.tools.spring.scaffold.generate.source.service.ServiceGenerator;
import open.source.tools.spring.scaffold.generate.utils.LoadTemplateHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ServiceGenerateTest {

    @Test
    public void shouldGeneratorService() throws IOException {
        ServiceGenerator serviceGenerator = new ServiceGenerator();
        String javaStrings = serviceGenerator.readTemplateFile("template-service.txt");

        String expectedValue = new LoadTemplateHelper().loadDataset(Layers.SERVICE, "UserService.txt");
        String generatedValue = serviceGenerator.operationGenerate(javaStrings, "User", "name:String");

        assertEquals(expectedValue, generatedValue);
    }

}
