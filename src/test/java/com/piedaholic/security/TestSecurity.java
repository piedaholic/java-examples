package com.piedaholic.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Assert;
import org.junit.Test;

public class TestSecurity {
    @Test
    void givenString_whenEncrypt_thenSuccess() throws NoSuchAlgorithmException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        String input = "baeldung";
        SecretKey key = AESUtil.generateKey(128);
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = AESUtil.encrypt(algorithm, input, key, ivParameterSpec);
        String plainText = AESUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);
        Assert.assertEquals(input, plainText);
    }

    @Test
    void givenFile_whenEncrypt_thenSuccess() throws NoSuchAlgorithmException, IOException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        SecretKey key = AESUtil.generateKey(128);
        String algorithm = "AES/CBC/PKCS5Padding";
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        //Resource resource = new ClassPathResource("inputFile/baeldung.txt");
        //File inputFile = resource.getFile();
        File encryptedFile = new File("classpath:baeldung.encrypted");
        File decryptedFile = new File("document.decrypted");
        //AESUtil.encryptFile(algorithm, key, ivParameterSpec, inputFile, encryptedFile);
        //AESUtil.decryptFile(algorithm, key, ivParameterSpec, encryptedFile, decryptedFile);
        //assertThat(inputFile).hasSameTextualContentAs(decryptedFile);
    }

    @Test
    void givenPassword_whenEncrypt_thenSuccess()
            throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        String plainText = "www.baeldung.com";
        String password = "baeldung";
        String salt = "12345678";
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        SecretKey key = AESUtil.getKeyFromPassword(password, salt);
        //String cipherText = AESUtil.encryptPasswordBased(plainText, key, ivParameterSpec);
        //String decryptedCipherText = AESUtil.decryptPasswordBased(cipherText, key, ivParameterSpec);
        //Assertions.assertEquals(plainText, decryptedCipherText);
    }

    @Test
    void givenObject_whenEncrypt_thenSuccess() throws NoSuchAlgorithmException, IllegalBlockSizeException,
            InvalidKeyException, InvalidAlgorithmParameterException, NoSuchPaddingException, IOException,
            BadPaddingException, ClassNotFoundException {

        //Student student = new Student("Baeldung", 20);
        SecretKey key = AESUtil.generateKey(128);
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        // SealedObject sealedObject = AESUtil.encryptObject(algorithm, student, key, ivParameterSpec);
        //Student object = (Student) AESUtil.decryptObject(algorithm, sealedObject, key, ivParameterSpec);
        //assertThat(student).isEqualToComparingFieldByField(object);
    }
}
