package pt.migcv.binary101.core;

import java.util.ArrayList;

import pt.migcv.binary101.core.exception.IsEmptyException;
import pt.migcv.binary101.core.exception.NotBinaryException;
import pt.migcv.binary101.core.exception.NotDecimalException;
import pt.migcv.binary101.core.exception.NotHexadecimalException;

public class Converter {

    private static char[] hexaAlphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String[] convertDecimal(String decimalNumber) throws NotDecimalException, IsEmptyException {
        decimalNumber = decimalNumber.replaceAll("\\s+","");
        if (decimalNumber.isEmpty()) {
            throw new IsEmptyException(decimalNumber);
        }
        try {
            String[] res = new String[3];
            // DECIMAL --> BINNARY
            String binaryNumber = Integer.toString(Integer.parseInt(decimalNumber), 2);
            // BINNARY --> HEXADECIMAL
            String hexadecimalNumber = convertBinaryToHexadecimal(binaryNumber);
            System.out.println("10:BINARY: " + binaryNumber);
            System.out.println("10:HEXADECIMAL: " + hexadecimalNumber);
            res[0] = formatString(binaryNumber, 4, ' ');    // BINARY NUMBER
            res[1] = formatString(decimalNumber, 3, ' ');   // DECIMAL NUMBER
            res[2] = hexadecimalNumber;
            return res;
        } catch (NumberFormatException e) {
            throw new NotDecimalException(decimalNumber);
        }
    }

    public static String[] convertBinary(String binaryNumber) throws NotBinaryException, IsEmptyException {
        binaryNumber = binaryNumber.replaceAll("\\s+","");
        if (binaryNumber.isEmpty()) {
            throw new IsEmptyException(binaryNumber);
        }
        if (!binaryNumber.matches("^[0-1]+$")) {
            throw new NotBinaryException(binaryNumber);
        }
        String[] res = new String[3];
        int decimalNumber = 0;
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            // BINNARY --> DECIMAL
            int decimalAux = Character.getNumericValue(binaryNumber.charAt(i));
            decimalNumber += decimalAux * Math.pow(2, binaryNumber.length() - 1 - i);
        }
        // BINNARY --> HEXADECIMAL
        String hexadecimalNumber = convertBinaryToHexadecimal(binaryNumber);
        System.out.println("2:DECIMAL: " + decimalNumber);
        System.out.println("2:HEXADECIMAL: " + hexadecimalNumber);
        res[0] = formatString("" + binaryNumber, 4, ' ');   // BINARY NUMBER
        res[1] = formatString("" + decimalNumber, 3, ' ');  // DECIMAL NUMBER
        res[2] = hexadecimalNumber;
        return res;
    }

    public static String[] convertHexadecimal(String hexadecimalNumber) throws NotHexadecimalException {
        hexadecimalNumber = hexadecimalNumber.toUpperCase();
        hexadecimalNumber = hexadecimalNumber.replaceAll("\\s+","");
        if (!hexadecimalNumber.matches("^[0-9A-F]+$")) {
            throw new NotHexadecimalException(hexadecimalNumber);
        }
        String[] res = new String[3];
        int decimalNumber = 0;
        // HEXADECIMAL --> DECIMAL
        for (int i = 0; i < hexadecimalNumber.length(); i++) {
            for (int j = 0; j < hexaAlphabet.length; j++) {
                if (hexadecimalNumber.charAt(i) == hexaAlphabet[j]) {
                    decimalNumber += Math.pow(16, hexadecimalNumber.length() - 1 - i) * j;
                    break;
                }
            }
        }
        // DECIMAL --> BINNARY
        String binaryNumber = Integer.toString(decimalNumber, 2);
        System.out.println("16:DECIMAL: " + decimalNumber);
        System.out.println("16:BINARY: " + binaryNumber);
        res[0] = formatString(binaryNumber, 4, ' ');  // BINARY NUMBER
        res[1] = formatString(""+decimalNumber, 3, ' '); // DECIMAL NUMBER
        res[2] = hexadecimalNumber;
        return res;
    }

    private static String convertBinaryToHexadecimal(String binnaryNumber) {
        String hexadecimalNumber = "";
        String hexadecimalAux = "";
        ArrayList<Integer> hexadecimalArray = new ArrayList<Integer>();
        for (int i = binnaryNumber.length() - 1, l = 0; i >= 0; i--, l++) {
            hexadecimalAux += "" + binnaryNumber.charAt(i);
            if ((l + 1) % 4 == 0 || i == 0) {
                int aux = 0;
                for (int j = hexadecimalAux.length() - 1; j >= 0; j--) {
                    int hexaAux = Character.getNumericValue(hexadecimalAux.charAt(j));
                    aux += hexaAux * Math.pow(2, j);
                }
                hexadecimalArray.add(aux);
                hexadecimalAux = "";
            }
        }
        for (int i = 0; i < hexadecimalArray.size(); i++) {
            hexadecimalNumber += "" + hexaAlphabet[hexadecimalArray.get(hexadecimalArray.size() - 1 - i)];
        }
        return hexadecimalNumber;
    }

    public static String formatString(String str, int space, char chr) {
        int i;
        String formatedStr = "";
        for(i = str.length(); i > space-1;) {
            formatedStr = chr + str.substring(i - space, i) + formatedStr;
            i -= space;
        }
        formatedStr = str.substring(0, i) + formatedStr;
        System.out.println("FORMATED STRING: <" + formatedStr + ">");

        return formatedStr;
    }
}
