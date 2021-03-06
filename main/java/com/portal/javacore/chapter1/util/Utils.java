package com.portal.javacore.chapter1.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static boolean isId(int id, String str){
        if(str == null) return false;
        if(Integer.valueOf(str.split("/")[0]) == id) return true;
        return false;
    }

    public static String getName(String str){
        if(str == null) return null;
        return (str.split("/")[1]);
    }

    public static int getId(String str){
        if(str == null) throw new NullPointerException();
        return Integer.valueOf(str.split("/")[0]);
    }

    public static int count(String dir){
        if(dir == null) throw new NullPointerException();
        try (BufferedReader reader = new BufferedReader(new FileReader(dir))) {
            String line = reader.readLine();
            while (line != null){
                String lines = reader.readLine();
                if(lines == null){
                    return Utils.getId(line);
                }
                line = lines;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
