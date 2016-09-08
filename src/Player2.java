/*          ********** CODE-CLASH **********
   DETAILS
 -------------------------------------------
 * AUTHOR           : Sonu Abraham K
 * PARTICIPANT_PID  : 110
 * PLAYER           : 2
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


public class Player2 extends Player {

    /* Default constructor to set Player's state and name.
     * */
    public Player2(){
        super();
        name="110";
    }

    /* Parameterized Constructor to set player's state.
     * */
    public Player2(State state){
        super(state);
        name="110";
    }

    /* Getter Method to return next move to be played
     * */
    @Override
    public Move getMove(State[][]mat,int winningStretch){
        //write logic below
		
		int countX=0,countY=0,countZ=0,countW=0,i,j,k,n,mid,flag=0;
		State obj;
		obj = this.getPlayerState();
		
		n = mat.length;
		
		// For not losing the game. Starts here
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if((mat[i][j] != obj)&&(mat[i][j] != State.EMPTY))
				{
					countX++;
				}
				if((mat[j][i] != obj)&&(mat[j][i] != State.EMPTY))
				{
					countY++;
				}
			}
			if(countX == (winningStretch - 1))
			{
				for(j=0;j<n;j++)
				{
					if(mat[i][j] == State.EMPTY)
					{
						return new Move(obj,i,j);
					}
				}
			}
			if(countY == (winningStretch - 1))
			{
				for(j=0;j<n;j++)
				{
					if(mat[j][i] == State.EMPTY)
					{
						return new Move(obj,j,i);
					}
				}
			}
		}
		
		for(i=0,j=(n-1);i<n;i++,j--)
		{
			if((mat[i][i] != obj)&&(mat[i][i] != State.EMPTY))
			{
				countZ++;
			}
			if((mat[j][j] != obj)&&(mat[j][j] != State.EMPTY))
			{
				countW++;
			}
		}
		
		if(countZ == (winningStretch - 1))
		{
			for(i=0;i<n;i++)
			{
				if(mat[i][i] == State.EMPTY)
				{
					return new Move(obj,i,i);
				}
			}
		}
		
		if(countW == (winningStretch - 1))
		{
			for(i=(n-1);i>=0;i--)
			{
				if(mat[i][i] == State.EMPTY)
				{
					return new Move(obj,i,i);
				}
			}
		}
		
		// For not losing the game. Ends here
		
		// For winning the game. Starts here
		
		countX =0;
		countY =0;
		countZ =0;
		countW =0;
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if((mat[i][j] == obj)&&(mat[i][j] != State.EMPTY))
				{
					countX++;
				}
				if((mat[j][i] == obj)&&(mat[j][i] != State.EMPTY))
				{
					countY++;
				}
			}
			if(countX == (winningStretch - 1))
			{
				for(j=0;j<n;j++)
				{
					if(mat[i][j] == State.EMPTY)
					{
						return new Move(obj,i,j);
					}
				}
			}
			if(countY == (winningStretch - 1))
			{
				for(j=0;j<n;j++)
				{
					if(mat[j][i] == State.EMPTY)
					{
						return new Move(obj,j,i);
					}
				}
			}
		}
		
		for(i=0,j=(n-1);i<n;i++,j--)
		{
			if((mat[i][i] == obj)&&(mat[i][i] != State.EMPTY))
			{
				countZ++;
			}
			if((mat[j][j] == obj)&&(mat[j][j] != State.EMPTY))
			{
				countW++;
			}
		}
		
		if(countZ == (winningStretch - 1))
		{
			for(i=0;i<n;i++)
			{
				if(mat[i][i] == State.EMPTY)
				{
					return new Move(obj,i,i);
				}
			}
		}
		if(countW == (winningStretch - 1))
		{
			for(i=(n-1);i>=0;i--)
			{
				if(mat[i][i] == State.EMPTY)
				{
					return new Move(obj,i,i);
				}
			}
		}
		
		// For winning the game. Ends here
		
		// For other move. Starts here
		
		countX =0;
		countY =0;
		countZ =0;
		
		mid = n/2;
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(mat[i][j] != State.EMPTY)
				{
					flag =1;
				}
			}
		}
		
		if(flag == 0)
		{
			return new Move(obj,mid,mid);
		}
		
		for(i=0,j=(n-1);i<n;i++,j--)
		{
			if((mat[i][i] == obj)&&(mat[i][i] != State.EMPTY))
			{
				countZ++;
			}
			if((mat[j][j] == obj)&&(mat[j][j] != State.EMPTY))
			{
				countW++;
			}
		}
		
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if((mat[i][j] == obj)&&(mat[i][j] != State.EMPTY))
				{
					countX++;
				}
				if((mat[j][i] == obj)&&(mat[j][i] != State.EMPTY))
				{
					countY++;
				}
			}
			if((countX > countY)&&(countX > countZ)&&(countX > countW))
			{
				for(k=0;k<n;k++)
				{
					if(mat[i][k] == State.EMPTY)
					{
						return new Move(obj,i,k);
					}
				}
			}
			
			else if((countY > countX)&&(countY > countZ)&&(countY > countW))
			{
				for(k=0;k<n;k++)
				{
					if(mat[k][i] == State.EMPTY)
					{
						return new Move(obj,k,i);
					}
				}
			}
			
			else if((countZ > countX)&&(countZ > countY)&&(countZ > countW))
			{
				for(k=0;k<n;k++)
				{
					if(mat[k][k] == State.EMPTY)
					{
						return new Move(obj,k,k);
					}
				}
			}
			
			else if((countW > countX)&&(countW > countY)&&(countW > countZ))
			{
				for(k=(n-1);k>=0;k--)
				{
					if(mat[k][k] == State.EMPTY)
					{
						return new Move(obj,k,k);
					}
				}
			}
			
		}
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(mat[i][j] == State.EMPTY)
				{
					return new Move(obj,i,j);
				}
			}
		}
		
		// For other move. Ends here

        return new Move();
    }

    public static void main(String[]args){
        Player2 p=new Player2(State.O);

        //Example 3x3 matrix of states
        State[][] mat=new State[3][3];
        mat[0][0]=State.X;
        mat[0][1]=State.EMPTY;
        mat[0][2]=State.EMPTY;
        mat[1][0]=State.EMPTY;
        mat[1][1]=State.EMPTY;
        mat[1][2]=State.EMPTY;
        mat[2][0]=State.EMPTY;
        mat[2][1]=State.EMPTY;
        mat[2][2]=State.EMPTY;

        System.out.println(p.getMove(mat,3));
    }
}
