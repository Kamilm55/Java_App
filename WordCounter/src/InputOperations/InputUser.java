package InputOperations;

import java.util.Scanner;

public class InputUser {
    public static int enterNumInput(){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }

    public static String enterFileName(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }

}
