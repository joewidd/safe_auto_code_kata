package com.josefwiddifield;

import java.io.FileNotFoundException;

import com.josefwiddifield.view.Menu;


public class DriverTripSystemCLI {
	
	private static final String MAIN_MENU_OPTION_ADD_DRIVER = "Add Driver";
	private static final String MAIN_MENU_OPTION_REMOVE_DRIVER = "Remove Driver";
	private static final String MAIN_MENU_OPTION_ADD_TRIP = "Add Trip";
	private static final String MAIN_MENU_OPTION_REMOVE_TRIP = "Remove Trip";
	private static final String MAIN_MENU_OPTION_QUIT = "Quit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_ADD_DRIVER, 
			MAIN_MENU_OPTION_REMOVE_DRIVER, 
			MAIN_MENU_OPTION_ADD_TRIP, 
			MAIN_MENU_OPTION_REMOVE_TRIP,
			MAIN_MENU_OPTION_QUIT };
	
	
	private Menu menu;
	
	
	
	
	
	
	public void run() {

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if (choice.equals (MAIN_MENU_OPTION_ADD_DRIVER)) {
				
			} else if (choice.equals(MAIN_MENU_OPTION_REMOVE_DRIVER)) {
				
			} else if(choice.equals(MAIN_MENU_OPTION_ADD_TRIP)) {
				
			} else if(choice.equals(MAIN_MENU_OPTION_REMOVE_TRIP)) {
				
			} else {
				break;
			}
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
	}
}
