package com.portal.javacore.chapter1.view;

import com.portal.javacore.chapter1.controller.DeveloperController;
import com.portal.javacore.chapter1.controller.TeamController;
import com.portal.javacore.chapter1.model.Developer;
import com.portal.javacore.chapter1.model.Team;

public class TeamView {

    private TeamController controller = new TeamController();

    public void start(String s){

        String[] cmd = s.split(" ");
        switch (cmd[1]){
            case ("create"):
                create(s.replace("team create ", ""));
                break;
            case ("delete"):
                delete(s.replace("team delete ", ""));
                break;
            case ("update"):
                update(s.replace("team update ", ""));
                break;
            case ("read"):
                read(s.replace("team read ", ""));
                break;
            case ("readAll"):
                readAll();
                break;
            default:
                System.err.println("Error: invalid argument");
        }
    }

    public void create(String s) {
        Team team = controller.create(s);
        System.out.printf("Team %s successfully created", team.getName()).println();
    }

    public void delete(String s) {
        controller.delete(s);
        System.out.printf("Team with id %s successfully deleted", s).println();
    }

    public void update(String s) {
        Team team = controller.update(s);
        System.out.printf("Team with id %s successfully updated", team.getId()).println();
    }

    public void read(String s) {
        System.out.println(controller.read(Integer.valueOf(s)));
    }

    public void readAll() {
        for(Team team : controller.readAll()){
            System.out.println(team);
        }
    }
}
