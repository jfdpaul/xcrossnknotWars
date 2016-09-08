/*
* Abstract class to define basic behavior of a 'Player'
*/
public abstract class Player {
    private State playerState;  //'State' of a 'Player'
    protected String name;      //Name of 'Player'

    /*Default Constructor
     * Creates a 'Player' object with default State as X (Cross)
     * */
    public Player(){
        playerState=State.X;
    }

    /* Parameterized Constructor :
    * Creates 'Player' object for a 'State'
    * */
    public Player(State state){
        playerState=state;
    }

    /*Setter Method to return 'State' of object of a 'Player'*/
    public final Player setState(State state){
        playerState=state;
        return this;
    }

    /*Getter Method to return next 'Move' to be played*/
    abstract public Move getMove(State[][]mat,int winningStretch);

    /*Getter Method to return 'State' of 'Player'*/
    public final State getPlayerState(){
        return playerState;
    }
}
