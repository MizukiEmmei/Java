// Import needed class definitions

// Class for Auction Play
class AuctionPlay {

    public static void main(String args []) {

	// Parameters for Auction
	int bidder_num = 5;

	// Initialize Auctioneer
	Auctioneer my_auctioneer = new Auctioneer(bidder_num);

	// Actual optimization process
	my_auctioneer.Evaluate();
    }
}
