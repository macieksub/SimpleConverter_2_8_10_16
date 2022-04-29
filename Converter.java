import java.util.Scanner;
import java.math.BigInteger;

public class Converter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = new String();
        while (!"/exit".equals(input)) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            input = sc.nextLine();
            String qwe = null;
            while (!"/exit".equals(input) && !"/back".equals(qwe) && !"".equals(input)) {
                String[] num = input.split(" ");
                int sb = Integer.parseInt(num[0]);
                int tb = Integer.parseInt(num[1]);
                System.out.printf("Enter number in base %d to convert to base %d (To go back type /back)", sb, tb);
                qwe = sc.next();
                if (!"/back".equals(qwe)) {
                    core(qwe, sb, tb);
                }
            }
        }
    }
    public static void core(String qwe, int sb, int tb) {
        if (!qwe.contains(".")) {
            BigInteger number = new BigInteger(qwe.toUpperCase(), sb);
            System.out.println("Conversion result: " + number.toString(tb));
        } else {
            String[] fractional = qwe.split("\\.");
            BigInteger number = new BigInteger(fractional[0].toUpperCase(), sb);
            double result = 0;
            System.out.print("Conversion result: " + number.toString(tb));
            //konwersja reszty na dziesiętny
            for (int i = 0; i < fractional[1].length(); i++) {
                if (fractional[1].charAt(i) - 48 <= 9) {
                    result += (fractional[1].charAt(i) - 48) * (1 / Math.pow(sb, (i + 1)));
                } else {
                    result += (fractional[1].charAt(i) - 87) * (1 / Math.pow(sb, (i + 1)));
                }
            }
            StringBuilder finalFract = new StringBuilder();
            for (int i = 0; i < 5 && result != 0.0; i++) {
                int przedPrzecinkiem = (int) (result * tb);
                result = result * tb - przedPrzecinkiem;
                if (przedPrzecinkiem <= 9) {
                    finalFract.append((char)(przedPrzecinkiem + 48));
                } else {
                    finalFract.append((char)(przedPrzecinkiem + 87));
                }
            }
            System.out.println("." + finalFract);
        }
    }
}