package OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(console.readLine());
        Playlist playlist = new Playlist();
        for (int i = 0; i < number; i++) {
            String[] input = console.readLine().split(";");

            try {

                String artist = input[0];
                String name = input[1];
                String[] minutesSeconds = input[2].split(":");
                String minutesString = minutesSeconds[0];
                String secondsString = minutesSeconds[1];

                Song song = new Song(artist, name, minutesString, secondsString);
                playlist.setPlaylist(song);
                System.out.println("Song added.");
            }
            catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        System.out.println("Songs added: "+playlist.getPlaylist().size());
        System.out.println(playlist.totalPlayerListLenght());
    }
}
