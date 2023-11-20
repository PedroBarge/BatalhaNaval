import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Frame {
    String[][] frame = new String[5][5];
    String[][] framePlayer = new String[5][5];
    String[][] trysFramePlayer1 = new String[5][5];
    String[][] trysFramePlayer2 = new String[5][5];
    static Scanner scan = new Scanner(System.in);

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

            while (Objects.equals(frame[line][column], " O ")) {
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

    //Frame player vs player
    public void makeNewFrameTrysPlayer1() {
        for (int i = 0; i < trysFramePlayer1.length; i++) {
            for (int j = 0; j < trysFramePlayer1.length; j++) {
                trysFramePlayer1[i][j] = " ~ ";
            }
        }
    }

    public void makeNewFrameTrysPlayer2() {
        for (int i = 0; i < trysFramePlayer2.length; i++) {
            for (int j = 0; j < trysFramePlayer2.length; j++) {
                trysFramePlayer2[i][j] = " ~ ";
            }
        }
    }

    public void buildTrysFramePlayer1() {
        System.out.println(" 0  1  2  3  4 ");
        System.out.println("---------------");
        for (int i = 0; i < trysFramePlayer1.length; i++) {
            for (int j = 0; j < trysFramePlayer1.length; j++) {
                System.out.print(trysFramePlayer1[i][j]);
            }
            System.out.println(" |" + i);
            System.out.println();
        }
    }

    public void buildTrysFramePlayer2() {
        System.out.println(" 0  1  2  3  4 ");
        System.out.println("---------------");
        for (int i = 0; i < trysFramePlayer2.length; i++) {
            for (int j = 0; j < trysFramePlayer2.length; j++) {
                System.out.print(trysFramePlayer2[i][j]);
            }
            System.out.println(" |" + i);
            System.out.println();
        }
    }

    public void buildFramePlayer1() {
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

    public void buildFramePlayer2() {
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

    public void updateFramePlayer1() {
        scan.nextLine();
        for (int i = 0; i < 5; i++) {

            System.out.println("Enter the line you want a boat to have\nBoat number: " + (i + 1));
            int player1Line = scan.nextInt();
            System.out.println("Enter the column you want a boat to have\nBoat number: " + (i + 1));
            int player1Column = scan.nextInt();
            frame[player1Line][player1Column] = " O ";

        }
        buildFramePlayer1();
    }

    public void updateFramePlayer2() {
        makeNewFramePlayer();
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the line you want a boat to have\nBoat number:" + (i + 1));
            int player2Line = scan.nextInt();
            System.out.println("Enter the column you want a boat to have\nBoat number:" + (i + 1));
            int player2Column = scan.nextInt();
            framePlayer[player2Line][player2Column] = " O ";
        }
        buildFramePlayer2();
    }

    public void guessPlayer1(int linePlayer1, int columnPlayer1) {
        if (framePlayer[linePlayer1][columnPlayer1].equals(" O ")) {
            System.out.println("ON THE BOAT");
            trysFramePlayer1[linePlayer1][columnPlayer1] = " O ";
        } else {
            System.out.println("You miss...");
            trysFramePlayer1[linePlayer1][columnPlayer1] = " X ";

        }
        buildTrysFramePlayer1();
    }

    public void guessPlayer2(int linePlayer2, int columnPlayer2) {
        if (frame[linePlayer2][columnPlayer2].equals(" O ")) {
            System.out.println("ON THE BOAT");
            trysFramePlayer2[linePlayer2][columnPlayer2] = " O ";
        } else {
            trysFramePlayer2[linePlayer2][columnPlayer2] = " X ";
            System.out.println("You miss...");
        }
        buildTrysFramePlayer2();
    }

}