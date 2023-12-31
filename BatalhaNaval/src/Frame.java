import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Frame {
    String[][] frame = new String[5][5];
    String[][] framePlayer = new String[5][5];
    String[][] trysFramePlayer1 = new String[5][5];
    String[][] trysFramePlayer2 = new String[5][5];
    static Scanner scan = new Scanner(System.in);
    public String shipEmoji = " \uD83D\uDEA2 ";
    public String seaEmoji = " \uD83C\uDF0A ";
    public String bombEmoji = " \uD83D\uDCA5 ";
    //------------------------------------------------------------------//
    Colors colors = new Colors();

    //------------------------------------------------------------------//
    // Frame Vazio
    public void makeNewFrame() {
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                frame[i][j] = seaEmoji;
            }
        }
    }

    public void buildFrame() {
        System.out.println(colors.brightBlueColor + " 0   1   2   3   4 ");
        System.out.println("---------------------");
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                System.out.print(frame[i][j]);
            }
            System.out.println(colors.brightBlueColor + " |" + i + colors.resetColor);
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

            while (Objects.equals(frame[line][column], shipEmoji)) {
                line = rand.nextInt(frame.length);
                column = rand.nextInt(frame[0].length);
            }
            frame[line][column] = shipEmoji;
        }
        System.out.println(colors.yellow + colors.bold + "CPU map" + colors.resetColor);
        buildFrame();
    }

    //------------------------------------------------------------------//
    //Player area
    public void makeNewFramePlayer() {
        for (int i = 0; i < framePlayer.length; i++) {
            for (int j = 0; j < framePlayer.length; j++) {
                framePlayer[i][j] = seaEmoji;
            }
        }
    }

    public void buildFramePlayerVsCPU() {
        System.out.println(colors.brightBlueColor + " 0   1   2   3   4 ");
        System.out.println("---------------------");
        for (int i = 0; i < framePlayer.length; i++) {
            for (int j = 0; j < framePlayer.length; j++) {
                System.out.print(framePlayer[i][j]);
            }
            System.out.println(colors.brightBlueColor + " |" + i + colors.resetColor);
            System.out.println();
        }
    }

    public void guessPlayerVsCPU(int linePlayer, int columnPlayer) {
        if (frame[linePlayer][columnPlayer].equals(shipEmoji)) {
            System.out.println(colors.green + "ON THE BOAT" + colors.resetColor);
            framePlayer[linePlayer][columnPlayer] = shipEmoji;
        } else {
            framePlayer[linePlayer][columnPlayer] = bombEmoji;
            System.out.println(colors.orange + "You miss..." + colors.resetColor);
        }
        buildFramePlayerVsCPU();
    }

    //------------------------------------------------------------------//

    //Frame player vs player
    public void makeNewFrameTrysPlayer1() {
        for (int i = 0; i < trysFramePlayer1.length; i++) {
            for (int j = 0; j < trysFramePlayer1.length; j++) {
                trysFramePlayer1[i][j] = seaEmoji;
            }
        }
    }

    public void makeNewFrameTrysPlayer2() {
        for (int i = 0; i < trysFramePlayer2.length; i++) {
            for (int j = 0; j < trysFramePlayer2.length; j++) {
                trysFramePlayer2[i][j] = seaEmoji;
            }
        }
    }

    public void buildTrysFramePlayer1() {
        System.out.println(colors.brightBlueColor + " 0   1   2   3   4 ");
        System.out.println("---------------------");
        for (int i = 0; i < trysFramePlayer1.length; i++) {
            for (int j = 0; j < trysFramePlayer1.length; j++) {
                System.out.print(trysFramePlayer1[i][j]);
            }
            System.out.println(colors.brightBlueColor + " |" + i + colors.resetColor);
            System.out.println();
        }
    }

    public void buildTrysFramePlayer2() {
        System.out.println(colors.brightBlueColor + " 0   1   2   3   4 ");
        System.out.println("---------------------");
        for (int i = 0; i < trysFramePlayer2.length; i++) {
            for (int j = 0; j < trysFramePlayer2.length; j++) {
                System.out.print(trysFramePlayer2[i][j]);
            }
            System.out.println(colors.brightBlueColor + " |" + i + colors.resetColor);
            System.out.println();
        }
    }

    public void buildFramePlayer1() {
        System.out.println(colors.brightBlueColor + " 0   1   2   3   4 ");
        System.out.println("---------------------");
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                System.out.print(frame[i][j]);
            }
            System.out.println(colors.brightBlueColor + " |" + i + colors.resetColor);
            System.out.println();
        }
    }

    public void buildFramePlayer2() {
        System.out.println(colors.brightBlueColor + " 0   1   2   3   4 ");
        System.out.println("---------------------");
        for (int i = 0; i < framePlayer.length; i++) {
            for (int j = 0; j < framePlayer.length; j++) {
                System.out.print(framePlayer[i][j]);
            }
            System.out.println(colors.brightBlueColor + " |" + i + colors.resetColor);
            System.out.println();
        }
    }

    public void updateFramePlayer1() {
        // TODO: 22/11/2023 Falta fazer trycatch de outofbound, aceita no linePlayer mas nao no columnPlayer.
        makeNewFrame();
        for (int i = 0; i < 5; i++) {
            System.out.println(colors.lightYellow + "Enter the line you want a boat to have\nBoat number: " + (i + 1));
            int player1Line = scan.nextInt();
            System.out.println("Enter the column you want a boat to have\nBoat number: " + (i + 1) + colors.resetColor);
            int player1Column = scan.nextInt();
            if (frame[player1Line][player1Column].equals(shipEmoji)) {
                System.out.println(colors.red + "You've already guessed this position. Try again.\n" + colors.resetColor);
                i -= 1;
            } else {
                frame[player1Line][player1Column] = shipEmoji;
            }
        }
        buildFramePlayer1();
    }

    public void updateFramePlayer2() {
        // TODO: 22/11/2023 Falta fazer trycatch de outofbound, aceita no linePlayer mas nao no columnPlayer.
        makeNewFramePlayer();
        for (int i = 0; i < 5; i++) {
            System.out.println(colors.lightYellow + "Enter the line you want a boat to have\nBoat number:" + (i + 1) + colors.resetColor);
            int player2Line = scan.nextInt();
            System.out.println(colors.lightYellow + "Enter the column you want a boat to have\nBoat number:" + (i + 1) + colors.resetColor);
            int player2Column = scan.nextInt();
            if (framePlayer[player2Line][player2Column].equals(shipEmoji)) {
                System.out.println(colors.red + "You've already guessed this position. Try again.\n" + colors.resetColor);
                i -= 1;
            } else {
                framePlayer[player2Line][player2Column] = shipEmoji;
            }
        }
        buildFramePlayer2();
    }

    public void guessPlayer1(int linePlayer1, int columnPlayer1) {
        if (framePlayer[linePlayer1][columnPlayer1].equals(shipEmoji)) {
            System.out.println(colors.blue + "ON THE BOAT" + colors.resetColor);
            trysFramePlayer1[linePlayer1][columnPlayer1] = shipEmoji;
        } else {
            System.out.println(colors.red + "You miss..." + colors.resetColor);
            trysFramePlayer1[linePlayer1][columnPlayer1] = bombEmoji;

        }
        buildTrysFramePlayer1();
    }

    public void guessPlayer2(int linePlayer2, int columnPlayer2) {
        if (frame[linePlayer2][columnPlayer2].equals(shipEmoji)) {
            System.out.println(colors.blue + "ON THE BOAT" + colors.resetColor);
            trysFramePlayer2[linePlayer2][columnPlayer2] = shipEmoji;
        } else {
            trysFramePlayer2[linePlayer2][columnPlayer2] = bombEmoji;
            System.out.println(colors.red + "You miss..." + colors.resetColor);
        }
        buildTrysFramePlayer2();
    }

}