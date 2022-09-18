package open.source.tools.spring.scaffold.generate.setup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import open.source.tools.spring.scaffold.generate.helpers.ScaffoldInfoHelper;


public class SetupGenerator extends ScaffoldInfoHelper {

	public SetupGenerator(String...params) {
		generate(params);
	}

	public void generate(String... params) {
		PrintWriter writer = null;
		try {
			File file = new File(getUserDir() + "/src/main/resources/scaffold.info");
			file.getParentFile().mkdirs();
			writer = new PrintWriter(file, "UTF-8");
			String namePackage = params[0] != null ? params[0] : "open.source.tools.spring.example";
			String dataBaseName = params[1] != null ? params[1] : "mydb";
			String userDataBase = params[2] != null ? params[2] : "root";
			String passWordDatabase = params[3] != null ? params[3] : "root";
			String springVersion = params[4] != null ? params[4] : "2.x";
			writer.println("package:" + namePackage);
			writer.println("dataBaseName:" + dataBaseName);
			writer.println("username:" + userDataBase);
			writer.println("password:" + passWordDatabase);
			writer.println("springVersion:" + springVersion);
			writer.close();
			System.out.println("create /src/main/resources/scaffold.info");
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		}
	}

	public boolean validateFile(String nameFile) {
		File f = new File(getUserDir() + "/src/main/resources/scaffold.info");
		if(f.exists()) { 
			System.out.println("scaffold.info already exists!");
			return false;
		} else {
			return true;
		}
	}
}
