package org;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingFiles {
    public static void main(String[] args) throws IOException {

//        if (args.length != 1){
//            System.out.println("you must enter one argument");
//        }
//
//        //File myDirectory = new File(args[0]);
//        //Path myDirectory = Paths.get(args[0]);
//        Path myDirectory = Path.of(args[0]);
//        List<String> myFiles = null;
//        if(!Files.exists(myDirectory) || !Files.isDirectory(myDirectory)) {
//            System.out.println("This path (" + myDirectory + ") doesnt exist");
//        } else {
//            myFiles = Files.list(myDirectory)
//                    .map(p -> p.getFileName().toString())
//                    .sorted()
//                    .toList();
//        }
//
//           for(String file : myFiles){
//               System.out.println(file);
//           }
//        }
        if (args.length != 1) {
            System.out.println("You must enter one path as argument");
            return;
        }

        File dir = new File(args[0]);
        if (!dir.isDirectory()) {
            System.out.println("Invalid directory.");
            return;
        }

        String[] files = dir.list();
        if (files != null) {
            Arrays.sort(files);
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}


