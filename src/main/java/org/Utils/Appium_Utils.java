package org.Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class Appium_Utils {
	
	public  AppiumDriverLocalService server;

	public AppiumDriverLocalService startAppiumServer(String IPAddress, int Port) {
	 server = new AppiumServiceBuilder()
			.withAppiumJS(new File(
					"C:\\Users\\arun.kumar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress(IPAddress).usingPort(Port).build();
	server.start();
	return server;
	}
	
	public List<HashMap<String, String>> getJsonData(String JsonFilePath) throws IOException {
				
		//This how we are have converted the json into String and String into List of HashMap
		/*Parse Json File > Json String (Common.io)
				Json String > HashMap (Jackson Bind)
				Hashmap > Test (TestNg)*/
		
		// And we have commented these below two line because we have Enhanced the code in single line (Called the File Directly)
//			File file = new File(JsonFilePath);
//			String filePath = file.toString();
		
			String jsonContent = FileUtils.readFileToString(new File(JsonFilePath), "UTF-8");

			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String, String>> data = mapper.readValue(jsonContent,
					new TypeReference<List<HashMap<String, String>>>() {
					});

			return data;

		}
	
	
	
	
	
	
	
	
	
	

}
