import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//class to find line
public class FindLines {

	private Scanner edit1;

	// Method to read file and locate specific line and returns it
	public String findInLine() throws FileNotFoundException {

		String last = null;

		boolean validChoice2 = false;

		// while loop for if user enters wrong input loop until correct input is entered
		while (!validChoice2) {

			File toEdit = new File("file_Details.txt");
			Scanner finder = new Scanner(toEdit);

			edit1 = new Scanner(System.in);
			System.out.print("\nEnter Valid Project number of project you wish to find: ");
			String number = edit1.nextLine();

			/*
			 * Loop through text file until project number corresponding to user input is
			 * found
			 */
			while (finder.hasNextLine()) {

				String data = finder.nextLine();

				String projectNumber[] = data.split(",");

				// if input corresponds with the project number return the line
				if (projectNumber[0].contains(number)) {
					validChoice2 = true;
					last = data;
					finder.close();
					break;

				}

			}
		}
		return last;

	}
}