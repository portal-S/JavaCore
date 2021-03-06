package com.portal.javacore.chapter1.controller;

import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.repository.io.JavaIOSkillRepositoryImpl;
import com.portal.javacore.chapter1.repository.interfaces.SkillRepository;
import com.portal.javacore.chapter1.util.Dirs;

import java.util.List;

public class SkillController {

    private SkillRepository repository = new JavaIOSkillRepositoryImpl();


    public Skill create(String skill) {
        return repository.create(new Skill(0, skill));
    }

    public void delete(String s) {
        repository.delete(Integer.valueOf(s), Dirs.SKILLS.getDirectory());
    }

    public Skill update(String skill) {
        String[] array = skill.split(" ");
        return repository.update(new Skill(Integer.valueOf(array[0]), array[1]));
    }

    public Skill read(int i) {
        return repository.getOne(i);
    }

    public List<Skill> readAll() {
        return repository.findAll();
    }
}
