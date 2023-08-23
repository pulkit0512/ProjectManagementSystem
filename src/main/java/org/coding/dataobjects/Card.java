package org.coding.dataobjects;

public class Card {
    private static int uniqueId = 0;
    private final int cardId;
    private String name;
    private String description;
    private int userId;
    private int listId;

    public Card() {
        uniqueId++;
        this.cardId = uniqueId;
    }

    public int getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
}
