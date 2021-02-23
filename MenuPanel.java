//MenuPanel, the panel on the MenuFrame
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MenuPanel extends JPanel{
   JFrame frame;
   JFrame newFrame;
  // static BattleshipPanel bp;
 //  static BattleshipPanel2 bp2;
   public MenuPanel(JFrame frame){
      this.frame = frame;
    //  bp = new BattleshipPanel(frame,newFrame);
    //  bp2 = new BattleshipPanel2(frame,newFrame);
      setLayout(new BorderLayout());
      JLabel c = new JLabel("Welcome to Battleship!");
      c.setHorizontalAlignment(SwingConstants.CENTER);
      c.setFont(new Font("Serif", Font.BOLD, 30));
      add(c,BorderLayout.CENTER);
      JPanel subpanel = new JPanel(new GridLayout(1,2));
      add(subpanel, BorderLayout.SOUTH);
      JButton b = new JButton("Start!");
      b.addActionListener(new Start());
      subpanel.add(b);
      JButton d = new JButton("How to Play");
      d.addActionListener(new HowToPlay());
      subpanel.add(d);
   }
   private class HowToPlay implements ActionListener{
      public void actionPerformed(ActionEvent e){
         frame.setVisible(false);
         if(newFrame==null){
            newFrame = new JFrame("Content Frame");
            newFrame.setVisible(true);
            newFrame.setLocation(100,100);
            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newFrame.setContentPane(new ContentPanel(frame,newFrame));
            newFrame.setSize(300,300);
         }
         else{
            newFrame.setVisible(true);
         }
      }
   }
   private class Start implements ActionListener{
      public void actionPerformed(ActionEvent e){
         frame.setVisible(false);
         newFrame = new JFrame("Battleship Frame");
         newFrame.setVisible(true);
         newFrame.setLocation(0,0);
         newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         newFrame.setContentPane(new BattleshipDisplay(newFrame));
         newFrame.setSize(1500,1500);
      }
   
   }
}