package org.coding.datastore;

import org.coding.dataobjects.Board;

import java.util.List;

public interface BoardDataStore {
    int addBoardInDataBase(Board board);
    void deleteBoardFromDataBase(int boardId);
    Board getBoardDetails(int boardId);

    List<Board> getAllBoards();
    void updateBoardDetails(Board board);
}
