package com.portal.javacore.chapter1.repository.interfaces;

import com.portal.javacore.chapter1.model.Skill;
import com.portal.javacore.chapter1.util.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface GenericRepository<T, ID> {
    List<T> findAll();

    T getOne(ID id);

    default void delete(Integer integer, String DIR){
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

    T create(T obj);

    T update(T obj);
}
