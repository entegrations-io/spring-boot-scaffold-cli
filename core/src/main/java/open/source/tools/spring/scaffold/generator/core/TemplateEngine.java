package open.source.tools.spring.scaffold.generator.core;

import open.source.tools.spring.scaffold.generator.core.exceptions.TemplateEngineException;

import java.util.Map;

public class TemplateEngine implements EngineContract {

    @Override
    public String replaceValues(final String contentTemplateIn, final Map<String, String> keyValues) {
        String contentTemplate = contentTemplateIn;
        if (contentTemplate == null) throw new TemplateEngineException("contentTemplate can not be null");
        if (keyValues == null) return contentTemplate;

        for (final Map.Entry<String, String> pair : keyValues.entrySet()) {
            if (contentTemplate.contains(pair.getKey()))
                contentTemplate = contentTemplate.replace(pair.getKey(), pair.getValue());
        }

        return contentTemplate;
    }

}
