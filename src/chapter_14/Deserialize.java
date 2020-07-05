package chapter_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {
    FileInputStream fileStream = new FileInputStream("MyGame.ser");

    ObjectInputStream os = new ObjectInputStream(fileStream);

//    Object one = os.readObject();
//    Object two = os.readObject();

//    GameCharacter elf= (GameCharacter) one;
//    GameCharecter troll =(GameCharacter) two;
//
//    os.cLose();


    public Deserialize() throws IOException {
    }
}
