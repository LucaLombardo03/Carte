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

    public int getPoints() {
        int points = 0;
        int aceCounting = 0;
        String card;

        //scopro quanti assi ci sono nella mano e sommo tutte le altre carte
        for (int addingNotAces = 0; addingNotAces != hand.size(); addingNotAces++) {

            card = hand.get(addingNotAces).getValue(); //salvo il valore della carta in una variabile per sommare i punti
            if (card.equals("A")) aceCounting++;
            else if (card.equals("2")) {
                points += 2;
            } else if (card.equals("3")) {
                points += 3;
            } else if (card.equals("4")) {
                points += 4;
            } else if (card.equals("5")) {
                points += 5;
            } else if (card.equals("6")) {
                points += 6;
            } else if (card.equals("7")) {
                points += 7;
            } else if (card.equals("8")) {
                points += 8;
            } else if (card.equals("9")) {
                points += 9;
            } else {
                points += 10;
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
