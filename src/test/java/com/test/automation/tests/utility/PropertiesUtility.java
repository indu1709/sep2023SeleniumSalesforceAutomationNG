package com.test.automation.tests.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertiesUtility {

	private FileInputStream stream = null;
	private Properties propFile = null;
	
	public Properties createPropertyObject() {
		return new Properties();
	}

	public void loadFile(String filename, Properties properties) {

		String propertyFilePath = null;
		switch (filename) {
		case "applicationDataProperties":
			propertyFilePath = Constants.APPLICATION_PROPERTIES;
			break;
		default:
			System.out.println("no correct keyword entered");

		}
		try {
			stream = new FileInputStream(propertyFilePath);
			properties.load(stream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getPropertyValue(String key, Properties properties) {
		String value = properties.getProperty(key);
		return value;

	}

	public void setPropertyValue(String key, String value, Properties properties) {
		properties.setProperty(key, value);

	}

	public void savePropertyFile(String filepath, Properties properties) {
		try {
			FileOutputStream output = new FileOutputStream(filepath);
			properties.store(output, filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeDataToPropertyFile(File path, String key, String value) {

		Properties propFile = new Properties();
		propFile.setProperty(key, value);
		try {
			propFile.store(new FileOutputStream(path), "updating data");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
