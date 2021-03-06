package com.portal.javacore.chapter1.view;

import com.portal.javacore.chapter1.controller.SkillController;
import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.repository.io.JavaIOSkillRepositoryImpl;

public class SkillView {

    private SkillController controller = new SkillController();

    public void start(String s){
        String[] cmd = s.split(" ");
        switch (cmd[1]){
            case ("create"):
                create(s.replace("skill create ", ""));
                break;
            case ("delete"):
                delete(s.replace("skill delete ", ""));
                break;
            case ("update"):
                update(s.replace("skill update ", ""));
                break;
            case ("read"):
                read(s.replace("skill read ", ""));
                break;
            case ("readAll"):
                readAll();
                break;
            default:
                System.err.println("Error: invalid argument");
        }
    }

    public void create(String s) {
        Skill skill = controller.create(s);
        System.out.printf("Skill %s successfully created", skill.getName()).println();
    }

    public void delete(String s) {
        controller.delete(s);
        System.out.printf("Skill with id %s successfully deleted", s).println();
    }

    public void update(String s) {
        Skill skill = controller.update(s);
        System.out.printf("Skill with id %s successfully updated", skill.getId()).println();
    }

    public void read(String s) {
        System.out.println(controller.read(Integer.valueOf(s)));
    }

    public void readAll() {
        for(Skill skill : controller.readAll()){
            System.out.println(skill);
        }
    }
}
