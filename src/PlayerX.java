/*          ********** CODE-CLASH **********
   DETAILS
 -------------------------------------------
 * AUTHOR           :
 * PARTICIPANT_PID  :
 * PLAYER           :
 -------------------------------------------
 * */

/*
* ------- INSTRUCTIONS --------
* > You are required to code the next move logic, for the present state of the game board ( n x n ).
* > Method should return a Move object (State,row,column)
* > Method will receive present state of board and winning stretch.
* > If 3 invalid moves are returned consecutively, the player will lose the match.
*    (An invalid move occurs when a Move is returned to a position whose State is not EMPTY)
* > Avoid getting stuck in an infinite loop when calculating the next move.
* > Each player's logic will be run against another player's logic.
*    eg. Player3 vs Player5
*    All combinations between Players will be worked out to get the score of the best logic.
* */


public class PlayerX extends Player {

    /* Default constructor to set Player's state and name.
     * */
    public PlayerX(){
        super();
        name="PX";
    }

    /* Parameterized Constructor to set player's state.
     * */
    public PlayerX(State state){
        super(state);
        name="PX";
    }

    /* Getter Method to return next move to be played
     * */
    @Override
    public Move getMove(State[][]mat,int winningStretch){
        //write logic below

        return new Move();
    }

    public static void main(String[]args){
        PlayerX p=new PlayerX(State.O);

        //Example 3x3 matrix of states
        State[][] mat=new State[3][3];
        mat[0][0]=State.X;
        mat[0][1]=State.EMPTY;
        mat[0][2]=State.X;
        mat[1][0]=State.EMPTY;
        mat[1][1]=State.O;
        mat[1][2]=State.EMPTY;
        mat[2][0]=State.EMPTY;
        mat[2][1]=State.EMPTY;
        mat[2][2]=State.EMPTY;

        System.out.println(p.getMove(mat,3));
    }
}
