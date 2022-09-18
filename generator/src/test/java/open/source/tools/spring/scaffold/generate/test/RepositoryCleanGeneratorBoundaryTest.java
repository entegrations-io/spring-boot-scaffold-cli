package open.source.tools.spring.scaffold.generate.test;

import open.source.tools.spring.scaffold.generate.Layers;
import open.source.tools.spring.scaffold.generate.utils.LoadTemplateHelper;
import open.source.tools.spring.scaffold.generate.source.repository.RepositoryCleanGenerator;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RepositoryCleanGeneratorBoundaryTest {

	@Test
	public void shouldGenerateRepository() throws IOException {
		RepositoryCleanGenerator repositoryGenerator = new RepositoryCleanGenerator();
		String javaStrings = repositoryGenerator.readTemplateFile("template-clean-repository.txt");

		String expectedValue = new LoadTemplateHelper().loadDataset(Layers.REPOSITORY,"UserCleanRepository.txt");
		String generatedValue = repositoryGenerator.operationGenerate(javaStrings, "User", "name:String");

		assertEquals(expectedValue, generatedValue);
	}

}
