package chapter_16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox3 {
    ArrayList<Song_test> songList = new ArrayList<Song_test>();

    public static void main(String[] args) {
        new Jukebox3().go();
    }
    public void go(){
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }
    void getSongs(){
        try{
            File file = new File("SongList.txt");
            BufferedReader reader =new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                addSong(line);
            }

        }catch (Exception ex){ex.printStackTrace();}
    }
    void addSong(String lineToParse){
        String[] tokens = lineToParse.split("/");
        Song_test nextSong = new Song_test(tokens[0], tokens[1]);
    }

}
