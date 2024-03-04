import java.util.ArrayList;
import java.util.Scanner;


public class BattleShipGame{
   public static void main(String[] args) {
      Board bComp = new boardComp();
      ((boardComp)bComp).setVal();
      ((boardComp)bComp).setShip();
      String[][] boardComp = ((boardComp)bComp).getBoard();
      Board bUser = new userBoard();
      ((userBoard)bUser).setVal();
      String[][] userBoard = ((userBoard)bUser).getBoard();
      System.out.println("Welcome to Battleship game. Type in the number and then letter.");
      printBoard(userBoard);
      System.out.println("");
      Game(userBoard, boardComp);
      
      
      
   }
   
   public static void printBoard(String[][] a) {
      String b = " ";
      System.out.println("      1 2 3 4 5 6 7 8 9 10");
      System.out.println(" ");
      for (int r = 0; r < a.length; r++) {
         b += (char)(65 + r) + "    ";
         for (int c = 0; c < a[0].length; c++) {
            b += a[r][c] + " ";
         }
         System.out.println(b);
         b = " ";
      } 

   }
   
   public static void Game(String[][] user, String[][] comp) {
      
      int row = 0;
      int col = 0;
      String letter;
      ArrayList<String> shipsSunk = new ArrayList<String>();
      for (int k = 0; k < 50; k++) {
         
         Scanner in = new Scanner(System.in);
         System.out.println("Choose the number: ");
         int number = in.nextInt();
         //col--;
         //Scanner un = new Scanner(System.in);
         System.out.println("Choose the letter: ");
         letter = in.nextLine();
         
         

         if (letter.equals("A") || letter.equals("a")) {
            row = 0;
         }
      
         if (letter.equals("B") || letter.equals("b")) {
            row = 1;
         }
      
         if (letter.equals("C") || letter.equals("c")) {
            row = 2;
         }
      
         if (letter.equals("D") || letter.equals("d")) {
            row = 3;
         }
      
         if (letter.equals("E") || letter.equals("e")) {
            row = 4;
         }
      
         if (letter.equals("F") || letter.equals("f")) {
            row = 5;
         }
      
         if (letter.equals("G") || letter.equals("g")) {
            row = 6;
         }
      
         if (letter.equals("H") || letter.equals("h")) {
            row = 7;
         }
      
         if (letter.equals("I") || letter.equals("i")) {
            row = 8;
         }
      
         if (letter.equals("J") || letter.equals("j")) {
            row = 9;
         }
         
         user[row][col] = comp[row][col];
         shipsSunk = shipChecker(user);
         
         printBoard(user);
         
         if (user[row][col].equals("M")) {
            System.out.println("YOU MISSED!!!!!");
         } else {
            System.out.println("Hit :(");
         }
         
         if (shipsSunk.size() == 0) {
            System.out.println("You have sunk no ships.");
         } else if (shipsSunk.size() == 5) {
            System.out.println("You have sunk all the ships. You win!");
            break;
         } else {
            System.out.println("You have sunk " + shipsSunk);
         }
         
         if (k == 50) {
            System.out.println("You lost ... ");
         }
         
      }
      
   }
   
   public static ArrayList<String> shipChecker(String[][] a) {
      
      ArrayList<String> m = new ArrayList<String>();
      int p = 0;
      int s = 0;
      int d = 0;
      int b = 0;
      int f = 0;

      for (int r = 0; r < a.length; r++) {
         for (int c = 0; c < a[0].length; c++) {
            
            if (a[r][c].equals("P")){
               p++;
            }
            if (a[r][c].equals("S")){
               s++;
            }
            if (a[r][c].equals("D")){
               d++;
            }
            if (a[r][c].equals("B")){
               b++;
            }
            if (a[r][c].equals("A")){
               f++;
            }
         }
         
         if (p == 2) {
            if (m.indexOf("Patrol Boat") == -1) {
               m.add("Patrol Boat");
            }
         }
         
         if (s == 3) {
            if (m.indexOf("Submarine") == -1) {
               m.add("Submarine");
            }         
         }
         
         if (d == 3) {
            if (m.indexOf("Destroyer") == -1) {
               m.add("Destroyer");
            }  
         }
         
         if (b == 4) {
            if (m.indexOf("Battleship") == -1) {
               m.add("Battleship");
            }  
         }
         
         if (f == 5) {
            if (m.indexOf("Aircraft Carrier") == -1) {
               m.add("Aircraft Carrier");
            }           
         }
      }
      return m;      
   }
}

