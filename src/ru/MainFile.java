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

    static void list(String szDir) {
        File f = new File(szDir);
        String[] sDirList = f.list();
        int i;
        for (i = 0; i < sDirList.length; i++) { 
            File f1 = new File(szDir + File.separator + sDirList[i]);
            if (f1.isFile()) {
                System.out.println(szDir + File.separator + sDirList[i]);
            } else {
                list(szDir + File.separator + sDirList[i]);
            }
        }
    }
}
