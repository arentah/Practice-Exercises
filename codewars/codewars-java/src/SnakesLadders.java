public class SnakesLadders {

    int[] board = new int[100];
    int player1;
    int player2;
    boolean gameOver = false;
    boolean turn = true;

    public SnakesLadders() {
        initializeBoard();
        player1 = 0;
        player2 = 0;
    }

    public static void main(String[] args) {

        SnakesLadders snakesLadders = new SnakesLadders();
        System.out.println(snakesLadders.play(1, 1));
        System.out.println(snakesLadders.play(1, 5));
        System.out.println(snakesLadders.play(6, 2));
        System.out.println(snakesLadders.play(1, 1));
    }

    public String play(int die1, int die2) {
        if (gameOver)
            return "Game over!";
        if (turn) {
            if (player1 == 100 || (player1 + die1 + die2) == 100) {
                gameOver = true;
                return "PLayer 1 Wins!";
            }
            player1 += (die1 + die2);
            if (player1 > 100)
                player1 = 100 - (player1 - 100);
            if (board[player1 - 1] != 0)
                player1 = board[player1 - 1];

            if(die1 == die2)
                turn = true;
            else
                turn = false;
            return "Player 1 is on square " + player1;

        } else {
            if (player2 == 100 || (player2 + die1 + die2) == 100) {
                gameOver = true;
                return "Player 2 Wins!";
            }
            player2 += (die1 + die2);
            if (player2 > 100)
                player2 = 100 - (player2 - 100);
            if (board[player2 - 1] != 0)
                player2 = board[player2 - 1];
            if(die1 == die2)
                turn = false;
            else
                turn = true;
            return "Player 2 is on square " + player2;
        }
    }


    public void initializeBoard() {

        board[1] = 38;
        board[6] = 14;
        board[7] = 31;
        board[14] = 26;
        board[15] = 6;
        board[27] = 84;
        board[20] = 42;
        board[35] = 44;
        board[48] = 11;
        board[45] = 25;
        board[50] = 67;
        board[61] = 19;
        board[63] = 60;
        board[70] = 91;
        board[73] = 53;
        board[77] = 98;
        board[86] = 94;
        board[91] = 88;
        board[94] = 75;
        board[98] = 80;
        board[88] = 68;
    }

}

/*Other Solutions*/
/*public class SnakesLadders {

    private int[] players = {0,0};
    private  int currentPlayer = 0;

    private static int[] dependencies = {0, 38, 0, 0, 0, 0, 14, 31, 0, 0,
                                         0, 0, 0, 0, 26, 6, 0, 0, 0, 0,
                                         42, 0, 0, 0, 0, 0, 0, 84, 0, 0,
                                         0, 0, 0, 0, 0, 44, 0, 0, 0, 0,
                                         0, 0, 0, 0, 0, 25, 0, 0, 11, 0,
                                         67, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                         0, 19, 0, 60, 0, 0, 0, 0, 0, 0,
                                         91, 0, 0, 53, 0, 0, 0, 98, 0, 0,
                                         0, 0, 0, 0, 0, 0, 94, 0, 68, 0,
                                         0, 88, 0, 0, 75, 0, 0, 0, 80, 0
                                        };


    public SnakesLadders() {}

    public String play(int die1, int die2) {
        if(players[0] == 100 || players[1] == 100) {
            return "Game over!";
        }

        int newPosition = players[currentPlayer] + die1 + die2;

        if(newPosition > 100) {
            newPosition = 100 - (newPosition - 100);
        }


        players[currentPlayer] = dependencies[newPosition-1] != 0 ? dependencies[newPosition-1] : newPosition;

        String response =  "Player ";
        if(players[currentPlayer] == 100) {
           response += currentPlayer + 1 + " Wins!";
        } else {
           response += currentPlayer + 1 + " is on square " + players[currentPlayer];
        }

        if(die1 != die2) {
          currentPlayer = currentPlayer == 1 ? 0 : 1;
        }

        return response;
    }
}*/

/*import java.util.HashMap;

public class SnakesLadders {
    private int[] positionOfPlayer = new int[] {0, 0};
    private int currentPlayer = 0; //0 for first player and 1 for second
    private boolean isGameWon = false;

    private static HashMap<Integer, Integer> teleportMap = new HashMap<>();
    static {
      teleportMap.put(2, 38);  teleportMap.put(36, 44); teleportMap.put(74, 53);
      teleportMap.put(7, 14);  teleportMap.put(46, 25); teleportMap.put(78, 98);
      teleportMap.put(8, 31);  teleportMap.put(49, 11); teleportMap.put(87, 94);
      teleportMap.put(15, 26); teleportMap.put(51, 67); teleportMap.put(89, 68);
      teleportMap.put(16, 6);  teleportMap.put(62, 19); teleportMap.put(92, 88);
      teleportMap.put(21, 42); teleportMap.put(64, 60); teleportMap.put(95, 75);
      teleportMap.put(28, 84); teleportMap.put(71, 91); teleportMap.put(99, 80);
    }

    public String play(int die1, int die2) {
      if (isGameWon) return "Game over!";
      movePlayer(currentPlayer, die1+die2);
      String result = isGameWon ? "Player "+(currentPlayer+1)+" Wins!"
                      : "Player "+(currentPlayer+1)+" is on square "+positionOfPlayer[currentPlayer];
      if (die1 != die2) currentPlayer = currentPlayer==1 ? 0 : 1;
      return result;
    }

    private void movePlayer(int index, int dice) {
      int newPosition = positionOfPlayer[index]+dice;
      if (newPosition > 100) newPosition = 200 - newPosition;
      positionOfPlayer[index] = teleportMap.getOrDefault(newPosition, newPosition);
      if (positionOfPlayer[index] == 100) isGameWon = true;
    }
}*/

/*import java.util.*;

public class SnakesLadders {
    Player playerOne = new Player(1);
    Player playerTwo = new Player(2);
    Player playersTurn = playerOne;

    private class Player{
      public Player(int playerNum){
        this.playerNum = playerNum;
      }

      int place = 0;
      int playerNum;
      boolean extraTurn = false;

      public void addMove(int  die1, int die2){
        int move = die1 + die2;

        extraTurn = die1 == die2;

        if((place + move) > 100){
          place = 100 - ((place + move) - 100);
        } else {
          place += move;
        }
        if(borad.containsKey(place))
          place = borad.get(place);
      }

      public String GetPlaceAsString(){
        if(didPlayerWin())
          return "Player " + playerNum + " Wins!";

        return "Player " + playerNum + " is on square " + place;
      }

      public boolean didPlayerWin(){
        if(place == 100){
          return true;
        }
        return false;
      }

      public boolean hasExtraTurn(){
        return extraTurn;
      }

    }

    HashMap<Integer, Integer> borad = new HashMap(){{
      put(8,31);
      put(7,14);
      put(2,38);
      put(15,26);
      put(16,6);
      put(21,42);
      put(36,44);
      put(46,25);
      put(49,11);
      put(51,67);
      put(62,19);
      put(64,60);
      put(74,53);
      put(78,98);
      put(87,94);
      put(89,68);
      put(92,88);
      put(95,75);
      put(99,80);
    }};

    public SnakesLadders() {}
    public String play(int die1, int die2) {

        if(playerOne.didPlayerWin() || playerTwo.didPlayerWin())
          return "Game over!";

        playersTurn.addMove(die1, die2);
        String text = playersTurn.GetPlaceAsString();
        if(!playersTurn.hasExtraTurn())
          if(playersTurn == playerOne)
            playersTurn = playerTwo;
          else
            playersTurn = playerOne;

        return text;
    }
}*/