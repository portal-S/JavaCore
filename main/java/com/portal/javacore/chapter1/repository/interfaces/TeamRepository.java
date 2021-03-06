package com.portal.javacore.chapter1.repository.interfaces;

import com.portal.javacore.chapter1.model.Developer;
import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.model.Team;

import java.util.List;

public interface TeamRepository extends GenericRepository<Team, Integer>{
    public List<Developer> getDevelopers(String developers);
}
