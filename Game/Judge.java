// Import needed class definitions
import java.util.*;

// Class for Judge
class Judge {
    
    // My random source
    Random my_random;

    // Parameters for game
    int player_num;

    // A list of players
    List<Player> player_list;

    // Constructor
    Judge(int _player_num) {
	
	this.player_num = _player_num;

	my_random = new Random();
	
	player_list = new ArrayList<Player>();

	InitializePlayerList();
    }
    
    // Initialize players
    void InitializePlayerList() {
	
	for( int i=0; i<player_num; i++) {
	    player_list.add(new Player(i, my_random));
	}
    }

    // Game process
    void Evaluate() {

	// Memoralize decision
	int decision[];
        decision = new int[player_num];

	// Get decisions
	Iterator it = player_list.iterator();
	int i=0;
	while( it.hasNext() ) {
	    Player tmp_player = (Player)it.next();
	    decision[i] = tmp_player.GetDecision();
	    i++;
	}

	// Judge profit
	if(decision[0] == 1 ) {
	    if(decision[1] == 1){
		System.out.println("Profits: Player 0: 3, Player 1: 3");
	    }
	    else{
		System.out.println("Profits: Player 0: 0, Player 1: 5");
	    }
	}
	else {
	    if(decision[1] == 1){
		System.out.println("Profits: Player 0: 5, Player 1: 0");
	    }
	    else{
		System.out.println("Profits: Player 0: 1, Player 1: 1");
	    }
	}
    }
}
