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


public class Player6 extends Player {

    /* Default constructor to set Player's state and name.
     * */
    public Player6(){
        super();
        name="78";
    }

    /* Parameterized Constructor to set player's state.
     * */
    public Player6(State state){
        super(state);
        name="78";
    }

    /* Getter Method to return next move to be played
     * */
    @Override
    public Move getMove(State[][]mat,int winningStretch)
	{
		int dime=mat.length;
        //write logic below
		int countX=0;
		int countO=0;
		int countE=0;
		int countSt=0;
		int posR=0;
		int posC=0;
		for(int i=0;i<dime;i++)
		{
			for(int j=0;j<dime;j++)
			{
				int k=i;
				for(int l=j;l<winningStretch&&(l<dime);l++)
				{
						if(mat[k][l]==State.X)
						{countX++;
						countSt++;}
						else if(mat[k][l]==State.O)
						{countO++;
						countSt++;}
						else if(mat[k][l]==State.EMPTY)
						{countE++;
						countSt++;
						posR=k;
						posC=l;
						}
		
				}	
			
				if((countX==winningStretch&&countE==1))
				{
				Move nextmove=new Move(State.X,posR,posC);
				return nextmove;

				}
				else if(countO==winningStretch&&countE==1)
				{
				Move nextmove=new Move(State.O,posR,posC);
				return nextmove;

				}
				k=j;
				countSt=0;
				countE=0;
				countX=0;
				countO=0;
				for(int l=k;l<winningStretch&&(l<dime);l++)
				{
					if(mat[k][l]==State.X)
						{countX++;
						countSt++;}
					else if(mat[k][l]==State.O)
						{countO++;
						countSt++;}
					else if(mat[k][l]==State.EMPTY)
						{countE++;
						countSt++;
						posR=k;
						posC=l;
						}
		
				}
			
				if((countX==winningStretch&&countE==1))
				{
				Move nextmove=new Move(State.X,posR,posC);
				return nextmove;
				}
				else if(countO==winningStretch&&countE==1)
				{
					Move nextmove=new Move(State.O,posR,posC);
					return nextmove;
				
				}
				k=i;
				countSt=0;
				countE=0;
				countX=0;
				countO=0;
				for(int l=j;l<winningStretch&&(l<dime)&&(k<dime);l++,k++)
				{
					if(mat[k][l]==State.X)
						{countX++;
						countSt++;}
					else if(mat[k][l]==State.O)
						{countO++;
						countSt++;}
					else if(mat[k][l]==State.EMPTY)
						{countE++;
						countSt++;
						posR=k;
						posC=l;
						}
		
				}
			
					if((countX==winningStretch&&countE==1))
					{
					Move nextmove=new Move(State.X,posR,posC);
					return nextmove;

					}
					else if(countO==winningStretch&&countE==1)
					{
					Move nextmove=new Move(State.O,posR,posC);
					return nextmove;

					}
			
			
			}
		}
		for(int i=0;i<dime;i++)
		for(int j=0;j<dime;j++)
		{
			if(mat[i][j]==State.EMPTY){
				Move nextmove=new Move(State.X,i,j);
				return nextmove;
			}
		}
		return null;
    }

    public static void main(String[]args){
        Player6 p=new Player6(State.O);

        //Example 3x3 matrix of states
        int dime=3;
		State[][] mat=new State[3][3];
        mat[0][0]=State.X;
        mat[0][1]=State.O;
        mat[0][2]=State.X;
        mat[1][0]=State.EMPTY;
        mat[1][1]=State.O;
        mat[1][2]=State.O;
        mat[2][0]=State.EMPTY;
        mat[2][1]=State.EMPTY;
        mat[2][2]=State.EMPTY;
		Move newmove=new Move();
		newmove=p.getMove(mat,3);
		if(newmove.state==State.X)
		{
			System.out.println("Move X"+newmove.row+","+newmove.column);
		}
		else if(newmove.state==State.O)
		{
			System.out.println("Move O"+newmove.row+","+newmove.column);
		}

        
    }
}
