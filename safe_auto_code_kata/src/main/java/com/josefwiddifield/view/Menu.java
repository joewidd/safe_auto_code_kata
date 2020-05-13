package com.josefwiddifield.view;



	
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.io.PrintWriter;
	import java.util.Scanner;
	
	public class Menu {
		private PrintWriter out;
		private Scanner in;

		public Menu(InputStream input, OutputStream output) {
			this.out = new PrintWriter(output);
			this.in = new Scanner(input);
		}

		public void displayMessage(String message) {
			out.println(message);
			out.flush();
		}

		public String getUserInput() {
			return in.nextLine();
		}

		public void showErrorMessage(String message) {
			out.println("****** " + message + " ******");
			out.flush();
		}

		public Object getChoiceFromOptions(Object[] options) {

			Object choice = null;
			while (choice == null) {
				displayMenuOptions(options);
				choice = getChoiceFromUserInput(options);

			}
			return choice;

		}

		public Object getChoiceFromUserInput(Object[] options) {
			Object choice = null;
			String userInput = in.nextLine();
			try {
				int selectedOption = Integer.valueOf(userInput);
				if (selectedOption > 0 && selectedOption <= options.length) {
					choice = options[selectedOption - 1];
				}
			} catch (NumberFormatException e) {

			}
			if (choice == null) {
				System.out.println("\n*** " + userInput + " is not a valid option. Please try again***\n");

			}
			return choice;
		}

		public void displayMenuOptions(Object[] options) {
			out.println();
			for (int i = 0; i < options.length; i++) {
				int optionNum = i + 1;
				out.println("(" + optionNum + ") " + options[i]);
			}
			out.flush();
		}
	
}
