package chapter_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClientA {
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    public void go(){
        //создаем GUI и подключаем слушатель для событий
        //к кнопке отправки
        //Вызываем метод SetUpNetwork()
        JFrame frame = new JFrame("Simple chat client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void setUpNetworking(){
        //создаем сокет и Print writer
        // присваиваем PrintWritter переменной writter
        try{
            sock = new Socket("127.0.0.1", 500);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }catch (IOException ex){ex.printStackTrace();}
    }
    public class SendButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            //получаем ьекст из текстового поля и отправляем
            //его на сервер с помощью переменной writer
            try{
                writer.println(outgoing.getText());
                writer.flush();
            }catch(Exception x){
                x.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }

}
