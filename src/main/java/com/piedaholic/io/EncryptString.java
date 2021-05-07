package com.piedaholic.io;

import java.io.Console;
import java.util.Arrays;

public class EncryptString {

    private static String string;
    private static char[] secretKey;
    private static String encryptionAlgo;
    
    // private static List<String> aesEncryptionAlgoList =
    // List.of("ECB","CBC","CFB","OFB","CTR","GCM");
    // Console console = new Console(); // DOES NOT COMPILE
    private static Console con = System.console();

    public static void main(String... args) {
        userInput();
    }

    public static void userInput() {
        if (con != null) {
            writeToConsole("Hello, Welcome to Java encryption Program!");
            string = con.readLine("Please enter the string to be encrypted : ");
            INPUT_AGAIN : while (true) {
                secretKey = con.readPassword("Please enter the secret key : ");
                var tmpString = con.readPassword("Please enter the secret key again : ");
                if (!Arrays.equals(secretKey, tmpString)) {
                    writeToConsole("The secret keys do not match");
                } else {
                    break INPUT_AGAIN;
                }
            }
            encryptionAlgo = con.readLine("Please enter the encryption algorithm : ");
            con.writer().format("String is %s, Secret Key is %s, Encryption Algorithm is %s", string,
                    // new String(secretKey)
                    String.valueOf(secretKey), encryptionAlgo);
        } else {
            System.err.println("System console not available");
        }

    }

    public static void writeToConsole(String msg) {
        con.writer().println(msg);
        con.writer().flush();
    }
}
