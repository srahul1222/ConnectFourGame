/**
 * 
 */
package SIMR;

import java.util.Scanner;

/** This is a connect four game
 * @author Rahul Swaminathan
 * due on 7/26/15
 */
public class ConnectFourGame {

 /**
  * @param args
  */
 public static void main(String[] args) {
  String [][] gameBoard = new String[6][7];
  Scanner console = new Scanner (System.in);  
  mainMenu(console,gameBoard);
  console.close();
 }

 /*
  * mainMenu(); displays a main menu with 5 options that the players can choose from
  * @param: Scanner console- used so that players can type in the option they picked
  * String[][] g- used so I can call the gameBoard array and use it in other methods
  * @return: void
  * The main menu has 5 choices. Depending on what choice they pick, 
  * a certain method will be called to execute their command
  */
 public static void mainMenu(Scanner console, String[][] g){
  System.out.println("-------------------------------------------------------------");
  System.out.println("MAIN MENU: Choose the number of the option you wish to select");
  System.out.println("*************************************************************");
  System.out.println("1. 2 player game");
  System.out.println("-------------------------------------------------------------");
  System.out.println("2. 1 player game vs dumb computer");
  System.out.println("-------------------------------------------------------------");
  System.out.println("3. 1 player game vs smart computer");
  System.out.println("-------------------------------------------------------------");
  System.out.println("4. Simulated game with computer playing itself");
  System.out.println("-------------------------------------------------------------");
  System.out.println("5. Quit");
  System.out.println("-------------------------------------------------------------");
  System.out.println("6. Credits");
  System.out.println("*************************************************************");
  int a = 0;
  try { 
   String option =console.nextLine();
   a = Integer.parseInt(option);
  } catch(NumberFormatException e) { 
   System.out.println("This option is not available right now");
   System.out.println();
   System.out.println();
   mainMenu(console,g);
  } catch(NullPointerException e) {
   System.out.println("This option is not available right now");
   System.out.println();
   System.out.println();
   mainMenu(console,g);
  } catch(ArrayIndexOutOfBoundsException e) {
   System.out.println("This option is not available right now");
   System.out.println();
   System.out.println();
   mainMenu(console,g);
  }
  if(a>6){
   System.out.println("This option is not available right now");
   System.out.println();
   System.out.println();
   mainMenu(console,g);
  }
  if(a==1){
   originalGameBoard(g);
   twoPlayerGame(console, g);
  }
  if(a==2){
   originalGameBoard(g);
   humanVSDumbComputer(console, g);
  }
  if(a==3){
   originalGameBoard(g);
   humanVSSmartComputer(console, g,a);
  }
  if(a==4){
   originalGameBoard(g);
   SmartComputerVSDumbComputer(console, g, a);
  }
  if(a==5){
   System.out.print("Are you sure you want to quit? D: (Y/N) ");
   String b = console.next();
   if(b.equalsIgnoreCase("yes")||(b.equalsIgnoreCase("y"))){
    console.close();
    System.out.println("Good bye. Thanks for playing.");
    System.exit(0);
   }
   if(b.equalsIgnoreCase("no")||(b.equalsIgnoreCase("n"))){
    console.nextLine();
    System.out.println();
    mainMenu(console,g);
   }
  }
  if(a==6){
   console.close();
   credits();
  }
 }

 /*
  * twoPlayerGame();- This method is option 1 in the main menu.
  * It will let players play against each other
  * @param: Scanner console- used so that I can call other methods with the scanner;
  * String[][] g- used so I can call the gameBoard array in other methods
  * @return: void
  * This method calls the other methods and alternates between red's turn and black's turn.
  * After each turn, int d is incremented. The game will continue until someone wins or draws.
  */
 public static void twoPlayerGame(Scanner console,String[][] g){
  System.out.println();
  System.out.println();
  System.out.println("Player 1 will be Red(\"R\").");
  System.out.println("PLayer 2 will be Black(\"B\").");
  System.out.println("Good Luck!");
  System.out.println("Have Fun!");
  System.out.println("and DON'T CHEAT!!!!!");
  int d=0;
  boolean flag=false;
  while(flag==false){
   if(d%2==0){
    redTurn(console,g);
    d++;
   } else{
    blackTurn(console,g);
    d++;
   }
  }
 }

 /*
  * humanVSDumbComputer();- This method is option 2 in the main menu.
  * It will let a player play against a dumb computer.
  * @param: Scanner console- used so that I can call other methods with the scanner;
  * String[][] g- used so I can call the gameBoard array in other methods
  * @return: void
  * This method calls the other methods and alternates between red's turn(human) and black's turn(dumb computer).
  * After each turn, int d is incremented. The game will continue until someone wins or draws,
  */
 public static void humanVSDumbComputer(Scanner console,String[][] g){
  System.out.println();
  System.out.println();
  System.out.println("You will be playing against the Dumb Computer!!!");
  System.out.println("BE WARNED: This will be the easiest game of your life!!!");
  System.out.println();
  System.out.println();
  System.out.println("Player 1 will be Red(\"R\").");
  System.out.println("The Dumb Computer will be Black(\"B\").");
  System.out.println("Good Luck!");
  System.out.println("Have Fun!");
  System.out.println("and DON'T CHEAT!!!!!");
  int d=0;
  boolean flag=false;
  while(flag==false){
   if(d%2==0){
    redTurn(console,g);
    d++;
   } else{
    dumbComputerForBlack(console,g);
    d++;
   }
  }
 }

 /*
  * originalGameBoard();- creates an empty game board that can be referred to later.
  * @param: String[][] g- used to call the gameBoard and set its initial values
  * @return: void
  * Prints out an empty game board
  */
 public static void originalGameBoard(String[][] g){
  for(int i=0;i<g.length;i++){
   for(int j=0;j<g[i].length;j++){
    g[i][j]="o";
    System.out.print(g[i][j]+" ");
   }
   System.out.println();
  } 
 }

 /*
  * gameBoard();- creates a gameBoard that is changed after each turn
  * @param: String[][] g- used to call the gameBoard and update its values after each turn
  * @return: void
  * This is called after each turn in order to save the changes made to the board
  */
 public static void gameBoard(String[][] g){
  for(int i=0;i<g.length;i++){
   for(int j=0;j<g[i].length;j++){
    System.out.print(g[i][j]+" ");
   }
   System.out.println();
  }
 }

 /*
  * redTurn();- This method is used for each turn in order to make a move.
  * @param: Scanner console- used to get input from the console on what move to make
  * String[][] g- used to make the move on the board and call other methods with the array
  * @return: void
  * This method splits the inputed string and then uses parseInt to check if it is an integer
  * If it is, it will play the move in the form row,column
  * It then calls other methods to check whether the game is over or not.
  */
 public static void redTurn(Scanner console, String[][] g){
  System.out.println("It is Red's turn to make a move.");
  System.out.println("Make your move in the form \"row,column\"");
  int row;
  int column;
  try { 
   String x =console.nextLine();
   String move[] = x.split(",");
   row = Integer.parseInt(move[0]);
   column = Integer.parseInt(move[1]);
  } catch(NumberFormatException e) { 
   System.out.println("Invalid move! Loss of turn.");
   return;
  } catch(NullPointerException e) {
   System.out.println("Invalid move! Loss of turn.");
   return;
  } catch(ArrayIndexOutOfBoundsException e) {
   System.out.println("Invalid move! Loss of turn.");
   return;
  }
  if(column>6 || row>5){
   System.out.println("Invalid move! Loss of turn.");
   return;
  }
  if (!g[row][column].equals("o")){
   System.out.println("Invalid move! Loss of turn.");
   return;
  }
  if (g[row][column].equals("o")){
   for (int rowchecker = 5; rowchecker >= 0;rowchecker--) {
    if (g[rowchecker][column].equals("o") && rowchecker==row){
     g[rowchecker][column] = "R";
     gameBoard(g);
     System.out.println();
     fourInAColumnForRed(console,g,rowchecker,column);
     fourInARowForRed(console,g,rowchecker);
     fourInABottomTopDiagonalForRed(console,g,rowchecker,column);
     fourInATopBottomDiagonalForRed(console,g,rowchecker,column);
     draw(console, g);
     return;
    } else if(!g[rowchecker][column].equals("o")){
     //do nothing
    } else{
     System.out.println("Invalid move! Loss of turn.");
     return;
    }
   }
  }
 }

 /*
  * blackTurn();- This method is used for each turn in order to make a move.
  * @param: Scanner console- used to get input from the console on what move to make
  * String[][] g- used to make the move on the board and call other methods with the array
  * @return: void
  * This method splits the inputed string and then uses parseInt to check if it is an integer
  * If it is, it will play the move in the form row,column
  * It then calls other methods to check whether the game is over or not.
  */
 public static void blackTurn(Scanner console, String[][] g){
  System.out.println("It is Black's turn to make a move.");
  System.out.println("Make your move in the form \"row,column\"");
  int row;
  int column;
  try { 
   String x =console.nextLine();
   String move[] = x.split(",");
   row = Integer.parseInt(move[0]);
   column = Integer.parseInt(move[1]);
  } catch(NumberFormatException e) { 
   System.out.println("Invalid move! Loss of turn.");
   return;
  } catch(NullPointerException e) {
   System.out.println("Invalid move! Loss of turn.");
   return;
  } catch(ArrayIndexOutOfBoundsException e) {
   System.out.println("Invalid move! Loss of turn.");
   return;
  }
  if(column>6 || row>5){
   System.out.println("Invalid move! Loss of turn.");
   return;
  }
  if (!g[row][column].equals("o")){
   System.out.println("Invalid move! Loss of turn.");
   return;
  }
  if (g[row][column].equals("o")){
   for (int rowchecker = 5; rowchecker >= 0;rowchecker--) {
    if (g[rowchecker][column].equals("o") && rowchecker==row){
     g[rowchecker][column] = "B";
     gameBoard(g);
     System.out.println();
     fourInAColumnForBlack(console,g,rowchecker,column);
     fourInARowForBlack(console,g,rowchecker);
     fourInABottomTopDiagonalForBlack(console,g,rowchecker,column);
     fourInATopBottomDiagonalForBlack(console,g,rowchecker,column);
     draw(console, g);
     return;
    } else if(!g[rowchecker][column].equals("o")){
     //do nothing
    } else{
     System.out.println("Invalid move! Loss of turn.");
     return;
    }
   }
  }
 }

 /*
  * fourInARowForRed();- This method checks to see if Red got 4 in a row
  * @param: Scanner console- used to call the main menu with scanner if the game is over
  * String[][] g- used to traverse the array to check if Red got four in a row
  * int row-  used to get the piece's current location and check against previous ones
  * @return: void
  * The method traverses the columns of the given row and increments "count" each time the current spot
  * is equal to the left spot. If "count becomes 4 or greater, the game has been won.
  */
 public static void fourInARowForRed(Scanner console, String[][] g, int row) {
  int count = 0;
  for (int column = 0; column < 7; column++) {
   if(column==0 && g[row][column].equals("R")){
    count++;
   } else if (g[row][column].equals("R") && g[row][column].equals(g[row][column-1])){
    count++;
   } else if (g[row][column].equals("R") && !g[row][column].equals(g[row][column-1])){
    count=1;
   } else{
    count=0;
   }
   if (count >= 4) {
    System.out.println("Red Wins!!! Good Game!");
    System.out.println();
    mainMenu(console,g);
   }
  }
 }

 /*
  * fourInARowForBlack();- This method checks to see if Black got 4 in a row
  * @param: Scanner console- used to call the main menu with scanner if the game is over
  * String[][] g- used to traverse the array to check if Black got four in a row
  * int row-  used to get the piece's current location and check against previous ones
  * @return: void
  * The method traverses the columns of the given row and increments "count" each time the current spot
  * is equal to the left spot. If "count becomes 4 or greater, the game has been won.
  */
 public static void fourInARowForBlack(Scanner console, String[][] g, int row) {
  int count = 0;
  for (int column = 0; column < 7; column++) {
   if(column==0 && g[row][column].equals("B")){
    count++;
   } else if (g[row][column].equals("B") && g[row][column].equals(g[row][column-1])){
    count++;
   } else if (g[row][column].equals("B") && !g[row][column].equals(g[row][column-1])){
    count=1;
   } else{
    count=0;
   }
   if (count >= 4) {
    System.out.println("Black Wins!!! Good Game!");
    System.out.println();
    mainMenu(console,g);
   }
  }
 }

 /*
  * fourInAColumnForRed();- This method checks to see if Red got 4 in a column
  * @param: Scanner console- used to call the main menu with scanner if the game is over
  * String[][] g- used to traverse the array to check if Red got four in a column
  * int row-  used to get the piece's current location and check against previous ones
  * int column- used to get the piece's current location and check against previous ones
  * @return: void
  * The method takes the given point and increments "count" each time the current spot
  * is equal to the spot above. If "count becomes 4 or greater, the game has been won.
  */
 public static void fourInAColumnForRed(Scanner console, String[][] g, int row, int column) {
  int count = 1;
  if(row<3){
   for (int i = 1; i <= 3; i++) {
    if (g[row][column].equals(g[row+i][column])){
     count++;
    }
    if (count >= 4) {
     System.out.println("Red Wins!!! Good Game!");
     System.out.println();
     mainMenu(console,g);
    }
   }
  }
 }

 /*
  * fourInAColumnForBlack();- This method checks to see if Black got 4 in a column
  * @param: Scanner console- used to call the main menu with scanner if the game is over
  * String[][] g- used to traverse the array to check if Black got four in a column
  * int row-  used to get the piece's current location and check against previous ones
  * int column- used to get the piece's current location and check against previous ones
  * @return: void
  * The method takes the given point and increments "count" each time the current spot
  * is equal to the spot above. If "count becomes 4 or greater, the game has been won.
  */
 public static void fourInAColumnForBlack(Scanner console, String[][] g, int row, int column) {
  int count = 1;
  if(row<3){
   for (int i = 1; i <= 3; i++) {
    if (g[row][column].equals(g[row+i][column])){
     count++;
    }
    if (count >= 4) {
     System.out.println("Black Wins!!! Good Game!");
     System.out.println();
     mainMenu(console,g);
    }
   }
  }
 }

 /* 
  * fourInABottomTopDiagonalForRed- checks to see if black has four in a certain diagonal
  * @param: Scanner console- used so that other methods can call the main menu with the scanner
  * String[][] g- used to make the move on the board and call other methods with the array
  * int row and int column- used so that the method can check around the given point
  * @return: void
  * This method takes a given point, and finds its minimum and maximum values in the diagonal
  * It then uses a while loop to check if the point is equal to points diagonal to it
  * Afterwards, it increments the minimum values and does the loop again
  * until the min==max
  */
 public static void fourInABottomTopDiagonalForRed(Scanner console, String[][] g, int row, int column) {
  int count=1;
  int maxX;
  int maxY;
  int minX;
  int minY;
  if(row+column<6){
   maxX=0;
   maxY=row+column;
   minX=row+column;
   minY=0;
  } else{
   maxX=(row+column)-6;
   maxY=6;
   minX=5;
   minY=(row+column)-5;
  }
  while(minX>maxX && minY<maxY){
   if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY+1])){
    count++;
   }
   minX--;
   minY++;
  }
  if(count>=4){
   System.out.println("Red Wins!!! Good Game!");
   System.out.println();
   mainMenu(console,g);
  }
 }

 /* 
  * fourInABottomTopDiagonalForBlack- checks to see if black has four in a certain diagonal
  * @param: Scanner console- used so that other methods can call the main menu with the scanner
  * String[][] g- used to make the move on the board and call other methods with the array
  * int row and int column- used so that the method can check around the given point
  * @return: void
  * This method takes a given point, and finds its minimum and maximum values in the diagonal
  * It then uses a while loop to check if the point is equal to points diagonal to it
  * Afterwards, it increments the minimum values and does the loop again
  * until the min==max
  */
 public static void fourInABottomTopDiagonalForBlack(Scanner console, String[][] g, int row, int column) {
  int count=1;
  int maxX;
  int maxY;
  int minX;
  int minY;
  if(row+column<6){
   maxX=0;
   maxY=row+column;
   minX=row+column;
   minY=0;
  } else{
   maxX=(row+column)-6;
   maxY=6;
   minX=5;
   minY=(row+column)-5;
  }
  while(minX>maxX && minY<maxY){
   if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY+1])){
    count++;
   }
   minX--;
   minY++;
  }
  if(count>=4){
   System.out.println("Black Wins!!! Good Game!");
   System.out.println();
   mainMenu(console,g);
  }
 }

 /*
  * draw()- This method traverses the gameBoard array
  * and tells me whether there is any space left on the board
  * @param: Scanner console- used so that I can call the main method with the scanner;
  * String[][] g- used so I can call the gameBoard array and traverse it
  * @return: void
  * While traversing the array, if any empty spots are found, "count" is incremented by 1.
  * If no spots are found empty, count will remain 0, 
  * and the game will be a draw.
  */
 public static void draw(Scanner console,String[][] g){
  int count = 0;
  for (int row = 0; row < g.length; ++row){
   for (int column = 0; column < g[row].length; ++column){
    if (g[row][column].equals("o")){
     count++;
    }
   }
  }
  if(count==0){
   System.out.println("It's a DRAW! The board has been completely filled up and no one has won.");
   mainMenu(console,g);
  }
 }

 /*
  * dumbComputerForBlack();- This method is used for the dumb computer in order to make a move.
  * @param: Scanner console- used so that other methods can call the main menu with the scanner
  * String[][] g- used to make the move on the board and call other methods with the array
  * @return: void
  * This method places the piece in random spots using Math.random.
  * The dumb computer can never make an illegal move.
  * It then calls other methods to check whether the game is over or not.
  */
 public static void dumbComputerForBlack(Scanner console, String[][] g){
  System.out.println("The Dumb Computer is attempting to think (but is actually failing horribly)...");
  System.out.println();
  System.out.println();
  int row=0;
  int column=(int)(Math.random()*7);
  if (g[0][column].equals("o")){
   for (row=5; row >= 0;row--) {
    if (g[row][column].equals("o")){
     g[row][column] = "B";
     gameBoard(g);
     System.out.println();
     break;
    } 
   }
  }
  fourInAColumnForBlack(console,g,row,column);
  fourInARowForBlack(console,g,row);
  fourInABottomTopDiagonalForBlack(console,g,row,column);
  fourInATopBottomDiagonalForBlack(console,g,row,column);
  draw(console, g);
 }

 /* 
  * fourInATopBottomDiagonalForRed- checks to see if black has four in a certain diagonal
  * @param: Scanner console- used so that other methods can call the main menu with the scanner
  * String[][] g- used to make the move on the board and call other methods with the array
  * int row and int column- used so that the method can check around the given point
  * @return: void
  * This method takes a given point, and finds its minimum and maximum values in the diagonal
  * It then uses a while loop to check if the point is equal to points diagonal to it
  * Afterwards, it increments the minimum values and does the loop again
  * until the min==max
  */
 public static void fourInATopBottomDiagonalForRed(Scanner console, String[][] g, int row, int column) {
  int count=1;
  int maxX;
  int maxY;
  int minX;
  int minY;
  if(row-column>0){
   maxX=row-column;
   maxY=0;
   minX=5;
   minY=(column-row)+5;
  } else if(row-column<0){
   maxX=0;
   maxY=column-row;
   minX=(row-column)+6;
   minY=6;
  } else{
   maxX=0;
   maxY=0;
   minX=5;
   minY=5;
  }
  while(minX>maxX && minY>maxY){
   if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY-1])){
    count++;
   }
   minX--;
   minY--;
  }
  if(count>=4){
   System.out.println("Red Wins!!! Good Game!");
   System.out.println();
   mainMenu(console,g);
  }
 }

 /* 
  * fourInATopBottomDiagonalForBlack- checks to see if black has four in a certain diagonal
  * @param: Scanner console- used so that other methods can call the main menu with the scanner
  * String[][] g- used to make the move on the board and call other methods with the array
  * int row and int column- used so that the method can check around the given point
  * @return: void
  * This method takes a given point, and finds its minimum and maximum values in the diagonal
  * It then uses a while loop to check if the point is equal to points diagonal to it
  * Afterwards, it increments the minimum values and does the loop again
  * until the min==max
  */
 public static void fourInATopBottomDiagonalForBlack(Scanner console, String[][] g, int row, int column) {
  int count=1;
  int maxX;
  int maxY;
  int minX;
  int minY;
  if(row-column>0){
   maxX=row-column;
   maxY=0;
   minX=5;
   minY=(column-row)+5;
  } else if(row-column<0){
   maxX=0;
   maxY=column-row;
   minX=(row-column)+6;
   minY=6;
  } else{
   maxX=0;
   maxY=0;
   minX=5;
   minY=5;
  }
  while(minX>maxX && minY>maxY){
   if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY-1])){
    count++;
   }
   minX--;
   minY--;
  }
  if(count>=4){
   System.out.println("Black Wins!!! Good Game!");
   System.out.println();
   mainMenu(console,g);
  }
 }

 /*
  * smartComputer();- This method is used for the smart computer in order to make a move.
  * @param: Scanner console- used so that other methods can call the main menu with the scanner
  * String[][] g- used to make the move on the board and call other methods with the array
  * int a- used so that the smart computer can choose to play a human or the dumb computer
  * based on what a's value is in the mainMenu();
  * @return: void
  * This method places the piece in random spots using Math.random if there is no other best move.
  * It will also try to block you if you have 2 or 3 in a row, column, or diagonal.
  * If it has 2 or 3 in a row, column, or diagonal, it will try to win
  * The smart computer can never make an illegal move.
  * It then calls other methods to check whether the game is over or not.
  */
 public static void smartComputer(Scanner console, String[][] g, int a){
  System.out.println("The Smart Computer is thinking hard...");
  System.out.println();
  System.out.println();


  //Black three in a bottom top diagonal
  int givenrow=5;
  for(int givencolumn=0;givencolumn<=3;givencolumn++){
   int count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow+givencolumn<6){
    maxX=0;
    maxY=givenrow+givencolumn;
    minX=givenrow+givencolumn;
    minY=0;
   } else{
    maxX=(givenrow+givencolumn)-6;
    maxY=6;
    minX=5;
    minY=(givenrow+givencolumn)-5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY<maxY){
    if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY+1])){
     count++;
     if(count==3){
      performSecondDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY, a);
     }
    }
    minX--;
    minY++;
   }
  }

  //Black three in a bottom top diagonal for the other side
  int givencolumn = 0;
  for(givenrow = 4;givenrow>=3;givenrow--){
   int count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow+givencolumn<6){
    maxX=0;
    maxY=givenrow+givencolumn;
    minX=givenrow+givencolumn;
    minY=0;
   } else{
    maxX=(givenrow+givencolumn)-6;
    maxY=6;
    minX=5;
    minY=(givenrow+givencolumn)-5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY<maxY){
    if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY+1])){
     count++;
     if(count==3){
      performSecondDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY++;
   }
  }


  //Black three in a top bottom diagonal
  givenrow=5;
  for(givencolumn=3;givencolumn<=6;givencolumn++){
   int count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow-givencolumn>0){
    maxX=givenrow-givencolumn;
    maxY=0;
    minX=5;
    minY=(givencolumn-givenrow)+5;
   } else if(givenrow-givencolumn<0){
    maxX=0;
    maxY=givencolumn-givenrow;
    minX=(givenrow-givencolumn)+6;
    minY=6;
   } else{
    maxX=0;
    maxY=0;
    minX=5;
    minY=5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY>maxY){
    if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY-1])){
     count++;
     if(count==3){
      performFirstDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY--;
   }
  }

  //Black three in a top bottom diagonal for the other side
  givencolumn=6;
  for(givenrow=4;givenrow>=3;givenrow--){
   int count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow-givencolumn>0){
    maxX=givenrow-givencolumn;
    maxY=0;
    minX=5;
    minY=(givencolumn-givenrow)+5;
   } else if(givenrow-givencolumn<0){
    maxX=0;
    maxY=givencolumn-givenrow;
    minX=(givenrow-givencolumn)+6;
    minY=6;
   } else{
    maxX=0;
    maxY=0;
    minX=5;
    minY=5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY>maxY){
    if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY-1])){
     count++;
     if(count==3){
      performFirstDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY--;
   }
  }


  //Black three in a row
  int count = 0;
  for (int row = 0; row <6; row++) {
   count = 0;
   for (int column = 0; column < 7; column++) {
    if(column==0 && g[row][column].equals("B")){
     count++;
    } else if (g[row][column].equals("B") && g[row][column].equals(g[row][column-1])){
     count++;
    } else if (g[row][column].equals("B") && !g[row][column].equals(g[row][column-1])){
     count=1;
    } else{
     count=0;
    }
    if(count==3){
     if (row==5){
      if (column==6){
       if(g[row][column-3].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column-3,a);
       }
      } else if (column<3){
       if(g[row][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       }
      }else{
       if(g[row][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       } else if(g[row][column-3].equals("o")) {
        performBlackChecksAndRedPlay(console, g, row, column-3,a);
       }
      }
     } else {
      if(column<3){
       if(g[row][column+1].equals("o") && !g[row+1][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       }
      } else if(column==6){
       if(g[row][column-3].equals("o") && !g[row+1][column-3].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column-3,a);
       }
      }else{
       if(g[row][column+1].equals("o") && !g[row+1][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       } else if(g[row][column-3].equals("o") && !g[row+1][column-3].equals("o")) {
        performBlackChecksAndRedPlay(console, g, row, column-3,a);
       }
      }
     }
     break;
    }
   }
  }

  //Black three in a column
  count = 0;
  for (int column = 0; column < 7; column++) {
   count = 0;
   for (int row = 0; row < 6; row++) {
    if(row==0 && g[row][column].equals("B")){
     count++;
    } else if (g[row][column].equals("B") && g[row][column].equals(g[row-1][column])){
     count++;
    } else if (g[row][column].equals("B") && !g[row][column].equals(g[row-1][column])){
     count=1;
    } else{
     count=0;
    }
    if(count==3 && row>2){
     if(g[row-3][column].equals("o")){
      performBlackChecksAndRedPlay(console, g, row-3, column,a);
     }
    }
   }
  }


  //Red three in a bottom top diagonal
  givenrow=5;
  for(givencolumn=0;givencolumn<=3;givencolumn++){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow+givencolumn<6){
    maxX=0;
    maxY=givenrow+givencolumn;
    minX=givenrow+givencolumn;
    minY=0;
   } else{
    maxX=(givenrow+givencolumn)-6;
    maxY=6;
    minX=5;
    minY=(givenrow+givencolumn)-5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY<maxY){
    if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY+1])){
     count++;
     if(count==3){
      performSecondDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY++;
   }
  }

  //Red three in a bottom top diagonal for the other side
  givencolumn = 0;
  for(givenrow = 4;givenrow>=3;givenrow--){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow+givencolumn<6){
    maxX=0;
    maxY=givenrow+givencolumn;
    minX=givenrow+givencolumn;
    minY=0;
   } else{
    maxX=(givenrow+givencolumn)-6;
    maxY=6;
    minX=5;
    minY=(givenrow+givencolumn)-5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY<maxY){
    if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY+1])){
     count++;
     if(count==3){
      performSecondDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY++;
   }
  }


  // Red three in a column
  count = 0;
  for (int column = 0; column < 7; column++) {
   count = 0;
   for (int row = 0; row < 6; row++) {
    if(row==0 && g[row][column].equals("R")){
     count++;
    } else if (g[row][column].equals("R") && g[row][column].equals(g[row-1][column])){
     count++;
    } else if (g[row][column].equals("R") && !g[row][column].equals(g[row-1][column])){
     count=1;
    } else{
     count=0;
    }
    if(count==3 && row>2){
     if(g[row-3][column].equals("o")){
      performBlackChecksAndRedPlay(console, g, row-3, column,a);
     }
    }
   }
  }

  //Red three in a top bottom diagonal
  givenrow=5;
  for(givencolumn=3;givencolumn<=6;givencolumn++){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow-givencolumn>0){
    maxX=givenrow-givencolumn;
    maxY=0;
    minX=5;
    minY=(givencolumn-givenrow)+5;
   } else if(givenrow-givencolumn<0){
    maxX=0;
    maxY=givencolumn-givenrow;
    minX=(givenrow-givencolumn)+6;
    minY=6;
   } else{
    maxX=0;
    maxY=0;
    minX=5;
    minY=5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY>maxY){
    if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY-1])){
     count++;
     if(count==3){
      performFirstDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY--;
   }
  }

  //Red three in a top bottom diagonal for the other side
  givencolumn=6;
  for(givenrow=4;givenrow>=3;givenrow--){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow-givencolumn>0){
    maxX=givenrow-givencolumn;
    maxY=0;
    minX=5;
    minY=(givencolumn-givenrow)+5;
   } else if(givenrow-givencolumn<0){
    maxX=0;
    maxY=givencolumn-givenrow;
    minX=(givenrow-givencolumn)+6;
    minY=6;
   } else{
    maxX=0;
    maxY=0;
    minX=5;
    minY=5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY>maxY){
    if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY-1])){
     count++;
     if(count==3){
      performFirstDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY--;
   }
  }

  //Red three in a row

  count = 0;
  for (int row = 0; row <6; row++) {
   count = 0;
   for (int column = 0; column < 7; column++) {
    if(column==0 && g[row][column].equals("R")){
     count++;
    } else if (g[row][column].equals("R") && g[row][column].equals(g[row][column-1])){
     count++;
    } else if (g[row][column].equals("R") && !g[row][column].equals(g[row][column-1])){
     count=1;
    } else{
     count=0;
    }
    if(count==3){
     if (row==5){
      if (column==6){
       if(g[row][column-3].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column-3,a);
       }
      } else if (column<3){
       if(g[row][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       }
      }else{
       if(g[row][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       } else if(g[row][column-3].equals("o")) {
        performBlackChecksAndRedPlay(console, g, row, column-3,a);
       }
      }
     } else {
      if(column<3){
       if(g[row][column+1].equals("o") && !g[row+1][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       }
      } else if(column==6){
       if(g[row][column-3].equals("o") && !g[row+1][column-3].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column-3,a);
       }
      }else{
       if(g[row][column+1].equals("o") && !g[row+1][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       } else if(g[row][column-3].equals("o") && !g[row+1][column-3].equals("o")) {
        performBlackChecksAndRedPlay(console, g, row, column-3,a);
       }
      }
     }
     break;
    }
   }
  }

  // Black two in a row
  count = 0;
  for (int row = 0; row <6; row++) {
   count = 0;
   for (int column = 0; column < 7; column++) {
    if(column==0 && g[row][column].equals("B")){
     count++;
    } else if (g[row][column].equals("B") && g[row][column].equals(g[row][column-1])){
     count++;
    } else if (g[row][column].equals("B") && !g[row][column].equals(g[row][column-1])){
     count=1;
    } else{
     count=0;
    }
    if(count==2){
     if (row==5){
      if (column==6){
       if(g[row][column-2].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column-2,a);
       }
      } else if (column==1){
       if(g[row][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       }
      }else{
       if(g[row][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       } else if(g[row][column-2].equals("o")) {
        performBlackChecksAndRedPlay(console, g, row, column-2,a);
       }
      }
     } else {
      if(column==1){
       if(g[row][column+1].equals("o") && !g[row+1][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       }
      } else if(column==6){
       if(g[row][column-2].equals("o") && !g[row+1][column-2].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column-2,a);
       }
      }else{
       if(g[row][column+1].equals("o") && !g[row+1][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       } else if(g[row][column-2].equals("o") && !g[row+1][column-2].equals("o")) {
        performBlackChecksAndRedPlay(console, g, row, column-2,a);
       }
      }
     }
     break;
    }
   }
  }


  //Black two in a column
  count = 0;
  for (int column = 0; column < 7; column++) {
   count = 0;
   for (int row = 0; row < 6; row++) {
    if(row==0 && g[row][column].equals("B")){
     count++;
    } else if (g[row][column].equals("B") && g[row][column].equals(g[row-1][column])){
     count++;
    } else if (g[row][column].equals("B") && !g[row][column].equals(g[row-1][column])){
     count=1;
    } else{
     count=0;
    }
    if(count==2 && row>1){
     if(g[row-2][column].equals("o")){
      performBlackChecksAndRedPlay(console, g, row-2, column,a);
     }
    } 
   }
  }

  //Red two in a row
  count = 0;
  for (int row = 0; row <6; row++) {
   count = 0;
   for (int column = 0; column < 7; column++) {
    if(column==0 && g[row][column].equals("R")){
     count++;
    } else if (g[row][column].equals("R") && g[row][column].equals(g[row][column-1])){
     count++;
    } else if (g[row][column].equals("R") && !g[row][column].equals(g[row][column-1])){
     count=1;
    } else{
     count=0;
    }
    if(count==2){
     if (row==5){
      if (column==6){
       if(g[row][column-2].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column-2,a);
       }
      } else if (column==1){
       if(g[row][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       }
      }else{
       if(g[row][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       } else if(g[row][column-2].equals("o")) {
        performBlackChecksAndRedPlay(console, g, row, column-2,a);
       }
      }
     } else {
      if(column==1){
       if(g[row][column+1].equals("o") && !g[row+1][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       }
      } else if(column==6){
       if(g[row][column-2].equals("o") && !g[row+1][column-2].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column-2,a);
       }
      }else{
       if(g[row][column+1].equals("o") && !g[row+1][column+1].equals("o")){
        performBlackChecksAndRedPlay(console, g, row, column+1,a);
       } else if(g[row][column-2].equals("o") && !g[row+1][column-2].equals("o")) {
        performBlackChecksAndRedPlay(console, g, row, column-2,a);
       }
      }
     }
     break;
    }
   }
  }


  //Red two in a bottom top diagonal
  givenrow=5;
  for(givencolumn=0;givencolumn<=3;givencolumn++){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow+givencolumn<6){
    maxX=0;
    maxY=givenrow+givencolumn;
    minX=givenrow+givencolumn;
    minY=0;
   } else{
    maxX=(givenrow+givencolumn)-6;
    maxY=6;
    minX=5;
    minY=(givenrow+givencolumn)-5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY<maxY){
    if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY+1])){
     count++;
     if(count==2){
      performSecondDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY++;
   }
  }

  //Red two in a bottom top diagonal for the other side
  givencolumn = 0;
  for(givenrow = 4;givenrow>=3;givenrow--){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow+givencolumn<6){
    maxX=0;
    maxY=givenrow+givencolumn;
    minX=givenrow+givencolumn;
    minY=0;
   } else{
    maxX=(givenrow+givencolumn)-6;
    maxY=6;
    minX=5;
    minY=(givenrow+givencolumn)-5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY<maxY){
    if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY+1])){
     count++;
     if(count==2){
      performSecondDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY++;
   }
  }

  //Black two in a top bottom diagonal
  givenrow=5;
  for(givencolumn=3;givencolumn<=6;givencolumn++){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow-givencolumn>0){
    maxX=givenrow-givencolumn;
    maxY=0;
    minX=5;
    minY=(givencolumn-givenrow)+5;
   } else if(givenrow-givencolumn<0){
    maxX=0;
    maxY=givencolumn-givenrow;
    minX=(givenrow-givencolumn)+6;
    minY=6;
   } else{
    maxX=0;
    maxY=0;
    minX=5;
    minY=5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY>maxY){
    if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY-1])){
     count++;
     if(count==2){
      performFirstDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY--;
   }
  }

  //Black two in a top bottom diagonal for the other side
  givencolumn=6;
  for(givenrow=4;givenrow>=3;givenrow--){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow-givencolumn>0){
    maxX=givenrow-givencolumn;
    maxY=0;
    minX=5;
    minY=(givencolumn-givenrow)+5;
   } else if(givenrow-givencolumn<0){
    maxX=0;
    maxY=givencolumn-givenrow;
    minX=(givenrow-givencolumn)+6;
    minY=6;
   } else{
    maxX=0;
    maxY=0;
    minX=5;
    minY=5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY>maxY){
    if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY-1])){
     count++;
     if(count==2){
      performFirstDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY--;
   }
  }


  //Black two in a bottom top diagonal
  givenrow=5;
  for(givencolumn=0;givencolumn<=3;givencolumn++){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow+givencolumn<6){
    maxX=0;
    maxY=givenrow+givencolumn;
    minX=givenrow+givencolumn;
    minY=0;
   } else{
    maxX=(givenrow+givencolumn)-6;
    maxY=6;
    minX=5;
    minY=(givenrow+givencolumn)-5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY<maxY){
    if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY+1])){
     count++;
     if(count==2){
      performSecondDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY++;
   }
  }

  //Black two in a bottom top diagonal for the other side
  givencolumn = 0;
  for(givenrow = 4;givenrow>=3;givenrow--){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow+givencolumn<6){
    maxX=0;
    maxY=givenrow+givencolumn;
    minX=givenrow+givencolumn;
    minY=0;
   } else{
    maxX=(givenrow+givencolumn)-6;
    maxY=6;
    minX=5;
    minY=(givenrow+givencolumn)-5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY<maxY){
    if(g[minX][minY].equals("B") && g[minX][minY].equals(g[minX-1][minY+1])){
     count++;
     if(count==2){
      performSecondDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY++;
   }
  }

  //Red two in a column
  count = 0;
  for (int column = 0; column < 7; column++) {
   count = 0;
   for (int row = 0; row < 6; row++) {
    if(row==0 && g[row][column].equals("R")){
     count++;
    } else if (g[row][column].equals("R") && g[row][column].equals(g[row-1][column])){
     count++;
    } else if (g[row][column].equals("R") && !g[row][column].equals(g[row-1][column])){
     count=1;
    } else{
     count=0;
    }
    if(count==2 && row>1){
     if(g[row-2][column].equals("o")){
      performBlackChecksAndRedPlay(console, g, row-2, column,a);
     }
    } 
   }
  }

  //Red two in a top bottom diagonal
  givenrow=5;
  for(givencolumn=3;givencolumn<=6;givencolumn++){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow-givencolumn>0){
    maxX=givenrow-givencolumn;
    maxY=0;
    minX=5;
    minY=(givencolumn-givenrow)+5;
   } else if(givenrow-givencolumn<0){
    maxX=0;
    maxY=givencolumn-givenrow;
    minX=(givenrow-givencolumn)+6;
    minY=6;
   } else{
    maxX=0;
    maxY=0;
    minX=5;
    minY=5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY>maxY){
    if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY-1])){
     count++;
     if(count==2){
      performFirstDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY--;
   }
  }

  //Red two in a top bottom diagonal for the other side
  givencolumn=6;
  for(givenrow=4;givenrow>=3;givenrow--){
   count=1;
   int maxX;
   int maxY;
   int minX;
   int minY;
   if(givenrow-givencolumn>0){
    maxX=givenrow-givencolumn;
    maxY=0;
    minX=5;
    minY=(givencolumn-givenrow)+5;
   } else if(givenrow-givencolumn<0){
    maxX=0;
    maxY=givencolumn-givenrow;
    minX=(givenrow-givencolumn)+6;
    minY=6;
   } else{
    maxX=0;
    maxY=0;
    minX=5;
    minY=5;
   }
   int originalMinX = minX;
   int originalMinY = minY;
   while(minX>maxX && minY>maxY){
    if(g[minX][minY].equals("R") && g[minX][minY].equals(g[minX-1][minY-1])){
     count++;
     if(count==2){
      performFirstDiagonalCheck(console, g, minX, originalMinX, minY, originalMinY, maxX, maxY,a);
     }
    }
    minX--;
    minY--;
   }
  }

  int column=(int)(Math.random()*7);
  if (g[0][column].equals("o")){
   for (int row=5; row >= 0;row--) {
    if (g[row][column].equals("o")){
     performBlackChecksAndRedPlay(console, g, row, column,a);
    }
   }
  }
 }

 /*
  * humanVSSmartComputer();- This method is option 3 in the main menu.
  * It will let a player play against a smart computer.
  * @param: Scanner console- used so that I can call other methods with the scanner;
  * String[][] g- used so I can call the gameBoard array in other methods
  * int a- used so that the smart computer can choose to play a human or the dumb computer
  * based on what a's value is in the mainMenu();
  * @return: void
  * This method calls the other methods and alternates between red's turn(human) and black's turn(smart computer).
  * The game will continue until someone wins or draws.
  */
 public static void humanVSSmartComputer(Scanner console,String[][] g, int a){
  System.out.println();
  System.out.println();
  System.out.println("You will be playing against the Smart Computer!!!");
  System.out.println("BE WARNED: This will be the hardest game of your life!!!");
  System.out.println();
  System.out.println();
  System.out.println("Player 1 will be Red(\"R\").");
  System.out.println("The Smart Computer will be Black(\"B\").");
  System.out.println("Good Luck!");
  System.out.println("Have Fun!");
  System.out.println("and DON'T CHEAT!!!!!");
  redTurnAgainstSmartComp(console,g,a);
 }

 /*
  * redTurnAgainstSmartComp();- This method is used for each turn in order to make a move.
  * @param: Scanner console- used to get input from the console on what move to make
  * String[][] g- used to make the move on the board and call other methods with the array
  * int a- used so that the smart computer can choose to play a human or the dumb computer
  * based on what a's value is in the mainMenu();
  * @return: void
  * This method splits the inputed string and then uses parseInt to check if it is an integer
  * If it is, it will play the move in the form row,column
  * It then calls other methods to check whether the game is over or not.
  */
 public static void redTurnAgainstSmartComp(Scanner console, String[][] g, int a){
  System.out.println("It is Red's turn to make a move.");
  System.out.println("Make your move in the form \"row,column\"");
  int row;
  int column;
  try { 
   String x =console.nextLine();
   String move[] = x.split(",");
   row = Integer.parseInt(move[0]);
   column = Integer.parseInt(move[1]);
  } catch(NumberFormatException e) { 
   System.out.println("Invalid move! Loss of turn.");
   smartComputer(console,g,a);
   return;
  } catch(NullPointerException e) {
   System.out.println("Invalid move! Loss of turn.");
   smartComputer(console,g,a);
   return;
  } catch(ArrayIndexOutOfBoundsException e) {
   System.out.println("Invalid move! Loss of turn.");
   smartComputer(console,g,a);
   return;
  }
  if(column>6 || row>5){
   System.out.println("Invalid move! Loss of turn.");
   smartComputer(console,g,a);
   return;
  }
  if (!g[row][column].equals("o")){
   System.out.println("Invalid move! Loss of turn.");
   smartComputer(console,g,a);
   return;
  }
  if (g[row][column].equals("o")){
   for (int rowchecker = 5; rowchecker >= 0;rowchecker--) {
    if (g[rowchecker][column].equals("o") && rowchecker==row){
     g[rowchecker][column] = "R";
     gameBoard(g);
     System.out.println();
     fourInAColumnForRed(console,g,rowchecker,column);
     fourInARowForRed(console,g,rowchecker);
     fourInABottomTopDiagonalForRed(console,g,rowchecker,column);
     fourInATopBottomDiagonalForRed(console,g,rowchecker,column);
     draw(console, g);
     smartComputer(console,g,a);
     return;
    } else if(!g[rowchecker][column].equals("o")){
     //do nothing
    } else{
     System.out.println("Invalid move! Loss of turn.");
     smartComputer(console,g,a);
     return;
    }
   }
  }
 }

 /*
  * performBlackChecksAndRedPlay();- This method is used to see if the smart computer made a winning move.
  * @param: Scanner console- used to call other methods with the console
  * String[][] g- used to make the move on the board and call other methods with the array
  * int a- used so that the smart computer can choose to play a human or the dumb computer
  * based on what a's value is in the mainMenu();
  * int newRow and int newColumn- both are used to set the point's location and call it in other methods
  * @return: void
  * This method checks to see if the smart computer won.
  * Afterwards, it checks the value of a and decides whether the smart comp will play the human
  * or the dumb computer
  */
 public static void performBlackChecksAndRedPlay(Scanner console, String[][] g, int newRow, int newColumn, int a){
  g[newRow][newColumn]="B";
  gameBoard(g);
  System.out.println();
  fourInAColumnForBlack(console,g,newRow,newColumn);
  fourInARowForBlack(console,g,newRow);
  fourInABottomTopDiagonalForBlack(console,g,newRow,newColumn);
  fourInATopBottomDiagonalForBlack(console,g,newRow,newColumn);
  draw(console, g);
  if(a==3){
   redTurnAgainstSmartComp(console, g,a);
  } else if(a==4){
   dumbComputerForRed(console,g,a);
  }
 }

 /*
  * performFirstDiagonalCheck();- This method is used to see if the smart computer or its opponent has
  * two or three in a certain diagonal. If so, it will either try to win or try to block it
  * @param: Scanner console- used to call other methods with the console
  * String[][] g- used to make the move on the board and call other methods with the array
  * int a- used so that the smart computer can choose to play a human or the dumb computer
  * based on what a's value is in the mainMenu();
  * int minX, int originalMinX, int minY, int originalMinY, int maxX, and int maxY- 
  * all are used to loop each diagonal and check to see how many of each color there are in it
  * @return: void
  * This method plays black's piece in the spot where it is needed to block a diagonal or win on a diagonal.
  * It checks to see which spots are open to occupy or block
  */
 public static void performFirstDiagonalCheck(Scanner console, String[][] g, int minX, int originalMinX, int minY, int originalMinY, int maxX, int maxY, int a){
  if (minX==originalMinX && minY==originalMinY){
   if ((minX-1)!=maxX && (minX-2)!=maxX && (minY-1)!=maxY && (minY-2)!=maxY){
    if(g[minX-2][minY-2].equals("o") && !g[minX-1][minY-2].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX-2, minY-2,a);
    }
   }
  } else {
   if ((minX-1)==maxX && (minX+1)==originalMinX){
    //do nothing
   } else if((minX-1)==maxX){
    if(g[minX+1][minY+1].equals("o") && !g[minX+2][minY+1].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX+1, minY+1,a);
    }
   } else if((minX+1)==originalMinX){
    if(g[minX+1][minY+1].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX+1, minY+1,a);
    } else if(!g[minX+1][minY+1].equals("o") && g[minX-2][minY-2].equals("o") && !g[minX-1][minY-2].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX-2, minY-2,a);
    }
   } else{
    if(g[minX+1][minY+1].equals("o") && !g[minX+2][minY+1].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX+1, minY+1,a);
    } else if(!g[minX+1][minY+1].equals("o") && g[minX-2][minY-2].equals("o") && !g[minX-1][minY-2].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX-2, minY-2,a);
    }
   }
  }
 }

 /*
  * performSecondDiagonalCheck();- This method is used to see if the smart computer or its opponent has
  * two or three in a certain diagonal. If so, it will either try to win or try to block it
  * @param: Scanner console- used to call other methods with the console
  * String[][] g- used to make the move on the board and call other methods with the array
  * int a- used so that the smart computer can choose to play a human or the dumb computer
  * based on what a's value is in the mainMenu();
  * int minX, int originalMinX, int minY, int originalMinY, int maxX, and int maxY- 
  * all are used to loop each diagonal and check to see how many of each color there are in it
  * @return: void
  * This method plays black's piece in the spot where it is needed to block a diagonal or win on a diagonal.
  * It checks to see which spots are open to occupy or block
  */
 public static void performSecondDiagonalCheck(Scanner console, String[][] g, int minX, int originalMinX, int minY, int originalMinY, int maxX, int maxY, int a){
  if (minX==originalMinX && minY==originalMinY){
   if ((minX-1)!=maxX && (minX-2)!=maxX && (minY-1)!=maxY && (minY-2)!=maxY){
    if(g[minX-2][minY+2].equals("o") && !g[minX-1][minY+2].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX-2, minY+2, a);
    }
   }
  } else {
   if ((minX-1)==maxX && (minX+1)==originalMinX){
    //do nothing
   } else if((minX-1)==maxX){
    if(g[minX+1][minY-1].equals("o") && !g[minX+2][minY-1].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX+1, minY-1, a);
    }
   } else if((minX+1)==originalMinX){
    if(g[minX+1][minY-1].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX+1, minY-1, a);
    } else if(!g[minX+1][minY+1].equals("o") && g[minX-2][minY+2].equals("o") && !g[minX-1][minY+2].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX-2, minY+2, a);
    }
   } else{
    if(g[minX+1][minY-1].equals("o") && !g[minX+2][minY-1].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX+1, minY-1, a);
    } else if(!g[minX+1][minY-1].equals("o") && g[minX-2][minY+2].equals("o") && !g[minX-1][minY+2].equals("o")){
     performBlackChecksAndRedPlay(console, g, minX-2, minY+2, a);
    }
   }
  }
 }

 /*
  * dumbComputerForRed();- This method is used for the dumb computer in order to make a move.
  * @param: Scanner console- used so that other methods can call the main menu with the scanner
  * String[][] g- used to make the move on the board and call other methods with the array
  * int a- used so that the smart computer can choose to play a human or the dumb computer
  * based on what a's value is in the mainMenu();
  * @return: void
  * This method places the piece in random spots using Math.random.
  * The dumb computer can never make an illegal move.
  * It then calls other methods to check whether the game is over or not.
  */
 public static void dumbComputerForRed(Scanner console, String[][] g, int a){
  try {
   Thread.sleep(1000);
  } catch (InterruptedException e) {
   System.out.println("An exception happened in the dumbComputerForRed method in the Thread.sleep." + e);
  }
  System.out.println("The Dumb Computer is attempting to think (but is actually failing horribly)...");
  System.out.println();
  System.out.println();
  int row=0;
  int column=(int)(Math.random()*7);
  if (g[0][column].equals("o")){
   for (row=5; row >= 0;row--) {
    if (g[row][column].equals("o")){
     g[row][column] = "R";
     gameBoard(g);
     System.out.println();
     break;
    } 
   }
  }
  fourInAColumnForRed(console,g,row,column);
  fourInARowForRed(console,g,row);
  fourInABottomTopDiagonalForRed(console,g,row,column);
  fourInATopBottomDiagonalForRed(console,g,row,column);
  draw(console, g);
  try {
   Thread.sleep(1000);
  } catch (InterruptedException e) {
   System.out.println("An exception happened in the dumbComputerForRed method in the Thread.sleep." + e);
  }
  smartComputer(console,g,a);
 }

 /*
  * SmartComputerVSDumbComputer();- This method is option 4 in the main menu.
  * It will let the Smart Computer play against a dumb computer.
  * @param: Scanner console- used so that I can call other methods with the scanner;
  * String[][] g- used so I can call the gameBoard array in other methods
  * int a- used so that the smart computer can choose to play a human or the dumb computer
  * based on what a's value is in the mainMenu();
  * @return: void
  * This method calls the other methods and alternates between red's turn(dumb computer) and black's turn(smart computer).
  * The game will continue until someone wins or draws,
  */
 public static void SmartComputerVSDumbComputer(Scanner console,String[][] g, int a){
  System.out.println();
  System.out.println();
  System.out.println("Now presenting... the match we have all been waiting for...");
  System.out.println("---------------------------------------");
  System.out.println("!!!!Dumb Computer VS Smart Computer!!!!");
  System.out.println("---------------------------------------");
  System.out.println("This will be the shortest game you have ever seen!");
  System.out.println("By the time you finish reading this, the game will have already finished!");
  System.out.println();
  System.out.println("The Dumb Computer will be Red(\"R\").");
  System.out.println("The Smart Computer will be Black(\"B\").");
  dumbComputerForRed(console,g,a);
 }

 /*
  * credits();- This method is option 6 in the main menu.
  * It will display the credits.
  * @param: none
  * @return: void
  * This method displays the credits for the connect four game
  */
 public static void credits(){
  System.out.println();
  System.out.println();
  System.out.println("-----------------------------------------------------------------------------");
  System.out.println();
  System.out.println("         ______     ______     ______     _____     __     ______   ______       ");
  System.out.println(" /\\  ___\\   /\\  == \\   /\\  ___\\   /\\  __-.  /\\ \\   /\\__  _\\ /\\  ___\\      ");      
  System.out.println(" \\ \\ \\____  \\ \\  __<   \\ \\  __\\   \\ \\ \\/\\ \\ \\ \\ \\  \\/_/\\ \\/ \\ \\___  \\     ");
  System.out.println("  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\____-  \\ \\_\\    \\ \\_\\  \\/\\_____\\    ");
  System.out.println("   \\/_____/   \\/_/ /_/   \\/_____/   \\/____/   \\/_/     \\/_/   \\/_____/    ");
  System.out.println();
  System.out.println("-----------------------------------------------------------------------------");
  System.out.println();
  System.out.println();
  System.out.println();
  try {
   Thread.sleep(3000);
  } catch (InterruptedException e) {
   System.out.println("An exception happened in the credits method in the Thread.sleep." + e);
  }
  System.out.println("EXECUTIVE PRODUCER : RAHUL SWAMINATHAN ");
  System.out.println();
  try {
   Thread.sleep(3000);
  } catch (InterruptedException e) {
   System.out.println("An exception happened in the credits method in the Thread.sleep." + e);
  }
  System.out.println("EXECUTIVE DIRECTOR : RAHUL SWAMINATHAN ");
  System.out.println();
  try {
   Thread.sleep(3000);
  } catch (InterruptedException e) {
   System.out.println("An exception happened in the credits method in the Thread.sleep." + e);
  }
  System.out.println("EXECUTIVE TESTOR AND BUG FINDER : MURALI SWAMINATHAN (MY DAD)");
  System.out.println();
  try {
   Thread.sleep(3000);
  } catch (InterruptedException e) {
   System.out.println("An exception happened in the credits method in the Thread.sleep." + e);
  }
  System.out.println("EXECUTIVE SUPPORT AND LOGIC / REASONING ANALYZER : VIDYA BALASUBRAMANIAN (MY MOM)");
  System.out.println();
  try {
   Thread.sleep(3000);
  } catch (InterruptedException e) {
   System.out.println("An exception happened in the credits method in the Thread.sleep." + e);
  }
  System.out.println("Overall, I did this project all by myself without any help from the Internet or someone else.");
  System.out.println("My dad helped me by playing the game after I was done with each stage.");
  System.out.println("He told me anything he found difficult about playing the game, and then gave me some advice on how to make it easier.");
  System.out.println("My mom gave me advice on how to simplify my program by removing some redundancies.");
  System.out.println("I had lots of fun making this game... even if it did take a really, really, really long time!");
 }
}
