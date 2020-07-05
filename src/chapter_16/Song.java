package chapter_16;

import java.util.Objects;

public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return title.equals(song.title);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(title);
        return title.hashCode();
    }

    @Override
    public int compareTo(Song o) {
        return title.compareTo(o.getTitle());
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getRating(){
        return rating;
    }
    public String getBpm(){
        return bpm;
    }

    public Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }
}
