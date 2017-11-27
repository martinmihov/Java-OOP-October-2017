package card;

import card.enums.Rank;
import card.enums.Suit;
import card.interfaces.Card;

public class CardImpl implements Card, Comparable<Card>{
    private Rank rank;
    private Suit suit;
    private int power;

    public CardImpl(Rank rank, Suit suit) {
        this.setRank(rank);
        this.setSuit(suit);
        this.setPower();
    }

    @Override
    public Rank getRank() {
        return this.rank;
    }

    @Override
    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public int compareTo(Card card) {
        return -1;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    private void setRank(Rank rank) {
        this.rank = rank;
    }

    private void setSuit(Suit suit) {
        this.suit = suit;
    }

    private void setPower() {
        this.power = this.rank.getPower() + this.suit.getPower();
    }
}
