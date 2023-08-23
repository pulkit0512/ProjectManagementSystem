package org.coding.datastore.impl;

import org.coding.dataobjects.Board;
import org.coding.datastore.BoardDataStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDataStoreImpl implements BoardDataStore {
    private static final Map<Integer, Board> boardDB = new HashMap<>();
    @Override
    public int addBoardInDataBase(Board board) {
        boardDB.put(board.getBoardId(), board);
        return board.getBoardId();
    }

    @Override
    public void deleteBoardFromDataBase(int boardId) {
        boardDB.remove(boardId);
    }

    @Override
    public Board getBoardDetails(int boardId) {
        return boardDB.get(boardId);
    }

    @Override
    public List<Board> getAllBoards() {
        return new ArrayList<>(boardDB.values());
    }

    @Override
    public void updateBoardDetails(Board board) {
        boardDB.put(board.getBoardId(), board);
    }
}
