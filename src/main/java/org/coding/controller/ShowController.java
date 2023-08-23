package org.coding.controller;

import com.google.gson.Gson;
import org.coding.dataobjects.Board;
import org.coding.dataobjects.Card;
import org.coding.dataobjects.SubProject;
import org.coding.datastore.BoardDataStore;
import org.coding.datastore.CardDataStore;
import org.coding.datastore.SubProjectDataStore;
import org.coding.datastore.impl.BoardDataStoreImpl;
import org.coding.datastore.impl.CardDataStoreImpl;
import org.coding.datastore.impl.SubProjectDataStoreImpl;

import java.util.List;

public class ShowController {
    private static final BoardDataStore boardDataStore = new BoardDataStoreImpl();
    private static final SubProjectDataStore subProjectDataStore = new SubProjectDataStoreImpl();
    private static final CardDataStore cardDataStore = new CardDataStoreImpl();
    private static final Gson gson = new Gson();
    public void showAllBoards() {
        List<Board> boards = boardDataStore.getAllBoards();
        if (boards.isEmpty()) {
            System.out.println("NO BOARDS.");
            return;
        }
        String response = gson.toJson(boards);
        System.out.println(response);
    }

    public void showBoard(int boardId) {
        Board board = boardDataStore.getBoardDetails(boardId);
        if (board == null) {
            System.out.println("BOARD NOT PRESENT.");
            return;
        }
        String response = gson.toJson(board);
        System.out.println(response);
    }

    public void showList(int listId) {
        SubProject subProject = subProjectDataStore.getSubProjectDetails(listId);
        if (subProject == null) {
            System.out.println("LIST NOT PRESENT.");
            return;
        }
        String response = gson.toJson(subProject);
        System.out.println(response);
    }

    public void showCard(int cardId) {
        Card card = cardDataStore.getCardDetails(cardId);
        if (card == null) {
            System.out.println("CARD NOT PRESENT");
            return;
        }
        String response = gson.toJson(card);
        System.out.println(response);
    }
}
