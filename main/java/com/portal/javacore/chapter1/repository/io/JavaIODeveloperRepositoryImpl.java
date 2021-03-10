package com.portal.javacore.chapter1.repository.io;

import com.portal.javacore.chapter1.model.Developer;
import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.repository.interfaces.DeveloperRepository;
import com.portal.javacore.chapter1.repository.interfaces.SkillRepository;
import com.portal.javacore.chapter1.util.Dirs;
import com.portal.javacore.chapter1.util.Utils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();

    private static String DIR = Dirs.DEVELOPERS.getDirectory();

    @Override
    public List<Developer> findAll() {
        List<Developer> developers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                String[] names = Utils.getName(line).split(";");
                developers.add(new Developer(Utils.getId(line), names[0], names[1], getSkills(line.split("/")[2])));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developers;
    }

    @Override
    public Developer getOne(Integer integer) {
        try {
           return Files.lines(new File(DIR).toPath()).filter(s -> Utils.isId(integer, s)).map(s ->{
               String[] names = Utils.getName(s).split(";");
               return new Developer(integer, names[0], names[1], getSkills(s.split("/")[2]));
           }).findAny().get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Developer create(Developer obj) {

        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                info.add(line);
                line = reader.readLine();
            }
            StringBuilder add = new StringBuilder((Utils.count(DIR) + 1) + "/" + obj.getFirstName() + ";" + obj.getLastName() + "/");
            for(Skill s : obj.getSkills()){
              add.append(s.getId() + ",");
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
    public Developer update(Developer obj) {
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                if(!Utils.isId(obj.getId(), line)) info.add(line);
                else {
                    StringBuilder add = new StringBuilder(obj.getId() + "/" + obj.getFirstName() + ";" + obj.getLastName() + "/");

                    for(Skill s : obj.getSkills()){
                        add.append(s.getId() + ",");
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

    public List<Skill> getSkills(String skills){
        return Arrays.stream(skills.split(",")).map(e -> {
            return skillRepository.findAll().stream().filter(s -> s.getId() == Integer.valueOf(e)).findAny().get();
        } ).collect(Collectors.toList());
    }
}


