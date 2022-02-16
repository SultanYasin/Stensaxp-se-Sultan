package ec.utbildning;

import java.util.*;


public class User implements Players {


    static String UserVal() {
        String playerVal = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("välj ditt drag :");
        System.out.println("1-sten  \n2-sax \n3-påse");
        int theAnswer = scanner.nextInt();
        System.out.println(theAnswer);
        switch (theAnswer) {
            case 1 -> playerVal = "sten";
            case 2 -> playerVal = "sax";
            case 3 -> playerVal = "påse";
            default -> {
                System.out.println(" du valde fel val");
                playerVal = UserVal();
            }
        }
        return playerVal;
    }


    @Override
    public void takeTurn() {

    }
}
