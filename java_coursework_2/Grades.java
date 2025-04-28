import java.util.Scanner;

//Johnny Tran
//Feb 3. 2022
//Assignment 4 Grade calculation
//Program will calculate overall course grades using grades

class Grades {
    public static void main(String[] args) {
        System.out.println("Course Grade: " + (homeWork() + examOne() + examTwo()));
    }
    public static double homeWork() {
        Scanner scan = new Scanner(System.in);
        //Prompts user for homework weight
        System.out.println("Homework Weight Percentage:");
        int WeightedHomework = scan.nextInt();

        //Prompts user for the total number of homework assignments
        System.out.println("Total Homework Assignments: ");
        int numOfHomework = scan.nextInt();

        //Prompts user for Average HW grade
        System.out.println("Average Homework Grade: ");
        double avgHomework = scan.nextDouble();

        //Prompts user for the amount of late days used
        System.out.println("Late Days used: ");
        int lateDays = scan.nextInt();

        //Prompts user for the amount of labs attended
        System.out.println("Labs attended: ");
        int numOfLabs = scan.nextInt();

        //calculation for the total amount of homework points
        double totalHomeworkScore = (avgHomework * 10) + (numOfLabs * 4);

        if (lateDays > numOfHomework / 2) { //Late penalty of 10% for using too many late days
            avgHomework = avgHomework - avgHomework / 10;
        }
        else if (lateDays == 0) { //bonus 5 points for no late days used
            totalHomeworkScore += 5;
        }
        else { //no grade change for having a few latedays that is not over half of homework assignments
            totalHomeworkScore += 0;
        }

        //amount of total homework points
        double allHomework = ((numOfHomework * 10) + (numOfHomework * 4));


        System.out.println("Total Score: " + totalHomeworkScore + " / " + allHomework); //used numOfHomework instead of numOfLabs since the number of labs total is the same as homework

        double weightedHomeworkScore = WeightedHomework * (avgHomework * 10 + numOfLabs * 4) / (numOfHomework * 10 + numOfHomework * 4); //calculation for the weighted grade

        System.out.println("Weighted Score: " + weightedHomeworkScore);
        return weightedHomeworkScore;
    }
    public static double examOne() {
        Scanner scan = new Scanner(System.in);

        //Asks for exam 1 weight
        System.out.println("Exam 1 Weight: ");
        int examOneWeight = scan.nextInt();

        //Asks exam 1 score
        System.out.println("Exam 1 Score: ");
        int examOneScore = scan.nextInt();

        //Asks for exam 1 curve if any
        System.out.println("Curve: ");
        int examOneCurve = scan.nextInt();

        int examOneFinalScore = examOneScore + examOneCurve; //calculates the students total score on exam 1

        if (examOneFinalScore > 100) { //student's final exam 1 grade cannot be higher than 100
            examOneFinalScore = 100;
        }
        else if (examOneFinalScore < 0) { //student's final exam 1 grade cannot be lower than 0
            examOneFinalScore = 0;
        }

        System.out.println("Total Points: " + examOneFinalScore + " / 100");

        double examOneWeightedScore = examOneWeight * examOneFinalScore / 100;

        System.out.println("Weighted Score: " + examOneWeightedScore);

        return examOneWeightedScore;
    }
    public static double examTwo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Exam 2 Weight: ");
        int examTwoWeight = scan.nextInt();

        System.out.println("Exam 2 Score: ");
        int examTwoScore = scan.nextInt();

        System.out.println("Curve: ");
        int examTwoCurve = scan.nextInt();

        int examTwoFinalScore = examTwoScore + examTwoCurve; //calculates the students total score on exam 1

        if (examTwoFinalScore > 100) { //student's final exam 1 grade cannot be higher than 100
            examTwoFinalScore = 100;
        }
        else if (examTwoFinalScore < 0) { //student's final exam 1 grade cannot be lower than 0
            examTwoFinalScore = 0;
        }

        System.out.println("Total Points: " + examTwoFinalScore + " / 100");

        double examTwoWeightedScore = examTwoWeight * examTwoFinalScore / 100;

        System.out.println("Weighted Score: " + examTwoWeightedScore);

        return examTwoWeightedScore;
    }
}
