package open.source.tools.spring.scaffold.templates.config.jms_aws_sqs;

import open.source.tools.spring.scaffold.generator.core.GeneratorOptions;
import open.source.tools.spring.scaffold.templates.helper.LoadTemplateTester;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ProducerMessageGeneratorTest {

    private LoadTemplateTester loadTemplateTester;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File temporaryPath;

    @Before
    public void setUp() throws IOException {
        temporaryPath = temporaryFolder.newFolder("test-templates");
        loadTemplateTester = new LoadTemplateTester();
    }

    @Test
    public void shouldCreateFile() throws IOException {
        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());

        HashMap<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("${package}", "open.source.tools.spring.example");
        generatorOptions.setKeyValue(keyValue);

        ProducerMessageGenerator messageListenerGenerator = new ProducerMessageGenerator(generatorOptions);
        File file = messageListenerGenerator.runGenerate();
        assertTrue(file.exists());
    }

    @Test
    public void shouldReturnContent() throws IOException {
        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());

        HashMap<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("${package}", "open.source.tools.spring.example");
        generatorOptions.setKeyValue(keyValue);

        ProducerMessageGenerator messageListenerGenerator = new ProducerMessageGenerator(generatorOptions);
        File file = messageListenerGenerator.runGenerate();

        String contentReturned = FileUtils.readFileToString(file);
        String contentExpected = loadTemplateTester.loadTemplate("/templates/config/template-producer-message-test.txt");

        assertEquals(contentExpected, contentReturned);
    }

}