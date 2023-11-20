package it.unimi.di.sweng.briscola.strategies;

import it.unimi.di.sweng.briscola.Card;
import it.unimi.di.sweng.briscola.Player;
import it.unimi.di.sweng.briscola.Strategy;
import it.unimi.di.sweng.briscola.Suit;
import org.jetbrains.annotations.NotNull;

public class SecondCardBriscolaStrategy implements Strategy {
    private Strategy next;

    public SecondCardBriscolaStrategy(Strategy next) {
        this.next = next;
    }

    @Override
    public @NotNull Card chooseCard(@NotNull Player me, @NotNull Player other, @NotNull Suit briscola) {
        Card cBriscola=null;
        Card cBriscolaLocal=null;
        for (Card c: me) {
            if(c.getSuit().equals(briscola)){
                cBriscola=c;
            }else if(c.getSuit().equals(other.playedCard().getSuit())&& c.getRank().compareTo(other.playedCard().getRank())>0){
                cBriscolaLocal=c;

            }
        }
        if(cBriscola!=null){
            return cBriscola;
        }
        if(cBriscolaLocal!=null){
            return cBriscolaLocal;
        }
        return next.chooseCard(me,other,briscola);
    }
}
