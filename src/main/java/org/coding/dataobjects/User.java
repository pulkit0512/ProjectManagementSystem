package org.coding.dataobjects;

import java.util.HashSet;
import java.util.Set;

public class User {
    private static int uniqueId = 0;
    private final int userId;
    private String name;
    private String email;
    private Set<Integer> cardIds;

    public User() {
        uniqueId++;
        this.userId = uniqueId;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Integer> getCardIds() {
        if (cardIds == null) {
            cardIds = new HashSet<>();
        }
        return cardIds;
    }
}
