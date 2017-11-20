package online_radio_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countOfSongs = Integer.parseInt(bufferedReader.readLine());

        SongDatabase songDatabase = new SongDatabase();

        while (countOfSongs-- > 0) {
            try {

                String[] songTokens = bufferedReader.readLine().split(";");

                Song song = new Song(songTokens[0], songTokens[1], songTokens[2]);

                songDatabase.addSong(song);

                System.out.println("Song added.");

            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        System.out.println(String.format("Songs added: %d%n%s", songDatabase.getSongList().size(), songDatabase.getTotalLengthOfSongs()));
    }
}
