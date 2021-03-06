package com.portal.javacore.chapter1.repository.interfaces;

import com.portal.javacore.chapter1.model.Developer;
import com.portal.javacore.chapter1.model.Skill;

import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer, Integer>{
    public List<Skill> getSkills(String skills);
}
