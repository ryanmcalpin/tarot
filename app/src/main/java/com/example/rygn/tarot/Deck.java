package com.example.rygn.tarot;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<>();
    List<String> minorArcNoSuit = new ArrayList<>();
    List<String> suits = new ArrayList<>();

    public List<Card> getCards() {


        cards.add(new Card("The Magician", "", ""));
        cards.add(new Card("The High Priestess", "", ""));
        cards.add(new Card("The Empress", "", ""));
        cards.add(new Card("The Emperor", "", ""));
//        cards.add("The Hierophant");
//        cards.add("The Lovers");
//        cards.add("The Chariot");
//        cards.add("Strength");
//        cards.add("The Hermit");
//        cards.add("Wheel of Fortune");
//        cards.add("Justice");
//        cards.add("The Hanged Man");
//        cards.add("Death");
//        cards.add("Temperance");
//        cards.add("The Devil");
//        cards.add("The Tower");
//        cards.add("The Star");
//        cards.add("The Moon");
//        cards.add("The Sun");
//        cards.add("Judgement");
//        cards.add("The World");
//        cards.add("The Fool");
//
//        minorArcNoSuit.add("Ace");
//        minorArcNoSuit.add("Two");
//        minorArcNoSuit.add("Three");
//        minorArcNoSuit.add("Four");
//        minorArcNoSuit.add("Five");
//        minorArcNoSuit.add("Six");
//        minorArcNoSuit.add("Seven");
//        minorArcNoSuit.add("Eight");
//        minorArcNoSuit.add("Nine");
//        minorArcNoSuit.add("Ten");
//        minorArcNoSuit.add("Page");
//        minorArcNoSuit.add("Knight");
//        minorArcNoSuit.add("Queen");
//        minorArcNoSuit.add("King");
//
//        suits.add("Swords");
//        suits.add("Wands");
//        suits.add("Pentacles");
//        suits.add("Cups");
//
//        for (int i = 0; i < suits.size(); i++) {
//            for (int ii = 0; ii < minorArcNoSuit.size(); ii++) {
//                cards.add(minorArcNoSuit.get(ii) + " of " + suits.get(i));
//            }
//        }

        return cards;
    }
}
