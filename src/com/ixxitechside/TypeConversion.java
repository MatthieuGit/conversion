package com.ixxitechside;

/**
 * Enumération des types de conversion
 * @author matthieu.bailly
 *
 */
public enum TypeConversion {
	
	/**
	 * Celcius
	 */
	C("1"),
	
	
	/**
	 * Fahrenheit
	 */
	F("2");
	
	
	private String label;
	
	private TypeConversion(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
