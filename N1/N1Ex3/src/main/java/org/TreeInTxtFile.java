package org;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class TreeInTxtFile {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("You must enter a path as argument");
        }
        String indent = "";
        File myDirectory = new File(args[0]);
        if (!myDirectory.isDirectory() || !myDirectory.exists()) {
            System.out.println("The argument is not a valid directory");
        }

        developingTree(myDirectory, "");

    }

    public static void developingTree(File myDirectory, String indent) {
        File[] files = myDirectory.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    String myStringToWrite = indent + files[i].getName() + " " + sdf.format(files[i].lastModified()) + " (D)\r\n";
                    writingTree(myStringToWrite);
                    developingTree(files[i], indent + "   ");
                } else {
                    String myStringToWrite = indent + files[i].getName() + " " + sdf.format(files[i].lastModified()) + " (F)\r\n";
                    writingTree(myStringToWrite);
                }
            }
        }
    }

    public static void writingTree(String myStringToWrite){
        String projectDir = System.getProperty("user.dir");
        Path path = Paths.get(projectDir,"..", "..", "directory.txt");
        try(FileWriter writer = new FileWriter(path.toString(), true)){
            writer.write(myStringToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
