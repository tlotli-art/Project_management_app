import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Class to display Projects pass their deadline
public class PastDeadline {

	// method to locate display projects that are pass their deadline
	public void pastDue() {
		try {
			// loop through file to check the dates
			File details = new File("file_Details.txt");
			Scanner reader = new Scanner(details);

			while (reader.hasNext()) {
				String firstData = reader.nextLine();

				String splitted[] = firstData.split(",");

				// if date on project line is before current date display the project
				try {

					// Check to see if date is before current date
					if (new SimpleDateFormat("dd-MM-yyyy").parse(splitted[7]).before(new Date())) {

						// Split line containing date before current date
						String projectDetails[] = firstData.split(",");

						// Print line
						System.out.println("\nProject still to be completed\nProject Number: " + projectDetails[0]
								+ "\nProject Name: " + projectDetails[1] + "\nBuilding type: " + projectDetails[2]
								+ "\nPhysical Adress: " + projectDetails[3] + "\nERF number: " + projectDetails[4]
								+ "\nTotal fee charged: " + projectDetails[5] + "\nTotal amount paid to date: "
								+ projectDetails[6] + "\nDeadline: " + projectDetails[7]);
						System.out.println("\nArchitect name: " + projectDetails[8] + "\nTelephone number: "
								+ projectDetails[9] + "\nEmail address: " + projectDetails[10] + "\nPhysical Adress: "
								+ projectDetails[11]);
						System.out.println("\nContractor name: " + projectDetails[12] + "\nTelephone number: "
								+ projectDetails[13] + "\nEmail address: " + projectDetails[14] + "\nPhysical Adress: "
								+ projectDetails[15]);
						System.out.println("\nCustomer name: " + projectDetails[16] + "\nTelephone number: "
								+ projectDetails[17] + "\nEmail address: " + projectDetails[18] + "\nPhysical Adress: "
								+ projectDetails[19] + "\n\n");

					} else {
						System.out.println("No project passed deadline!");
						break;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
