package com.josefwiddifield.writerandreader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Objects;
import java.time.*;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class DriverTripSystemWriterReader {

	private static final String FILE_NAME = "ReportFile.txt";
	private File file = new File(FILE_NAME);

	public void addDriver(String input) throws IOException {
		try (FileWriter fr = new FileWriter(file, true); BufferedWriter br = new BufferedWriter(fr)) {
			br.write("Driver," + input + "\n");
		} catch (IOException e) {
			throw new IOException(e);
		}
	}

	// TODO make this work
	public void addTrip(String input, int count) throws IOException {

		try (FileWriter fr = new FileWriter(file, true); BufferedWriter br = new BufferedWriter(fr)) {
			br.write("Trip," + count + "," + input + "\n");
		} catch (IOException e) {
			throw new IOException(e);
		}
	}

	public void removeLineFromFile(String file, String lineToRemove) {

		try {

			File inFile = new File(file);

			if (!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
			}

			// Construct the new file that will later be renamed to the original filename.
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {

				if (!line.trim().equals(lineToRemove)) {

					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			// Delete the original file
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeLineFromFileWithId(String file, Long id) {
		try {
			File inFile = new File(file);

			if (!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
			}
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader reader = new BufferedReader(new FileReader(inFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String lineToRemove = Objects.toString(id, null);
			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				String trimmLine[] = trimmedLine.split(",");
				String partToCompare = trimmLine[1];

				if (!partToCompare.equals(lineToRemove)) {
					writer.write(currentLine + System.getProperty("line.separator"));
				}
			}
			writer.close();
			reader.close();
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}

			if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createReport(String file, String name) {
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

			Integer miles = 0;
			File inFile = new File(file);
			if (!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
			}
			BufferedReader reader = new BufferedReader(new FileReader(inFile));

			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				String trimmLine[] = trimmedLine.split(",");
				String partOneToCompare = trimmLine[0];
				if (partOneToCompare.equals("Trip")) {
					String partTwoToCompare = trimmLine[2];
					if (partTwoToCompare.equalsIgnoreCase(name)) {
						LocalDateTime start = LocalDateTime.parse(trimmLine[3], format);
						LocalDateTime end = LocalDateTime.parse(trimmLine[4], format);
						miles = Integer.parseInt(trimmLine[5]);
						long numberOfHours = Duration.between(start, end).toHours();
						long mph = miles / numberOfHours;
						
						if(mph > 5 || mph < 100) {
							System.out.println("Driver Report");
							System.out.println(trimmLine[2] + " drove " + miles + " miles" + " at an average of " + mph + " mph");
						}
						
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
