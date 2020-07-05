package chapter_13.into;

import javax.swing.*;
import java.awt.*;

public class Steps_to_gui extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JButton button = new JButton("click");

        frame.getContentPane().add(BorderLayout.EAST, button);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

}
