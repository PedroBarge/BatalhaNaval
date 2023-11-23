import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    //------------------------------------------------------------------//
    static CPUPlayer cpuPlayer = new CPUPlayer();
    static PlayerPlayer playerPlayer = new PlayerPlayer();
    //------------------------------------------------------------------//
    public static void main(String[] args) throws InterruptedException {
        int choiceMenu = 1;
        while (choiceMenu != 0) {
            try {
                cleanConsole();
                showRules();
                System.out.println("Menu");
                System.out.println("1- CPU vs Player \n2- Player vs Player \n0- Close");
                System.out.print("-> ");
                choiceMenu = scanner.nextInt();

                switch (choiceMenu) {
                    case 1:
                        cleanConsole();
                        cpuPlayer.startCpuPlayer();
                        scanner.nextLine();
                        break;
                    case 2:
                        cleanConsole();
                        playerPlayer.startGamePP();
                        scanner.nextLine();

                        break;
                    case 0:
                        cleanConsole();
                        System.out.println("Closing...");
                        break;
                    default:
                        System.out.println("Invalide option. Try again.");
                        Thread.sleep(2000);
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("An error occurred...\nGoing back to main menu...");
                Thread.sleep(2000);
            }
        }

    }

    public static void cleanConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void showRules() {
        System.out.println("+------------------------------------------------------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t\tRULES");
        System.out.println("\t\t\t\t\t\tThis game is for two players\n");
        System.out.println("""
                \tWhen you choose the option CPU vs Player:\s
                \tThe CPU will make a map for him and you need to guess all the boats\s
                \tWhen you choose the option Player vs Player:\s
                \tBoth players will need to build their own map""");
        System.out.println();
        System.out.println("+------------------------------------------------------------------------------------+");
    }
}