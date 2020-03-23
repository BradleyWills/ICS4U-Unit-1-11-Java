
import java.util.Scanner;

/**
* The StudentInputs program implements an application that allows you to
* input information about a student and the program will save/output it.
*
* @author  Bradley Wills
* @version 1.0
* @since   2020-03-22
*/

public class StudentInputs {
  // Create variables 
  static double userPlanetDistance;
  static double planetDistance;

  
  enum Grades {
    TWELVE("12"), ELEVEN("11"), TEN("10"), NINE("9"), EIGHT("8"), SEVEN("7"),
    SIX("6"), FIVE("5"), FOUR("4"), THREE("3"), TWO("2"), ONE("1"),
    SK("Senior Kindergarten"), JK("Junior Kindergarten");
    private String grade;
    Grades(String grade) {
      this.grade = grade;
    }
    
    public String getGrade() {
      return this.grade;
    }
  }
  
  /**
   * Plays the body of the program.
   */
  public static void main(String[] args) {
    boolean finished = false;
    Scanner userInput = new Scanner(System.in);
    System.out.println("How many students are you inputting information for?");
    int studentCount = Integer.parseInt(userInput.nextLine());
    String[][] studentInfo = new String[studentCount][5];
    
    for (int counter = 0; counter < studentCount; counter++) {
      System.out.println("Enter a first name for student # " + (counter + 1) + ".");
      studentInfo[counter][0] = userInput.nextLine();
      
      System.out.println("Enter a middle name for student # " + (counter + 1) + ".");
      studentInfo[counter][1] = userInput.nextLine();
      
      System.out.println("Enter a last name for student # " + (counter + 1) + ".");
      studentInfo[counter][2] = userInput.nextLine();
      
      System.out.println("Enter a date of birth (DD/MM/YYYY) for student # "
          + (counter + 1) + ".");
      studentInfo[counter][3] = userInput.nextLine();
      
      System.out.println("Enter a grade (as plain text: JK-TWELVE) for student # "
          + (counter + 1) + ".");
      studentInfo[counter][4] = userInput.nextLine().toUpperCase();
      
      
    }
    boolean invalidCheck = false;
    int studentNum;
    String finishedInput;
    System.out.println("Do you want to check the information of a student?");
    while (invalidCheck == false) {
      finishedInput = userInput.nextLine().toUpperCase();
      if (finishedInput.equals("NO")) {
        invalidCheck = true;
      } else if (finishedInput.equals("YES")) {
        invalidCheck = true;
        System.out.println("Input the student number:");
        try {
          studentNum = userInput.nextInt();
          if ((studentNum >= 1) && (studentNum <= studentInfo.length + 1)) {
            // Formats the names
            String properFirstName = studentInfo[studentNum - 1][0].substring(0, 1).toUpperCase()
                + studentInfo[studentNum - 1][0].substring(1).toLowerCase();
            String properMidName = studentInfo[studentNum - 1][1].substring(0, 1).toUpperCase()
                + studentInfo[studentNum - 1][1].substring(1).toLowerCase();
            String properLastName = studentInfo[studentNum - 1][2].substring(0, 1).toUpperCase()
                + studentInfo[studentNum - 1][2].substring(1).toLowerCase();
            // Outputs the information
            System.out.println("Name: " + properFirstName + " " + properMidName + " "
                + properLastName);
            System.out.println("Birthday: " + studentInfo[studentNum - 1][3]);
            System.out.println("Grade: " 
                + Grades.valueOf(studentInfo[studentNum - 1][4]).getGrade());
          } else {
            // Informs user their input is invalid
            System.out.println("Invalid Input");
          }
        } catch (Exception e) {
          // Informs user their input is invalid
          System.out.println("Invalid Input");
        }
      } else {
        invalidCheck = false;
        System.out.println("Invalid Input. Input yes or no.");
      }  
    }
  }
}