package ru;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/ru/javawebinar/basejava");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        list(".\\");
    }

    static void list(String directory) {
        File dir = new File(directory);
        String[] files = dir.list();
        if (files != null) {
            for (String file : files) {
                File f = new File(directory + File.separator + file);
                if (f.isFile()) {
                    System.out.println(directory + File.separator + "\n\t" + file);
                } else {
                    for (String file1 : files) {
                        if (file1.equals(file)) {
                        } else {
                            list(directory + File.separator + file);
                        }
                    }

                }
            }
        }
    }
}
