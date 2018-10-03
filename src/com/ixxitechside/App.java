package com.ixxitechside;

import java.util.Scanner;

public class App {

	private static final String TITRE_APPLICATION = "CONVERTISSEUR DEGRES CELSIUS ET DEGRES FAHRENHEIT";
	private static final String SEPARATOR = "---------------------------------------------------------";
	private static final String TITRE_MENU = "Choisissez le mode de conversion";
	private static final String MENU_OPTION_1 = "1 - Convertisseur Celsius - Fahrenheit";
	private static final String MENU_OPTION_2 = "2 - Convertisseur Fahrenheit - Celsius";
	private static final String TEMPERATURE_A_CONVERTIR = "Temp�rature � convertir :";
	private static final String QUESTION_NOUVELLE_CONVERSION = "Souhaitez-vous convertir une autre temp�rature ? (O/N)";
	private static final String FIN_PROGRAMME = "Au revoir !";

	public static void main(String[] args) {
		//TODO afficher le titre CONVERTISSEUR DEGRES CELSIUS ET DEGRES FAHRENHEIT
		System.out.println(TITRE_APPLICATION);
		System.out.println(SEPARATOR);

		String choix = null;
		Boolean recommencer = Boolean.TRUE;
		do {
			try(Scanner reponse = new Scanner(System.in)){
				//TODO methode afficherMenuOption()
				System.out.println(TITRE_MENU);
				System.out.println(MENU_OPTION_1);
				System.out.println(MENU_OPTION_2);
				choix = reponse.nextLine();
				System.out.println(TEMPERATURE_A_CONVERTIR);
				int temp = Integer.parseInt(reponse.nextLine());
				TypeConversion typeConversion = getTypeConvertisseur(choix);
				Double resultat = 0.0;
				switch (typeConversion){
				case C :
					resultat = calculerTemperatureFahrenheit(temp);
					System.out.format("%d �C correspond � %a �F", temp, resultat);
					System.out.println(System.lineSeparator());
					break;

				case F :
					resultat = calculerTemperatureCelcius(temp);
					System.out.format("%d �F correspond � %a �C", temp, resultat);
					System.out.println(System.lineSeparator());
					break;

				default :
					break;
				}

				System.out.println(QUESTION_NOUVELLE_CONVERSION);
				
				char continuerPartie = reponse.nextLine().charAt(0);
				
				if (continuerPartie!='N') {
					recommencer = Boolean.FALSE;
				}
			}
		}while (recommencer);

		System.out.println(FIN_PROGRAMME);
	}

	/**
	 * Converti la temp�rature en fahrenheit en celcius
	 * @param temp
	 * 			la temp�rature en fahrenheit
	 * @return
	 * 			la temp�rature en celcius
	 */
	private static Double calculerTemperatureCelcius(int temp) {
		Double resultatEnCelcius = 0.0;
		resultatEnCelcius = (double) (((temp - 32) * 5) / 9);
		return resultatEnCelcius;
	}

	/**
	 * Retourne en fonction du choix de l'utilisateur le type de conversion � appliquer
	 * @param choix
	 * 				1 - pour celcius / 2 pour fahrenheit
	 * @return
	 * 		un enum de type conversion
	 */
	private static TypeConversion getTypeConvertisseur(String choix) {
		if (TypeConversion.C.getLabel().equals(choix)) {
			return TypeConversion.C;
		} else {
			return TypeConversion.F;
		}
	}

	/**
	 * Converti la temp�rature en celcius en fahrenheit
	 * @param temp
	 * 			la temp�rature en celcius
	 * @return
	 * 			la temp�rature en fahrenheit
	 */
	private static Double calculerTemperatureFahrenheit(int temp) {
		Double resultatEnFahrenheit = 0.0;
		resultatEnFahrenheit = (double) ((9/5 * temp) + 32);
		return resultatEnFahrenheit;

	}
}
