import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        List<String> cart = new ArrayList<>();

        Console cons = System.console();
        Scanner scan = new Scanner(System.in);
        String input = "";
        
        while (!input.equals("quit")) {
            input = cons.readLine().toLowerCase();
            
            if (input.equals("list")) {

                if (cart.size() > 0) {
                    for (int x = 0; x < cart.size(); x++) {
                        //System.out.println(x+1 + ". " + cart.get(x));
                        System.out.printf("%d. %s\n", (x+1), cart.get(x));
                    }
                } else {
                    System.out.println("Your cart is empty");
                    }
                }

                if (input.startsWith("add")) {
                    input = input.replace(',',' ').trim();
                    scan = new Scanner(input.substring(4));
                    String stringVal = "";
                    while (scan.hasNext()) {
                        stringVal = scan.next();
                        cart.add(stringVal);
                    }
                }

                if (input.startsWith("delete")) {
                    input = input.replace(',',' ').trim();

                    scan = new Scanner(input.substring(6));
                    String stringVal = scan.next();
                    
                    int cartPosition = Integer.parseInt(stringVal);
                    cartPosition --;

                    if (cartPosition > cart.size()) {
                        System.out.println("Incorrect Cart Position");
                    } else {
                        cart.remove(cartPosition);
                    }
            }

        }
        System.out.println("Bye! Bye! See you again...");

}
}
