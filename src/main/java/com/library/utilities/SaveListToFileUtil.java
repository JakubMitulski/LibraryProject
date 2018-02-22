package com.library.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveListToFileUtil {
    public static void saveToFile(List list, String fileName) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(list);
            fout.close();
        } catch (IOException e) {
            System.out.println("Occurred an error with saving to file");
        }
    }
}
