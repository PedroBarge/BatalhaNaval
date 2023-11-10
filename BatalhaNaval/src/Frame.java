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
        System.out.println(" 0  1  2  3  4  5  6  7  8  9");
        System.out.println("-----------------------------");
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                System.out.print(frame[i][0]);
                System.out.print(frame[0][j]);
            }
            System.out.println("|" + i);
            System.out.println();
        }
    }

    public void updateFrame() {
        System.out.println("Insert the line");
        int chooseLine = scanner.nextInt();
        System.out.println("Insert the column");
        int chooseColumn = scanner.nextInt();
        frame[chooseLine][chooseColumn] = " X ";
    }
}
