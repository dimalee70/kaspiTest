import java.util.Scanner;

public class Main {
    static RomanNumeral Numeral = new RomanNumeral();



    public static void main (String[] args)
    {
        System.out.println("Enter your Roman Numerals or Integer number:");

        Scanner console = new Scanner(System.in);

        String value = console.next();

        try {
            char c = value.charAt( 0 );

            if ( Character.isDigit( c ) )
            {
                int int_value = Integer.parseInt( value );

                System.out.println("Roman value = " + Numeral.convertIntegerToRoman(int_value));
            }
            else {

                System.out.println("Integer value = " + Numeral.convertRomanToInt(value));
            }
        }
        catch( NumberFormatException e)
        {
            System.out.println("Problem: Invalid format");
        }

    }
}

