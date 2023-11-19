package it.unimi.di.sweng.briscola.strategies;

import it.unimi.di.sweng.briscola.Card;
import it.unimi.di.sweng.briscola.Player;
import it.unimi.di.sweng.briscola.Strategy;
import it.unimi.di.sweng.briscola.Suit;
import org.jetbrains.annotations.NotNull;

public class FirstCardBriscolaStrategy implements Strategy {
    private Strategy next;

    public FirstCardBriscolaStrategy(Strategy next) {
        this.next = next;
    }

    @Override
    public @NotNull Card chooseCard(@NotNull Player me, @NotNull Player other, @NotNull Suit briscola) {
        for (Card c:me) {
            if(c.getSuit()==briscola){
                return c;
            }
        }
        return next.chooseCard(me,other,briscola);
    }
}
