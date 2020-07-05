package chapter_15;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String[] adviceList = {"Eat less food", "Купите облегающие джинсы", "Два слова - не годиться",
    "будьте честны - хотя бы сегодня", "Возможно стоит сменить прическу"};
    public void go(){
        try{
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true){
                Socket sock = serverSocket.accept();

                PrintWriter writter = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writter.println(advice);
                writter.close();
                System.out.println(advice);
            }
        }catch(IOException ex){ex.printStackTrace();}
    }
    private String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
