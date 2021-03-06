package com.portal.javacore.chapter1.repository.io;

import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.repository.interfaces.SkillRepository;
import com.portal.javacore.chapter1.util.Dirs;
import com.portal.javacore.chapter1.util.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private static String DIR = Dirs.SKILLS.getDirectory();

    @Override
    public List<Skill> findAll() {
        List<Skill> skills = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Dirs.SKILLS.getDirectory()))) {
            String line = reader.readLine();
            while (line != null){
                skills.add(new Skill(Utils.getId(line), Utils.getName(line)));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skills;
    }

    @Override
    public Skill getOne(Integer integer) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Dirs.SKILLS.getDirectory()))) {
            String line = reader.readLine();
            while (line != null){
                if(Utils.isId(integer, line)) return new Skill(integer, Utils.getName(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*@Override
    public void delete(Integer integer){
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIRS.SKILLS.getDirectory()))) {
            String line = reader.readLine();
            while (line != null){
                if(!Utils.isId(integer, line)) info.add(line);
                line = reader.readLine();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(DIRS.SKILLS.getDirectory()));
            for(String s : info){
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public Skill create(Skill obj) {
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Dirs.SKILLS.getDirectory()))) {
            String line = reader.readLine();
            while (line != null){
                info.add(line);
                line = reader.readLine();
            }
            info.add((Utils.count(Dirs.SKILLS.getDirectory()) + 1) + "/" + obj.getName());
            obj.setId(Utils.count(Dirs.SKILLS.getDirectory()) + 1);
            BufferedWriter writer = new BufferedWriter(new FileWriter(Dirs.SKILLS.getDirectory()));
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
    public Skill update(Skill obj) {
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Dirs.SKILLS.getDirectory()))) {
            String line = reader.readLine();
            while (line != null){
                if(!Utils.isId(obj.getId(), line)) info.add(line);
                else {
                    info.add(obj.getId() + "/" + obj.getName());
                }
                line = reader.readLine();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(Dirs.SKILLS.getDirectory()));
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


}
