package it;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float bet;
        Deck deck = new Deck();
        Hand dealer; //banco
        Hand player;
        Balance playerBalance;
        float startingMoney=100;
        deck.buildDeck(); //si mescola automaticamente

        dealer = new Hand(deck.getDeck()); //assicurati che il mazzo sia creato ogni nuova partita nella quale crei una nuova mano.
        player = new Hand(deck.getDeck());

        do{
            System.out.println("Quanti crediti vuoi puntare?");
            bet = sc.nextFloat();
        }while(bet<0);
        for(int i = 0; i<2; i++){
            player.addCard();
        }
        System.out.println("Le carte del giocatore sono:");
        player.printHand();
        for(int i = 0; i<2; i++){
            dealer.addCard();
        }
        System.out.println("La carta del banco è:");
        dealer.printCard();
    }
}
































































