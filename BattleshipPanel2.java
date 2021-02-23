import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BattleshipPanel2 extends JPanel{
   JFrame menuFrame;
   JFrame b2Frame;
   BattleshipDisplay e;
   private JButton next;
   JLabel label;
   public BattleshipPanel2(JFrame menuFrame,JFrame b2Frame){
            setLayout(new BorderLayout());

      label = new JLabel();
      label.setFont(new Font("Serif", Font.PLAIN, 20));
      add(label, BorderLayout.NORTH);
      this.menuFrame = menuFrame;
      this.b2Frame = b2Frame;
      setSize(1500,1500);
      next = new JButton("Next");
      next.addActionListener(new next2());
      add(next, BorderLayout.SOUTH);
      next.setEnabled(false);
      e = new BattleshipDisplay(2);
      //while(d.getGameOver() == false || e.getGameOver() == false) {
         while(e.getNextEnabled() == false) {
            next.setEnabled(false);
            label.setText("Player " + e.getPlayerNum() + "'s turn.");
         }
         next.setEnabled(true);
         e.setNextEnabled(false);
      //}
      }
 
   private class next2 implements ActionListener {
      public void actionPerformed(ActionEvent f) {
         menuFrame.setVisible(false);
         if(b2Frame==null){
            b2Frame = new JFrame("Player 1 Frame");
            b2Frame.setVisible(true);
            b2Frame.setLocation(100,100);
            b2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            b2Frame.setContentPane(MenuPanel.bp);
            b2Frame.setSize(1500,1500);
         }
         else{
            b2Frame.setVisible(true);
         }

      }
   }
}