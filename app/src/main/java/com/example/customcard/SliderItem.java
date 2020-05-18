package com.example.customcard;

public class SliderItem {

    private int currentCard;

    SliderItem(int currentCard){
        this.currentCard = currentCard;
    }

    public int getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(int currentCard) {
        this.currentCard = currentCard;
    }
}
