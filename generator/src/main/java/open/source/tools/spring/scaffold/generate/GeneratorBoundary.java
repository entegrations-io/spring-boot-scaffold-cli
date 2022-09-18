package open.source.tools.spring.scaffold.generate;

import java.io.IOException;

public interface GeneratorBoundary {

	boolean generate(String nameClass, String parameters, String fileNameTemplate) throws IOException;
	
	String getLayer();
}
