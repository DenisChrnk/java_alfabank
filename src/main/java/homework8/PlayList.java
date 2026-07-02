package homework8;

import java.util.ArrayList;

public class PlayList {
    String playListName;
    ArrayList<String> playList;

    public PlayList(String playListName) {
        this.playListName = playListName;
        this.playList = new ArrayList<>();
    }

    public void addToPlayList(String songTitle) {
        playList.add(songTitle);
        System.out.println("Добавлена песня: " + songTitle);
    }

    public void deleteMusicFromPlayList(int id) {
        System.out.println("Удалена песня: " + playList.get(id));
        playList.remove(id);
    }

    public void updateSong(int id, String song) {
        System.out.println("Обновлена песяна: " + playList.get(id) + " на " + song);
        playList.set(id, song);
    }

    public String getSong(int id) {
        String song = playList.get(id);
        System.out.println(song);
        return song;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playListName='" + playListName + '\'' +
                ", playList=" + playList +
                '}';
    }
}
