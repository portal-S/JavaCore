package com.portal.javacore.chapter1.util;

public enum Dirs {
    SKILLS("C:/Users/User/IdeaProjects/JavaCore/src/main/resources/skills.txt"),
    DEVELOPERS("C:/Users/User/IdeaProjects/JavaCore/src/main/resources/developers.txt"),
    TEAMS("C:/Users/User/IdeaProjects/JavaCore/src/main/resources/teams.txt");

    public String getDirectory() {
        return directory;
    }

    Dirs(String directory) {
        this.directory = directory;
    }

    private String directory;

}
