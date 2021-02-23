//ContentPanel has the content of your new frame
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ContentPanel extends JPanel{

   JFrame menuFrame;
   JFrame contentFrame;
   public ContentPanel(JFrame menuFrame,JFrame contentFrame){
      this.menuFrame = menuFrame;
      this.contentFrame = contentFrame;
      setLayout(new BorderLayout());
      JTextArea area = new JTextArea("Battleship is a strategy type guessing game for two players. It is played on ruled grids on which each player's fleet of ships (including battleships) are marked. The locations of the fleets are concealed from the other player. Players alternate turns calling shots at the other player's ships, and the objective of the game is to destroy the opposing player's fleet. Detailed instructions will be displayed at each step in the game.");
      area.setFont(new Font("Serif", Font.PLAIN, 15));
      area.setLineWrap(true);
      area.setWrapStyleWord(true);
      add(area,BorderLayout.CENTER);
      JButton b = new JButton("Back");
      b.addActionListener(new ButtonListener());
      add(b,BorderLayout.SOUTH);
   }
   private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         menuFrame.setVisible(true);
         contentFrame.setVisible(false);
      }
   }
}