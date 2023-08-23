package org.coding.controller;

import org.coding.dataobjects.Board;
import org.coding.dataobjects.PrivacyType;
import org.coding.datastore.BoardDataStore;
import org.coding.datastore.impl.BoardDataStoreImpl;

import java.util.Set;

public class BoardController {
    private static final BoardDataStore boardDataStore = new BoardDataStoreImpl();

    private static final ListController listController = new ListController();
    private static final CardController cardController = new CardController();
    public void addBoard(String boardName) {
        Board board = new Board();
        board.setName(boardName);
        board.setPrivacyType(PrivacyType.PUBLIC);
        board.setUrl("www."+board.getBoardId()+".com");
        int boardId = boardDataStore.addBoardInDataBase(board);
        System.out.println(boardId + " created successfully.");
    }

    public void deleteBoard(int boardId) {
        Board board = boardDataStore.getBoardDetails(boardId);
        if (board == null) {
            System.out.println("No Project with given ID found.");
            return;
        }

        Set<Integer> subProjects = board.getSubProjects();
        for(int subProjectId : subProjects) {
            listController.deleteList(subProjectId);
        }

        boardDataStore.deleteBoardFromDataBase(boardId);
    }

    public void updateBoard(int boardId, String attribute, String value) {
        Board board = boardDataStore.getBoardDetails(boardId);
        if (attribute.equalsIgnoreCase("NAME")) {
            board.setName(value);
        } else if (attribute.equalsIgnoreCase("PRIVACY")) {
            if (value.equals(PrivacyType.PRIVATE.toString())) {
                board.setPrivacyType(PrivacyType.PRIVATE);
            } else {
                board.setPrivacyType(PrivacyType.PUBLIC);
            }
        } else if (attribute.equalsIgnoreCase("ADD_MEMBER")) {
            board.getUsers().add(Integer.parseInt(value));
        } else if (attribute.equalsIgnoreCase("REMOVE_MEMBER")){
            int userId = Integer.parseInt(value);
            cardController.unAssignAllCardsForUser(userId);
            board.getUsers().remove(userId);
        } else {
            System.out.println("Not a valid command.");
            return;
        }

        boardDataStore.updateBoardDetails(board);
    }
}
