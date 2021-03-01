package com.front.utilities;

import com.crud.controller.BusinessController.Color;
import com.crud.controller.BusinessController.Material;

//data entry control
public final class Inputs {
	
	//TitleCase
	public static String toTitleCase(String input) {
	    StringBuilder titleCase = new StringBuilder(input.length());
	    boolean nextTitleCase = true;
	    for (Character c : input.toCharArray()) {
    		if (c.equals(' ') || c.equals('-') || c.equals('\'')) {
    			nextTitleCase = true;
    		} else if (nextTitleCase) {
    			c = Character.toUpperCase(c);
    			nextTitleCase = false;
    		} else {
    			c = Character.toLowerCase(c);
    		}
    		titleCase.append(c);
    	}
	    return titleCase.toString();
	}

	//enum color
	public static boolean validColor(String input) {
		try {
			return Color.valueOf(toTitleCase(input)) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	//string to enum
	public static Color toColor(String input) {
		return Color.valueOf(toTitleCase(input));
	}

	//valid material
	public static boolean validMaterial(String input) {
		try {
			return Material.valueOf(toTitleCase(input)) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	//string to material
	public static Material toMaterial(String input) {
		return Material.valueOf(toTitleCase(input));
	}
	
	//string to double
	public static double toDouble(String input) {
		input = input.replaceAll(",", "");
		if (!input.matches("\\d+\\.?\\d*")) {
			return -1.0;
		}
		return Double.parseDouble(input);
	}
	
}