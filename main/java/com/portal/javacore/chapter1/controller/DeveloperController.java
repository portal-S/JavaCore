package com.portal.javacore.chapter1.controller;

import com.portal.javacore.chapter1.model.Developer;
import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.repository.interfaces.DeveloperRepository;
import com.portal.javacore.chapter1.repository.interfaces.SkillRepository;
import com.portal.javacore.chapter1.repository.io.JavaIODeveloperRepositoryImpl;
import com.portal.javacore.chapter1.repository.io.JavaIOSkillRepositoryImpl;
import com.portal.javacore.chapter1.util.Dirs;

import java.util.Arrays;
import java.util.List;

public class DeveloperController {

    private DeveloperRepository repository = new JavaIODeveloperRepositoryImpl();


    public Developer create(String developer) {
        String[] info = developer.split(" ");
        return repository.create(new Developer(0, info[0], info[1], repository.getSkills(info[2])));
    }

    public void delete(String s) {
        repository.delete(Integer.valueOf(s), Dirs.DEVELOPERS.getDirectory());
    }
//developer update 2 Aligadji Guseinov 1,4
    public Developer update(String developer) {
        String[] info = developer.split(" ");
        return repository.update(new Developer(Integer.valueOf(info[0]), info[1], info[2], repository.getSkills(info[3])));
    }

    public Developer read(int i) {
        return repository.getOne(i);
    }

    public List<Developer> readAll() {
        return repository.findAll();
    }
}
