package chapter_16;

import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;

public class Song_test implements Comparable{
    private String songName;
    private String songAutor;

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongAutor(String songAutor) {
        this.songAutor = songAutor;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongAutor() {
        return songAutor;
    }

    public Song_test(String songName) {
    }

    public Song_test(String songName, String songAutor) {
        this.songName = songName;
        this.songAutor = songAutor;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
}
