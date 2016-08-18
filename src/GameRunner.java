/**
 * Created by jonty on 7/30/16.
 */
public class GameRunner {

    private static Game game;
    private int pLength;
    private int[][] finalResult;
    private Player player[];

    public GameRunner(){

        //Initialize list of players
        player=new Player[]{new Player1(),new Player2()};

        //Iniitalize final result
        pLength=player.length;
        finalResult=new int[pLength][pLength];
    }

    //Inner class to store result set
    class ResultSet{
        int elem1,elem2;
    }

    private void startSimulation(){
        //run all possibilities of 1-on-1
        for(int i=0;i<pLength;i++){
            for(int j=i+1;j<pLength;j++){
                this.game=new Game(5,3);
                ResultSet result=startGameLoop(player[i].setState(State.X),player[j].setState(State.O));
                finalResult[i][j]=result.elem1;
                finalResult[j][i]=result.elem2;
            }
        }
    }

    /*Method to return score based on which player's turn it was and if error was present*/
    private ResultSet getScore(boolean firstPlayerTurn, boolean hasError){
        ResultSet result=new ResultSet();
        if(firstPlayerTurn&&hasError){
            result.elem1=-5;
            result.elem2=+5;
        }
        else if(!firstPlayerTurn&&hasError){
            result.elem1=+5;
            result.elem2=-5;
        }
        else if(firstPlayerTurn&&!hasError){
            result.elem1=+5;
            result.elem2=0;
        }
        else if(!firstPlayerTurn&&hasError){
            result.elem1=0;
            result.elem2=+5;
        }
        return result;

    }

    //Run game for player1 and player2 and return score of simulation
    private ResultSet startGameLoop(Player player1,Player player2){

        final int error_count[]=new int[1];


                //initialize game-running to true
                boolean gameRunning=true;
                Player player;
                while(gameRunning){

                    //set player
                    if((game.turn++)%2==0) {
                        player = player2;
                    }
                    else {
                        player = player1;
                    }

                    error_count[0]=0 ;  //to count errors due to wrong proposed moves

                    //give 3 chances to a player to make a right move
                    while(error_count[0]<3) {
                        //get present player's next move
                        Move move = player.getMove(game.getGameMatrix());

                        if(move==null){
                            error_count[0]++;
                            continue;
                        }

                        //check if present proposed move is valid
                        if (game.isValidMove(move.state, move.row, move.column)) {

                            //if move is valid, make the move.
                            game.setMove(move.state,move.row,move.column);

                            //show result of move
                            game.showMatrixOnConsole();

                            if(game.isWin(move.state,move.row,move.column)){

                                //display player won
                                System.out.println("Player "+player.name+" won");
                                gameRunning=false;
                            }
                            break;
                        }
                        else{
                            //else if move is invalid then check again from same player
                            error_count[0]++;
                        }
                    }

                    //check if error was encountered and terminate if so with message
                    if(error_count[0]==3){

                        //display message
                        System.out.println("Player : "+player.name+" made 3 wrong moves");

                        //set game state to false
                        gameRunning=false;
                    }
                }


        //checks for default as being player1's turn and for error as true
        return getScore(game.turn%2!=0,error_count[0]==3);
    }

    private void showSimulationResult(){
        for(int i=0;i<pLength;i++){
            System.out.print("\t"+player[i].name);
        }

        for(int i=0;i<pLength;i++){
            System.out.print("\n"+player[i].name+" : ");
            int sum=0;
            for(int j=0;j<pLength;j++){
                System.out.print("\t"+finalResult[i][j]);
                sum+=finalResult[i][j];
            }
            System.out.println("\t = "+sum);
        }
    }

    public static void main(String[]args){
        GameRunner runner=new GameRunner();
        runner.startSimulation();
        runner.showSimulationResult();
    }
}
