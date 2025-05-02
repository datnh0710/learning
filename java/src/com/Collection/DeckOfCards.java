package com.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<Card> cardList;

    public DeckOfCards() {
        Card[] deck = new Card[52];
        int count = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Face face : Card.Face.values()) {
                deck[count] = new Card(face, suit);
                ++count;
            }
        }
        cardList = Arrays.asList(deck);
        Collections.shuffle(cardList);
    }

    public void printCards() {
        for (int i = 0; i < cardList.size(); i++) {
            System.out.printf("%-19s%s", cardList.get(i), ((i + 1) % 4 == 0) ? "%n" : "");
        }
    }

    public static void main(String[] args) {
        DeckOfCards cards= new DeckOfCards();
        cards.printCards();
    }
}
