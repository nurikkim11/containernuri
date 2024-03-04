public class Board{

String[][] b = new String[10][10];
   
   public String getVal(int r, int c) {
      return b[r][c];
   }
    
}


class boardComp extends Board {
   public void setVal(){
      for (int r = 0; r < b.length; r++) {
         for (int c = 0; c < b[0].length; c++) {
            b[r][c] = "M";
         }
      } 
   }
   
   public void setShip() {
      int n = 0;
      
      do {
         n = 0;
         setVal();
         placeShip(2, "P");
         placeShip(3, "S");
         placeShip(3, "D");
         placeShip(4, "B");
         placeShip(5, "A");
         
      
         for (int r = 0; r < b.length; r++) {
            for (int c = 0; c < b[0].length; c++) {
               if (b[r][c].equals("M")) {
                  n++;
               }
            }
         }
      } while (n!=83);
      
 
 
   }
   
   
   public void placeShip(int a, String x) {
      int horizontalNum = verticalNum();
      int r = 0; 
      int c = 0;
      
      if (horizontalNum == 1) {
         
         c = (int)(Math.random() * (10-a)) + 1;
         r = (int)(Math.random() * 9) + 0;
         
         for (int i = 0; i < a; i++) {
            b[r][c+i] = x;
         }
      }
               
      
      if (horizontalNum == 2) {
         
         
         c = (int)(Math.random() * 9) + 0;
         r = (int)(Math.random() * (10-a)) + 1;

         for (int y = 0; y < a; y++) {
            b[r+y][c] = x;
         }
         
         
      }
   }
   

   
   public String[][] getBoard() {
      return b;
   }

   public static int verticalNum() {
      return (int)(Math.random()*2+1);
   }
}


class userBoard extends Board {
   public void setVal(){
      for (int r = 0; r < b.length; r++) {
         for (int c = 0; c < b[0].length; c++) {
            b[r][c] = "~";
         }
      } 
   }
   
   public String[][] getBoard() {
      return b;
   }
   
   
}

