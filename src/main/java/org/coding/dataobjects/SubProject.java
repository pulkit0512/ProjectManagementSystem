package org.coding.dataobjects;

import java.util.HashSet;
import java.util.Set;

public class SubProject {
    private static int uniqueId = 0;
    private final int subProjectId;
    private String name;
    private Set<Integer> cards;
    private int boardId;

    public SubProject() {
        uniqueId++;
        subProjectId = uniqueId;
    }


    public int getSubProjectId() {
        return subProjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getCards() {
        if (cards == null) {
            cards = new HashSet<>();
        }
        return cards;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
}
