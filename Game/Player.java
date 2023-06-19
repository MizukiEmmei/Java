// Import needed class definitions
import java.util.*;

// Class for Player
class Player {

    int Id;
    Random my_random;
    
    // Construrctor
    Player(int _Id, Random _my_random) {

	this.Id = _Id;
	this.my_random = _my_random;
    }

    // Return Id
    int GetId() {

	return Id;
    }

    // Decision making
    int GetDecision() {

	int tmp_bid = my_random.nextInt(2);
	System.out.println("Player " + Id + ", Decision: " + tmp_bid );

	return tmp_bid;
    }
}
