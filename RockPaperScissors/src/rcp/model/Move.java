package rcp.model;

/**
 * 
 * @author Gabriella
 */
public class Move {

    /**
     * Type of move that can be taken by the player | Move type: rock, paper,
     * scissors, where rock < paper < scissors < rock
     */
    public enum Type {

        ROCK {
            @Override
            public boolean beats(Type opponent) {
                return opponent == SCISSORS;
            }
        }, PAPER {
            @Override
            public boolean beats(Type opponent) {
                return opponent == ROCK;
            }
        }, SCISSORS {
            @Override
            public boolean beats(Type opponent) {
                return opponent == PAPER;
            }
        };

        /**
         * Check whether the move type beats the other's
         *
         * @param type of move to compare
         * @return true if the the move type beats the other's, false otherwise
         */
        public abstract boolean beats(Type type);

    }

}
