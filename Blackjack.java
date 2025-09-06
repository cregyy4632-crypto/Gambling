import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        Deck deck = new Deck();
        Hand player = new Hand();
        Hand dealer = new Hand();

        // Initial deal
        player.add(deck.deal());
        dealer.add(deck.deal());
        player.add(deck.deal());
        dealer.add(deck.deal());

        System.out.println("Dealer shows: " + dealer.getCards().get(0));
        System.out.println("Your hand:   " + player);

        // Player turn
        while (true) {
            if (player.isBust()) {
                System.out.println("You bust! Dealer wins.");
                return;
            }
            System.out.print("Hit or stand? (h/s): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.startsWith("h")) {
                player.add(deck.deal());
                System.out.println("Your hand:   " + player);
            } else if (choice.startsWith("s")) {
                break;
            }
        }

        // Dealer turn  
        
        System.out.println("Dealer hand: " + dealer);
        while (dealer.getValue() < 17) {
            dealer.add(deck.deal());
            System.out.println("Dealer hits: " + dealer);
        }

        if (dealer.isBust()) {
            System.out.println("Dealer busts! You win.");
            return;
        }

        int playerValue = player.getValue();
        int dealerValue = dealer.getValue();
        System.out.println("Final - You: " + playerValue + " Dealer: " + dealerValue);
        if (playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("Push (tie).");
        }
        }
    }
}