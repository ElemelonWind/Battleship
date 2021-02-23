import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BattleshipDisplay2 extends JPanel{
   
   private JButton[][] board;
   private int[][] matrix;
   private JTextArea label;
   private final int N = 10;
   private int shipNum = 2;
   private JButton changeDirection;
   private boolean vertical;
   private boolean shipsPlaced;
   JFrame frame;
   JFrame newFrame;
   JFrame endFrame;
   int gameOver;
   private int hitCount2,hitCount3,hitCount4,hitCount5;

   private JButton confirm, next;
   /*
   * main battleship class
   * use two matrices, one for numbers and one with buttons
   * numbers 1-5 represent the number of ship
   * click on a button multiple times to change the direction of the ship
   * make sure confirm button is not enabled if the ship position is illegal
   */
   public BattleshipDisplay2(JFrame frame,JFrame newFrame)
   {
      this.frame = frame;
      this.newFrame = newFrame;
      shipsPlaced = false;
      vertical = true;
      gameOver = 0;
      setLayout(new BorderLayout());
      JPanel north = new JPanel(new GridLayout(1,2,10,10));
      label = new JTextArea(3,20);
      label.setText("Player 2, Add your " + shipNum + "-pegged ship. Use the 'change direction' button to change from vertical to horizontal. Don't let your opponent see! Press confirm when finished.");
      label.setLineWrap(true);
      label.setWrapStyleWord(true);
   
      label.setFont(new Font("Serif", Font.PLAIN, 20));
      north.add(label);
      changeDirection = new JButton("Change Direction");
      changeDirection.addActionListener(new direction());
      north.add(changeDirection);
      JPanel center = new JPanel(new GridLayout(N,N));
      board = new JButton[N][N];
      matrix = new int[N][N];
      for(int x = 0; x < N; x++) {
         for(int y = 0; y < N; y++) {
            board[x][y] = new JButton();
            board[x][y].setBackground(Color.gray);
            board[x][y].addActionListener(new listener(x,y));
            board[x][y].setPreferredSize(new Dimension(50,50));
            matrix[x][y] = 0;
            center.add(board[x][y]);
         }
      }
      add(north,BorderLayout.NORTH);
      add(center,BorderLayout.CENTER);
      JPanel south = new JPanel(new GridLayout(2,1));
      add(south, BorderLayout.SOUTH);
      confirm = new JButton("Confirm");
      confirm.addActionListener(new confirm());
      confirm.setEnabled(false);
      changeDirection.setEnabled(true);
      south.add(confirm);
      next = new JButton("Next");
      next.addActionListener(new next());
      next.setEnabled(false);
      south.add(next);
   }
   private class direction implements ActionListener {
      private int myRow, myCol;
      private boolean good;
      public void actionPerformed(ActionEvent e) {
         good = true;
         myRow = 10;
         myCol = 10;
         for(int r = N-1; r >= 0; r--) {
            for(int c = N-1; c >= 0; c--) {
               if(board[r][c].getBackground() == Color.blue) {
                  myRow = r;
                  myCol = c;
                  board[r][c].setBackground(Color.gray);
               }
            }
         }
         if(myRow == 10 && myCol == 10) {
            if(vertical == true) 
               vertical = false;
            else
               vertical = true;
         }
         else {
            if(vertical == true) 
               vertical = false;
            else
               vertical = true;
            for(int x = 0; x < shipNum; x++) {
               if(vertical == true) {
                  if(myRow+x<10)
                     if(board[myRow+x][myCol].getBackground()==Color.gray) {
                     
                        board[myRow+x][myCol].setBackground(Color.blue);}
                     else
                        good = false;
                  
                  else
                     good = false;
               }
               else
                  if(myCol + x < 10)
                     if(board[myRow][myCol+x].getBackground()==Color.gray) {
                     
                        board[myRow][myCol+x].setBackground(Color.blue);}
                     else
                        good = false;
                  
                  else
                     good = false;
            
            }
            if(good == true) {
               confirm.setEnabled(true);
            }
            else
               confirm.setEnabled(false);
         }
      }
   }
   private class listener implements ActionListener {
      private int myRow, myCol;
      private boolean good;
      public listener(int a, int b){
         myRow = a;
         myCol = b;
         good = true;
      }
      public void actionPerformed(ActionEvent e) {
         for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
               if(board[r][c].getBackground() == Color.blue) {
                  
                  board[r][c].setBackground(Color.gray);
               }
            }
         }
         if(shipsPlaced == false) {
         
            for(int x = 0; x < shipNum; x++) {
               if(vertical == true) {
                  if(myRow+x<10)
                     if(board[myRow+x][myCol].getBackground()==Color.gray) {
                     
                        board[myRow+x][myCol].setBackground(Color.blue);}
                     else
                        good = false;
                  
                  else
                     good = false;
               }
               else
                  if(myCol + x < 10)
                     if(board[myRow][myCol+x].getBackground()==Color.gray) {
                     
                        board[myRow][myCol+x].setBackground(Color.blue);}
                     else
                        good = false;
                  
                  else
                     good = false;
            
            }
            if(good == true) {
            
               confirm.setEnabled(true);
            }
            else 
               confirm.setEnabled(false);
         }
         else {
            board[myRow][myCol].setBackground(Color.blue);
            confirm.setEnabled(true);
         }
      
      }
   }
   private class confirm implements ActionListener {
      private int myRow, myCol;
      public void actionPerformed(ActionEvent e) {
         if(shipsPlaced == false) {
            for(int r = 0; r < N; r++) {
               for(int c = 0; c < N; c++) {
                  if(board[r][c].getBackground() == Color.blue) {
                     matrix[r][c] = shipNum;
                     board[r][c].setBackground(Color.green);
                  }
               }
            }
            shipNum++;
            if(shipNum == 6) {
               next.setEnabled(true);
               confirm.setEnabled(false);
               changeDirection.setEnabled(false);
               for(int r = 0; r < N; r++) {
                  for(int c = 0; c < N; c++) {
                     board[r][c].setEnabled(false);
                  
                  }
               }
               label.setText("Press next to continue.");
            }
            else {
               label.setText("Player 2, Add your " + shipNum + "-pegged ship. Use the 'change direction' button to change from vertical to horizontal. Don't let your opponent see! Press confirm when finished.");
               confirm.setEnabled(false);
               next.setEnabled(false);
            }
         }
         else {
            for(int r = 0; r < N; r++) {
               for(int c = 0; c < N; c++) {
                  if(board[r][c].getBackground() == Color.blue) {
                     myRow = r;
                     myCol = c;
                  }
               }
            }
            switch(matrix[myRow][myCol]) {
               case 0:
                  label.setText("Miss!"); 
                  board[myRow][myCol].setBackground(Color.white); 
                  board[myRow][myCol].setEnabled(false);
                  break;
               case 2: 
                  hitCount2++; 
                  board[myRow][myCol].setEnabled(false);
                  if(hitCount2 == 2) {
                     label.setText("You sunk the 2-pegged ship!");
                     gameOver++;
                     for(int r = 0; r < N; r++) {
                        for(int c = 0; c < N; c++) {
                           if(matrix[r][c]==2) {
                              board[r][c].setBackground(Color.yellow);
                           }
                        }
                     }
                  }
                  else {
                     label.setText("Hit!");
                     board[myRow][myCol].setBackground(Color.red);
                  }
                  break;
               case 3:
                  hitCount3++; 
                  board[myRow][myCol].setEnabled(false);
                  if(hitCount3 == 3) {
                     label.setText("You sunk the 3-pegged ship!");
                     gameOver++;
                     for(int r = 0; r < N; r++) {
                        for(int c = 0; c < N; c++) {
                           if(matrix[r][c]==3) {
                              board[r][c].setBackground(Color.yellow);
                           }
                        }
                     }
                  }
                  else {
                     label.setText("Hit!");
                     board[myRow][myCol].setBackground(Color.red);
                  }
                  break;
               case 4:
                  hitCount4++; 
                  board[myRow][myCol].setEnabled(false);
                  if(hitCount4 == 4) {
                     label.setText("You sunk the 4-pegged ship!");
                     gameOver++;
                     for(int r = 0; r < N; r++) {
                        for(int c = 0; c < N; c++) {
                           if(matrix[r][c]==4) {
                              board[r][c].setBackground(Color.yellow);
                           }
                        }
                     }
                  }
                  else {
                     label.setText("Hit!");
                     board[myRow][myCol].setBackground(Color.red);
                  }
                  break;
               case 5:
                  hitCount5++; 
                  board[myRow][myCol].setEnabled(false);
                  if(hitCount5 == 5) {
                     label.setText("You sunk the 5-pegged ship!");
                     gameOver++;
                     for(int r = 0; r < N; r++) {
                        for(int c = 0; c < N; c++) {
                           if(matrix[r][c]==5) {
                              board[r][c].setBackground(Color.yellow);
                           }
                        }
                     }
                  }
                  else {
                     label.setText("Hit!");
                     board[myRow][myCol].setBackground(Color.red);
                  }
                  break;
            }
            confirm.setEnabled(false);
            next.setEnabled(true);
         
         }
      }
      
   }
   private class next implements ActionListener {
      private int firstTurnOver = 0;
      public void actionPerformed(ActionEvent e) {
         firstTurnOver++;
         if(shipsPlaced == false) {
            for(int r = 0; r < N; r++) {
               for(int c = 0; c < N; c++) {
                  board[r][c].setBackground(Color.gray);
                  board[r][c].setEnabled(true);
               }
            }
            shipsPlaced = true;
         }
         if(gameOver == 4) {
            newFrame.setVisible(false);
            endFrame = new JFrame("End Frame");
            endFrame.setVisible(true);
            endFrame.setLocation(0,0);
            endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            endFrame.setContentPane(new EndPanel(endFrame,1));
            endFrame.setSize(500,500);
         }
         else {
            if(firstTurnOver>=2){
               frame.setVisible(true);
               newFrame.setVisible(false);
            }
            label.setText("Player 1's turn. Click the spot you wish to target!");
            next.setEnabled(false);
         }
      }
   }
}