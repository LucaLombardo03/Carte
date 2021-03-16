package it;

import java.util.ArrayList;
import java.util.Random;


public class Deck {
    private ArrayList<Card> Deck;

    String[] suit = {"H", "C", "S", "D"};
    String[] value = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K"};

    public Deck() {
        Deck = new ArrayList<Card>();
    }

    //costruisco il mazzo
    public void buildDeck() {

        int k = 0;
        int j = 0;
        for (int l = 0; l != 2; l++) {
            for (int i = 0; i < 4; i++) {
                do {
                    Card card = new Card(value[j], suit[i]);
                    Deck.add(card);
                    j++;
                    k++;
                } while (j < 13);
                j = 0;
            }
        }
        Deck.add(Deck.get(1));
        shuffle(); //mescola automaticamente il mazzo dopo esser stato creato
    }


    //Stampo il mazzo
    public void printDeck() {
        for (int i = 0; i < 104; i++) {
            System.out.println(Deck.get(i).getValue() + Deck.get(i).getSuit());
        }
    }


    //mescolo il mazzo (parte automaticamente dopo aver creato il mazzo)
    public void shuffle() {
        int scambia = 3000000;

        int indiceUno;
        int indiceDue;
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i != scambia; i++) {
            indiceUno = rnd.nextInt(Deck.size() - 1);
            indiceDue = rnd.nextInt(Deck.size() - 1);

            //usato indice 104 come supporto
            Deck.set(104, Deck.get(indiceUno));
            Deck.set(indiceUno, Deck.get(indiceDue));
            Deck.set(indiceDue, Deck.get(104));
        }

    }

    public ArrayList<Card> getDeck() {
        return Deck;
    }

    public void setDeck(ArrayList<Card> Deck) {
        this.Deck = Deck;
    }


    public Card drawCard() {
        Card card = Deck.get(0);
        Deck.remove(0);
        return card;
    }
    //end

}
