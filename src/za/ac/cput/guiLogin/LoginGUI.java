package za.ac.cput.guiLogin;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LoginGUI {

    public static void main(String[] args) {

        User userObject = new User();
        userObject.setSize(400, 200);
        userObject.setVisible(true);
        userObject.setDefaultCloseOperation(EXIT_ON_CLOSE);
        userObject.setGui();
    }

}
