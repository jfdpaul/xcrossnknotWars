/*          ********** CODE-CLASH **********
   DETAILS
 -------------------------------------------
 * AUTHOR           : SANJAY K JOHN
 * PARTICIPANT_PID  : 15
 * PLAYER           : 3
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


public class Player3 extends Player {

    /* Default constructor to set Player's state and name.
     * */
    public Player3(){
        super();
        name="15";
    }

    /* Parameterized Constructor to set player's state.
     * */
    public Player3(State state){
        super(state);
        name="15";
    }

    /* Getter Method to return next move to be played
     * */
    @Override
    public Move getMove(State[][]mat,int winningStretch){
        //write logic below
		//System.out.println("Enter the order : ");
		int i,j,k,l,m,tc,c=winningStretch,x=0,y=0;
		
		
//////////////////////////////////////////////////////////////////////////////to right
		for(i=0;i<winningStretch;i++)
		{
			for(j=0;j<winningStretch;j++)
			{
				if(j+1!=winningStretch)
				{
					if(mat[i][j]==State.X && mat[i][j+1]==State.EMPTY)
					{
						tc=0;
						for(m=j+1;m<winningStretch;m++)
						{
								if(mat[i][m]==State.EMPTY)
								{
									tc++;
								}
						}
						if(tc<c)
						{
							c=tc;
							x=i;
							y=j+1;
						}
					}
				}
				
			}
		}
		
		
		//////////////////////////////////////////////////////////////////////////////to dawn
		for(i=0;i<winningStretch;i++)
		{
			for(j=0;j<winningStretch;j++)
			{
				if(i+1!=winningStretch && mat[j][i]==State.X && mat[j][i+1]==State.EMPTY)
				{
					tc=0;
					for(m=i+1;m<winningStretch;m++)
					{
							if(mat[j][m]==State.EMPTY)
							{
								tc++;
							}
					}
					if(tc<c)
					{
						c=tc;
						x=j+1;
						y=j+1;
					}
				}
			}
		}
		
		
		
		//////////////////////////////////////////////////////////////////////////////to diagonal-left
		for(j=0;j<winningStretch;j++)
		{
			if(/*i+1!=winningStretch &&*/ j+1!=winningStretch && mat[j][j]==State.X && mat[j+1][j+1]==State.EMPTY)
			{
				tc=0;
				for(m=j+1;m<winningStretch;m++)
				{
					if(mat[m][m]==State.EMPTY)
					{
						tc++;
					}
				}
				if(tc<c)
				{
					c=tc;
					x=j+1;
					y=j+1;
				}
			}
		}
		
		//////////////////////////////////////////////////////////////////////////////to diagonal-right
		for(j=winningStretch-1;j>=0;j--)
		{
			if(j!=0 && mat[j][j]==State.X && mat[j-1][j-1]==State.EMPTY)
			{
				tc=0;
				for(m=j-1;m>=0;m--)
				{
					if(mat[m][m]==State.EMPTY)
					{
						tc++;
					}
				}
				if(tc<c)
				{
					c=tc;
					x=j-1;
					y=j-1;
				}
			}
		}
		/////////////////////////////////////////////////////////////////////////////////end
		
        return new Move(getPlayerState(),x,y);
    }

    public static void main(String[]args) throws Exception{
        Player3 p=new Player3(State.O);

        //Example 3x3 matrix of states
        State[][] mat=new State[4][4];
        mat[0][0]=State.X;
        mat[0][1]=State.O;
        mat[0][2]=State.EMPTY;
		mat[0][3]=State.EMPTY;
        mat[1][0]=State.EMPTY;
        mat[1][1]=State.X;
        mat[1][2]=State.EMPTY;
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
