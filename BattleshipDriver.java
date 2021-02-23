import javax.swing.*;

public class BattleshipDriver {
   //MenuFrame that opens other frames with content
   public static void main(String[] args){
      JFrame frame = new JFrame("Menu Frame");
      frame.setVisible(true);
      frame.setLocation(100,100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MenuPanel(frame));
      frame.setSize(500,500);
   }
}