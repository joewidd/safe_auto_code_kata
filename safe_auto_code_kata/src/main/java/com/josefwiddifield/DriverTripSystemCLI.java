package com.josefwiddifield;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.josefwiddifield.view.Menu;


public class DriverTripSystemCLI {
	
	private static final String MAIN_MENU_OPTION_ADD_DRIVER = "Add Driver";
	private static final String MAIN_MENU_OPTION_REMOVE_DRIVER = "Remove Driver";
	private static final String MAIN_MENU_OPTION_ADD_TRIP = "Add Trip";
	private static final String MAIN_MENU_OPTION_REMOVE_TRIP = "Remove Trip";
	private static final String MAIN_MENU_OPTION_GET_REPORT = "Get Report";
	private static final String MAIN_MENU_OPTION_QUIT = "Quit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_ADD_DRIVER, 
			MAIN_MENU_OPTION_REMOVE_DRIVER, 
			MAIN_MENU_OPTION_ADD_TRIP, 
			MAIN_MENU_OPTION_REMOVE_TRIP,
			MAIN_MENU_OPTION_GET_REPORT,
			MAIN_MENU_OPTION_QUIT };
	
	
	private Menu menu;
	
	private DriverTripSystem driverTripSystem = new DriverTripSystem();
	
	
	public DriverTripSystemCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if (choice.equals (MAIN_MENU_OPTION_ADD_DRIVER)) {
				menu.displayMessage("Add a driver");
				
				try {
					String name = menu.getUserInput();
					driverTripSystem.addDriverToReport(name);
				} catch(NullPointerException e) {
					menu.displayErrorMessage("Null Pointer Exception");
				} catch (IOException e) {
					menu.displayErrorMessage("IO Exception");
				}
				
			} else if (choice.equals(MAIN_MENU_OPTION_REMOVE_DRIVER)) {
				menu.displayMessage("Type the name of the Driver you want to remove exactly");
				try {
				String nameToRemove = "Driver," + menu.getUserInput();
				driverTripSystem.removeDriverFromReport(nameToRemove);
				} catch(NullPointerException e) {
					menu.displayErrorMessage("Null Pointer Exception");
				}
			} else if(choice.equals(MAIN_MENU_OPTION_ADD_TRIP)) {
				menu.displayMessage("Input name of driver");
				//match name to driver in file
				//add start time
				//add end time
				//add miles driven
			} else if(choice.equals(MAIN_MENU_OPTION_REMOVE_TRIP)) {
				
			} else if(choice.equals(MAIN_MENU_OPTION_GET_REPORT)) {
				
			} else {
				break;
			}
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		DriverTripSystemCLI cli = new DriverTripSystemCLI(menu);
		cli.run();
	}
}
