package com.library.common;

import java.io.File;
import java.io.IOException;

public class FileCreator {

   public void createFile (String fileName) {

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//