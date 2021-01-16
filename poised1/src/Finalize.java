import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

//Class to change status of project to finalized
public class Finalize {

	// method to finalize project
	public void finishedProject() throws FileNotFoundException {

		// object to locate line to finalize
		FindLines locateInLine = new FindLines();
		String data = locateInLine.findInLine();
		String position[] = data.split(",");

		/*
		 * if amount Due is less than amount paid print a invoice showing customer name
		 * and contact details write invoice on text document
		 */
		if (Long.parseLong(position[5]) > Long.parseLong(position[6])) {

			long difference = Long.parseLong(position[5]) - Long.parseLong(position[6]);

			System.out.println("Invoice\n");
			System.out.println("Customer: " + position[16] + "\n" + "\nContact Details" + position[17] + "\nCall:"
					+ position[18] + "\nEmail: " + position[19]);
			System.out.println("\nAmount Due: " + "R" + difference);
			try {
				FileWriter invoice = new FileWriter("invoice.txt");
				invoice.write("Invoice\n");
				invoice.write("Customer: " + position[16] + "\n" + "\nContact Details" + position[17] + "\nCall:"
						+ position[18] + "\nEmail: " + position[19]);
				invoice.write("\nAmount Due: " + "R" + difference);
				System.out.println("Invoice created!");
				invoice.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}

		// if amount is fully paid tell user
		else if (Long.parseLong(position[5]) > Long.parseLong(position[6])) {
			System.out.println("Amount fully paid");
		}

		// use buffered writer to write completed projects new file
		try {

			// set true for append mode
			BufferedWriter writer = new BufferedWriter(new FileWriter("Completed_project.txt", true));

			Date d1 = new Date();

			// write complete project
			writer.write("Project Finalised" + " at " + d1 + "\nExpected deadline: " + position[7]
					+ "\nProject Number: " + position[0] + "\nProject Name: " + position[1] + "\nBuilding type: "
					+ position[2] + "\nPhysical Adress: " + position[3] + "\nERF number: " + position[4]
					+ "\nTotal fee charged: " + position[5] + "\nTotal amount paid to date: " + position[6]);
			writer.write("\nArchitect name: " + position[8] + "\nTelephone number: " + position[9] + "\nEmail address: "
					+ position[10] + "\nPhysical Adress: " + position[11]);
			writer.write("\nContractor name: " + position[12] + "\nTelephone number: " + position[13]
					+ "\nEmail address: " + position[14] + "\nPhysical Adress: " + position[15]);
			writer.write("\nCustomer name: " + position[16] + "\nTelephone number: " + position[17]
					+ "\nEmail address: " + position[18] + "\nPhysical Adress: " + position[19] + "\n\n");

			// close writer
			writer.close();
			System.out.println("Project Finalised!");

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}