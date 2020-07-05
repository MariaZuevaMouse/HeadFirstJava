package chapter12.SimpleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change color");
        button.addActionListener(this);

        MyDrowPanel drowPanel = new MyDrowPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drowPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}
class MyDrowPanel extends JPanel{
    public void paintComponent(Graphics g){
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color (red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }
}
