import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class PlayerPlayer {
    static Scanner scan = new Scanner(System.in);
    Frame map = new Frame();
    Set<String> player1Guesses = new HashSet<>();
    Set<String> player2Guesses = new HashSet<>();

    public void startGamePP() throws InterruptedException {

        int boatsLeftPlayer1 = 5;
        int boatsLeftPlayer2 = 5;
        map.makeNewFrame();
        //constroi o mapa do player 1
        System.out.println("Player vs Player");
        System.out.println("The player1 and player2 will make a map and both players need to get all the boats");
        System.out.println("Player 1 Map");

        map.updateFramePlayer1();

        cleanConsole();
        //constroi o mapa do player 2
        System.out.println("Player 2 Map");
        map.updateFramePlayer2();
        cleanConsole();

        map.makeNewFrameTrysPlayer1();
        map.makeNewFrameTrysPlayer2();
        while (boatsLeftPlayer1 > 0 || boatsLeftPlayer2 > 0) {
            try {
                boolean canContinuePlayer1 = false;
                while (!canContinuePlayer1) {
                    System.out.println("Player 1 guess");
                    System.out.print("Insert line ");
                    int linePlayer1 = scan.nextInt();
                    System.out.print("Insert column ");
                    int columnPlayer1 = scan.nextInt();
                    String guessPlayer1 = linePlayer1 + "," + columnPlayer1;
                    if (player1Guesses.contains(guessPlayer1)) {
                        System.out.println("You've already guessed this position. Try again.\n");
                    } else {
                        map.guessPlayer1(linePlayer1, columnPlayer1);
                        player1Guesses.add(guessPlayer1);
                        if (map.framePlayer[linePlayer1][columnPlayer1].equals(map.shipEmoji)) {
                            boatsLeftPlayer1--;
                            System.out.println("Boats left: " + boatsLeftPlayer1 + "\n");
                        }
                        canContinuePlayer1 = true;
                    }
                }
                boolean canContinuePlayer2 = false;
                while (!canContinuePlayer2) {
                    System.out.println("Player 2 guess");
                    System.out.print("Insert line ");
                    int linePlayer2 = scan.nextInt();
                    System.out.print("Insert column ");
                    int columnPlayer2 = scan.nextInt();
                    //verificação se já tem guesses
                    String guessPlayer2 = linePlayer2 + "," + columnPlayer2;
                    if (player2Guesses.contains(guessPlayer2)) {
                        System.out.println("You've already guessed this position. Try again.\n");
                    } else {
                        map.guessPlayer2(linePlayer2, columnPlayer2);
                        player2Guesses.add(guessPlayer2);
                        if (map.frame[linePlayer2][columnPlayer2].equals(map.shipEmoji)) {
                            boatsLeftPlayer2--;
                            System.out.println("Boats left: " + boatsLeftPlayer2 + "\n");
                        }
                        canContinuePlayer2 = true;
                    }
                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                scan.nextLine();
                System.out.println("Please, only insert the right numbers\n");
                Thread.sleep(2000);
            }
            if (boatsLeftPlayer1 == 0) {
                System.out.println("Player 2 map");
                map.buildFramePlayer2();
                Thread.sleep(2000);
                break;
            }else if(boatsLeftPlayer2 == 0) {
                System.out.println("Player 1 map");
                map.buildFramePlayer1();
                Thread.sleep(2000);
                break;
            }
        }
        map.makeNewFrame();
    }

    public static void cleanConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
