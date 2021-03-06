package com.portal.javacore.chapter1.controller;

import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.model.Team;
import com.portal.javacore.chapter1.model.TeamStatus;
import com.portal.javacore.chapter1.repository.interfaces.SkillRepository;
import com.portal.javacore.chapter1.repository.interfaces.TeamRepository;
import com.portal.javacore.chapter1.repository.io.JavaIOSkillRepositoryImpl;
import com.portal.javacore.chapter1.repository.io.JavaIOTeamRepositoryImpl;
import com.portal.javacore.chapter1.util.Dirs;

import java.util.List;

public class TeamController {

    private TeamRepository repository = new JavaIOTeamRepositoryImpl();


    public Team create(String team) {
        String[] info = team.split(" ");
        return repository.create(new Team(0, info[0], repository.getDevelopers(info[1]), TeamStatus.ACTIVE));
    }

    public void delete(String s) {
        repository.delete(Integer.valueOf(s), Dirs.TEAMS.getDirectory());
    }

    public Team update(String team) {
        String[] info = team.split(" ");
        return repository.update(new Team(Integer.valueOf(info[0]), info[1], repository.getDevelopers(info[2]), TeamStatus.ACTIVE));
    }

    public Team read(int i) {
        return repository.getOne(i);
    }

    public List<Team> readAll() {
        return repository.findAll();
    }
}
