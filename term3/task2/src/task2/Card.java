package task2;

public class Card {
	private  Values value;
	 private Suits suit;
	
	public Card (Values value, Suits suit) {
		this.value=value;
		this.suit=suit;
	}
		
		public Values getValue () {
			return value; 
		}
		
		public Suits getSuit () {
			return suit;
		}
		
		public  void setValue (Values value) {
			this.value=value;
		}
		
		public void setSuit (Suits suit) {
			this.suit=suit;
		}

		@Override
		public String toString() {
			return "Card [value=" + value + ", suit=" + suit + "]";
		}
	}
