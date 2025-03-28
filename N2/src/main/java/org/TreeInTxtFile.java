package org;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class TreeInTxtFile {

    public static void main(String[] args) throws IOException {
        Properties config = myProperties();
        String projectDir = System.getProperty("user.dir");

        String pathToFilesToRead = projectDir + config.getProperty("pathToFilesToRead");
        String pathToOutputDirectoryFile = projectDir + config.getProperty("pathToOutputDirectoryFile");
        String indent = "";


        File myDirectory = new File(pathToFilesToRead);
        if (!myDirectory.isDirectory() || !myDirectory.exists()) {
            System.out.println("file not found. Verify your path");
        }

        clearingTxtFileIfExists(pathToOutputDirectoryFile);
        developingTree(myDirectory, "", pathToOutputDirectoryFile);

    }

    public static Properties myProperties() {
        Properties myProperties = new Properties();

        try (InputStream myInput = TreeInTxtFile.class.getResourceAsStream("/assets/config.properties")) {
            myProperties.load(myInput);
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
            e.getMessage();
        }
    }

    public static void clearingTxtFileIfExists(String pathToOutputDirectoryFile) {
        Path path = Paths.get(pathToOutputDirectoryFile);
        if(Files.exists(path)) {
            try (
                    FileWriter writer = new FileWriter(path.toString())) {
                writer.write("");
            } catch (
                    IOException e) {
                e.getMessage();
            }
        }
    }

//    public static Path settingDirectoryDocumentPath(){
//        String projectDir = System.getProperty("user.dir");
//        Path path = Paths.get(projectDir, "..", "..", "directory.txt");
//        return path;
//
//    }
}
