package com.piedaholic.security;

public class TestSecurity {
    /*
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
    */
}
