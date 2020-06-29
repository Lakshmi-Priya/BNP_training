package com.app.main;
import java.io.IOException;
import java.util.*;
import com.app.bo.*;
import com.app.bo.impl.*;
import com.app.exception.BusinessException;
import com.app.model.Filename;
public class Main {

	public static void main(String[] args) {
		
		//UI display 
		System.out.println("Virtual Key for your Repositories");
		System.out.println("---------------------------------");
		System.out.println("        Lakshmi Priya .E        \n\n\n ");
		Scanner sc = new Scanner(System.in);
		FileBO bo = new FileBOImpl();
		int ch = 0;
		String message="";
		
		//Displaying the main menu
		do {
			System.out.println("         MAIN MENU            ");
			System.out.println("------------------------------\n");
			System.out.println("Please select any of the option below");
			System.out.println("Enter 1 to retrieve file names in asc order");
			System.out.println("Enter 2 to do any file operations");
			System.out.println("Enter 3 to close the application");
			try {
			ch = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e) {
				System.out.println("Enter a valid number again [1,2 or 3]");
				continue;
			}

			switch (ch) {
			//Case to sort the files in the directory in ascending order
			case 1:
				List<Filename> s = bo.ascOrder();
				if(s.size()<1){
					System.out.println("Empty directory");
				}
				else {
				System.out.println("Files in asc order are as follows");
				for(int i=0;i<s.size();i++){
					System.out.println(s.get(i).getFilenames());}
				}
				break;
				
			//Case to do file operation
			case 2:
				int ch1 = 0;
				do {
				System.out.println("     SUB MENU FOR FILE OPERATIONS       ");
				System.out.println("-----------------------------------------\n\n");
				System.out.println("Please select any of the option below");
				System.out.println("1)Enter 1 to add a file");
				System.out.println("2)Enter 2 to delete any file");
				System.out.println("3)Enter 3 to search for a file");
				System.out.println("4)Enter 4 to navigate to main menu");
				try {
					ch1 = Integer.parseInt(sc.nextLine());
				}catch(Exception e){
					System.out.println("Enter a valid number [1,2,3 or 4]");
					continue;
				}
				
				String name="";
				String dir="";
				System.out.println(ch1);
				
				switch (ch1)
				{
					//Case to add a file in the existing directory(directories that are there in root)
					case 1:
						System.out.println("Enter the directory where you want to add the file");
						dir=sc.nextLine();
						System.out.println("Enter the filename you want to create (with extension)");
						name = sc.nextLine();
					try {
						message=bo.addFile(name,dir);
						System.out.println(message.toString());
					} catch (BusinessException e1) {
						System.out.println(e1.getMessage());
					} catch (IOException e1) {
						System.out.println("Directory does not exists");
					}
						break;
						
					//Case to delete a file in the existing directory (directories that are there in root)
					case 2:
						System.out.println("Enter the directory from where you want to delete the file");
						dir=sc.nextLine();
						System.out.println("Enter the filename you want to delete (with extension)");
						name = sc.nextLine();
						try {
								message=bo.deleteFile(name,dir);
								System.out.println(message.toString());
							} catch (BusinessException e) {
								System.out.println(e.getMessage());
							} catch (IOException e) {
								System.out.println("Directory does not exists");
							}
						
						break;
						
					//Case to search for file/directory in the root directory
					case 3:
						System.out.println("Enter the filename/directory you want to search (with extension for file)");
						name=sc.nextLine();
						message=bo.search(name);
						System.out.println(message.toString());
						break;
						
					//Case to navigate to the main menu
					case 4:
						break;
					default:
						System.out.println("Enter a valid number [1,2,3 or 4]");
				}}while(ch1!=4);
				break;
				
			//Case to exit the application
			case 3:
				break;
			default:
				System.out.println("Enter a valid number [1,2 or 3]");
				break;
			}
		} while (ch != 3);
		
		System.out.println("Thank you for using the application");
		sc.close();

	}

}
