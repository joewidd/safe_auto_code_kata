package com.josefwiddifield;

import java.io.IOException;

import com.josefwiddifield.writerandreader.DriverTripSystemWriterReader;

public class DriverTripSystem {
	
	private DriverTripSystemWriterReader writerAndReader = new DriverTripSystemWriterReader();
	
	
	public void addDriverToReport(String inputName) throws IOException {
		writerAndReader.addDriver(inputName);
	}
	public void removeDriverFromReport(String inputName) {
		writerAndReader.removeLineFromFile("ReportFile.txt", inputName);
	}
	public void addTripToReport(String inputTripDetails, int count) throws IOException {
		writerAndReader.addTrip(inputTripDetails, count);
	}
	public void removeTripFromReport(long inputId){
		writerAndReader.removeLineFromFileWithId("ReportFile.txt", inputId);
	}
	public void makeTripReport(String inputName) {
		writerAndReader.createReport("ReportFile.txt", inputName);
	}
}
