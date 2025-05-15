package studentscores;

import java.util.*;

public class StudentScores {

    public static void main(String[] args) {

        Scanner scannerObj = new Scanner(System.in);

        HashMap<String, Integer> studentScores = new HashMap<>();

        // asks the user to input how many students they want to insert in the hashmap
        System.out.print("How many students do you want to put? ");
        int students = scannerObj.nextInt();
        scannerObj.nextLine();

        System.out.println();

        // loops to add the students into the hashmap
        for (int i = 0; i < students; i++) {

            System.out.print("Student Name: ");
            String name = scannerObj.nextLine();

            System.out.print("Student Score: ");
            int score = scannerObj.nextInt();
            scannerObj.nextLine();

            studentScores.put(name, score);
            System.out.println();

        }

        System.out.println();

        OUTER:
        while (true) {

            // asks the user to select any of the following options
            System.out.println("Find score(1)");
            System.out.println("Update score(2)");
            System.out.println("Show students and scores(3)");
            System.out.println("Exit program(4)");
            System.out.print("Please select which action you want to do: ");
            int select = scannerObj.nextInt();
            scannerObj.nextLine();
            String selectedName;

            System.out.println();

            switch (select) {
                // the first option gives the user the score of the searched student
                // for options 1 and 2, if a searched student name does not exist it will not be found
                case 1 -> {
                    System.out.print("Enter student's name to find their score: : ");
                    selectedName = scannerObj.nextLine();
                    if (studentScores.containsKey(selectedName)) {
                        System.out.printf("%s's score is: %s", selectedName, studentScores.get(selectedName));
                    } else {
                        System.out.printf("%s was not found", selectedName);
                    }
                }
                // this option allows the user to change the score of the searched student
                case 2 -> {
                    System.out.print("Enter student's name to update their score: : ");
                    selectedName = scannerObj.nextLine();
                    if (studentScores.containsKey(selectedName)) {
                        System.out.print("Enter the new score: : ");
                        int newScore = scannerObj.nextInt();
                        scannerObj.nextLine();
                        studentScores.put(selectedName, newScore);
                        System.out.printf("%s's score updated successfully!", selectedName);
                        System.out.println();

                    } else {
                        System.out.printf("%s was not found", selectedName);
                    }
                }
                // this option displays all the added students using a for loop
                case 3 -> {
                    System.out.println("List of students and scores");
                    for (String student: studentScores.keySet()) {
                        System.out.printf("%s - %s",  student, studentScores.get(student));
                        System.out.println();
                    }
                }
                // this option breaks the loop and ends the program
                case 4 -> {
                    break OUTER;
                }
            }

            System.out.println();
            System.out.println();

        }

    }

}
