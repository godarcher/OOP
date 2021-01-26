package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Student> group = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initializeGroup();
        printGroup();

        boolean quit = false;

        while(!quit){
            quit = modifyGroup();
        }

        System.out.println("Bye!");
        scanner.close();

    } 

    private static void initializeGroup(){
        System.out.println("Please enter the group size:");
        int groupSize = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < groupSize; i++){
            System.out.println("Please enter a studentnumber:");
            int studentNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter a first name:");
            String name = scanner.nextLine();

            System.out.println("Please enter a last name:");
            String lastName = scanner.nextLine();

            group.add( new Student(name, lastName, studentNumber));
        }
    }

    private static void printGroup(){
        System.out.println("Group now contains: ");
        for (int i = 0; i < group.size(); i++){
            System.out.println(group.get(i).toString());
        }
    }

    private static boolean modifyGroup(){
        System.out.println("Student number and new given/family name?");
        int studentNumber = scanner.nextInt();

        if (studentNumber == -1)
            return true;
        else{
            String name = scanner.next();
            String familyName = scanner.next();

            for (Student student : group){
                if (student.getStudentNumber() == studentNumber){
                    student.setName(name);
                    student.setFamilyName(familyName);
                }
            }

            printGroup();
            return false;
        }
    }
}
