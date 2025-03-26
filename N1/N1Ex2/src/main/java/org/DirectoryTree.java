package org;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class DirectoryTree {
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
                    System.out.println(indent + files[i].getName() + " " + sdf.format(files[i].lastModified()) + " (D)");
                    developingTree(files[i], indent + "   ");
                } else {
                    System.out.println(indent + files[i].getName() + " " + sdf.format(files[i].lastModified()) + " (F)");
                }
            }
        }
    }
}
