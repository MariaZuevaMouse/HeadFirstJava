package chapter_18.rmi.client;

import chapter_18.rmi.server.MyRemote;

import java.rmi.Naming;

public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }
    public void go(){
        try{
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");
            String s = service.sayHello();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
