import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String title;
    private String artist;
    private List<Song> song;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.song = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    //find song
    boolean findSong(String title){
        for (Song songs : song){
            if(songs.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    //add song to album
    String addSongToAlbum(String title, double duration){

        if(findSong(title)==false){
            Song s = new Song(title,duration);
            song.add(s);
            return "Song Added to the Album";
        }
        return "Song already exists";
    }

    //concept
    String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist){
        int index = trackNo -1;
        if(index>=0 && index<this.song.size()){
            playlist.add(this.song.get(index));
            return "Song added to your playlist";
        }
        return "Invalid position of Song";
    }

    //add song to playlist
    String addSongToPlaylistFromAlbum(String title, List<Song> playList){
        if(findSong(title)==true){
            for(Song s: this.song){
                if(s.getTitle().equals(title)){
                    playList.add(s);
                    return "Song added to your playlist";
                }
            }
        }
        return "Song not Present in the playlist";
    }
}
