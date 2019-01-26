package com.example.rygn.tarot;

public class Card {
    String title;
    int resId;
    String description;
    boolean reversed;

    public Card() {}

    public Card(String title, int resId, String description) {
        this.title = title;
        this.resId = resId;
        this.description = description;
        this.reversed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int imageUrl) {
        this.resId = resId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isReversed() {
        return reversed;
    }

    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }
}
