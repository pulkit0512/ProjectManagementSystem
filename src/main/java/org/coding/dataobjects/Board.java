package org.coding.dataobjects;

import java.util.HashSet;
import java.util.Set;

public class Board {
    private static int uniqueId;
    private final int boardId;
    private String name;
    private PrivacyType privacyType;
    private String url;
    private Set<Integer> users;
    private Set<Integer> subProjects;

    public Board() {
        uniqueId++;
        this.boardId = uniqueId;
    }

    public int getBoardId() {
        return boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrivacyType getPrivacyType() {
        return privacyType;
    }

    public void setPrivacyType(PrivacyType privacyType) {
        this.privacyType = privacyType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Integer> getUsers() {
        if (users == null) {
            users = new HashSet<>();
        }
        return users;
    }

    public Set<Integer> getSubProjects() {
        if (subProjects == null) {
            subProjects = new HashSet<>();
        }
        return subProjects;
    }
}
