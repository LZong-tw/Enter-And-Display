/**
 * Name: Yun-Chung Lin
 * ID: U1010425
 * Ex: Enter And Display
 * Information: 
 *      
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EnterAndDisplay extends JFrame {
  public EnterAndDisplay() {
    Panel p = new Panel();
    add(p);
    p.setFocusable(true);
  }

  public static void main(String[] args) {
    EnterAndDisplay frame = new EnterAndDisplay();
    frame.setTitle("Enter And Display");
    frame.setSize(900, 100);
    frame.setLocationRelativeTo(null); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  static class Panel extends JPanel {
    private boolean boo=true; //Save to judge whether the Enter key was pressed or not.
    private String message=""; //String container
    private int x=20, y=20;
    /** Construct a panel to draw string */
    public Panel() {
      addKeyListener(new KeyAdapter() {
        @Override /** Handle key-Pressed event */
        public void keyPressed(KeyEvent e) {
          switch(e.getKeyCode()){
            case KeyEvent.VK_ENTER: boo=false; message=""; break; // If the Enter key was pressed, wipe out the string container and set the boolean false.
            default: message+=e.getKeyChar(); boo=true; // If other keys were pressed, put them into the string container.
          }
          repaint();
        }
      });
    }

    @Override
    protected void paintComponent(Graphics g) {
      if(boo){
        super.paintComponent(g);
        g.drawString(String.valueOf(message), x, y); 
      }
    }
  }
}
