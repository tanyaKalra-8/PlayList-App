import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Udd gaye", "Ritviz");
        album1.addSongToAlbum("Song 1", 5.3);
        album1.addSongToAlbum("song 2", 4.3);
        album1.addSongToAlbum("song 3", 3.4);

        Album album2 = new Album("Moosa", "Sidhu Moosewala");
        album2.addSongToAlbum("old school", 5.3);
        album2.addSongToAlbum("Same beef", 4.3);
        album2.addSongToAlbum("So high", 3.4);

        List<Song> myPlaylist = new LinkedList<>();
        System.out.println(album2.addSongToPlaylistFromAlbum("old school", myPlaylist));
        System.out.println(album1.addSongToPlaylistFromAlbum(2,myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum("Same beef", myPlaylist));

        play(myPlaylist);
    }

    private static void play(List<Song> myPlaylist) {

        ListIterator<Song> itr = myPlaylist.listIterator();

        if(myPlaylist.size()==0){
            System.out.println("Playlist is empty");
            return;
        }

        System.out.println("Currently playing: ");
        System.out.println(itr.next());

        Scanner sc = new Scanner(System.in);
        printMenu();
        boolean isNext = true;
//        if(itr.hasPrevious()){
//            itr.previous();
//        }

        while(true){
            System.out.println("Enter your choice or Enter 6 to open Menu");
            int choice = sc.nextInt();

            switch (choice){

                case 1:
                    if(!isNext){
                        itr.next();
                        isNext=true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                        isNext=true;
                    }
                    else System.out.println("You have reached the end of the list");
                    break;

                case 2:
                    if(isNext){
                        itr.previous();
                        isNext=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing");
                        System.out.println(itr.previous());
                        isNext=false;
                    }
                    else System.out.println("You are on the first song of the list");
                    break;

                case 3:
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing: ");
                        System.out.println(itr.previous());
                        itr.next();
                    }
                    else{
                        System.out.println("No song is playing currently");
                    }
                    break;

                case 4:
                    if(itr.hasPrevious()){
                        delete(itr.previous(), myPlaylist);
                        System.out.println("Current song is removed from your playList");
                    }
                    else{
                        System.out.println("No song is playing currently");
                    }
                    break;

                case 5:
                    printAllSongs(myPlaylist);
                    break;

                case 6:
                    printMenu();
                    break;

                case 7: // exit
                    return;
            }
        }
    }

    private static void delete(Song song, List<Song> myPlaylist) {
        myPlaylist.remove(song);
        return;
    }


    static void printAllSongs(List<Song> playlist){
        for(Song s: playlist){
            System.out.println(s);
        }
    }
    static void printMenu(){

        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Play current song again");
        System.out.println("4. Delete current song");
        System.out.println("5. Show all songs");
        System.out.println("6. Print the entire menu");
        System.out.println("7. Exit");
    }
}