import java.util.ArrayList;
import java.util.Scanner;

public class Boats {
    String name;

    Scanner scanner = new Scanner(System.in);

    ArrayList<String> boatsArray = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void createBoat() {
        boatsArray.add("X");
        System.out.println("This boats ar already in game:");
        for (int i = 0; i < boatsArray.size(); i++) {
            System.out.print(boatsArray.get(i));
        }
        System.out.println();
        System.out.println("Place a boat");
        System.out.println("Yes or No");
        String boatYN = scanner.next().toLowerCase();
        if (boatYN.equals("yes") || boatYN.equals("y")) {
            setName(boatYN);
            boatsArray.add(boatYN);
        }else System.out.println("Boat will not be add");
    }

}
