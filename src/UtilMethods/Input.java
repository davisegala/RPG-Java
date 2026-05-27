package UtilMethods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    
    //Return a player int input
    public static int Int() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Try again");
                scanner.next();
            }
        }
    }
    
    //Return a player String input
    public static String String() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Try again");
                scanner.next();
            }
        }
    }
    
    //Return a player int input in the range   
    public static int Choise(int range){
        while (true){
            int num = Input.Int();
            if (Input.choiseInRange(num, range)) {
                return num;
            } else {
                System.out.println("Invalid choise");
            }
        }
    }
    
    public static boolean choiseInRange(int var, int range){
        return 1 <= var && var <= range;
    }
}
