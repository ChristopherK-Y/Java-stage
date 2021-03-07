package card;

import java.util.Objects;

public class Card {
    private final int rank;
    private final String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // [♥ A] ...
    @Override
    public String toString() {
        return String.format("[%s %s]", suit, rankToString(rank));
    }

    private static String rankToString(int rank) {
        switch (rank) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(rank);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    public static void main(String[] args) {
        Card c1 = new Card(11, "♥");
        Card c2 = new Card(12, "♠");
        Card c3 = new Card(13, "♣");
        Card c4 = new Card(10, "♦");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}
