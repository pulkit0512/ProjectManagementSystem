package org.coding;

import org.coding.controller.BoardController;
import org.coding.controller.CardController;
import org.coding.controller.ListController;
import org.coding.controller.ShowController;
import org.coding.dataobjects.CommandType;
import org.coding.dataobjects.User;
import org.coding.datastore.UserDataStore;
import org.coding.datastore.impl.UserDataStoreImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final File FILE = new File("/Users/pulkitarora/learning/ProjectManagement/input.txt");
    private static final ShowController showController = new ShowController();
    private static final BoardController boardController = new BoardController();
    private static final ListController listController = new ListController();
    private static final CardController cardController = new CardController();
    private static final Scanner sc;

    static {
        try {
            sc = new Scanner(FILE);
            addMockUserData();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        System.out.println("\n\nWelcome to Project Management System");
        while (sc.hasNextLine()) {
            String inputLine = sc.nextLine();
            System.out.println("===" + inputLine + "===");
            String[] input = inputLine.split(" ");
            String command = input[0];
            if(command.equalsIgnoreCase(CommandType.BOARD.toString())) {
                performBoardCommand(input);
            } else if(command.equalsIgnoreCase(CommandType.LIST.toString())) {
                performListCommand(input);
            } else if(command.equalsIgnoreCase(CommandType.CARD.toString())) {
                performCardCommand(input);
            } else if(command.equalsIgnoreCase(CommandType.SHOW.toString())) {
                performShowCommand(input);
            } else {
                System.out.println("Not a valid command");
            }
        }
    }

    private static void performListCommand(String[] input) {
        String action = input[1];
        if (action.equalsIgnoreCase("CREATE")) {
            int boardId = getId(input[2]);
            if (boardId == 0) {
                return;
            }
            String name = input[3];
            listController.addList(boardId, name);
        } else if (action.equalsIgnoreCase("DELETE")) {
            int id = getId(input[2]);
            if (id == 0) {
                return;
            }

            listController.deleteList(id);
        } else {
            int id = getId(action);
            if (id == 0) {
                return;
            }

            String attribute = input[2];
            String newValue = input[3];

            listController.updateList(id, attribute, newValue);
        }
    }

    private static void performBoardCommand(String[] input) {
        String action = input[1];
        if (action.equalsIgnoreCase("CREATE")) {
            String name = input[2];
            boardController.addBoard(name);
        } else if (action.equalsIgnoreCase("DELETE")) {
            int id = getId(input[2]);
            if (id == 0) {
                return;
            }

            boardController.deleteBoard(id);
        } else {
            int id = getId(action);
            if (id == 0) {
                return;
            }

            String attribute = input[2];
            String newValue = input[3];

            boardController.updateBoard(id, attribute, newValue);
        }
    }

    private static void performCardCommand(String[] input) {
        String action = input[1];
        if (action.equalsIgnoreCase("CREATE")) {
            int listId = getId(input[2]);
            if (listId == 0) {
                return;
            }
            String name = input[3];
            cardController.addCard(listId, name);
        } else if (action.equalsIgnoreCase("DELETE")) {
            int id = getId(input[2]);
            if (id == 0) {
                return;
            }

            cardController.deleteCard(id);
        } else {
            int id = getId(action);
            if (id == 0) {
                return;
            }

            String attribute = input[2];
            String newValue;
            if (attribute.equalsIgnoreCase("UNASSIGN")) {
                newValue = null;
            } else {
                newValue = input[3];
            }

            cardController.updateCard(id, attribute, newValue);
        }
    }

    private static void performShowCommand(String[] input) {
        if(input.length == 1) {
            showController.showAllBoards();
        } else {
            if(input.length != 3) {
                System.out.println("Not a valid SHOW command");
                return;
            }

            String commandType = input[1];
            int id = getId(input[2]);
            if (id == 0) {
                return;
            }

            if (commandType.equalsIgnoreCase(CommandType.BOARD.toString())) {
                showController.showBoard(id);
            } else if (commandType.equalsIgnoreCase(CommandType.LIST.toString())) {
                showController.showList(id);
            } else if (commandType.equalsIgnoreCase(CommandType.CARD.toString())) {
                showController.showCard(id);
            } else {
                System.out.println("Not a valid SHOW command");
            }
        }
    }

    private static int getId(String input) {
        int id;
        try {
            id = Integer.parseInt(input);
            return id;
        } catch(Exception ex) {
            System.out.println("Not a valid ID");
            return 0;
        }
    }

    private static void addMockUserData() {
        UserDataStore userDataStore = new UserDataStoreImpl();
        User user1 = new User();
        user1.setName("Pulkit");
        user1.setEmail("Pulkit@gmail.com");
        int userId1 = userDataStore.addUser(user1);
        System.out.println(userId1 + " add successfully in DateBase.");

        User user2 = new User();
        user2.setName("Arpit");
        user2.setEmail("Arpit@gmail.com");
        int userId2 = userDataStore.addUser(user2);
        System.out.println(userId2 + " add successfully in DateBase.");

        User user3 = new User();
        user3.setName("Atul");
        user3.setEmail("Atul@gmail.com");
        int userId3 = userDataStore.addUser(user3);
        System.out.println(userId3 + " add successfully in DateBase.");

        User user4 = new User();
        user4.setName("Shikhar");
        user4.setEmail("Shikhar@gmail.com");
        int userId4 = userDataStore.addUser(user4);
        System.out.println(userId4 + " add successfully in DateBase.");

        User user5 = new User();
        user5.setName("Sanyam");
        user5.setEmail("Sanyam@gmail.com");
        int userId5 = userDataStore.addUser(user5);
        System.out.println(userId5 + " add successfully in DateBase.");
    }
}