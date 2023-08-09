package InputOperations;

import java.util.Scanner;

public class InputUser {
    public static int enterNumInput(){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
//        sc.close();
        return input;
    }

    public static String enterFileName(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
//        sc.close();
//    Closing System.in: If you are using System.in as the input stream for your Scanner, you should avoid closing it since it represents the standard input of the program. Closing it could lead to unexpected behavior.
        return input;
    }
}
