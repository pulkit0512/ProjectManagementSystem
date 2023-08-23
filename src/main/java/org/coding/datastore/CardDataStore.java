package org.coding.datastore;


import org.coding.dataobjects.Card;

public interface CardDataStore {
    int addCardInDataBase(Card card);
    void deleteCardFromDataBase(int cardId);
    Card getCardDetails(int cardId);
    void updateCardDetails(Card card);
}
