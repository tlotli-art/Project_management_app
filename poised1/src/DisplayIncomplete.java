import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class to display incomplete projects
public class DisplayIncomplete {

	private Scanner reader;

	// method to find and display incomplete projects
	public void incomplete() {
		try {
			Scanner reader1 = new Scanner(new File("Completed_project.txt"));
			Scanner reader2 = new Scanner(new File("file_Details.txt"));

			/*
			 * Arrays to locate projects in the project and complete project text files and
			 * array lists to add the arrays in
			 */
			String split[] = null;
			String split1[] = null;
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();

			// add complete project data to first array list
			while (reader1.hasNext()) {

				String line = reader1.nextLine();

				if (line.contains("Number")) {

					split = line.split(": ");

					list1.add(split[1]);
				}
			}

			// add project data to second array list
			while (reader2.hasNext()) {

				String line2 = reader2.nextLine();
				split1 = line2.split(",");
				list2.add(split1[0]);
			}

			// Get elements that are uncommon in the two arrays
			List<String> list3 = new ArrayList<>(list1);
			list3.removeAll(list2); // list contains items only in first list

			List<String> list4 = new ArrayList<>(list2);
			list4.removeAll(list1); // list2 contains items only in second list

			list4.addAll(list3); // list2 now contains all the not-common items

			String test = null;
			for (int i = 0; i < list4.size(); i++) {
				test = list4.get(i);

				/*
				 * using the uncommon project number in the array list locate the project not
				 * complete in the project text file and display it to the user
				 */
				File details = new File("file_Details.txt");
				reader = new Scanner(details);

				while (reader.hasNext()) {
					String project = reader.nextLine();

					String splitted[] = project.split(",");

					if (splitted[0].contains(test)) {

						String projectDetails[] = project.split(",");

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

					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

}
