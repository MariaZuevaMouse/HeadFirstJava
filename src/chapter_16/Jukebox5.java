package chapter_16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jukebox5 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox5().go();
    }
    class ArtistCompare implements Comparator<Song>{
        @Override
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }
    public void go(){
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList,artistCompare);
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
