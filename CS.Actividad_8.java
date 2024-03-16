import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    String suit;
    String color;
    String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + "," + color + "," + value;
    }
}

public class Deck {
    List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Treboles", "Corazones", "Picas", "Diamantes"};
        String[] colors = {"Negro", "Rojo"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String suit : suits) {
            for (String color : colors) {
                for (String value : values) {
                    cards.add(new Card(suit, color, value));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezclo la baraja.");
    }

    public void head() {
        if (!cards.isEmpty()) {
            Card card = cards.remove(0);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en la baraja.");
        } else {
            System.out.println("La baraja esta vacia.");
        }
    }

    public void pick() {
        if (!cards.isEmpty()) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card card = cards.remove(randomIndex);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("La baraja esta vacia.");
        }
    }

    public void hand() {
        if (cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                System.out.println(card);
            }
            System.out.println("Quedan " + cards.size() + " cartas en la baraja.");
        } else {
            System.out.println("No hay suficientes cartas en la baraja para repartir una mano.");
        }
    }

public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println();

        System.out.println("Mostrando la cabeza:");
        deck.head();
        System.out.println();

        System.out.println("Seleccionando una carta al azar:");
        deck.pick();
        System.out.println();

        System.out.println("Repartiendo una mano:");
        deck.hand();
    }
}
