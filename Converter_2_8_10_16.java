import java.util.Scanner;

public class Converter_2_8_10_16 {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String input = null;
        while (!"/exit".equals(input)) {
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
            input = sc.next();
            if (input.equals("/from")) {
                conversionFrom(sc);
            } else if (input.equals("/to")) {
                conversionTo(sc);
            }
        }
    }
    public static void conversionTo(Scanner sc) {
        System.out.println("Enter source number:");
        String source1 = sc.next();
        System.out.println("Enter source base:");
        int base1 = sc.nextInt();
        int result1;
        switch (base1) {
            case 2:
                result1 = Integer.parseInt(source1, 2);
                break;
            case 8:
                result1 = Integer.parseInt(source1, 8);
                break;
            case 16:
                result1 = Integer.parseInt(source1, 16);
                break;
            default:
                result1 = 0;
        }
        System.out.println("Conversion to decimal result: " + result1);
    }
    
    public static void conversionFrom(Scanner sc) {
        System.out.println("Enter number in decimal system:");
        int decimal = sc.nextInt();
        System.out.println("Enter target base:");
        int base = sc.nextInt();
        StringBuilder result = new StringBuilder();
        
        while (decimal > 0) {
            int aa = decimal % base;
            switch (aa) {
                case 10:
                    result.append("A");
                    break;
                case 11:
                    result.append("B");
                    break;
                case 12:
                    result.append("C");
                    break;
                case 13:
                    result.append("D");
                    break;
                case 14:
                    result.append("E");
                    break;
                case 15:
                    result.append("F");
                    break;
                default:
                    result.append(aa);
                    
                
            }
            decimal /= base;
        }
        result.reverse();
        System.out.println("Conversion result: " + result);
        
    }
}
