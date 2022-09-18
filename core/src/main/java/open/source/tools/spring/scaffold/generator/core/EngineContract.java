package open.source.tools.spring.scaffold.generator.core;

import java.util.Map;

public interface EngineContract {

    String replaceValues(String contentTemplate, Map<String, String> keyValues);
}
