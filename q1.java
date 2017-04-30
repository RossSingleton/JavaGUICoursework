/*
 * Name: Ross Singleton
 * Student number: C1615528
 */
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.List;

 public class q1 {
   public static void main(String[] args) {
     // Uses Scanner to read in text from the command line
     Scanner in = new Scanner(System.in);

     // Gets the desired file name from the user
     System.out.println("Please enter a file name:");
     String userInput = in.nextLine();
     Path fileLocation = Paths.get(userInput);

     String fileName = "";

     // Check if the file entered by the user exists
     if (Files.exists(fileLocation)) {
       fileName = fileName + fileLocation.toString();
       System.out.println("Successfully loaded file: " + fileName);
     }
     else {
       try {
         Path userFile = Files.createFile(fileLocation);
       }
       catch (Exception notFound) {
         System.out.println("Error, file already exists");
         System.out.println(notFound);
         System.exit(0);
       }
     }

     int menu = 0;
     do {
          System.out.println("-Menu-");
          System.out.println("1. Display all students");
          System.out.println("2. Search for a course");
          System.out.println("3. Add New Student");
          System.out.println("4. Create a new file");
          System.out.println("5. Delete Student");
          System.out.println("6. Search by Address");
          System.out.println("7. Search for a subset of records");
          System.out.println("8. Exit");

          menu = in.nextInt();
          switch(menu) {
            case 1:
            try{
              //Create object of FileReader
              FileReader inputFile = new FileReader(fileName);

              //Instantiate the BufferedReader Class
              BufferedReader bufferReader = new BufferedReader(inputFile);

              //Variable to hold the one line data
              String line;

              // Read file line by line and print on the console
              while ((line = bufferReader.readLine()) != null)   {
                System.out.println(line);
              }
              //Close the buffer reader
              bufferReader.close();
            }
            catch(Exception e){
              System.out.println("Error: " + e.getMessage());
            }
            break;

            case 2:
            try {
              System.out.println("Please enter a course name:");
              Scanner scanner = new Scanner(System.in);
              String searchCourse = scanner.nextLine();

              //Create object of FileReader
              FileReader inputFile = new FileReader(fileName);

              //Instantiate the BufferedReader Class
              BufferedReader bufferReader = new BufferedReader(inputFile);

              //Variable to hold the one line data
              List<String> lines = new ArrayList<String>();
              String line = "";
              while ((line = bufferReader.readLine()) != null) {
                lines.add(line);
              }
              bufferReader.close();

              ArrayList<String> results = new ArrayList<>();

              for (String temp: lines) {
                String[] row = temp.split(",");
                if(row[2].toLowerCase().contains(searchCourse.toLowerCase())) {
                    results.add(temp);
                }
              }
              for (String result: results) {
                System.out.println(result);
              }
            }
            catch(Exception e) {
              System.out.println("Error: " + e.getMessage());
            }
            break;

            case 3:
            // initialise the variable we will use to collect all the students data
            String studentInfo = "";

            // used to validate each entry with regex
            Boolean valid = false;

            Scanner newStudent = new Scanner(System.in);

            do {
              System.out.println("Please enter the students name:");
              String studentName = newStudent.nextLine();

              if (studentName.matches("[a-zA-Z][a-zA-z ]*")) {
                studentInfo += (studentName + ",");
                System.out.println("Sucessfully Added");
                valid = true;
              }
              else {
                System.out.println("Names must contain only letters, and be at least 1 letter long");
              }
            } while (!valid); valid = false;

            valid = false;
            do {
              System.out.println("Please enter the student ID");
              String studentID = newStudent.nextLine();

              if (studentID.matches("[C][0-9]{7}")) {
                studentInfo += (studentID + ",");
                System.out.println("Sucessfully Added");
                valid = true;
              }
              else {
                System.out.println("The student ID should be uppercase C followed by 6 digits");
              }
            } while (!valid); valid = false;

            valid = false;
            do {
              System.out.println("Please enter the course name");
              String studentCourse = newStudent.nextLine();

              if (studentCourse.matches("[a-zA-Z][a-zA-z ]*")) {
                studentInfo += (studentCourse + ", ");
                System.out.println("Sucessfully Added");
                valid = true;
              }
              else {
                System.out.println("Course names must contain only letters, and be at least 1 letter long");
              }
            } while (!valid); valid = false;

            valid = false;
            do {
              System.out.println("Please enter the course ID");
              String courseID = newStudent.nextLine();

              if (courseID.matches("[A-Z]{2}[0-9]{4}")) {
                studentInfo += (courseID + ", ");
                System.out.println("Successfully Added");
                valid = true;
              }
              else {
                System.out.println("Course ID's should be 2 uppercase letters followed by 4 digits");
              }
            } while (!valid); valid = false;

            valid = false;
            do {
              System.out.println("Please enter the students house number");
              String houseNum = newStudent.nextLine();

              if (houseNum.matches("[0-9]+[a-zA-Z]?")) {
                studentInfo += (houseNum + ", ");
                System.out.println("Successfully Added");
                valid = true;
              }
              else {
                System.out.println("House number should be any numbers followed by 0 or 1 letter");
              }
            } while (!valid); valid = false;

            valid = false;
            do {
              System.out.println("Please enter the students street name");
              String streetName = newStudent.nextLine();

              if (streetName.matches("[a-zA-Z][a-zA-Z ]*")) {
                studentInfo += (streetName + ", ");
                System.out.println("Successfully Added");
                valid = true;
              }
              else {
                System.out.println("Street names should be letters only and at least one letter");
              }
            } while (!valid); valid = false;

            valid = false;
            do {
              System.out.println("Please enter the students town");
              String townName = newStudent.nextLine();

              if (townName.matches("[a-zA-Z][a-zA-Z ]*")) {
                studentInfo += (townName + ", ");
                System.out.println("Successfully Added");
                valid = true;
              }
              else {
                System.out.println("Town names should be letters only and at least one letter");
              }
            } while (!valid); valid = false;

            valid = false;
            do {
              System.out.println("Please enter the students postcode");
              String postCode = newStudent.nextLine();

              if (postCode.matches("[A-Z]{2}[0-9]{1}[A-Z]{2}")) {
                studentInfo += (postCode + ", ");
                System.out.println("Successfully Added");
                valid = true;
              }
              else {
                System.out.println("Postcodes should be 2 upper case letters, 1 digit, 2 upper case letters");
              }
            } while (!valid); valid = false;

            try {
            Path text = Paths.get(fileName);
            Files.write(text, "\n".getBytes(), StandardOpenOption.APPEND);
            Files.write(text, studentInfo.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Successfully Written To File");
            }
            catch (Exception e) {
              e.printStackTrace();
            }

            break;

            case 4:
            System.out.println("Please enter the name of the file you want to create: ");
            Scanner inputTxt = new Scanner(System.in);
            String newUserFile = inputTxt.nextLine();
            Path newFileLocation = Paths.get(newUserFile);


            try {
              Path createNewFile = Files.createFile(newFileLocation);
              System.out.println("New file sucessfully created");
            }
            catch (Exception notFound) {
              System.out.println("Error, file already exists");
              System.out.println(notFound);
              System.exit(0);
            }
            break;

            case 5:
            try {
              System.out.println("Please enter the line you want to delete:");
              Scanner scanner = new Scanner(System.in);
              int lineDelete = scanner.nextInt();

              //Create object of FileReader
              FileReader inputFile = new FileReader(fileName);

              //Instantiate the BufferedReader Class
              BufferedReader bufferReader = new BufferedReader(inputFile);

              //Variable to hold the one line data
              List<String> lines = new ArrayList<String>();
              String line = "";
              while ((line = bufferReader.readLine()) != null) {
                lines.add(line);
              }
              bufferReader.close();

              lines.remove(lineDelete);

              try {
                Path tempFile = Files.createFile(Paths.get("temp.txt"));
                for (String temp: lines) {
                  Files.write(tempFile, temp.getBytes(), StandardOpenOption.APPEND);
                  Files.write(tempFile, "\n".getBytes(), StandardOpenOption.APPEND);
                }
                Files.delete(fileLocation);

                Files.move(tempFile, fileLocation);

                System.out.println("Successfully Deleted from the File");
              }
              catch (Exception e) {
                e.printStackTrace();
              }
            }
            catch (Exception e) {
              e.printStackTrace();
            }
            break;

            case 6:
            
            break;
          }
        } while(menu != 8);
   }
  }
