package it;
import java.util.*;

// da settare nella VM del main
// --module-path "C:\Users\zacch\Downloads\java\JLib\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
public class Main {
    public static void main(String[]args){
        Deck deck = new Deck();
        System.out.println("");
        deck.buildDeck();
        deck.printDeck();
        System.out.println("");
        deck.shuffle();


    }
}

































































errore
