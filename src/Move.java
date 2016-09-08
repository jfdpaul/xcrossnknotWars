/*
 * Class to store a move's logic
 * */
public class Move {
    State state;    //State of a Move
    int row,column; //(row,column) position on board


    /* Default Constructor to set State and
     * (row,column) tuple of a Move
     * */
    public Move(){
        this.state=State.X;
        this.row=0;
        this.column=0;
    }

    /* Parameterized Constructor to set State and
     * (row,column) tuple of a Move
     * */
    public Move(State state,int row,int column){
        this.state=state;
        this.row=row;
        this.column=column;
    }

    @Override
    public String toString(){
        return state+" @ ("+row+","+column+")";
    }
}
