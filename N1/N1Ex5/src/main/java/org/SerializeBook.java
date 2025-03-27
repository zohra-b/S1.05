package org;

import java.io.*;

public class SerializeBook {
    public static void serialize(){

        final Book book = new Book("George Orwell", "1984", "9788499890944");
        ObjectOutputStream oos = null;



        try {
            final FileOutputStream mySerFile = new FileOutputStream("book.ser");

            oos = new ObjectOutputStream(mySerFile);

            oos.writeObject(book);
            oos.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
