import java.util.Scanner;

/**
 * bineryconversion
 */
public class bineryconversion {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        try (Scanner input = new Scanner(System.in)) {
            int number = input.nextInt();
            System.out.println("The Binary code of " + number + " is : " +decToBinary(number));
            System.out.println("The BCD code of " + number + " is : " + decToBCD(number));
            System.out.println("The gray code of " + number + " is : " + toGray(number));       
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
        int Originalnum = num;
        //if the bit is a 0 return 4 bits (aesthetic purpose)
        if(num == 0) { return "0000"; }
        while(num != 0)
        {
            //get the digits individually
            int t =  num % 10;
            //convert the individual digit to binary
            String tBCD = decToBinary(t);
            
            while(tBCD.length() < 4)
            {
                tBCD = "0" + tBCD;
            }
            //store the 
            BCD = tBCD + BCD;
            //divide by 10, to get the next digit in the number --> int t = num % 10
            num /= 10; 
        }
        if(Originalnum > 9)
        {
            System.out.println(BCD.substring(0, (BCD.length()/Originalnum)));
        }
        return BCD;
    }

    public static String toGray(int dec)
    {
        String binary = decToBinary(dec);
        // a String variable to store the obtained gray
        String gray = "";
        //store the first bit of the binary code
        gray += binary.charAt(0);    
        for (int i = 1; i < binary.length(); i++)
        {
            // perform XOR on the previous bit and the
            // current bit of the binary string
            gray += (Integer.parseInt(String.valueOf(binary.charAt(i - 1))) ^ Integer.parseInt(String.valueOf(binary.charAt(i))));      
        }
        return gray;
    }
}