package com.example.rygn.tarot;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        cards.add(new Card("The Fool", R.drawable.maj_00, R.string.c2, R.string.c2r));
        cards.add(new Card("The Magician", R.drawable.maj_01, R.string.c2, R.string.c2r));
//        cards.add(new Card("The High Priestess", R.drawable.maj_02, "C"));
//        cards.add(new Card("The Empress", R.drawable.maj_03, "D"));
//        cards.add(new Card("The Emperor", R.drawable.maj_04, ""));
//        cards.add(new Card("The Hierophant", R.drawable.maj_05, ""));
//        cards.add(new Card("The Lovers", R.drawable.maj_06, ""));
//        cards.add(new Card("The Chariot", R.drawable.maj_07, ""));
//        cards.add(new Card("Strength", R.drawable.maj_08, ""));
//        cards.add(new Card("The Hermit", R.drawable.maj_09, ""));
//        cards.add(new Card("Wheel of Fortune", R.drawable.maj_10, ""));
//        cards.add(new Card("Justice", R.drawable.maj_11, ""));
//        cards.add(new Card("The Hanged Man", R.drawable.maj_12, ""));
//        cards.add(new Card("Death", R.drawable.maj_13, ""));
//        cards.add(new Card("Temperance", R.drawable.maj_14, ""));
//        cards.add(new Card("The Devil", R.drawable.maj_15, ""));
//        cards.add(new Card("The Tower", R.drawable.maj_16, ""));
//        cards.add(new Card("The Star", R.drawable.maj_17, ""));
//        cards.add(new Card("The Moon", R.drawable.maj_18, ""));
//        cards.add(new Card("The Sun", R.drawable.maj_19, ""));
//        cards.add(new Card("Judgement", R.drawable.maj_20, ""));
//        cards.add(new Card("The World", R.drawable.maj_21, ""));
//
//        cards.add(new Card("Ace of Swords", R.drawable.min_s_ac, ""));
//        cards.add(new Card("Two of Swords", R.drawable.min_s_02, ""));
//        cards.add(new Card("Three of Swords", R.drawable.min_s_03, ""));
//        cards.add(new Card("Four of Swords", R.drawable.min_s_04, ""));
//        cards.add(new Card("Five of Swords", R.drawable.min_s_05, ""));
//        cards.add(new Card("Six of Swords", R.drawable.min_s_06, ""));
//        cards.add(new Card("Seven of Swords", R.drawable.min_s_07, ""));
//        cards.add(new Card("Eight of Swords", R.drawable.min_s_08, ""));
//        cards.add(new Card("Nine of Swords", R.drawable.min_s_09, ""));
//        cards.add(new Card("Ten of Swords", R.drawable.min_s_10, ""));
//        cards.add(new Card("Page of Swords", R.drawable.min_c_pa, ""));
//        cards.add(new Card("Knight of Swords", R.drawable.min_s_kn, ""));
//        cards.add(new Card("Queen of Swords", R.drawable.min_s_qu, ""));
//        cards.add(new Card("King of Swords", R.drawable.min_s_ki, ""));
//
//        cards.add(new Card("Ace of Wands", R.drawable.min_w_ac, ""));
//        cards.add(new Card("Two of Wands", R.drawable.min_w_02, ""));
//        cards.add(new Card("Three of Wands", R.drawable.min_w_03, ""));
//        cards.add(new Card("Four of Wands", R.drawable.min_w_04, ""));
//        cards.add(new Card("Five of Wands", R.drawable.min_w_05, ""));
//        cards.add(new Card("Six of Wands", R.drawable.min_w_06, ""));
//        cards.add(new Card("Seven of Wands", R.drawable.min_w_07, ""));
//        cards.add(new Card("Eight of Wands", R.drawable.min_w_08, ""));
//        cards.add(new Card("Nine of Wands", R.drawable.min_w_09, ""));
//        cards.add(new Card("Ten of Wands", R.drawable.min_w_10, ""));
//        cards.add(new Card("Page of Wands", R.drawable.min_w_pa, ""));
//        cards.add(new Card("Knight of Wands", R.drawable.min_w_kn, ""));
//        cards.add(new Card("Queen of Wands", R.drawable.min_w_qu, ""));
//        cards.add(new Card("King of Wands", R.drawable.min_w_ki, ""));
//
//        cards.add(new Card("Ace of Pentacles", R.drawable.min_p_ac, ""));
//        cards.add(new Card("Two of Pentacles", R.drawable.min_p_02, ""));
//        cards.add(new Card("Three of Pentacles", R.drawable.min_p_03, ""));
//        cards.add(new Card("Four of Pentacles", R.drawable.min_p_04, ""));
//        cards.add(new Card("Five of Pentacles", R.drawable.min_p_05, ""));
//        cards.add(new Card("Six of Pentacles", R.drawable.min_p_06, ""));
//        cards.add(new Card("Seven of Pentacles", R.drawable.min_p_07, ""));
//        cards.add(new Card("Eight of Pentacles", R.drawable.min_p_08, ""));
//        cards.add(new Card("Nine of Pentacles", R.drawable.min_p_09, ""));
//        cards.add(new Card("Ten of Pentacles", R.drawable.min_p_10, ""));
//        cards.add(new Card("Page of Pentacles", R.drawable.min_p_pa, ""));
//        cards.add(new Card("Knight of Pentacles", R.drawable.min_p_kn, ""));
//        cards.add(new Card("Queen of Pentacles", R.drawable.min_p_qu, ""));
//        cards.add(new Card("King of Pentacles", R.drawable.min_p_ki, ""));
//
//        cards.add(new Card("Ace of Cups", R.drawable.min_c_ac, ""));
        cards.add(new Card("Two of Cups", R.drawable.min_c_02, R.string.c2, R.string.c2r));
//        cards.add(new Card("Three of Cups", R.drawable.min_c_03, ""));
//        cards.add(new Card("Four of Cups", R.drawable.min_c_04, ""));
//        cards.add(new Card("Five of Cups", R.drawable.min_c_05, ""));
//        cards.add(new Card("Six of Cups", R.drawable.min_c_06, ""));
//        cards.add(new Card("Seven of Cups", R.drawable.min_c_07, ""));
//        cards.add(new Card("Eight of Cups", R.drawable.min_c_08, ""));
//        cards.add(new Card("Nine of Cups", R.drawable.min_c_09, ""));
//        cards.add(new Card("Ten of Cups", R.drawable.min_c_10, ""));
//        cards.add(new Card("Page of Cups", R.drawable.min_c_pa, ""));
//        cards.add(new Card("Knight of Cups", R.drawable.min_c_kn, ""));
//        cards.add(new Card("Queen of Cups", R.drawable.min_c_qu, ""));
//        cards.add(new Card("King of Cups", R.drawable.min_c_ki, ""));

        return cards;
    }
}
