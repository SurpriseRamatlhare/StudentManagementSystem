package vut;

import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        StudentPD objStudent = new StudentPD();
        objStudent.openConnection();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your initials: ");
        String initials = input.nextLine();
        System.out.print("Enter your Surname: ");
        String surname = input.nextLine();
        System.out.print("Enter your Student Number: ");
        String studentNumber = input.nextLine();

       
        objStudent.setInitials(initials);
        objStudent.setSurname(surname);
        objStudent.setStudentNumber(studentNumber);

        objStudent.addStudent(objStudent);
        System.out.println("--------------------------------------");


        System.out.println("Student List:");
        for (StudentPD student : objStudent.getAll()) {
            System.out.println(student);
        }

    }
}
