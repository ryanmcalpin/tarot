package com.example.rygn.tarot;

public class Spread {
    String spreadType;
    int[] cardIndices;

    public Spread () {}

    public Spread(String spreadType, int[] cardIndices) {
        this.spreadType = spreadType;
        this.cardIndices = cardIndices;
    }

    public String getSpreadType() {
        return spreadType;
    }

    public void setSpreadType(String spreadType) {
        this.spreadType = spreadType;
    }

    public int[] getCardIndices() {
        return cardIndices;
    }

    public void setCardIndices(int[] cardIndices) {
        this.cardIndices = cardIndices;
    }
}
