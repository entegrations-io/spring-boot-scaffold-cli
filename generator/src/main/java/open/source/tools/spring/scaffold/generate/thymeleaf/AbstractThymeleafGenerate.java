package open.source.tools.spring.scaffold.generate.thymeleaf;

import open.source.tools.spring.scaffold.generate.helpers.ScaffoldInfoHelper;
import org.springframework.util.StringUtils;



public abstract class AbstractThymeleafGenerate extends ScaffoldInfoHelper {
	
	private static final String TABS_INDEX = "					";
	private static final String TABS_FORM = "				";
	private static final String TABS_VIEW = "		";

	public String generateThParameters(String parameters) {
		String [] params = parameters.split(" ");
		String thParameters = "";
		
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			thParameters += TABS_INDEX + "<th>" + StringUtils.capitalize(nameAndType[0]) + "</th> \n";
		}

		thParameters += TABS_INDEX + "<th>Actions</th>";
		return thParameters;
	}
	
	
	
	public String generateTdParameters(String className, String parameters) {
		String [] params = parameters.split(" ");
		String tdParameters = "";
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			tdParameters += TABS_INDEX + "<td th:text=\"${" + className.toLowerCase() + "." + nameAndType[0] + "}\"></td> \n";
		}
		
		tdParameters += TABS_INDEX + "<td>\n";
		tdParameters += TABS_INDEX + "		<a th:href=\"@{/"+ className.toLowerCase() + "s/{id}(id = " + "${" + className.toLowerCase() + ".id}" + ")}\" class=\"btn btn-secondary\" title=\"View\"><i class=\"far fa-eye\"></i></a> \n";
		tdParameters += TABS_INDEX + " 		<a th:href=\"@{/"+ className.toLowerCase() + "s/{id}/edit(id = " + "${" + className.toLowerCase() + ".id}" + ")}\" class=\"btn btn-primary\" title=\"Edit\"><i class=\"fas fa-edit\"></i></a> \n";
		tdParameters += TABS_INDEX + "		<a href=\"#\" data-action=\"delete\" th:data-item-action-url=\"@{/"+ className.toLowerCase() + "s/{id}(id = " + "${" + className.toLowerCase() + ".id}" + ")}\"  th:data-item-success-url=\"@{/"+ className.toLowerCase() + "s/}\" data-confirm=\"Are you sure, to delete this record?\" class=\"btn btn-danger\" title=\"Delete\"><i class=\"far fa-trash-alt\"></i></a> \n";
		tdParameters += TABS_INDEX + "</td>";
		return tdParameters;
	}

	public String generateInputParameters(String parameters) {
		String inputParameters = "";
		String [] params = parameters.split(" ");
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			
			inputParameters += TABS_FORM + "<div class=\"form-group\"> \n";
			inputParameters += TABS_FORM + "	<label for=\""+ nameAndType[0] +"\">"+ StringUtils.capitalize(nameAndType[0]) +"</label>  \n";
			inputParameters += TABS_FORM + "	<input id=\""+ nameAndType[0] +"\" name=\"" + nameAndType[0] + "\" type=\"text\" class=\"form-control\" th:field=\"*{"+ nameAndType[0] +"}\" />  \n";
			inputParameters += TABS_FORM + "</div> \n";
		}
		
		return inputParameters;
	}
	
	public String generateViewParameters(String paramClassName, String parameters) {
		String inputParameters = "";
		String [] params = parameters.split(" ");
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			inputParameters += TABS_VIEW + "<div class=\"mb-3 row\"> \n";
			inputParameters += TABS_VIEW + "	<label for=\""+ nameAndType[0] +"\" class=\"col-sm-2 col-form-label\">"+ StringUtils.capitalize(nameAndType[0]) +": </label>  \n";
			inputParameters += TABS_VIEW + "	<div class=\"col-sm-10\"> \n";
			inputParameters += TABS_VIEW + "        <input type=\"text\" readonly class=\"form-control-plaintext\" th:id=\""+ nameAndType[0] +"\" th:value=\"${" + paramClassName + "." + nameAndType[0] + "}\"> \n";
			inputParameters += TABS_VIEW + "	</div> \n";
			inputParameters += TABS_VIEW + "</div> \n";
		}
		return inputParameters;
	}
	
	
}
