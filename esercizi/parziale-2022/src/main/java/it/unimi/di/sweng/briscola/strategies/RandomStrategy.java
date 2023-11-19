package it.unimi.di.sweng.briscola.strategies;

import it.unimi.di.sweng.briscola.Card;
import it.unimi.di.sweng.briscola.Player;
import it.unimi.di.sweng.briscola.Strategy;
import it.unimi.di.sweng.briscola.Suit;
import org.jetbrains.annotations.NotNull;

public class RandomStrategy implements Strategy {
    Strategy next;

    public RandomStrategy(Strategy next) {
        this.next = next;
    }

    @Override
    public @NotNull Card chooseCard(@NotNull Player me, @NotNull Player other, @NotNull Suit briscola) {
        return null;
    }
}
