package com.jdbcapp.StudentJDBCApp;

import java.util.Scanner;

public class MenuImpl implements IMenu {
	

	    private IStudent student = new StudentImpl();
	    private Scanner sc = new Scanner(System.in);

	    @Override
	    public void showMenu() {
	        int choice = 0;

	        do {
	            
	        	
	            System.out.println("1. Insert a student");
	            System.out.println("2. Insert multiple students");
	            System.out.println("3. Update a student");
	            System.out.println("4. Update multiple students");
	            System.out.println("5. Delete a student");
	            System.out.println("6. Delete multiple students");
	            System.out.println("7. Show all students");
	            System.out.println("8. Exit");
	            System.out.print("Select From 1-8: ");

	            choice = sc.nextInt();

	           
	            switch (choice) {
	                case 1:
	                    student.insertStudent();
	                    break;

	                case 2:
	                    student.insertMultipleStudents();
	                    break;

	                case 3:
	                    student.updateStudent();
	                    break;

	                case 4:
	                    student.updateMultipleStudents();
	                    break;

	                case 5:
	                    student.deleteStudent();
	                    break;

	                case 6:
	                    student.deleteMultipleStudents();
	                    break;

	                case 7:
	                    student.showStudents();
	                    break;

	                case 8:
	                    System.out.println("Program Completed");
	                    break;

	                default:
	                    System.out.println("Invalid Option");
	                    break;
	            }

	        } while (choice != 8);
	    }
	}



