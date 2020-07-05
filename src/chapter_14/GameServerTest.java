package chapter_14;

import java.io.*;

public class GameServerTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"luk", "mech","kostet"});
        GameCharacter two = new GameCharacter(120, "Mag", new String[]{"golie ruki", "bolshoy topor"});
        GameCharacter three = new GameCharacter(200, "Troll", new String[]{"zaklinaniya", "nevidimost"});

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        one = null;
        two = null;
        three = null;

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();


            System.out.println("First type is " + oneRestore.getType());
            System.out.println("second type is " + twoRestore.getType());
            System.out.println("third type is " + threeRestore.getType());
        }catch (Exception ex){ex.printStackTrace();}

    }
}

