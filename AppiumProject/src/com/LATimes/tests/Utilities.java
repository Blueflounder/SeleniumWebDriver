package com.LATimes.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {
	
	public static Properties GetObject() throws IOException {
		Properties p = new Properties();
		File f = new File("Object.properties");
		InputStream stream = new FileInputStream(f);
		p.load(stream);
		
		return p;
	}

}
