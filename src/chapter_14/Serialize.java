package chapter_14;

import java.io.*;

public class Serialize<characterOne> {
    FileOutputStream fileStream = new FileOutputStream("MyGame.ser");

    ObjectOutputStream os = new ObjectOutputStream(fileStream);
    character characterOne = new character();

//    os.writeObject(characterOne);
//    os.writeObject(characterTwo);
//
//    os.close();

    public Serialize() throws IOException {
    }
}
class character implements Serializable{
    public character() {
    }
}
