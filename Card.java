public class Card {
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);

        private final int defaultValue;

        Rank(int defaultValue) {
            this.defaultValue = defaultValue;
        }

        public int getDefaultValue() {
            return defaultValue;
        }
    }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getDefaultValue();
    }

    public boolean isAce() {
        return rank == Rank.ACE;
    }

    @Override
    public String toString() {
        String rankLabel;
        switch (rank) {
            case TWO: rankLabel = "2"; break;
            case THREE: rankLabel = "3"; break;
            case FOUR: rankLabel = "4"; break;
            case FIVE: rankLabel = "5"; break;
            case SIX: rankLabel = "6"; break;
            case SEVEN: rankLabel = "7"; break;
            case EIGHT: rankLabel = "8"; break;
            case NINE: rankLabel = "9"; break;
            case TEN: rankLabel = "10"; break;
            case JACK: rankLabel = "J"; break;
            case QUEEN: rankLabel = "Q"; break;
            case KING: rankLabel = "K"; break;
            case ACE: rankLabel = "A"; break;
            default: rankLabel = rank.name();
        }

        String suitLabel;
        switch (suit) {
            case CLUBS: suitLabel = "\u2663"; break;     // ♣
            case DIAMONDS: suitLabel = "\u2666"; break;  // ♦
            case HEARTS: suitLabel = "\u2665"; break;    // ♥
            case SPADES: suitLabel = "\u2660"; break;    // ♠
            default: suitLabel = suit.name();
        }
        return rankLabel + suitLabel;
    }
}

 
