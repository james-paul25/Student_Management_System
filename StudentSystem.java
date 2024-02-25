import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    ArrayList<String> studentName = new ArrayList<String>();
    ArrayList<String> studentDepartment = new ArrayList<String>();
    ArrayList<Integer> studentAge = new ArrayList<Integer>();
    ArrayList<Integer> studentId = new ArrayList<Integer>();

    public void line(){
        System.out.println("=======================================================" +
                "================================================================");
    }
    public void addStudentInfo(){
        StudentSystem get = new StudentSystem();
        Scanner input = new Scanner(System.in);

        System.out.println("Adding student information...");
        get.line();

        System.out.print("\t\t\t\t\t\t\tInput student name: ");
        String name = input.nextLine();
        System.out.print("\t\t\t\t\t\t\tInput student department: ");
        String department = input.nextLine();
        System.out.print("\t\t\t\t\t\t\tInput student age: ");
        int age = 0;
        if(input.hasNextInt()){
            age = input.nextInt();
            input.nextLine();
        }else{
            input.nextLine();
            //System.out.println("Invalid input, please input correctly!");
        }
        System.out.print("\t\t\t\t\t\t\tInput student ID: ");
        int id = 0;
        if(input.hasNextInt()){
            id = input.nextInt();
            input.nextLine();
        }else{
            input.nextLine();
            //System.out.println("Invalid input, please input correctly!");
        }

        studentName.add(name);
        studentDepartment.add(department);
        studentAge.add(age);
        studentId.add(id);
        System.out.println("Student added successfully.");

    }
    public void listOfStudent(){
        StudentSystem get = new StudentSystem() ;
        if(!studentName.isEmpty()){
            System.out.println("\t\t\t\t\t\t\t\t\tList of students: ");
            for(int i = 0; i < studentName.size(); i++){
                System.out.println("Student number "+ (i + 1));
                System.out.println("\t\t\t\t\t\tID: " + studentId.get(i) +
                        "\n\t\t\t\t\t\t\tName: "+ studentName.get(i) +
                        "\n\t\t\t\t\t\t\tDepartment: " + studentDepartment.get(i) +
                        "\n\t\t\t\t\t\t\tAge: " + studentAge.get(i)
                        );
            }
        }
        if(studentName.isEmpty()){
            System.out.println("Empty list, please add student information!");
        }
    }
    public void removeStudent(){
        StudentSystem get = new StudentSystem();
        Scanner input = new Scanner(System.in);

        System.out.println("\t\t\t\t\t\t\t1. Remove one student information" +
                "\n\t\t\t\t\t\t\t2. Clear all students information");
        System.out.print("\t\t\t\t\t\tInput choice: ");
        int choice = 0;
        if(input.hasNextInt()){
            choice = input.nextInt();
            input.nextLine();
        }else{
            System.out.println("Invalid input, please input correctly!");
        }
        switch(choice){
            case 1:
                System.out.println("Removing student information...");
                System.out.print("\t\t\t\t\t\t\tInput student number: ");
                if (input.hasNextInt()) {
                    int removing = input.nextInt();
                    input.nextLine();
                    int toRemove = removing - 1;
                    if (toRemove >= 0 && toRemove < studentName.size()) {
                        System.out.println("Removing student " + studentName.get(toRemove));
                        studentName.remove(toRemove);
                        studentDepartment.remove(toRemove);
                        studentAge.remove(toRemove);
                        studentId.remove(toRemove);
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Invalid student number.");
                    }
                } else {
                    System.out.println("Invalid input for student number.");
                }
                break;
            case 2:
                System.out.println("Clearing...");
                System.out.println("Cleared successfully.");
                studentName.clear();
                studentDepartment.clear();
                studentAge.clear();
                studentId.clear();
                break;
            default:
                get.line();
                System.out.println("Invalid input, please input correctly!");
        }
    }
    public void searchStudent(){
        StudentSystem get = new StudentSystem();
        Scanner input = new Scanner(System.in);

        System.out.println("Search for student information...");
        System.out.print("\t\t\t\t\t\tInput student ID: ");
        if(input.hasNextInt()){
            int id = input.nextInt();
            input.nextLine();
            System.out.println("Searching for student ID " + id);
            for(int i = 0; i < studentId.size(); i++){
                if(studentId.get(i).equals(id)){
                    System.out.println("\t\t\t\t\t\tSearch result: ");
                    System.out.println("\t\t\t\t\t\t\tName: " + studentName.get(i) +
                            "\n\t\t\t\t\t\t\tDepartment: " + studentDepartment.get(i) +
                            "\n\t\t\t\t\t\t\tAge: " + studentAge.get(i));
                    break;
                }
            }
            if(!studentId.contains(id)){
                System.out.println("\t\t\t\t\t\t\tID " + id + " is not in the list." +
                        "\n\t\t\t\t\t\t\tPlease input correct ID!");
            }
        }else{
            input.nextLine();
            System.out.println("Invalid input, please input correctly!");
        }
    }
    public void menu(){
        StudentSystem get = new StudentSystem();
        get.line();
        System.out.println("\t\t\t\t\t\t\t\t\tStudent System Management");
        get.line();
        System.out.println(""" 
                \t\t\t\t\t\t\t1. Add student information 
                \t\t\t\t\t\t\t2. See list of student 
                \t\t\t\t\t\t\t3. Remove student information 
                \t\t\t\t\t\t\t4. Search for student information 
                \t\t\t\t\t\t\t5. Exit""");
    }


    public static void main(String[] args){
        StudentSystem get = new StudentSystem();
        Scanner input = new Scanner(System.in);

        int choice;
        do{
            get.menu();
            System.out.print("\t\t\t\t\t\tInput choice: ");
            if(input.hasNextInt()){
                choice = input.nextInt();
                input.nextLine();
                get.line();
                switch(choice){
                    case 1:
                        get.addStudentInfo();
                        break;
                    case 2:
                        get.listOfStudent();
                        break;
                    case 3:
                        get.removeStudent();
                        break;
                    case 4:
                        get.searchStudent();
                        break;
                    case 5:
                        System.out.println("Exiting program!");
                        break;
                }
            }else{
                get.line();
                System.out.println("Invalid input, please input correctly!");
                input.next();
                choice = 0;
            }
        }while(choice != 5);
    }
}
