import java.util.Scanner;

/**
 * bineryconversion
 */
public class bineryconversion {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        try (Scanner input = new Scanner(System.in)) {
            int number = input.nextInt();
            System.out.println(decToBinary(number));
            System.out.println(decToBCD(number));
        }
        
    }

    //convert decimal to binary
    public static String decToBinary(int dec) {
        String binary = "";
        if(dec == 0) { return "0"; }
        while (dec > 0) {
            binary = dec % 2 + binary;
            dec /= 2;
        }
        return binary;
    }

    //convert dec to BCD Code
    public static String decToBCD(int num) {
        String BCD = "";
        if(num == 0) { return "0000"; }
        while(num != 0)
        {
            int t =  num % 10;
            String tBCD = decToBinary(t);
            
            while(tBCD.length() < 4)
            {
                tBCD = "0" + tBCD;
            }

            BCD = tBCD + BCD;
            num /= 10; 
        }
        return BCD;
    }
}
