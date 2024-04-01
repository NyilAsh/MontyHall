import javax.swing.*;
import java.util.Random;
/*
GoatDoor: This class extends the MontyHall class and is responsible for opening a goat door.
It contains a static method, openGoatDoor, that takes the user's choice and the location of the car door as arguments
and returns the location of the goat door that is revealed.
The method also updates the GUI to show the location of the goat door.
*/

public class GoatDoor extends MontyHall{
    public static int openGoatDoor(int userChoice, int carDoor) {
        int goatDoor;
        Random random = new Random();
        ImageIcon goatIcon = new ImageIcon("Goat.jpg");
        do {
            goatDoor = random.nextInt(NUM_OF_DOORS) + 1;
        }
        while (goatDoor == userChoice || goatDoor == carDoor);
        if (goatDoor == 1) {
            door1Button.setIcon(goatIcon);
        } else if (goatDoor == 2) {
            door2Button.setIcon(goatIcon);
        }
        if (goatDoor == 3) {
            door3Button.setIcon(goatIcon);
        }
        return goatDoor;
    }
}
