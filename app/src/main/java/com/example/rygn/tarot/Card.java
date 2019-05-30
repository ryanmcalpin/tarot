package com.example.rygn.tarot;

public class Card {
    String title;
    int imageId;
    int descriptionId;
    int rDescriptionId;
    boolean reversed;
    int i;

    public Card() {}

    public Card(String title, int imageId, int descriptionId, int rDescriptionId) {
        this.title = title;
        this.imageId = imageId;
        this.descriptionId = descriptionId;
        this.rDescriptionId = rDescriptionId;
        this.reversed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageUrl) {
        this.imageId = imageId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getrDescriptionId() {
        return rDescriptionId;
    }

    public void setrDescriptionId(int rDescriptionId) {
        this.rDescriptionId = rDescriptionId;
    }

    public boolean isReversed() {
        return reversed;
    }

    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }
}
