//ContentPanel has the content of your new frame
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class EndPanel extends JPanel{

   JFrame menuFrame;
   public EndPanel(JFrame menuFrame,int playerNum){
      this.menuFrame = menuFrame;
      setLayout(new BorderLayout());
      JTextArea area = new JTextArea("Player " + playerNum + " wins!");
      area.setFont(new Font("Serif", Font.PLAIN, 15));
      area.setLineWrap(true);
      area.setWrapStyleWord(true);
      add(area,BorderLayout.CENTER);
      JButton b = new JButton("Exit");
      b.addActionListener(new ButtonListener());
      add(b,BorderLayout.SOUTH);
   }
   private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         System.exit(0);
      }
   }
}