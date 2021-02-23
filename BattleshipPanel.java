import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BattleshipPanel extends JPanel{
   JFrame menuFrame;
   JFrame b1Frame;
   BattleshipDisplay d;
   private JButton next;
   JLabel label;
   private boolean p1turn;
   //BattleshipPanel2 bp2;
   public BattleshipPanel(JFrame menuFrame,JFrame b1Frame){
            setLayout(new BorderLayout());
      
      label = new JLabel();
      label.setFont(new Font("Serif", Font.PLAIN, 20));
      add(label, BorderLayout.NORTH);
      p1turn = true;
      this.menuFrame = menuFrame;
      this.b1Frame = b1Frame;
      setSize(1500,1500);
      d = new BattleshipDisplay(1);
      add(d, BorderLayout.CENTER);
      next = new JButton("Next");
      next.addActionListener(new next(p1turn));
      add(next, BorderLayout.SOUTH);
      next.setEnabled(false);
      //e = new BattleshipDisplay(2);
      //while(d.getGameOver() == false || e.getGameOver() == false) {
         while(d.getNextEnabled() == false) {
            next.setEnabled(false);
            label.setText("Player " + d.getPlayerNum() + "'s turn.");
         }
         next.setEnabled(true);
         d.setNextEnabled(false);
         /*while(e.getNextEnabled() == false) {
            next.setEnabled(false);
            label.setText("Player " + e.getPlayerNum() + "'s turn.");
         }
         next.setEnabled(true);
         e.setNextEnabled(false);*/
      //}
   } 
   private class next implements ActionListener {
      boolean a;
      public next (boolean arg) {
         a = arg;
      } 
      public void actionPerformed(ActionEvent f) {
         /*if(a == true) {
            add(d);
         }
         else
            add(e);*/
            menuFrame.setVisible(false);
         if(b1Frame==null){
            b1Frame = new JFrame("Player 2 Frame");
            b1Frame.setVisible(true);
           b1Frame.setLocation(100,100);
            b1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            b1Frame.setContentPane(new BattleshipPanel2(menuFrame, b1Frame));
            b1Frame.setSize(1500,1500);
         }
         else{
           b1Frame.setVisible(true);
         }

      }
   }
}