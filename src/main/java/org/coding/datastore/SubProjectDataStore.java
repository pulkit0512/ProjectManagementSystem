package org.coding.datastore;

import org.coding.dataobjects.SubProject;

public interface SubProjectDataStore {
    int addSubProjectInDataBase(SubProject subProject);
    void deleteSubProjectFromDataBase(int subProjectId);
    SubProject getSubProjectDetails(int subProjectId);
    void updateSubProjectDetails(SubProject subProject);
}
