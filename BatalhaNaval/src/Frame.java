import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class Frame {
    Scanner scanner = new Scanner(System.in);
    String[][] frame = new String[5][5];

    public void makeNewFrame() {
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                frame[i][j] = " ~ ";
            }
        }
    }

    public void buildFrame() {
        System.out.println(" 0  1  2  3  4  5 ");
        System.out.println("-----------------------------");
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                System.out.print(frame[i][j]);
            }
            System.out.println(" |" + i);
            System.out.println();
        }
    }

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
    }

    public void updateFramePlayer() {
        int countBoat = 0;
        
        System.out.println("Insert line");
        int linePlayer = scanner.nextInt();
        System.out.println("Insert column");
        int columnPlayer = scanner.nextInt();

        frame[linePlayer][columnPlayer] = " O ";

    }


}
