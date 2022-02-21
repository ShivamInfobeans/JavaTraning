package day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Homework {
    public static void main(String[] args) {

    }
    // genreMaxPlayedSong(List<Song> songs, int k) -> it returns
    // for each genre the top k played songs
    public static void genreMaxPlayedSong(List<Song> songs) {
        HashMap<String, Song> map = new HashMap<>();
        for (Song song : songs) {
            List<String> genres = song.getGenre();
            for (String genre : genres) {
                if (map.containsKey(genre)) {
                    Song preSong = map.get(genre);
                    if (preSong.getPlayCount() < song.getPlayCount()) {
                        map.put(genre, song);
                    }
                } else {
                    map.put(genre, song);
                }
            }
        }
        Set<Map.Entry<String, Song>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            Song song = (Song) entry.getValue();
            System.out.println(entry.getKey() + " -> " + song.getTitle() + "," + song.getPlayCount());
        }
    }
}

class Song {
    String title;
    List<String> genre;
    int playCount;

    public String getTitle() {
        return title;
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<String> getGenre() {
        return genre;
    }

}
/*
Suppose you are given a List of songs.
genre = pop, rock,
write a function that returns for each genre the song that is played
the maximum number of times.

song = {"title-1", 5 , ["pop","rock"]}, {"title-2",6,["pop"]}, {"title-3",4,["rock"]},
{"title-4",4,["pop","rock","classical"]},{"title-5",10,["jazz","pop"],
{"title-6",1,["jazz"]}, {"title-7",6,["jazz"]}
}
output:
pop -> title-2,6
rock -> title-1, 5
}
k=2
Map<String, List<>> function(songList, int k){
output:
pop ->  title-2 , 6 | title-5 , 10
rock -> title-1 ,5 | title-3 , 4
classical -> title-4 , 4
jazz -> title-5 , 10 |title-7,  6


}
 */

/*



 */