package com.portal.javacore.chapter1.repository.io;

import com.portal.javacore.chapter1.model.Developer;
import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.model.Team;
import com.portal.javacore.chapter1.model.TeamStatus;
import com.portal.javacore.chapter1.repository.interfaces.DeveloperRepository;
import com.portal.javacore.chapter1.repository.interfaces.SkillRepository;
import com.portal.javacore.chapter1.repository.interfaces.TeamRepository;
import com.portal.javacore.chapter1.util.Dirs;
import com.portal.javacore.chapter1.util.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOTeamRepositoryImpl implements TeamRepository {

    private DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();

    private static String DIR = Dirs.TEAMS.getDirectory();

    @Override
    public List<Team> findAll() {
        List<Team> teams = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                String[] names = Utils.getName(line).split(";");
                teams.add(new Team(Utils.getId(line), names[0], getDevelopers(line.split("/")[1]), TeamStatus.ACTIVE));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teams;
    }

    @Override
    public Team getOne(Integer integer) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                if(Utils.isId(integer, line)) return new Team(Utils.getId(line), Utils.getName(line), getDevelopers(line.split("/")[2]), TeamStatus.ACTIVE);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Team create(Team obj) {
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                info.add(line);
                line = reader.readLine();
            }
            StringBuilder add = new StringBuilder((Utils.count(DIR) + 1) + "/" + obj.getName() + "/");
            for(Developer d : obj.getPosts()){
                add.append(d.getId() + ",");
            }
            info.add(add.toString());
            obj.setId(Utils.count(DIR) + 1);
            BufferedWriter writer = new BufferedWriter(new FileWriter(DIR));
            for(String s : info){
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Team update(Team obj) {
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                if(!Utils.isId(obj.getId(), line)) info.add(line);
                else {
                    StringBuilder add = new StringBuilder(obj.getId() + "/" + obj.getName() + "/");
                    for(Developer d : obj.getPosts()){
                        add.append(d.getId() + ",");
                    }
                    info.add(add.toString());
                }
                line = reader.readLine();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(DIR));
            for(String s : info){
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public List<Developer> getDevelopers(String developers){
        List<Developer> developerList = new ArrayList<>();
        for(String skill : developers.split(",")){
            int id = Integer.valueOf(skill);
            for (Developer dev :  developerRepository.findAll()){
                if(dev.getId() == id) developerList.add(dev);
            }
        }
        return developerList;
    }
}
