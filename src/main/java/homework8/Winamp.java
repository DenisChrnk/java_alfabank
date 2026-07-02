package homework8;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Winamp {
    public static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        PlayList playList = new PlayList("Мой плейлист");
        playList.addToPlayList("Супер песня");
        playList.addToPlayList("Песня супер пупер");
        playList.deleteMusicFromPlayList(0);
        playList.updateSong(0, "Не прям супер песня");
        playList.getSong(0);

        System.out.println(playList);
    }
}
