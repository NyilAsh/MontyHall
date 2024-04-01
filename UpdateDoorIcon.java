import javax.swing.*;
import java.util.Random;
/*
UpdateDoorIcon: This class extends the MontyHall class
and is responsible for updating the icons on the doors to show whether the player has won a car or a goat.
It contains a static method, updateDoorIcon, that takes the user's choice
and the location of the car door as arguments and updates the game's GUI.
*/
public class UpdateDoorIcon extends MontyHall{
    public static void updateDoorIcon(int userChoice, int carDoor) {
        if (userChoice == carDoor) {
            if (carDoor == 1) {
                door1Button.setIcon(new ImageIcon("car.png"));
                announcerButton.setText("You won the car!");
            } else if (carDoor == 2) {
                door2Button.setIcon(new ImageIcon("car.png"));
                announcerButton.setText("You won the car!");
            } else if (carDoor == 3) {
                door3Button.setIcon(new ImageIcon("car.png"));
                announcerButton.setText("You won the car!");
            }
        } else {
            if (userChoice == 1) {
                door1Button.setIcon(new ImageIcon("Goat.jpg"));
                announcerButton.setText("You chose wrong, You did not win the car!");
            } else if (userChoice == 2) {
                door2Button.setIcon(new ImageIcon("Goat.jpg"));
                announcerButton.setText("You chose wrong, You did not win the car!");
            } else if (userChoice == 3) {
                door3Button.setIcon(new ImageIcon("Goat.jpg"));
                announcerButton.setText("You chose wrong, You did not win the car!");
            }
        }
    }
}