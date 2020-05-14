package com.josefwiddifield;

import java.io.IOException;
import java.util.regex.Pattern;

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
	
	private int count = 0;
	
	
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
				menu.displayMessage("Type the name of the driver you want to remove exactly");
				try {
				String nameToRemove = "Driver," + menu.getUserInput();
				driverTripSystem.removeDriverFromReport(nameToRemove);
				} catch(NullPointerException e) {
					menu.displayErrorMessage("Null Pointer Exception");
				}
			} else if(choice.equals(MAIN_MENU_OPTION_ADD_TRIP)) {
				menu.displayMessage("Input name of driver, start date, end date, and miles formatted as such: name,YYYY-MM-dd HH:mm,YYYY-MM-dd HH:mm,miles");
				
				try {
				String tripDetails = menu.getUserInput();
				while (!Pattern.matches("[A-Z,a-z]+,\\d{4}-[01]\\d-[0-3]\\d\\s[0-2]\\d((:[0-5]\\d)?){2},\\d{4}-[01]\\d-[0-3]\\d\\s[0-2]\\d((:[0-5]\\d)?){2},[0-9][A-Za-z0-9 -]*$", tripDetails)) {
	            menu.displayMessage("invalid answer, try again");
	            tripDetails = menu.getUserInput();
				}
				count++;
				driverTripSystem.addTripToReport(tripDetails,count);
				} catch(NullPointerException e) {
					menu.displayErrorMessage("Null Pointer Exception");
				} catch (IOException e) {
					menu.displayErrorMessage("IO Exception");
				}
				
			} else if(choice.equals(MAIN_MENU_OPTION_REMOVE_TRIP)) {
				
			} else if(choice.equals(MAIN_MENU_OPTION_GET_REPORT)) {
				menu.displayMessage("Driver Report");
				
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
