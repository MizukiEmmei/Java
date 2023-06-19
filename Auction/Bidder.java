// Import needed class definitions
import java.util.Random;

// Class for Bidder
class Bidder {

    int Id;

    Random my_random;
    
    // Construrctor
    Bidder(int _Id, Random _my_random) {

	this.Id = _Id;
	this.my_random = _my_random;
    }

    // Return Id
    int GetId() {

	return Id;
    }

    // Make Bid
    int GetBid() {

	int tmp_bid = my_random.nextInt(21) + 10;
	System.out.println("Bidder: " + Id + " Bid : " + tmp_bid);

	return tmp_bid;
    }
}
