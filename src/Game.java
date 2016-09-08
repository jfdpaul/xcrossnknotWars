/**
 * Created by jonty on 7/30/16.
 */

public class Game {
    private State[][] mat;  //matrix to store the three enum values.
    private int size;       //size of square matrix
    private int winning_stretch;    //number of similar moves in one stretch
    int turn;      // number of turns played

    /*Constructor to initialise to default values*/
    public Game(){
        size=5;
        winning_stretch=3;
        initGame();
    }

    /*Constructor to initialise matrix size to given values*/
    public Game(int size,int winning_stretch){
        this.size=size;
        this.winning_stretch=winning_stretch;
        initGame();
    }

    /*Get winning stretch*/
    int getWinningStretch(){
        return winning_stretch;
    }

    /*Method to set state at (row,column)*/
    public void setMove(State state, int row, int column){
        mat[row][column]= state;
    }

    /*Method to check if state at (row,column) is Empty or not*/
    public boolean isValidMove(State state, int row, int column){
        if(mat[row][column]!= State.EMPTY)
            return false;
        else
            return true;
    }

    /*Method to check if state at (row,column) will lead to win or not*/
    public boolean isWin(State state, int row, int column){
        int count=0;

        /*Horizontal check*/
        //going towards right
        for(int i=column;i<size;i++){
            if(mat[row][i]== state)
                count++;
            else
                break;
        }
        //going towards left
        for(int i=column-1;i>=0;i--){
            if(mat[row][i]== state)
                count++;
            else
                break;
        }
        if(count==winning_stretch)
            return true;

        /*Vertical check*/
        count=0;
        //going down
        for(int i=row;i<size;i++){
            if(mat[i][column]== state)
                count++;
            else
                break;
        }
        //going towards up
        for(int i=row-1;i>=0;i--){
            if(mat[i][column]== state)
                count++;
            else
                break;
        }
        if(count==winning_stretch)
            return true;

        /*Diagonal(North-West to South-East) check*/
        count=0;
        //going (South-East)
        for(int i=row,j=column;i<size && j<size ;i++,j++){
            if(mat[i][j]== state)
                count++;
            else
                break;
        }
        //going (North-West)
        for(int i=row-1,j=column-1;i>=0 && j>=0 ;i--,j--){
            if(mat[i][j]== state)
                count++;
            else
                break;
        }
        if(count==winning_stretch)
            return true;

        /*Diagonal(South-West to North-East) check*/
        count=0;
        //going (North-East)
        for(int i=row,j=column;i>=0 && j<size ;i--,j++){
            if(mat[i][j]== state)
                count++;
            else
                break;
        }
        //going (South-West)
        for(int i=row+1,j=column-1;i<size && j>=0 ;i++,j--){
            if(mat[i][j]== state)
                count++;
            else
                break;
        }
        if(count==winning_stretch)
            return true;

        //DEFAULT CONDITION
        return false;
    }

    /*Set initial parameters*/
    public void initGame(){
        turn=0;
        mat=new State[size][size];
        for(int i=0;i<size;i++) {
            for (int j = i; j < size; j++) {
                mat[i][j] = State.EMPTY;
                mat[j][i] = State.EMPTY;
            }
        }
    }

    public State[][] getGameMatrix(){
        return mat;
    }

    /*Method to display matrix*/
    public void showMatrixOnConsole(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(mat[i][j]== State.EMPTY)
                    System.out.print("#");
                else
                    System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
