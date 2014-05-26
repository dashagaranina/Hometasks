import java.util.Random;

public class Deck {
	private Card[] cards = new Card[36];

	public Deck() {
		for (int i = 0; i < 36; i++) {
			cards[i] = new Card(Values.values()[i%9], Suits.values()[i/9]);
		}
	}

	public  void mix(Card[] cards) {
		Random rand = new Random();
		Card current = null;
		for (int i = 0; i < 36; i++) {
			int cur = rand.nextInt(36);
			current = this.cards[i];
			cards[i] = this.cards[cur];
			cards[cur] = current;

		}
	}

	public static void main(String[] args) {
		Card [] cards = new Card [36];
		Deck d= new Deck();
		d.mix(cards);
		for (int i = 0; i < 36; i++) {
			System.out.println(cards[i]);
		}
	}
}