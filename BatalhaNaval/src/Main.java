public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Boats boats= new Boats();
        System.out.println("Batalha Naval");

        frame.makeNewFrame();
        frame.buildFrame();
        boats.createBoat();
        frame.updateFrame();
        frame.buildFrame();

    }
}