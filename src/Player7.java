/*          ********** CODE-CLASH **********
   DETAILS
 -------------------------------------------
 * AUTHOR           :KARNAN S
 * PARTICIPANT_PID  :14
 * PLAYER           :7
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
import java.util.*;
class sList{
	int x,y;
	sList(int i,int j){
		x=i;
		y=j;
	}
}

public class Player7 extends Player {

    /* Default constructor to set Player's state and name.
     * */
    public Player7(){
        super();
        name="14";
    }

    /* Parameterized Constructor to set player's state.
     * */
    public Player7(State state){
        super(state);
        name="14";
    }

    /* Getter Method to return next move to be played
     * */
    @Override
    public Move getMove(State[][]mat,int winningStretch){
        //write logic below
		int x=0,y=0,f1=0,f2=0;
		int msize=mat.length;
		State opstat;
		ArrayList<sList> posop=new ArrayList<sList>();
		ArrayList<sList> emptys=new ArrayList<sList>();
		State mystat=getPlayerState();
		for(int i=0;i<msize;i++){
			for(int j=0;j<msize;j++){
				if((!mat[i][j].equals (mystat)) && (!mat[i][j].equals(State.EMPTY)) ){
					opstat=mat[i][j];
					posop.add(new sList(i,j));
		
				}else if(mat[i][j].equals(State.EMPTY)){
		
					emptys.add(new sList(i,j));
		
				}
			}
		}
		//System.out.println(emptys.size());
		for(int i=0;i<emptys.size();i++){
			int tex=emptys.get(i).x;
			int tey=emptys.get(i).y;
			//System.out.println(tex+" "+tey);
			for(int j=0;j<posop.size();j++){
				int tx=posop.get(j).x;
				int ty=posop.get(j).y;
				
				//System.out.println(tx + ","+ty);
				if((tex+1)==tx ||(tey+1)==ty){
					x=tex;
					f1=1;
				}
				if((tex-1)==tx|| (tey-1)==ty){
					y=tey;
					f2=1;
				}
				
				if(f1==1 && f2==1){
					break;
				}
			}
			if(f1==1 && f2==1){
				break;	
			}
		}
		
        return new Move(mystat,x,y);
    }


    public static void main(String[]args){
        Player7 p=new Player7(State.O);

        //Example 3x3 matrix of states
        State[][] mat=new State[4][4];
        mat[0][0]=State.X;
        mat[0][1]=State.O;
        mat[0][2]=State.EMPTY;
		mat[0][3]=State.EMPTY;
        mat[1][0]=State.EMPTY;
        mat[1][1]=State.EMPTY;
        mat[1][2]=State.X;
		mat[1][3]=State.X;
        mat[2][0]=State.EMPTY;
        mat[2][1]=State.EMPTY;
        mat[2][2]=State.EMPTY;
		mat[2][3]=State.EMPTY;
		mat[3][0]=State.EMPTY;
		mat[3][1]=State.EMPTY;
		mat[3][2]=State.O;
		mat[3][3]=State.EMPTY;
		

        System.out.println(p.getMove(mat,3));
    }
}
