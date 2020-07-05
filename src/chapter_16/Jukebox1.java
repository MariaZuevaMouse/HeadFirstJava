package chapter_16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Jukebox1 {
    ArrayList<String> songList = new ArrayList<>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }
    public void go(){
        getSong();
        System.out.println(songList);
        Collections.sort(songList);

        System.out.println(songList);
    }
    void getSong(){
        try{
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                addSong(line);
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
    void addSong(String lineToPars){
        String[] tokens = lineToPars.split("/");
        songList.add(tokens[0]);
    }
}
