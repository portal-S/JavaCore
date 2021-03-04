package com.portal.javacore.chapter1.view;

import com.portal.javacore.chapter1.controller.SkillControllerImpl;
import com.portal.javacore.chapter1.controller.interfaces.SkillController;
import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.repository.JavaIOSkillRepositoryImpl;
import com.portal.javacore.chapter1.view.interfaces.SkillView;

import java.util.Scanner;

public class SkillViewImpl implements SkillView {

    private SkillController controller = new SkillControllerImpl();

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
                readAll(s);
                break;
            default:
                System.err.println("Error: invalid argument");
        }
    }

    @Override
    public void create(String s) {
        controller.create(new Skill(JavaIOSkillRepositoryImpl.count() + 1, s));
        System.out.printf("Skill %s successfully created", s).println();
    }

    @Override
    public void delete(String s) {
        controller.delete(Integer.valueOf(s));
        System.out.printf("Skill with id %s successfully deleted", s).println();
    }

    @Override
    public void update(String s) {
        String[] array = s.split(" ");
        controller.update(new Skill(Integer.valueOf(array[0]), array[1]));
        System.out.printf("Skill with id %s successfully deleted", array[0]).println();
    }

    @Override
    public void read(String s) {
        System.out.println(controller.read(Integer.valueOf(s)));
    }

    @Override
    public void readAll(String s) {
        for(Skill skill : controller.readAll()){
            System.out.println(skill);
        }
    }
}
