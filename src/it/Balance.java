package it;

import java.util.ArrayList;

public class Balance {
    float balance;
    float bet;
    ArrayList<Card> dealer;
    ArrayList<Card> player;

    public Balance(float startingMoney, ArrayList<Card> player, ArrayList<Card> dealer) {
        this.balance = startingMoney;
        this.player = player;
        this.dealer = dealer;
    }

    public void addBalance(float money) {
        balance += money;
    }

    public void setBet(float currentBet) {
        this.bet = currentBet;
    }

    public float checkWin() {
        Hand Player = new Hand();
        Player.setHand(player);
        Hand Dealer = new Hand();
        Dealer.setHand(dealer);
        float moneyWon = 0;


        if(Player.getPoints()>21) return 0;
        else if(Dealer.getPoints()> Player.getPoints()) return 0;
        else if(Dealer.getPoints()== Player.getPoints()) return bet;
        else if(Player.getPoints()==21&&player.size()==2) return bet*5/2;
        else if(Dealer.getPoints()>21) return bet*2;
        else return bet*2;
    }


}
