//Johnny Tran Section 
//1. 30. 2022
//Assignment 3. Draw A Picture

//Program will draw a something in ASCII using for loops and nested loops 
//Program also needs class constant Size that will change the size of the picture 

public class AsciiArt {
    
    //Changes the size of the output 
    public static final int size = 5;
    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            System.out.print("_");
            for (int j = 0; j < size; j++) {
                System.out.print(".....");
                System.out.print("#");
            }
        }
        System.out.println("");
        for (int g = 0; g < size/2; g++) {
            for (int h = 0; h < size; h++) {    
                for (int i = 0; i < size; i++) {
                    System.out.print("#");
                    for (int j = 0; j < size; j++) {
                        System.out.print("_");
                    }
                }
            }   
        System.out.println("");
                
        }
        for (int i = 0; i < size; i++) {
            System.out.print("_");
            for (int j = 0; j < size; j++) {
                System.out.print("....");
                System.out.print("#");
            }
        }    
    }
} 

   