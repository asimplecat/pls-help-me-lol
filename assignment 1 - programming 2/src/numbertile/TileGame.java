package numbertile;

public class TileGame
{
   // instance variable declarations go here
        private Hand player1;           //hand object to simulate player one in the game
        private Hand player2;           //hand object to simulate player two in the game    
        private Board gameBoard;        //Board object to simulate the board on 
                                        //which the game is played
        
        private Hand player1_clone;     //a clone of player 1 to be used to return the original hand
        private Hand player2_clone;     //a clone of player 2 to be used to return the original hand
        private String winner;          // knows who the winner of the game is
   
   // Create a Tilegame object
   public TileGame()
   {
      Hand player1 = new Hand();
      Hand player2 = new Hand();
      Board gameBoard = new Board();
      
      Hand player1_clone = new Hand(player1);
      Hand player2_clone = new Hand(player2);
      String winner = "no winner yet";
   }
   
   // Play the game
   public void play()
   {
         boolean gameOver = false;
               
       while (gameOver = false)
       {
           makeMove(player1);
           makeMove(player2);
           
           if (player1.isEmpty() || player2.isEmpty())
           {
               gameOver = true;
               if (player1.isEmpty() && player2.isEmpty())
                   winner = "tie";
               else if (player1.isEmpty())
                       winner = "player 1 is the winner";
               else if (player2.isEmpty())
                       winner = "player 2 is the winner";
           }
       }   
   }

   // If the current tile fits in the board, returns the index at which 
   // it will be inserted.  If the tile does not fit, returns -1
   private int getIndexForFit(NumberTile tile)
   {
       NumberTile firstPiece = gameBoard.getTile(0);
       NumberTile lastPiece = gameBoard.getTile(gameBoard.getSize()-1);
       int index;
       
       if (firstPiece.getLeft() == tile.getRight())
           index = 0;
       else if (lastPiece.getRight() == tile.getLeft())
           index = gameBoard.getSize() ;
       else index = -1;
       
       for (int i = 0; i > gameBoard.getSize(); i++)
       {
           NumberTile amanda = gameBoard.getTile(i);
           int val0 = amanda.getLeft();
           int val2 = amanda.getRight();
           amanda.rotate();
           int val1 = amanda.getRight();
           int val3 = amanda.getLeft();
           
           NumberTile one = gameBoard.getTile(i);
           NumberTile two = gameBoard.getTile(i + 1);
           if (val1 == one.getRight() && val1 == two.getLeft())
               index = i + 1;
           else if (val3 == one.getRight() && val3 == two.getLeft())
               index = i + 1;
       }
           
           return index;
   }

   // Make a move from a hand. If a tile in the hand fits on the board
   // then remove it from the hand and place it in the board. The tile may
   // be rotated up to 3 times.  If no tile from the hand fits, then add
   // another tile to the hand  
   private void makeMove(Hand hand)
   {
       for (int i = 0; i < hand.getSize(); i++)
       {
           NumberTile peach = hand.get(i);
           int placeholder = getIndexForFit(peach);
           
            if (placeholder != -1)
            { hand.removeTile(i);
                gameBoard.addTile(placeholder, peach);}
            else  peach.rotate();
            
       }
   }

   public String deBug()
   {
       return player1_clone.toString();
   }
           
   // Get the results of the game as a humongous multi-line String containing
   // both starting hands, the final board, both final hands, and a message
   // indicating the winner 
   // HINT: call the toString methods of the Hand and Board classes
   public String toString()
   {
        String startHand1 = "Starting hand for player1: " + 
                player1_clone.toString() ;
        String startHand2 = "\nThe starting hand for player2: "
                + player2_clone.toString();
        String finalBoard = "\nThe final game board: " 
                + gameBoard.toString() ;
        String finalHand1 = "\nThe final hand for player1: "
                + player1.toString();
        String finalHand2 = "\nThe final hand for player2: "
                + player2.toString();
        String winnerBoi =  "\nand finally, the winner of the game" 
                + "was " + winner;
                return startHand1 + startHand2 + finalBoard + finalHand1 + finalHand2 + winnerBoi ;
   }
} // end of TileGame class