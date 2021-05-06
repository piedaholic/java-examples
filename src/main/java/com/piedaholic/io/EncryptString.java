package com.piedaholic.io;

import java.io.Console;
import java.util.Arrays;

public class EncryptString {

    private static String string;
    private static char[] secretKey;
    private static String encryptionAlgo;
    /*-
        The AES algorithm is an iterative, symmetric-key block cipher that supports 
        cryptographic keys (secret keys) of 128, 192, and 256 bits to encrypt and decrypt data in blocks of 128 bits.
        If the data to be encrypted does not meet the block size of 128 bits requirement, it must be padded. 
        Padding is a process of filling up the last block to 128 bits.
        
        The AES algorithm has six modes of operation:
    
            ECB (Electronic Code Book)
            CBC (Cipher Block Chaining)
            CFB (Cipher FeedBack)
            OFB (Output FeedBack)
            CTR (Counter)
            GCM (Galois/Counter Mode)
    
        The mode of operation may be applied in order to strengthen the effect of the encryption algorithm. 
        Moreover, the mode of operation may convert the block cipher into a stream cipher. 
        Each mode has its strength and weakness. 
    */
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
