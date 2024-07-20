package utilitiesCommon.pkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path = ".//src//main//resources//config.properties";
	
	public ReadConfig() throws IOException {
		
		properties = new Properties();
		FileInputStream  fis = new FileInputStream(path);
		properties.load(fis);
	}
	
	public String GetBrowser() {
		
		String browname = properties.getProperty("browser");
		if(browname!=null) {
			return browname;
		}else {
			throw new RuntimeException("Browser not found");
		}
	}

}
