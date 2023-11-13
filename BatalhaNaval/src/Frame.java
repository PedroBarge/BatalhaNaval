import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class Frame {
    Scanner scanner = new Scanner(System.in);
    String[][] frame = new String[5][5];
    String[][] framePlayer = new String[5][5];


    public void makeNewFrame() {
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                frame[i][j] = " ~ ";
            }
        }
    }

    //------------------------------------------------------------------//
    public void buildFrame() {
        System.out.println(" 0  1  2  3  4 ");
        System.out.println("---------------");
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                System.out.print(frame[i][j]);
            }
            System.out.println(" |" + i);
            System.out.println();
        }
    }

    //------------------------------------------------------------------//
    public void updateFrameCPU() {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int line = rand.nextInt(frame.length);
            int column = rand.nextInt(frame[0].length);

            while (frame[line][column] == " O ") {
                line = rand.nextInt(frame.length);
                column = rand.nextInt(frame[0].length);
            }

            frame[line][column] = " O ";
        }
        buildFrame();
    }
    //------------------------------------------------------------------//

    public void makeNewFramePlayer() {
        for (int i = 0; i < framePlayer.length; i++) {
            for (int j = 0; j < framePlayer.length; j++) {
                framePlayer[i][j] = " ~ ";
            }
        }
    }

    public void buildFramePlayer() {
        System.out.println(" 0  1  2  3  4 ");
        System.out.println("---------------");
        for (int i = 0; i < framePlayer.length; i++) {
            for (int j = 0; j < framePlayer.length; j++) {
                System.out.print(framePlayer[i][j]);
            }
            System.out.println(" |" + i);
            System.out.println();
        }
    }

    public void updateFramePlayer(int linePlayer,int columnPlayer) {
        int countBoat = 0;

        framePlayer[linePlayer][columnPlayer] = " O ";
        buildFramePlayer();
        countBoat++;

    }
    //------------------------------------------------------------------//

}
