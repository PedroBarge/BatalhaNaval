public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        System.out.println("Batalha Naval");

        System.out.println("Building a new frame: ");
        frame.makeNewFrame();
        frame.buildFrame();
        System.out.println("Building a new frame with boats RANDOM ");
        frame.updateFrameCPU();
        frame.buildFrame();
        System.out.println("Building a new frame with boats PLAYER ");
        frame.makeNewFrame();
        frame.updateFramePlayer();
        frame.buildFrame();
        //-----
        System.out.println("Menu");
        System.out.println("1- CPU vs Player");
        System.out.println("2- Player vs Player");

    }
}