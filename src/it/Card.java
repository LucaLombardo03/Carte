package it;

public class Card {
    private String suit;
    private String value;

    Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    } // ritorna il seme della carta

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    } // ritorna il numero/figura della carta

    public void setValue(String value) {
        this.value = value;
    }

}
