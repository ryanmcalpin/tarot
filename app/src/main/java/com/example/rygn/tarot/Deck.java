package com.example.rygn.tarot;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<String> cards = new ArrayList<>();

    public List<String> getDeck() {
        cards.add("c1");
        cards.add("c2");
        return cards;
    }
}
