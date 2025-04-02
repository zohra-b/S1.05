package org;

import javax.crypto.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Properties;


public class TreeInTxtFile {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Properties config = myProperties();

        String projectDir = System.getProperty("user.dir");

        String pathToFilesToRead = projectDir + config.getProperty("pathToFilesToRead");
        String pathToOutputDirectoryFile = projectDir + config.getProperty("pathToOutputDirectoryFile");
        String pathToEncryptedFile = projectDir + config.getProperty("pathToEncryptedFile");
        String pathToDecryptedFile = projectDir + config.getProperty("pathToDecryptedFile");
        String indent = "";

        SecretKey myKey = myKey();


        File myDirectory = new File(pathToFilesToRead);
        if (!myDirectory.isDirectory() || !myDirectory.exists()) {
            System.out.println("file not found. Verify your path");
        }


        clearingTxtFileIfExists(pathToOutputDirectoryFile);
        try {
            developingTree(myDirectory, "", pathToOutputDirectoryFile);
            System.out.println("An output file : " + pathToOutputDirectoryFile + " has been created");
        } catch (Exception e) {
            System.out.println("the output file creation failed : " + e.getMessage());
        }
        encryptFile(pathToOutputDirectoryFile, pathToEncryptedFile, myKey );
        decryptfile(pathToEncryptedFile, pathToDecryptedFile, myKey );

    }

    public static Properties myProperties() {
        Properties myProperties = new Properties();
        //Path configUrl = Paths.get("C:/Users/zocat/IdeaProjects/S1.05-JavaUtils/N3/src/main/resources/config.properties");


        try (InputStream myInput =(
                TreeInTxtFile.class.getClassLoader().getResourceAsStream("config.properties"))) {

            if(myInput == null){
                throw new FileNotFoundException("config.properties not found");
            }
            myProperties.load(myInput);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        }
        return myProperties;
    }

    public static void developingTree(File myDirectory, String indent, String pathToOutputDirectoryFile) {
        File[] files = myDirectory.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    String myStringToWrite = indent + files[i].getName() + " " + sdf.format(files[i].lastModified()) + " (D)\r\n";
                    writingTree(myStringToWrite, pathToOutputDirectoryFile);
                    developingTree(files[i], indent + "   ", pathToOutputDirectoryFile);
                } else {
                    String myStringToWrite = indent + files[i].getName() + " " + sdf.format(files[i].lastModified()) + " (F)\r\n";
                    writingTree(myStringToWrite, pathToOutputDirectoryFile);
                }
            }
        }

    }



    public static void writingTree(String myStringToWrite, String pathToOutputDirectoryFile) {

        try (FileWriter writer = new FileWriter(pathToOutputDirectoryFile, true)) {
            writer.write(myStringToWrite);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clearingTxtFileIfExists(String pathToOutputDirectoryFile) {
        Path path = Paths.get(pathToOutputDirectoryFile);

        try {

            Files.deleteIfExists(path);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static SecretKey myKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey myKey = keyGen.generateKey();
        System.out.println("A key has succesfully been generated");
        return myKey;

    }

    public static void encryptFile(String inputFile, String outputFile, SecretKey myKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, myKey);

        try (FileInputStream in = new FileInputStream(inputFile);
             FileOutputStream out = new FileOutputStream(outputFile);
             CipherOutputStream cipherOut = new CipherOutputStream(out, cipher)) {

            byte[] buffer = new byte[8192]; // Tampon de 8KB
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                cipherOut.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("An encrypted file has been successfully generated in " + outputFile);
    }

    public static void decryptfile(String encryptedFile, String decryptedFile,  SecretKey myKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, myKey);

        try (InputStream in = new FileInputStream(encryptedFile);
             CipherInputStream cipherIn = new CipherInputStream(in, cipher);
             FileOutputStream out = new FileOutputStream(decryptedFile);
        ) {

            byte[] buffer = new byte[8192]; // Tampon de 8KB
            int bytesRead;
            while ((bytesRead = cipherIn.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
