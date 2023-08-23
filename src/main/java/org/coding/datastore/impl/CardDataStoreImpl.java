package org.coding.datastore.impl;

import org.coding.dataobjects.Card;
import org.coding.datastore.CardDataStore;

import java.util.HashMap;
import java.util.Map;

public class CardDataStoreImpl implements CardDataStore {
    private static final Map<Integer, Card> cardDB = new HashMap<>();
    @Override
    public int addCardInDataBase(Card card) {
        cardDB.put(card.getCardId(), card);
        return card.getCardId();
    }

    @Override
    public void deleteCardFromDataBase(int cardId) {
        cardDB.remove(cardId);
    }

    @Override
    public Card getCardDetails(int cardId) {
        return cardDB.get(cardId);
    }

    @Override
    public void updateCardDetails(Card card) {
        cardDB.put(card.getCardId(), card);
    }
}
