package it;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    Deck deck = new Deck();

    //costruttore
    public Hand(ArrayList<Card> Deck) {
        deck.setDeck(Deck); //imposto l'iterazione deck uguale anche per questa classe
        createHand(); // creo una nuova mano vuota
    }

    public Hand() {

    }

    public void createHand() {
        hand = new ArrayList<Card>();
        addCard();
        addCard();
    }


    public void addCard() {
        hand.add(deck.drawCard());
    }

    public void printHand() {
        for (int i = 0; i != hand.size(); i++) {
            System.out.println(hand.get(i).getValue() + hand.get(i).getSuit());
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getPoints() {
        int points = 0;
        int aceCounting = 0;
        String card;

        //scopro quanti assi ci sono nella mano e sommo tutte le altre carte
        for (int addingNotAces = 0; addingNotAces != hand.size(); addingNotAces++) {

            card = hand.get(addingNotAces).getValue(); //salvo il valore della carta in una variabile per sommare i punti

            switch (card) {
                case "A" -> aceCounting++;
                case "2" -> points += 2;
                case "3" -> points += 3;
                case "4" -> points += 4;
                case "5" -> points += 5;
                case "6" -> points += 6;
                case "7" -> points += 7;
                case "8" -> points += 8;
                case "9" -> points += 9;
                default -> points += 10;
            }

        }
        //sommo i punti degli assi
        for (int addingAces = 0; addingAces != aceCounting; addingAces++) {
            if (points + 11 < 21) points += 11;
            else points++;
        }

        return points;
    }


}
