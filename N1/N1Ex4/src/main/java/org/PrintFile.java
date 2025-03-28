package org;

import java.io.*;
import java.text.SimpleDateFormat;

public class PrintFile {

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
        if (myDirectory.isDirectory()) {
            File[] files = myDirectory.listFiles();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println(indent + file.getName() + " " + sdf.format(file.lastModified()) + " (D)\r\n");
                        ;
                        developingTree(file, indent + "   ");
                    } else {
                        System.out.println(indent + file.getName() + " " + sdf.format(file.lastModified()) + " (F)\r\n");

                    }
                }
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(myDirectory.toString()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("An error occured. ");
            }
        }


    }

}


