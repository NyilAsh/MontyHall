import javax.swing.*;
import java.awt.*;
import java.util.Random;
/*
MontyHall: This is the main class that creates the GUI and handles user input.
It contains the main method, which creates an instance of the class and starts the simulation.
The MontyHall class also contains several private variables and methods that are used to handle the logic of the game,
including choosing the car door and opening a goat door.
 */
public class MontyHall implements DoorController, MontyHallGUI{
    private final Random random = new Random();
    public static final int NUM_OF_DOORS = 3;
    public int carDoor = random.nextInt(NUM_OF_DOORS) + 1;
    public int userChoice;
    public static JButton door1Button;
    public static JButton door2Button;
    public static JButton door3Button;
    public static JTextField announcerButton = new JTextField();
    ImageIcon door1Icon;
    ImageIcon door2Icon;
    ImageIcon door3Icon;
    ImageIcon YesIcon;
    ImageIcon NoIcon;
    MontyHall() {
// Assigning Icons
        setDoorIcons();
        YesIcon = new ImageIcon("YES.jpg");
        NoIcon = new ImageIcon("NO.jpg");
// Creating Doors and assigning user choice as numbers
        DoorSelect();
//End door creation
//Yes No Selection
        JButton yesButton = new JButton(YesIcon);
        yesButton.addActionListener(e -> {
            userChoice = SwitchDoorSelect(GoatDoor.openGoatDoor(userChoice, carDoor), userChoice);
            UpdateDoorIcon.updateDoorIcon(userChoice, carDoor);
        });
        JButton noButton = new JButton(NoIcon);
        noButton.addActionListener(e -> UpdateDoorIcon.updateDoorIcon(userChoice, carDoor));

//End Yes No Selection
//Start Announcer GUI
        setAnnouncerButton("Announcer: Welcome to the game show! Select the door (1, 2, or 3): ");
        AnnouncerButtonGUI();
//End of Announcer GUI
        JFrame frame = new JFrame("Monty Hall");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel doorsPanel = new JPanel(new GridLayout(1, 3));
        doorsPanel.add(door1Button);
        doorsPanel.add(door2Button);
        doorsPanel.add(door3Button);
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.add(yesButton);
        buttonsPanel.add(noButton);
        frame.add(doorsPanel, BorderLayout.NORTH);
        frame.add(buttonsPanel, BorderLayout.CENTER);
        frame.add(announcerButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new MontyHall();
    }
    @Override
    public void DoorSelect() {
        door1Button = new JButton(door1Icon);
        door1Button.addActionListener(e -> {
            userChoice = 1;
            GoatDoor.openGoatDoor(userChoice, carDoor);
            setAnnouncerButton("You chose Door 1 - Do you want to Switch Doors?");
        });
        door2Button = new JButton(door2Icon);
        door2Button.addActionListener(e -> {
            userChoice = 2;
            GoatDoor.openGoatDoor(userChoice, carDoor);
            setAnnouncerButton("You chose Door 2 - Do you want to Switch Doors?");
        });
        door3Button = new JButton(door3Icon);
        door3Button.addActionListener(e -> {
            userChoice = 3;
            GoatDoor.openGoatDoor(userChoice, carDoor);
            setAnnouncerButton("You chose Door 3 - Do you want to Switch Doors?");
        });
    }
    public int SwitchDoorSelect(int goatDoor, int userChoice) {
        int switchDoor;
        do {
            switchDoor = random.nextInt(3) + 1;
            //switchDoor = SwitchDoorSelect();
        }
        while (switchDoor == userChoice || switchDoor == goatDoor);
        return switchDoor;
    }
    @Override
    public void setDoorIcons() {
        door1Icon = new ImageIcon("Door1.jpg");
        door2Icon = new ImageIcon("Door2.jpg");
        door3Icon = new ImageIcon("Door3.jpg");
    }
    @Override
    public void setAnnouncerButton(String announcerButtonText) {
        announcerButton.setText(announcerButtonText);
    }
    @Override
    public void AnnouncerButtonGUI(){
        announcerButton.setBounds(50,50,150,30);
        announcerButton.setForeground(Color.RED);
        Font font = new Font ("Courier New", Font.BOLD,30);
        announcerButton.setFont(font);
        announcerButton.setHorizontalAlignment(SwingConstants.CENTER);
    }
}