package com.portal.javacore.chapter1.view;

import com.portal.javacore.chapter1.controller.DeveloperController;
import com.portal.javacore.chapter1.model.Developer;
import com.portal.javacore.chapter1.model.Skill;

public class DeveloperView {

    private DeveloperController controller = new DeveloperController();

    public void start(String s){

        String[] cmd = s.split(" ");
        switch (cmd[1]){
            case ("create"):
                create(s.replace("developer create ", ""));
                break;
            case ("delete"):
                delete(s.replace("developer delete ", ""));
                break;
            case ("update"):
                update(s.replace("developer update ", ""));
                break;
            case ("read"):
                read(s.replace("developer read ", ""));
                break;
            case ("readAll"):
                readAll();
                break;
            default:
                System.err.println("Error: invalid argument");
        }
    }

    public void create(String s) {
        Developer developer = controller.create(s);
        System.out.printf("Developer %s successfully created", developer.getFirstName()).println();
    }

    public void delete(String s) {
        controller.delete(s);
        System.out.printf("Developer with id %s successfully deleted", s).println();
    }

    public void update(String s) {
        Developer developer = controller.update(s);
        System.out.printf("Developer with id %s successfully updated", developer.getId()).println();
    }

    public void read(String s) {
        System.out.println(controller.read(Integer.valueOf(s)));
    }

    public void readAll() {
        for(Developer developer : controller.readAll()){
            System.out.println(developer);
        }
    }
}
