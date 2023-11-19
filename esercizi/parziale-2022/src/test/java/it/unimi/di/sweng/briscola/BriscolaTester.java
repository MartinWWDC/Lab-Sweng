package it.unimi.di.sweng.briscola;

import it.unimi.di.sweng.briscola.strategies.RandomStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BriscolaTester {
    /**
     * come si fa????

    @Test
    void establishTurnWinnerTest(){
        Player p1=mock(Player.class);
        Player p2=mock(Player.class);
        Deck dk= mock(Deck.class);
        for (int i = 0; i < 6; i++) {
            when(dk.draw()).thenReturn(Card.get(Rank.RE,Suit.BASTONI));
        }

        when(dk.draw()).thenReturn(Card.get(Rank.RE,Suit.BASTONI));


        Briscola br=new Briscola(p1,p2,dk);

        assertThat(br.establishTurnWinner(Card.get))


    }
    */
    @Test
    void playerIterableTest(){
        Player p=new Player("Tino");
        p.giveCard(Card.get(Rank.RE,Suit.BASTONI));
        p.giveCard(Card.get(Rank.QUATTRO,Suit.BASTONI));
        p.giveCard(Card.get(Rank.RE,Suit.DENARI));
        assertThat(p.iterator()).toIterable().containsExactlyInAnyOrder(Card.get(Rank.RE,Suit.BASTONI),
        Card.get(Rank.QUATTRO,Suit.BASTONI),
        Card.get(Rank.RE,Suit.DENARI));
    }

    @Test
    void playerComparableTest(){
        Player p1=new Player("Tino");
        Player p2 =new Player("Gino");
        p1.addWonCardsToPersonalDeck(Card.get(Rank.RE,Suit.BASTONI),Card.get(Rank.RE,Suit.BASTONI));
        p2.addWonCardsToPersonalDeck(Card.get(Rank.DUE,Suit.BASTONI),Card.get(Rank.SEI,Suit.BASTONI));



        assertThat(p1.compareTo(p2)).isEqualTo(1);
    }

    @Test
    void randomStrategyTest(){
        List<Card> cards=List.of(Card.get(Rank.RE,Suit.BASTONI),Card.get(Rank.CAVALLO,Suit.COPPE));
        RandomStrategy rS =new RandomStrategy(null);
        Player me=mock(Player.class);
        Player other=mock(Player.class);

        MockUtils.whenIterated(me,Card.get(Rank.RE,Suit.BASTONI),Card.get(Rank.CAVALLO,Suit.COPPE));
        assertThat(rS.chooseCard(me,other,Suit.COPPE)).isIn(cards);

    }

}
