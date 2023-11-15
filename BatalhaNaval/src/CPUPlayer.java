import java.util.InputMismatchException;
import java.util.Scanner;

public class CPUPlayer extends Frame {
    Frame map = new Frame();
    static Scanner scanner = new Scanner(System.in);

    public void startCpuPlayer() {
        int boatsLeft = 5;
        //constroi o mapa do cpu
        map.makeNewFrame();
        System.out.println("CPU vs Player");
        System.out.println("The CPU will make a map and the player need to guess all the boats");
        //System.out.println("CPU");
        map.updateFrameCPU();

        // constroi mapa do player
        System.out.println("Insert here your guess");
        System.out.println("Player guess");
        map.makeNewFramePlayer();
        map.buildFramePlayerVsCPU();

        // começa o jogo
        while (boatsLeft > 0) {
            try {
                System.out.println("Player guess");
                System.out.print("Insert line ");
                int linePlayer = scanner.nextInt();
                System.out.print("Insert column ");
                int columnPlayer = scanner.nextInt();
                map.guessPlayerVsCPU(linePlayer, columnPlayer);
                if (map.framePlayer[linePlayer][columnPlayer].equals(" O ")) {
                    boatsLeft--;
                    System.out.println("Boats left: " + boatsLeft + "\n");
                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                scanner.nextLine();
                System.out.println("Please, only insert the right numbers\n");
            }
        }
        map.buildFrame();
    }
}
