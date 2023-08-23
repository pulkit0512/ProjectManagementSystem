package org.coding.datastore;

import org.coding.dataobjects.User;

public interface UserDataStore {
    int addUser(User user);
    User getUser(int userId);

    void updateUser(User user);
}
