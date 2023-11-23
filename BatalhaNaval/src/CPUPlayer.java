import java.util.*;

public class CPUPlayer extends Frame {
    Frame map = new Frame();
    static Scanner scanner = new Scanner(System.in);
    ArrayList<String> playerGuesses = new ArrayList<>();

    public void startCpuPlayer() throws InterruptedException {
        int boatsLeft = 5;
        //constroi o mapa do cpu
        map.makeNewFrame();
        map.updateFrameCPU();
        Main.cleanConsole();
        System.out.println(colors.bold + colors.yellow + "CPU vs Player");
        System.out.println("The CPU will make a map and the player need to guess all the boats" + colors.resetColor);


        // constroi mapa do player
        System.out.println(colors.lightYellow + "Insert here your guess");
        System.out.println("Player guess" + colors.resetColor);
        map.makeNewFramePlayer();
        map.buildFramePlayerVsCPU();

        // começa o jogo
        while (boatsLeft > 0) {
            try {

                System.out.println(colors.lightYellow + "Player guess");
                System.out.print("Insert line: ");
                int linePlayer = scanner.nextInt();
                System.out.print("Insert column: " + colors.resetColor);
                int columnPlayer = scanner.nextInt();

                String guess = linePlayer + "," + columnPlayer;
                if (playerGuesses.contains(guess)) {
                    System.out.println(colors.red + "You've already guessed this position. Try again.\n" +colors.resetColor);
                    continue;
                }

                map.guessPlayerVsCPU(linePlayer, columnPlayer);
                playerGuesses.add(guess);

                if (map.framePlayer[linePlayer][columnPlayer].equals(map.shipEmoji)) {
                    boatsLeft--;
                    System.out.println(colors.blue + "Boats left: " + boatsLeft + "\n" + colors.resetColor);
                }

            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                scanner.nextLine();
                System.out.println(colors.red + "Please, only insert the right numbers\n" + colors.resetColor);
            }
            if (boatsLeft == 0) {
                System.out.println(colors.yellow + colors.bold + "CPU map" + colors.resetColor);
                map.buildFrame();
                Thread.sleep(2000);
            }

        }
    }
}
