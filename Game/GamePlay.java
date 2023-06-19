// Import needed class definitions
import java.util.*;

// Class for Game Play
class GamePlay {

    public static void main(String args []) {

	// Parameters for game play
	int player_num = 2;

	// Initialize Judge
	Judge my_judge = new Judge(player_num);

	// Actual game play process
	my_judge.Evaluate();
    }
}
