import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    //------------------------------------------------------------------//
    static CPUPlayer cpuPlayer = new CPUPlayer();

    //------------------------------------------------------------------//
    public static void main(String[] args) {
        int choiceMenu = 1;
        while (choiceMenu != 0) {
            System.out.println("Menu");
            System.out.println("1- CPU vs Player \n2- Player vs Player \n0- Close");
            choiceMenu = scanner.nextInt();

            switch (choiceMenu) {
                case 1:
                    cpuPlayer.startCpuPlayer();
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Closing...");
                    break;
                default:
            }
        }
    }
}