package com.portal.javacore.chapter1;

import com.portal.javacore.chapter1.controller.SkillController;
import com.portal.javacore.chapter1.view.DeveloperView;
import com.portal.javacore.chapter1.view.SkillView;
import com.portal.javacore.chapter1.view.TeamView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter the command to execute");
            System.out.println("(type) (command) (args)");
            while (scanner.hasNext()){
                if(!validCmd(scanner.nextLine())) System.err.println("Error: invalid data type");
            }
        }
    }
    private static boolean validCmd(String str){
        String[] cmd = str.split(" ");
        switch (cmd[0]){
            case ("skill"):
                SkillView skillView = new SkillView();
                skillView.start(str);
                return true;
            case ("developer"):
                DeveloperView developer = new DeveloperView();
                developer.start(str);
                return true;
            case ("team"):
                TeamView teamView = new TeamView();
                teamView.start(str);
                return true;
            default:
                return false;

        }
    }


}