package com.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadListFromFileUtil {
    public static List readFromFile(String fileName) {
        List list = new ArrayList();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                list = (List) objectInputStream.readObject();
                objectInputStream.close();
            }
        } catch (IOException ignored) {

        } catch (ClassNotFoundException e) {
            System.out.println("Occurred an error with reading from file");
        }
        return list;
    }
}
