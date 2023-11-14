import java.util.Random;
import java.util.Scanner;

public class Frame {
    String[][] frame = new String[5][5];
    String[][] framePlayer = new String[5][5];

    //------------------------------------------------------------------//
    // Frame Vazio
    public void makeNewFrame() {
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                frame[i][j] = " ~ ";
            }
        }
    }
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
    //Mapa do CPU
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
        //buildFrame();
    }
    //------------------------------------------------------------------//
    //Player area
    public void makeNewFramePlayer() {
        for (int i = 0; i < framePlayer.length; i++) {
            for (int j = 0; j < framePlayer.length; j++) {
                framePlayer[i][j] = " ~ ";
            }
        }
    }
    public void buildFramePlayerVsCPU() {
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
    public void guessPlayerVsCPU(int linePlayer, int columnPlayer) {
        if (frame[linePlayer][columnPlayer].equals(" O ")) {
            System.out.println("ON THE BOAT");
            framePlayer[linePlayer][columnPlayer] = " O ";
        } else {
            framePlayer[linePlayer][columnPlayer] = " X ";
            System.out.println("You miss...");
        }
        buildFramePlayerVsCPU();
    }
    //------------------------------------------------------------------//
}
