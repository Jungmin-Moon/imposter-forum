package sqlfiles;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Forbidden_Passwords {

    List<String> forbiddenWords = new ArrayList<>();
    String path = "D:\\Programming\\Portable Forum\\src\\Plan.txt";

    protected void buildList() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str;

            while ((str = br.readLine()) != null) {
                forbiddenWords.add(str);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }


    }


    protected boolean comparePassword(String potentialPassword) {

        boolean forbidden = false;

        for (String s: forbiddenWords) {
            if (potentialPassword.equalsIgnoreCase(s)) {
                return true;
            }
        }

        return forbidden;
    }
}
