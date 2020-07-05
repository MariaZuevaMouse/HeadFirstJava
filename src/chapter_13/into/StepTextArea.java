package chapter_13.into;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepTextArea implements ActionListener {
    JTextArea text;
    public static void main(String[] args) {
        StepTextArea gui = new StepTextArea();
        gui.go();
    }
    public void go(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Jast click it");
        button.addActionListener((ActionListener) this);
        text = new JTextArea(10,20);
        text.setLineWrap(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.getContentPane().add(BorderLayout.SOUTH,button);

        frame.setSize(350,300);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ev){
        text.append("button clicked \n");
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
}
