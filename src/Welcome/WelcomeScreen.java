package Welcome;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WelcomeScreen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename;

		char ch;
		File directory = new File("D://Suvanjali//");
		String[] flist = directory.list();
		Scanner input = new Scanner(System.in);
		System.out.println("*******Assignment 1 ********");
		System.out.println("******* Suvanjali Badade*****************");
		System.out.println();

		do {

			System.out.println("Select File Option to perform any operation:- \n");
			System.out.println("1.Create New file inside the directory");
			System.out.println("2.Display list of file inside directory");
			System.out.println("3. Delete perticular file");
			System.out.println("4.Search file inside the directory");
			System.out.println("5.Exit");

			int choice = input.nextInt();

			switch (choice) {

			case 1:

				System.out.println("Enter the file name for crating new file");
				filename = input.next();
				createNewFile(filename);
				break;

			case 2:
				listOfFiles();
				break;

			case 3:

				System.out.println("Enter the file name which you want to delete");
				filename = input.next();
				deleteFile(filename);
				break;

			case 4:
				System.out.println("Enter the file name for searching");
				filename = input.next();
				searchFile(filename);
				break;

			case 5:

				System.out.println("Thank you User");
				break;

			default:

				System.out.println("Your input number is incorrect.Choose correct Number");
				break;

			}
			System.out.println("Do you want to continue Type (y or n) \n");
			ch = input.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

	}

	
//Display all files inside directory 
	private static void listOfFiles() {
		System.out.println("\n List of files and Folder \n");
		File folder = new File("D://Suvanjali//");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) 
				System.out.println(file.getName());
			 else if (file.isFile()) 
				System.out.println(file.getName());
		}
	}
// create new file inside the directory 	
  public static void createNewFile(String filename)
  {

		try {
			File file = new File("D://Suvanjali//" + filename + ".txt");

			if (file.createNewFile())
				System.out.println("File Created Successfully \n");
			
			else {
				   if (file.exists())
					   System.out.println("File Already Exists");
				   else  
					   System.out.println("File Doesen't exist");

				 }
		     } 
		 catch (IOException e) {
			e.printStackTrace();
		 }
		
  }
  //Delete file from Directory
  
  public static void deleteFile(String filename)
  {
	  File directory_delete = new File("D://Suvanjali//");

		String[] flist_delete = directory_delete.list();
		int flag_d = 0;
		if (flist_delete == null) {
			System.out.println("There is no file preseent in the directory");
		} else {
			for (int i = 0; i < flist_delete.length; i++) {
				String delete_filename = flist_delete[i];
				if (delete_filename.equalsIgnoreCase(filename)) {

					File file = new File(
							"D://Suvanjali//" + delete_filename);
					if (file.delete()) {
						System.out.println("File deleted successfully");
					} else {
						System.out.println("Failed to delete the file");
					}
					flag_d = 1;
				}
			}
		}

		if (flag_d == 0) {
			System.out.println("File Not Found");
		}

  }
  //Search the file inside the dorectory
  public static void searchFile(String filename)
  {
	  File directory_search = new File("D://Suvanjali//");
		String[] flist_search = directory_search.list();
		int flag_s = 0;
		if (flist_search == null) {
			System.out.println("There is no file preseent in the directory");
		} else {
			for (int i = 0; i < flist_search.length; i++) {
				String search_filename = flist_search[i];
				if (search_filename.equalsIgnoreCase(filename)) {
					System.out.println(search_filename + " found");
					flag_s = 1;
				}
			}
		}

		if (flag_s == 0) {
			System.out.println("File Not Found");
		}

  }

}

