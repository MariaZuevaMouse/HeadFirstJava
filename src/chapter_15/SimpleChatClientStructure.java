package chapter_15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClientStructure {
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    public void go(){
        //создаем GUI и подключаем слушатель для событий
        //к кнопке отправки
        //Вызываем метод SetUpNetwork()
    }
    private void setUpNetworking(){
        //создаем сокет и Print writer
        // присваиваем PrintWritter переменной writter
    }
    public class SendButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            //получаем ьекст из текстового поля и отправляем
            //его на сервер с помощью переменной writer
        }
    }

}
