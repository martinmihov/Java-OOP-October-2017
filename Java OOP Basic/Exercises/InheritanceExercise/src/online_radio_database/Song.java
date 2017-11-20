package online_radio_database;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    public String getLength() {
        return this.length;
    }

    private void setArtistName(String artistName) {
        if (artistName == null || artistName.trim().length() < 3 || artistName.trim().length() > 20) {
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName == null || songName.trim().length() < 3 || songName.trim().length() > 30) {
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
            this.songName = songName;
    }

    private void setLength(String length) {
        if (this.getMinutes(length) == -1 || this.getMinutes(length) == -1) {
            throw new IllegalArgumentException("Invalid song length.");
        }
        if (this.getMinutes(length) < 0 || this.getMinutes(length) > 14) {
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
        if (this.getSeconds(length) < 0 || this.getSeconds(length) > 59) {
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        this.length = length;
    }

    private int getSeconds(String length) {

        String[] lengthArgs = length.split(":");

        if(lengthArgs[lengthArgs.length - 1].trim().matches("\\d+")) {
            return Integer.parseInt(lengthArgs[lengthArgs.length - 1]);
        }

        return -1;
    }

    private int getMinutes(String length) {

        String[] lengthArgs = length.split(":");

        if(lengthArgs[lengthArgs.length - 2].trim().matches("\\d+")) {
            return Integer.parseInt(lengthArgs[lengthArgs.length - 2]);
        }

        return -1;
    }
}