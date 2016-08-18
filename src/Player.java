/**
 * Created by jonty on 7/30/16.
 */
public abstract class Player {
    private State playerState;
    protected String name;

    abstract public Move getMove(State[][]mat);
    public Player setState(State state){
        playerState=state;
        return this;
    }
    public State getPlayerState(){
        return playerState;
    }
}
