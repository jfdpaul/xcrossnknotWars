import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jonty on 7/30/16.
 */
public class GameRunner {

    int sumTotal[];
    private static Game game;
    private int pLength;
    private int[][][] finalResult;
    private Player player[];
    boolean isInteractive;

    public GameRunner(){

        //Initialize list of players

//        player=new Player[]{new Player1(),new Player2(),new Player3(),new Player4(),new Player5(),new Player6(),new Player7()};
        player=new Player[]{new Player2(),new Player7()};
        //Initialize final result
        pLength=player.length;
        finalResult=new int[pLength][pLength][pLength];
        isInteractive=false;
        sumTotal=new int[pLength];
    }

    //Inner class to store result set
    class ResultSet{
        int elem1,elem2;
        public void show(){
            System.out.println("\nResult 1 : "+elem1);
            System.out.println("Result 2 : "+elem2);
        }
    }

    private void startSimulation(int n) {

        //run all possibilities of 1-on-1 for 10 iterations
        for (int k = 0; k < n; k++) {
            System.out.println("Iteration " + (k + 1));
            for (int i = 0; i < pLength; i++) {
                for (int j = 0; j < pLength; j++) {
                    if (i != j) {
                        this.game = new Game(3, 3);
                        System.out.println("Player " + player[i].name + " v/s Player " + player[j].name);
                        ResultSet result = startGameLoop(player[i].setState(State.X), player[j].setState(State.O));
                        //result.show();
                        finalResult[i][j][i] += result.elem1;
                        finalResult[j][i][i] += result.elem2;
                    }
                }
            }
        }
    }

    private void startISimulation() {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        isInteractive=true;
        //run all possibilities of 1-on-1 for 10 iterations
        for (int i = 0; i < pLength; i++) {
            for (int j = 0; j < pLength; j++) {
                if (i != j) {
                    this.game = new Game(7, 5);
                    System.out.println("----------- Player " + player[i].name + " v/s Player " + player[j].name+" -----------\n");
                    if(isInteractive){
                        System.out.println("Let's start <Enter>");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    ResultSet result = startGameLoop(player[i].setState(State.X), player[j].setState(State.O));
                    finalResult[i][j][i] += result.elem1;
                    finalResult[j][i][i] += result.elem2;
                    try {
                        if(isInteractive){
                            System.out.println("\nPress <Enter> to continue...");
                            System.in.read();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /*Method to return score based on which player's turn it was and if error was present*/
    private ResultSet getScore(boolean firstPlayerTurn, boolean hasError){
        ResultSet result=new ResultSet();
        if(firstPlayerTurn&&hasError){
            result.elem1=-1;
            result.elem2=1;
        }
        else if(!firstPlayerTurn&&hasError){
            result.elem1=1;
            result.elem2=-1;
        }
        else if(firstPlayerTurn&&!hasError){
            result.elem1=1;
            result.elem2=0;
        }
        else if(!firstPlayerTurn&&!hasError){
            result.elem1=0;
            result.elem2=1;
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
                if((game.turn++)%2!=0) {
                    player = player2;
                }
                else {
                    player = player1;
                }
                System.out.println("Player "+player.name+"'s turn");
                if(isInteractive){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                error_count[0]=0 ;  //to count errors due to wrong proposed moves

                //give 3 chances to a player to make a right move
                while(error_count[0]<3) {

                    //get present player's next move
                    try {
                        System.out.print("\t\t\t\t< Player "+player.name+" is thinking... >");

                        Move move = player.getMove(game.getGameMatrix(),game.getWinningStretch());
                        System.out.println(move);
                        System.out.print("\r");

                        if(move==null||move.state!=player.getPlayerState()){
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
                                System.out.println("Player "+player.name+" won\n-------------------------------\n");
                                gameRunning=false;
                            }
                            break;
                        }
                        else{
                            //else if move is invalid then check again from same player
                            error_count[0]++;
                        }
                    }
                    catch(Exception e){
                        error_count[0]++;
                    }
                }

                    //check if error was encountered and terminate if so with message
                    if(error_count[0]==3){

                        //display message
                        System.out.println("\nXXXXXXXXXXXXXXXXX\nPlayer : "+player.name+" made 3 wrong moves\n" +
                                "XXXXXXXXXXXXXXXXX\n");

                        //set game state to false
                        gameRunning=false;
                    }
                }

        //checks for default as being player1's turn and for error as true
        return getScore(game.turn%2!=0,error_count[0]==3);
    }

    private void showSimulationResult(){
        System.out.print("\nSimulation Result\n\t");
        for(int i=0;i<pLength;i++){
            sumTotal[i]=0;
            System.out.print("\t"+player[i].name);
        }

        for(int k=0;k<pLength;k++) {
            for (int i = 0; i < pLength; i++) {
                System.out.print("\n" + player[i].name + " : ");
                int sum=0;
                for (int j = 0; j < pLength; j++) {
                    System.out.print("\t" + finalResult[i][j][k]);
                    sum+=finalResult[i][j][k];
                }
                sumTotal[i] += sum;
                System.out.println("\t = " + sum);
            }
            System.out.println("********************");
        }
    }

    private void showTotal(){
        int sum;
        for(int k=0; k<pLength; k++) {
            System.out.println(sumTotal[k]);
        }
    }
    public static void main(String[]args){

        GameRunner runner=new GameRunner();
//        runner.startSimulation(1);
        runner.startISimulation();
        runner.showSimulationResult();
        runner.showTotal();
/*
        System.out.println("\t******************** CODE CLASH ********************");
        System.out.println("\t\t\t\t\t\t\t|X|O|X|");
        System.out.println("\t\t\t\t\t\t\t| |O| |");
        System.out.println("\t\t\t\t\t\t\t|X| | |");
        */
    }
}
