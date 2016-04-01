package com.test.OnlineStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ShoppingCartUtilities {

	
	
	public static int StripAndConvertToInt(String price) {

		String strippedPrice = price.replace("$", "");
		double dblPrice = Double.parseDouble(strippedPrice);
		int intPrice = (int) dblPrice;

		return intPrice;

	}
	
	public static Properties GetObject() throws IOException {
		Properties p = new Properties();
		File f = new File("C:\\Users\\amits\\workspace\\Maven\\Object.properties");
		InputStream stream = new FileInputStream(f);
		p.load(stream);
		
		return p;
	}
	
}