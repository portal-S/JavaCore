package com.portal.javacore.chapter1.repository;

import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.repository.interfaces.SkillRepository;
import com.portal.javacore.chapter1.util.Utils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private final static String DIR = "C:/Users/User/IdeaProjects/JavaCore/src/main/resources/skills.txt";

    public JavaIOSkillRepositoryImpl() {

    }

    @Override
    public List<Skill> findAll() {
        List<Skill> skills = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
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
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
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

    @Override
    public void delete(Integer integer){
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                if(!Utils.isId(integer, line)) info.add(line);
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
    }

    @Override
    public void create(Skill obj) {
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                info.add(line);
                line = reader.readLine();
            }
            info.add(obj.getId() + "/" + obj.getName());
            BufferedWriter writer = new BufferedWriter(new FileWriter(DIR));
            for(String s : info){
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Skill obj) {
        List<String> info = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                if(!Utils.isId(obj.getId(), line)) info.add(line);
                else {
                    info.add(obj.getId() + "/" + obj.getName());
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
    }

    public static int count(){
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(DIR))) {
            String line = reader.readLine();
            while (line != null){
                count++;
                if(reader.readLine() == null) return Utils.getId(line);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
