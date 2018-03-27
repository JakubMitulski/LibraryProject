/**
 * FileCreator.java
 * Purpose: class for creating new file when such a file with given name does not exist.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.common;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    public void createFile(String fileName) {

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
