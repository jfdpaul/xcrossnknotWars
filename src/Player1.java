/*          ********** CODE-CLASH **********
   DETAILS
 -------------------------------------------
 * AUTHOR           :Athul Jose
 * PARTICIPANT_PID  :70
 * PLAYER           :1
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


public class Player1 extends Player {

    /* Default constructor to set Player's state and name.
     * */
    public Player1(){
        super();
        name="70";
    }

    /* Parameterized Constructor to set player's state.
     * */
    public Player1(State state){
        super(state);
        name="70";
    }

    /* Getter Method to return next move to be played
     * */
    @Override
    public Move getMove(State[][]mat,int winningStretch){
        //write logic below
		int i=0,j=0,k=0,l=0,pos=-1,n;
		n=4;

//to find in row
	i=0;
	while(i<n)
	{
	int flag=0;
	for(j=0;j<n;j++)
	{
		if(mat[i][j]==State.X)
	{
		//System.out.println("Check X");
		flag++;
	}
	else if(mat[i][j]==State.O)
	{
		//System.out.println("Check O");
	}		
	else
	{
		if (pos==-1)
		{
			pos=j;
		}
				//System.out.println("Check Empty");

	}
	}
	if(flag==n-1&&pos!=-1)
	{
		System.out.println("pos:"+i+" " +pos);
        return new Move(State.O,i,pos);

	}
i++;	
	};
	
	//to find in coloumn
	j=0;
	while(j<n)
	{
	int flag=0;
	for(i=0;i<n;i++)
	{
		if(mat[i][j]==State.X)
	{
		//System.out.println("Check X");
		flag++;
	}
	else if(mat[i][j]==State.O)
	{
		//System.out.println("Check O");
	}		
	else
	{
		if (pos==-1)
		{
			pos=j;
		}
				//System.out.println("Check Empty");

	}
	}
	if(flag==n-1&&pos!=-1)
	{
		System.out.println("pos:"+pos+" " +j);
        return new Move(State.O,pos,j);

	}
j++;	
	}
//at diagonal
	/*
	*/
        return new Move(State.O,i,j);
    }

    public static void main(String[]args){
        Player1 p=new Player1(State.O);
int n=5;
        //Example 3x3 matrix of states
        State[][] mat=new State[n][n];
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








        System.out.println(p.getMove(mat,5));
    }
}
