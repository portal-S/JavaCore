package com.portal.javacore.chapter1.controller;

import com.portal.javacore.chapter1.controller.interfaces.SkillController;
import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.repository.JavaIOSkillRepositoryImpl;
import com.portal.javacore.chapter1.repository.interfaces.SkillRepository;

import java.util.List;

public class SkillControllerImpl implements SkillController {

    private SkillRepository repository = new JavaIOSkillRepositoryImpl();


    @Override
    public void create(Skill skill) {
        repository.create(skill);
    }

    @Override
    public void delete(int i) {
        repository.delete(i);
    }

    @Override
    public void update(Skill skill) {
        repository.update(skill);
    }

    @Override
    public Skill read(int i) {
        return repository.getOne(i);
    }

    @Override
    public List<Skill> readAll() {
        return repository.findAll();
    }
}
