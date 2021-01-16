import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Class that creates new Project
public class AddProjects {

	// Method that creates new project data and writes it in the project text file
	public void addNewProject() throws FileNotFoundException {
		Scanner edit = new Scanner(System.in);

		File details = new File("file_Details.txt");
		Scanner reader = new Scanner(details);

		// Ask user to enter new details to record new project
		System.out.println("Enter new project number: ");

		String newProjectNumber = edit.nextLine();

		System.out.println("Enter new project name: ");

		String newProjectName = edit.nextLine();

		System.out.println("Enter new building type: ");

		String newBuildingType = edit.nextLine();

		System.out.println("Enter new physical address: ");

		String newPhysicalAddress = edit.nextLine();

		System.out.println("Enter new erf number: ");

		String newErfNumber = edit.nextLine();

		System.out.println("Enter new total fee charged: ");

		String newTotalFeeCharged = edit.nextLine();

		System.out.println("Enter new amount paid to date: ");

		String newAmountPaidToDate = edit.nextLine();

		System.out.println("Enter new dead line: ");

		String newDeadLine = edit.nextLine();

		System.out.println("Enter new project's architect name and surname: ");

		String newArchitectName = edit.nextLine();

		/*
		 * Check if name is already in the file if so add number next to new name
		 */
		int count = 0;
		int total = 0;
		while (reader.hasNext()) {
			String firstData = reader.nextLine();

			Pattern p = Pattern.compile(newArchitectName);
			Matcher m = p.matcher(firstData);
			while (m.find()) {
				count++;
				total = count;
			}

		}

		if (total >= 1) {

			newArchitectName = newArchitectName + String.valueOf(total);
		}

		System.out.println("Enter new project architect's phone number: ");

		String newArchitectPhoneNumber = edit.nextLine();

		System.out.println("Enter new project architect's email address: ");

		String newArchitectEmail = edit.nextLine();

		System.out.println("Enter new project architect's physical address: ");

		String newArchitectPhysicalAddress = edit.nextLine();

		System.out.println("Enter new project contractor name and surname: ");

		String newContractorName = edit.nextLine();

		/*
		 * Check if name is already in the file if so add number next to new name
		 */
		int count2 = 0;
		int total2 = 0;
		while (reader.hasNext()) {
			String firstData = reader.nextLine();

			Pattern p2 = Pattern.compile(newContractorName);
			Matcher m2 = p2.matcher(firstData);
			while (m2.find()) {
				count2++;
				total2 = count2;
			}

		}

		if (total2 >= 1) {

			newContractorName = newContractorName + String.valueOf(total2);
		}
		System.out.println("Enter new project contractor phone number: ");

		String newContractorPhoneNumber = edit.nextLine();

		System.out.println("Enter new project contractor email address: ");

		String newContractorEmail = edit.nextLine();

		System.out.println("Enter new project contractor physical address: ");

		String newContractorPhysicalAddress = edit.nextLine();

		System.out.println("Enter new project's customer name and surname: ");

		String newCustomerName = edit.nextLine();

		/*
		 * Check if name is already in the file if so add number next to new name
		 */
		int count3 = 0;
		int total3 = 0;
		while (reader.hasNext()) {
			String firstData = reader.nextLine();

			Pattern p3 = Pattern.compile(newCustomerName);
			Matcher m3 = p3.matcher(firstData);
			while (m3.find()) {
				count3++;

				total3 = count3;
			}

		}

		if (total3 >= 1) {

			newCustomerName = newCustomerName + String.valueOf(total3);
		}

		reader.close();

		System.out.println("Enter new project's customer phone number: ");

		String newCustomerPhoneNumber = edit.nextLine();

		System.out.println("Enter new project's customer email address: ");

		String newCustomerEmail = edit.nextLine();

		System.out.println("Enter new project's customer physical address: ");

		String newCustomerPhysicalAddress = edit.nextLine();

		/*
		 * If user doesn't enter project name use customer name and building type as new
		 * project name
		 */
		if (newProjectName.equals("")) {

			String name[] = newCustomerName.split(" ");
			String newNewProjectName = newBuildingType + " " + name[1];

			newProjectName = newNewProjectName;
		}

		// use buffered writer to write new projects to file
		try {

			// set true for append mode
			BufferedWriter writer = new BufferedWriter(new FileWriter("file_Details.txt", true));

			// write new data
			writer.write(newProjectNumber + "," + newProjectName + "," + newBuildingType + "," + newPhysicalAddress
					+ "," + newErfNumber + "," + newTotalFeeCharged + "," + newAmountPaidToDate + "," + newDeadLine
					+ "," + newArchitectName + "," + newArchitectPhoneNumber + "," + newArchitectEmail + ","
					+ newArchitectPhysicalAddress + "," + newContractorName + "," + newContractorPhoneNumber + ","
					+ newContractorEmail + "," + newContractorPhysicalAddress + "," + newCustomerName + ","
					+ newCustomerPhoneNumber + "," + newCustomerEmail + "," + newCustomerPhysicalAddress);

			// close writer
			writer.close();
			System.out.println("Done!");

		} catch (IOException e) {
			System.out.println(e);
		}
		edit.close();

	}

}
