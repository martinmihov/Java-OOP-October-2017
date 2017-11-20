package online_radio_database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongDatabase {
    private List<Song> songList;

    public SongDatabase() {
        this.songList = new ArrayList<>();
    }

    public List<Song> getSongList() {
        return Collections.unmodifiableList(this.songList);
    }

    public void addSong(Song song) {
        this.songList.add(song);
    }

    public String getTotalLengthOfSongs() {
        int tempMinutes = 0;
        int tempSeconds = 0;
        for (Song song : this.songList) {
            String length = song.getLength();

            String[] lengthTokens = length.split(":");

            tempMinutes += Integer.parseInt(lengthTokens[0]);
            tempSeconds += Integer.parseInt(lengthTokens[1]);
        }
        int hours = 0;
        int minutes = 0;
        int seconds;

        if(tempSeconds > 59) {
            seconds = tempSeconds % 60;
            tempMinutes += tempSeconds / 60;
        } else {
            seconds = tempSeconds;
        }

        if(tempMinutes > 59) {
            minutes += tempMinutes % 60;
            hours += tempMinutes / 60;
        } else {
            minutes = tempMinutes;
        }

        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }
}