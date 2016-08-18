/**
 * Created by jonty on 8/18/16.
 */
public class Player2 extends Player{

    public Player2(){
        name="P2";
    }
    public Move getMove(State[][]mat){

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(mat[i][j]==State.EMPTY){
                    return new Move(getPlayerState(),i,j);
                }
            }
        }
        return null;
    }
}