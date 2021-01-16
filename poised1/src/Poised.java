import java.io.FileNotFoundException;
import java.util.Scanner;

public class Poised {

	private static Scanner scan;
	private static Scanner scan2;
	private static Scanner scan3;

	// main method
	public static void main(String[] args) {

		// Scanner to read user inputs
		Scanner edit = new Scanner(System.in);
		// method to handle user inputs
		try {
			userInput(edit);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// close the scanner
		edit.close();
	}

	// class to handle the low level code of user entering second input
	private static void userInput(Scanner edit) throws FileNotFoundException {

		// initialize variables for user input and to check if user input is correct
		String option = null;
		boolean validChoice2 = false;

		// while loop to loop through question to user if user input is invalid
		while (!validChoice2) {

			// print instruction to user
			System.out.println(
					"Welcome To Poised Project Manager\n\nEnter '1' to 'Display Project'\nEnter '2' to 'Add New Project'\nEnter '3' to edit 'Project'\nEnter '4' to finalise a project\nEnter '5' to 'Display Incomplete projects\nEnter '6'  to Display Projects Passed Their Deadline   ");

			// If user enters wrong input they should enter another input
			option = edit.nextLine();

			/*
			 * If user chooses this option, display other instruction for user and read user
			 * input
			 */
			if (option.equals("1")) {
				validChoice2 = true;

				// object to locate line
				FindLines locateInLine = new FindLines();
				String data = locateInLine.findInLine();

				// Split line found
				String position[] = data.split(",");

				// Create variables for new data from line
				int prjNumber = Integer.parseInt(position[0]);
				String prjName = position[1];
				String buildingType1 = position[2];
				String physicalAddress1 = position[3];
				int erfNumber1 = Integer.parseInt(position[4]);
				long totalFeeCharged1 = Long.parseLong(position[5]);
				long amountPaidToDate1 = Long.parseLong(position[6]);
				String prjdeadLine = position[7];
				String aName = position[8];
				String aTelephoneNumber = position[9];
				String aEmail = position[10];
				String aPhysicalAddress = position[11];
				String cName = position[12];
				String cTelephoneNumber = position[13];
				String cEmail = position[14];
				String cPhysicalAddress = position[15];
				String cuName = position[16];
				String cuTelephoneNumber = position[17];
				String cuEmail = position[18];
				String cuPhysicalAddress = position[19];

				// Object for Project
				Project project = new Project(prjNumber, prjName, buildingType1, physicalAddress1, erfNumber1,
						totalFeeCharged1, amountPaidToDate1, prjdeadLine);

				/*
				 * Print out the string from method from Project class together with object
				 * parameters
				 */
				System.out.println("\nProject\n");
				System.out.println(project + "\n");

				Person architect = new Architect(aName, aTelephoneNumber, aEmail, aPhysicalAddress);

				/*
				 * Print out the string from method from Person class together with object
				 * parameters
				 */
				System.out.println("\nArchitect\n");
				System.out.println(architect);

				// Object for person
				Person contractor = new Contractor(cName, cTelephoneNumber, cEmail, cPhysicalAddress);

				/*
				 * Print out the string from method from Person class together with object
				 * parameters
				 */
				System.out.println("\nContractor\n");
				System.out.println(contractor);

				// Object for person
				Person customer = new Customer(cuName, cuTelephoneNumber, cuEmail, cuPhysicalAddress);

				/*
				 * Print out the string from method from Person class together with object
				 * parameters
				 */
				System.out.println("\nCustomer\n");
				System.out.println(customer);

			}
			/*
			 * If user chooses this option display other instruction for user and read user
			 * input
			 */
			else if (option.equals("2")) {
				validChoice2 = true;

				// declare and initialize object using Add projects class to add new project
				AddProjects newProject = new AddProjects();
				newProject.addNewProject();

			}
			/*
			 * If user chooses this option display other instruction for user and read user
			 * input
			 */
			else if (option.equals("3")) {
				validChoice2 = true;

				System.out.println(
						"Enter '1' to edit Amount Paid:\nEnter '2' to edit Dead Line:\nEnter '3' to edit Architects details\nEnter '4' to edit Contractors details\nEnter '5' to edit Customers details  ");
				String choice = edit.next();

				if (choice.equals("1")) {

					// declare and initialize object using class to locate lines and use EditLine
					// class to edit the Amount paid in the text file
					FindLines locateInLine = new FindLines();

					String data = locateInLine.findInLine();

					String position[] = data.split(",");

					String amount = position[6];

					System.out.println("Please enter new amount: ");
					String please = edit.next();

					EditLines.modifyFile("file_Details.txt", amount, please);
					System.out.println("Done!");
				}

				else if (choice.equals("2")) {

					/*
					 * declare and initialize object using class to locate lines and use EditLine
					 * class to edit the Deadline in the text file
					 */
					FindLines locateInLine = new FindLines();

					String data = locateInLine.findInLine();

					String position[] = data.split(",");

					String editData = position[7];

					System.out.println("Please enter new Deadline(dd-MM-yyyy): ");
					String date = edit.next();

					EditLines.modifyFile("file_Details.txt", editData, date);
					System.out.println("Done!");
				}

				else if (choice.equals("3")) {

					/*
					 * declare and initialize object using class to locate lines and use EditLine
					 * class to edit the Architects details in the text file
					 */
					FindLines locateInLine = new FindLines();

					String data = locateInLine.findInLine();

					String position[] = data.split(",");

					String editName = position[8];

					scan2 = new Scanner(System.in);

					System.out.println("Please enter new Name: ");
					String name = scan2.nextLine();

					EditLines.modifyFile("file_Details.txt", editName, name);

					String editCall = position[9];

					System.out.println("Please enter new Phone Number: ");
					String call = edit.next();

					EditLines.modifyFile("file_Details.txt", editCall, call);

					String editEmail = position[10];

					System.out.println("Please enter new email: ");
					String email = edit.next();

					EditLines.modifyFile("file_Details.txt", editEmail, email);

					String editAddress = position[11];

					System.out.println("Please enter new Address: ");
					String address = edit.next();

					EditLines.modifyFile("file_Details.txt", editAddress, address);
					System.out.println("Done!");
				}

				else if (choice.equals("4")) {

					/*
					 * declare and initialize object using class to locate lines and use EditLine
					 * class to edit the Contractors details in the text file
					 */
					FindLines locateInLine = new FindLines();

					String data = locateInLine.findInLine();

					String position[] = data.split(",");

					String editName = position[12];

					scan3 = new Scanner(System.in);

					System.out.println("Please enter new Name: ");
					String name = scan3.nextLine();

					EditLines.modifyFile("file_Details.txt", editName, name);

					String editCall = position[13];

					System.out.println("Please enter new Phone Number: ");
					String call = edit.next();

					EditLines.modifyFile("file_Details.txt", editCall, call);

					String editEmail = position[14];

					System.out.println("Please enter new email: ");
					String email = edit.next();

					EditLines.modifyFile("file_Details.txt", editEmail, email);

					String editAddress = position[15];

					System.out.println("Please enter new Address: ");
					String address = edit.next();

					EditLines.modifyFile("file_Details.txt", editAddress, address);
					System.out.println("Done!");
				}

				else if (choice.equals("5")) {

					/*
					 * declare and initialize object using class to locate lines and use EditLine
					 * class to edit the Customers details in the text file
					 */
					FindLines locateInLine = new FindLines();

					String data = locateInLine.findInLine();

					String position[] = data.split(",");

					String editName = position[16];
					scan = new Scanner(System.in);

					System.out.println("Please enter new Name: ");
					String name = scan.nextLine();

					EditLines.modifyFile("file_Details.txt", editName, name);

					String editCall = position[17];

					System.out.println("Please enter new Phone Number: ");
					String call = edit.next();

					EditLines.modifyFile("file_Details.txt", editCall, call);

					String editEmail = position[18];

					System.out.println("Please enter new email: ");
					String email = edit.next();

					EditLines.modifyFile("file_Details.txt", editEmail, email);

					String editAddress = position[19];

					System.out.println("Please enter new Address: ");
					String address = edit.next();

					EditLines.modifyFile("file_Details.txt", editAddress, address);
					System.out.println("Done!");
					break;
				}
			}

			/*
			 * If user chooses this option display other instruction for user and read user
			 * input
			 */
			else if (option.equals("4")) {
				validChoice2 = true;

				Finalize complete = new Finalize();
				complete.finishedProject();

			}
			/*
			 * If user chooses this option display other instruction for user and read user
			 * input
			 */
			else if (option.equals("5")) {
				validChoice2 = true;

				/*
				 * declare and initialize object using Display incomplete projects class to
				 * display incomplete projects to user
				 */
				DisplayIncomplete inprogress = new DisplayIncomplete();
				inprogress.incomplete();

			}

			/*
			 * If user chooses this option display other instruction for user and read user
			 * input
			 */
			else if (option.equals("6")) {
				validChoice2 = true;

				/*
				 * declare and initialize object using Past deadline class to display overdue
				 * projects
				 */
				PastDeadline deadLine = new PastDeadline();
				deadLine.pastDue();

			}

		}
	}
}
