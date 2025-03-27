package org;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeBook {
    public static void deserialize(){
       ObjectInputStream ois = null;

       try{
            final FileInputStream myDeserFile = new FileInputStream("book.ser");

            ois = new ObjectInputStream(myDeserFile);

            final Book book = (Book) ois.readObject();

           System.out.println(book.getTitle() + " - " + book.getAuthor() + " - Isbn: " + book.getIsbn());

       } catch (IOException e){
           System.out.println(e.getMessage());
       } catch (final ClassNotFoundException e){
           System.out.println(e.getMessage());
       }
       finally {
            try {
                if (ois != null){
                    ois.close();
                }
            } catch (IOException e){
                e.getMessage();
            }
       }


    }

}

















