import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CPUPlayer extends Frame {
    Frame frame = new Frame();
    static Scanner scanner = new Scanner(System.in);

    public void startCpuPlayer() {
        int boatsLeft = 5;
        //constroi o mapa do cpu
        frame.makeNewFrame();
        System.out.println("CPU vs Player");
        System.out.println("The CPU will make a map and the player need to get all the boats");
        frame.buildFrame();
        System.out.println("CPU");
        frame.updateFrameCPU();

        // constroi mapa do player
        System.out.println("Player guess");
        frame.makeNewFramePlayer();
        frame.buildFramePlayer();

        while (boatsLeft>0){
            System.out.println("Player guess");
            System.out.print("Insert line ");
            int linePlayer = scanner.nextInt();
            System.out.print("Insert column ");
            int columnPlayer = scanner.nextInt();
            frame.updateFramePlayer(linePlayer,columnPlayer);
        }
    }
}
