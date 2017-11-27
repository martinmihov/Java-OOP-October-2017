package card.interfaces;

import card.enums.Rank;
import card.enums.Suit;

public interface Card extends Comparable<Card>{
    Rank getRank();

    Suit getSuit();

    int getPower();
}
