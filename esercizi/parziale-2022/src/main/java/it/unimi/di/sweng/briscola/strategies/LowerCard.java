package it.unimi.di.sweng.briscola.strategies;

import it.unimi.di.sweng.briscola.*;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LowerCard implements Strategy {
    private Strategy next;

    public LowerCard(Strategy next) {
        this.next = next;
    }

    @Override
    public @NotNull Card chooseCard(@NotNull Player me, @NotNull Player other, @NotNull Suit briscola) {
        Iterator<Card> it=me.iterator();
        Card ret=it.next();
        while (it.hasNext()){
            Card next=it.next();
            if(next.getRank().compareTo(ret.getRank())<0){
                ret=next;
            }
        }
        return ret;
    }
}
