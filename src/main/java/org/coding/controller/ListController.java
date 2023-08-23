package org.coding.controller;

import org.coding.dataobjects.Board;
import org.coding.dataobjects.SubProject;
import org.coding.datastore.BoardDataStore;
import org.coding.datastore.SubProjectDataStore;
import org.coding.datastore.impl.BoardDataStoreImpl;
import org.coding.datastore.impl.SubProjectDataStoreImpl;

import java.util.Set;

public class ListController {
    private static final BoardDataStore boardDataStore = new BoardDataStoreImpl();
    private static final SubProjectDataStore subProjectDataStore = new SubProjectDataStoreImpl();

    private static final CardController cardController = new CardController();
    public void addList(int boardId, String name) {
        SubProject subProject = new SubProject();
        subProject.setName(name);
        subProject.setBoardId(boardId);
        int listId = subProjectDataStore.addSubProjectInDataBase(subProject);

        Board board = boardDataStore.getBoardDetails(boardId);
        board.getSubProjects().add(subProject.getSubProjectId());
        boardDataStore.updateBoardDetails(board);
        System.out.println(listId + " added successfully to board ID: " + boardId);
    }

    public void deleteList(int listId) {
        SubProject subProject = subProjectDataStore.getSubProjectDetails(listId);
        if (subProject == null) {
            System.out.println("No List found");
            return;
        }

        Set<Integer> cards = subProject.getCards();
        for(int cardId : cards) {
            cardController.deleteCard(cardId);
        }

        Board board = boardDataStore.getBoardDetails(subProject.getBoardId());
        board.getSubProjects().remove(listId);
        boardDataStore.updateBoardDetails(board);

        subProjectDataStore.deleteSubProjectFromDataBase(listId);
    }

    public void updateList(int listId, String attribute, String value) {
        SubProject subProject = subProjectDataStore.getSubProjectDetails(listId);
        if (attribute.equalsIgnoreCase("NAME")) {
            subProject.setName(value);
        } else {
            System.out.println("Not a valid command.");
            return;
        }
        subProjectDataStore.updateSubProjectDetails(subProject);
    }
}
