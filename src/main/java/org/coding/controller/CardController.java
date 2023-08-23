package org.coding.controller;

import org.coding.dataobjects.Card;
import org.coding.dataobjects.SubProject;
import org.coding.dataobjects.User;
import org.coding.datastore.CardDataStore;
import org.coding.datastore.SubProjectDataStore;
import org.coding.datastore.UserDataStore;
import org.coding.datastore.impl.CardDataStoreImpl;
import org.coding.datastore.impl.SubProjectDataStoreImpl;
import org.coding.datastore.impl.UserDataStoreImpl;

import java.util.Set;

public class CardController {
    private static final SubProjectDataStore subProjectDataStore = new SubProjectDataStoreImpl();
    private static final CardDataStore cardDataStore = new CardDataStoreImpl();
    private static final UserDataStore userDataStore = new UserDataStoreImpl();
    public void addCard(int listId, String cardName) {
        Card card = new Card();
        card.setName(cardName);
        card.setListId(listId);

        int cardId = cardDataStore.addCardInDataBase(card);

        SubProject subProject = subProjectDataStore.getSubProjectDetails(listId);
        subProject.getCards().add(card.getCardId());
        subProjectDataStore.updateSubProjectDetails(subProject);
        System.out.println(cardId + " added successfully to list ID: " + listId);
    }

    public void deleteCard(int cardId) {
        Card card = cardDataStore.getCardDetails(cardId);
        if (card == null) {
            System.out.println("No Card found.");
            return;
        }

        User user = userDataStore.getUser(card.getUserId());
        user.getCardIds().remove(cardId);
        userDataStore.updateUser(user);

        SubProject subProject = subProjectDataStore.getSubProjectDetails(card.getListId());
        subProject.getCards().remove(cardId);
        subProjectDataStore.updateSubProjectDetails(subProject);

        cardDataStore.deleteCardFromDataBase(cardId);
    }

    public void updateCard(int cardId, String attribute, String value) {
        Card card = cardDataStore.getCardDetails(cardId);
        if (attribute.equalsIgnoreCase("NAME")) {
            card.setName(value);
        } else if (attribute.equalsIgnoreCase("DESCRIPTION")) {
            card.setDescription(value);
        } else if (attribute.equalsIgnoreCase("ASSIGN")) {
            User user = userDataStore.getUser(Integer.parseInt(value));
            user.getCardIds().add(cardId);
            userDataStore.updateUser(user);

            card.setUserId(user.getUserId());
        } else if (attribute.equalsIgnoreCase("UNASSIGN")){
            User user = userDataStore.getUser(card.getUserId());
            user.getCardIds().remove(cardId);
            userDataStore.updateUser(user);

            card.setUserId(0);
        } else if (attribute.equalsIgnoreCase("MOVE")) {
            SubProject current = subProjectDataStore.getSubProjectDetails(card.getListId());
            SubProject updated = subProjectDataStore.getSubProjectDetails(Integer.parseInt(value));
            if (updated == null) {
                System.out.println("No LIST to move the card.");
                return;
            }
            current.getCards().remove(cardId);
            updated.getCards().add(cardId);
            subProjectDataStore.updateSubProjectDetails(current);
            subProjectDataStore.updateSubProjectDetails(updated);

            card.setListId(updated.getSubProjectId());
        } else {
            System.out.println("Not a valid command.");
            return;
        }
        cardDataStore.updateCardDetails(card);
    }

    public void unAssignAllCardsForUser(int userId) {
        User user = userDataStore.getUser(userId);

        Set<Integer> cardIds = user.getCardIds();
        for(int cardId : cardIds) {
            Card card = cardDataStore.getCardDetails(cardId);
            card.setUserId(0);
            cardDataStore.updateCardDetails(card);
        }
    }
}
