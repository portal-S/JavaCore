package com.portal.javacore.chapter1;

import com.portal.javacore.chapter1.view.SkillViewImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter the command to execute");
            System.out.println("(type) (command) (arg)");
            while (scanner.hasNext()){
                if(!validCmd(scanner.nextLine())) System.err.println("Error: invalid data");
            }

        }
    }

    private static boolean validCmd(String str){
        String[] cmd = str.split(" ");
        switch (cmd[0]){
            case ("skill"):
                SkillViewImpl skillView = new SkillViewImpl();
                skillView.start(str);
                return true;

            default:
                return false;

        }
    }


}