package rcp.handler;

import java.util.Random;
import javax.swing.JOptionPane;
import rcp.model.Move;
import rcp.ui.MainFrame;

/**
 *
 * @author Gabriella
 */
public class GameHandler {
    
    private final MainFrame MAIN_FRAME;
    private final Random RANDOM;
    
    public GameHandler(MainFrame mainFrame) {
        this.MAIN_FRAME = mainFrame;
        this.RANDOM = new Random();
    }

    /**
     * play the game; make move based on the input code and randomized type for
     * computer's move
     *
     * @param code of move type: [0]Rock, [1]Paper, [2]Scissors
     */
    public void play(int code) {

        // get player's move type
        Move.Type player = this.getMoveType(code);
        // display player move
        this.MAIN_FRAME.getPlayerMoveValue().setText(player.toString());

        // get randomized computer's move type
        Move.Type comp = this.getMoveType(this.RANDOM.nextInt(3));
        // display computer move
        this.MAIN_FRAME.getCompMoveValue().setText(comp.toString());
        
        String winnerInfo = "";
        if (player.equals(comp)) {  // tie
            winnerInfo = "It's a tie!";
        } else if (player.beats(comp)) {    // player win
            winnerInfo = "You win!";
            //increment player score
            int playerScore = Integer.parseInt(this.MAIN_FRAME.getPlayerScoreValue().getText());
            this.MAIN_FRAME.getPlayerScoreValue().setText((playerScore + 1) + "");
        } else {    // computer win
            winnerInfo = "Computer win!";
            //increment computer score
            int compScore = Integer.parseInt(this.MAIN_FRAME.getCompScoreValue().getText());
            this.MAIN_FRAME.getCompScoreValue().setText((compScore + 1) + "");
        }
        // set winner info
        this.MAIN_FRAME.getWinLabel().setText(winnerInfo);
        
    }

    /**
     * Show the message dialogue if the [How to Play] button is clicked
     */
    public void showHowToPlay() {
        JOptionPane.showMessageDialog(this.MAIN_FRAME, "Click one of the three moves option: [Rock, Paper, Scissors]\n"
                + "The box above the option will show yours and the computer's move, and determine who is the winner\n"
                + "Click the [Reset Game] button to reset the current game");
    }

    /**
     * Reset the game
     */
    public void resetGame() {

        // clear all values
        this.MAIN_FRAME.getPlayerMoveValue().setText("");
        this.MAIN_FRAME.getPlayerScoreValue().setText("0");
        this.MAIN_FRAME.getCompMoveValue().setText("");
        this.MAIN_FRAME.getCompScoreValue().setText("0");
        this.MAIN_FRAME.getWinLabel().setText("");
        
    }

    /**
     * Exit the game
     */
    public void exitGame() {
        System.exit(0);
    }

    /**
     * Get move type based on the input code
     *
     * @param code of move type: [0]Rock, [1]Paper, [2]Scissors
     */
    private Move.Type getMoveType(int code) {
        switch (code) {
            case 0:
                return Move.Type.ROCK;
            case 1:
                return Move.Type.PAPER;
            case 2:
                return Move.Type.SCISSORS;
            default:
                return null;
        }
    }
    
}
