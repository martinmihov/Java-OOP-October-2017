package OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> playlist;

    public Playlist() {
        this.playlist = new ArrayList<>();
    }

    public void setPlaylist(Song song) {
        this.playlist.add(song);
    }

    public List<Song> getPlaylist() {
        return this.playlist;
    }

    public String totalPlayerListLenght (){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        for (Song song : getPlaylist()) {
            seconds += song.getSeconds();
        }
        minutes = seconds / 60;
        seconds = seconds % 60;
        for (Song song : getPlaylist()) {
            minutes += song.getMinutes();
        }
        hours = minutes / 60;
        minutes = minutes % 60;

        return "Playlist length: "+hours+"h "+minutes+"m "+seconds+"s";
    }
}
