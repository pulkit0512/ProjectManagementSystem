package org.coding.datastore.impl;

import org.coding.dataobjects.User;
import org.coding.datastore.UserDataStore;

import java.util.HashMap;
import java.util.Map;

public class UserDataStoreImpl implements UserDataStore {
    private static final Map<Integer, User> userDB = new HashMap<>();
    @Override
    public int addUser(User user) {
        userDB.put(user.getUserId(), user);
        return user.getUserId();
    }

    @Override
    public User getUser(int userId) {
        return userDB.get(userId);
    }

    @Override
    public void updateUser(User user) {
        userDB.put(user.getUserId(), user);
    }
}
