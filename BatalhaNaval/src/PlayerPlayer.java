import java.util.Scanner;

public class PlayerPlayer {
    static Scanner scan = new Scanner(System.in);
    Frame map = new Frame();

    public void startGamePP() {

        int boatsLeftPlayer1 = 5;
        int boatsLeftPlayer2 = 5;
        map.makeNewFrame();
        //constroi o mapa do player 1
        System.out.println("Player vs Player");
        System.out.println("The player1 and player2 will make a map and both players need to get all the boats");
        System.out.println("Player 1 Map");
        map.updateFramePlayer1();
        //constroi o mapa do player 2
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        System.out.println("Player 2 Map");
        map.updateFramePlayer2();

        map.makeNewFrameTrysPlayer1();
        map.makeNewFrameTrysPlayer2();
        while (boatsLeftPlayer1 > 0 && boatsLeftPlayer2 > 0) {
            System.out.println("Player 1 guess");
            System.out.print("Insert line ");
            int linePlayer1 = scan.nextInt();
            System.out.print("Insert column ");
            int columnPlayer1 = scan.nextInt();
            map.guessPlayer1(linePlayer1, columnPlayer1);
            if (map.framePlayer[linePlayer1][columnPlayer1].equals(" O ")) {
                boatsLeftPlayer1--;
                System.out.println("Boats left: " + boatsLeftPlayer1 + "\n");
            }
            System.out.println("Player 2 guess");
            System.out.print("Insert line ");
            int linePlayer2 = scan.nextInt();
            System.out.print("Insert column ");
            int columnPlayer2 = scan.nextInt();
            map.guessPlayer2(linePlayer2, columnPlayer2);
            if (map.frame[linePlayer2][columnPlayer2].equals(" O ")) {
                boatsLeftPlayer2--;
                System.out.println("Boats left: " + boatsLeftPlayer2 + "\n");
            }
        }
        map.makeNewFrame();
    }
}
