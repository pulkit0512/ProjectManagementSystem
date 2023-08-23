package org.coding.datastore.impl;

import org.coding.dataobjects.SubProject;
import org.coding.datastore.SubProjectDataStore;

import java.util.HashMap;
import java.util.Map;

public class SubProjectDataStoreImpl implements SubProjectDataStore {
    private static final Map<Integer, SubProject> subProjectDB = new HashMap<>();
    @Override
    public int addSubProjectInDataBase(SubProject subProject) {
        subProjectDB.put(subProject.getSubProjectId(), subProject);
        return subProject.getSubProjectId();
    }

    @Override
    public void deleteSubProjectFromDataBase(int subProjectId) {
        subProjectDB.remove(subProjectId);
    }

    @Override
    public SubProject getSubProjectDetails(int subProjectId) {
        return subProjectDB.get(subProjectId);
    }

    @Override
    public void updateSubProjectDetails(SubProject subProject) {
        subProjectDB.put(subProject.getSubProjectId(), subProject);
    }
}
