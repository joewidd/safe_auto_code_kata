package com.josefwiddifield;

import java.io.IOException;

import com.josefwiddifield.writerandreader.DriverTripSystemWriterReader;

public class DriverTripSystem {
	
	private DriverTripSystemWriterReader writer = new DriverTripSystemWriterReader();
	
	
	public void addDriverToReport(String input) throws IOException {
		writer.addDriver(input);
	}
	public void removeDriverFromReport(String input) {
		writer.removeLineFromFile("ReportFile.txt", input);
	}
	
}
