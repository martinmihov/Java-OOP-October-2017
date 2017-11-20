package OnlineRadioDatabase;

public class Song {
    private String artist;
    private String song;
    private int minutes;
    private int seconds;

    public Song(String artist, String song, String minutesString, String secondsString) {
        setArtist(artist);
        setSong(song);
        setMinutes(minutesString);
        setSeconds(secondsString);
    }

    private void setArtist(String artist) {
        if (artist.length() >= 3 && artist.length() <= 20) {
            this.artist = artist;
        } else {
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
    }

    private void setSong(String song) {
        if (song.length() >= 3 && song.length() <= 30) {
            this.song = song;
        } else {
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
    }

    public int getMinutes() {
        return minutes;
    }

    private void setMinutes(String minutesString) {
        if (!minutesString.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid song length.");
        }
        int minutes = Integer.parseInt(minutesString);
        if (minutes < 0 || minutes > 14) {
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }

        this.minutes = minutes;
    }

    private void setSeconds(String secondsString) {
        if (!secondsString.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid song length.");
        }
        int seconds = Integer.parseInt(secondsString);

        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }

        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }
}
