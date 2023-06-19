// Import needed class definitions
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// Class for Auctioneer
class Auctioneer {
    
    // My random source
    Random my_random;

    // Parameters for Auction
    int bidder_num;

    // A list of bidders
    List<Bidder> bidder_list;

    // Constructor
    Auctioneer(int _bidder_num) {
	
	this.bidder_num = _bidder_num;

	my_random = new Random();
	
	bidder_list = new ArrayList<Bidder>();

	InitializeBidderList();
    }
    
    // Initialize bidders
    void InitializeBidderList() {
	
	for( int i=0; i<bidder_num; i++) {
	    bidder_list.add(new Bidder(i, my_random));
	}
    }

    // Auction process
    void Evaluate() {

	// Memoralize bid
	int bid[];
	bid = new int[bidder_num];

	// Get Bids
	Iterator it = bidder_list.iterator();
	int i=0;
	while( it.hasNext() ) {
	    Bidder tmp_bidder = (Bidder)it.next();
	    bid[i] = tmp_bidder.GetBid();
	    i++;
	}
	
	int max = bid[0];
	int win_i = 0;
	for(i = 1; i < bidder_num; i++) {
		if(max < bid[i]) {
			max = bid[i];
			win_i = i;
			
		}
	}
	System.out.println("Winnder: Bidder " + win_i + " !!");
	
	
	/*
	// Winner Determination
	int eval = ( bid[0] - bid[1] + 3 ) % 3;
	if( eval == 0 ) {
	    System.out.println("Draw...");
	}
	else if(eval == 2) {
	    System.out.println("Winnder: Bidder 0 !!");
	}
	else if(eval == 1) {
	    System.out.println("Winnder: Bidder 1 !!");
	}
	else {
	    System.out.println("Evaluation Error!");
	}
    }
    */
}
    }
