package com.portal.javacore.chapter1.util;

public class Utils {
    public static boolean isId(int id, String str){
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

}
