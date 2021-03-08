package it;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand dealer;

        Hand player;
        Balance playerBalance;
        float startingMoney=100;
        deck.buildDeck();
        deck.shuffle();
        //deck.printDeck();

        dealer = new Hand(deck.getDeck());//assicurati che il mazzo sia creato ogni nuova partita nella quale crei una nuova mano.

        //deck.printDeck();
        dealer.addCard();
        //punti.CalculatePoints();
        //System.out.println("\n");
        //dealer.printHand();


        //
        player = new Hand(deck.getDeck());
        player.addCard();
        player.printHand();

        System.out.println(player.getPoints());

        //
        playerBalance = new Balance(startingMoney,player.getHand(),dealer.getHand());
    }
}
































































