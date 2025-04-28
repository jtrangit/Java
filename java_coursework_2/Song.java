//Johnny Tran Section 
//1. 23. 2022
//Assignment 2. Get You a Cat

//Program will print out 6 verses from the American folk song 'Bought Me a Cat'

public class Song {

    public static void main(String[] args) {
        //verse 1
        verseOne();
        System.out.println(" ");

        //verse 2
        verseTwo();
        System.out.println(" ");

        //verse 3
        verseThree();
        System.out.println(" ");
        //verse 4
        verseFour();
        System.out.println(" ");
        //verse 5
        verseFive();
        System.out.println(" ");
        //verse 6
        verseSix();
    }

    static void verseOne() {
        System.out.println("Bought me a cat and the cat pleased me,");
        System.out.println("I fed my cat under yonder tree.");
        fiddle();
    }

    static void verseTwo() {
        System.out.println("Bought me a hen and the hen pleased me,");
        System.out.println("I fed my hen under yonder tree.");
        chimmy();
        fiddle();
    }

    static void verseThree() {
        System.out.println("Bought me a duck and the duck pleased me,");
        System.out.println("I fed my duck under yonder tree.");
        quack();
        chimmy();
        fiddle();
    }

    static void verseFour() {
        System.out.println("Bought me a goose and the goose pleased me,");
        System.out.println("I fed my goose under yonder tree.");
        hissy();
        quack();
        chimmy();
        fiddle();
    }

    static void verseFive() {
        System.out.println("Bought me a sheep and the sheep pleased me,");
        System.out.println("I fed my sheep under yonder tree.");
        sheep();
        hissy();
        quack();
        chimmy();
        fiddle();
    }

    static void verseSix() {
        System.out.println("Bought me a bird and the bird pleased me,");
        System.out.println("I fed my bird under yonder tree.");
        bird();
        sheep();
        hissy();
        quack();
        chimmy();
        fiddle();
    }

    static void fiddle() {
        System.out.println("Cat goes fiddle-i-fee");
    }
    static void chimmy() {
        System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
    }
    static void quack() {
        System.out.println("Duck goes quack, quack,");
    }
    static void hissy() {
        System.out.println("Goose goes hissy, hissy,");
    }
    static void sheep() {
        System.out.println("Sheep goes baa, baa,");
    }
    static void bird() {
        System.out.println("Bird goes chirp, chirp,");
    }
}