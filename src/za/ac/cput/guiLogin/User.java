package za.ac.cput.guiLogin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
// import static java.lang.String.valueOf; import method to parse from char to String

public class User extends JFrame implements ActionListener {

    private JPanel panelSouth, panelNorth;
    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnClear, btnExit;
    private JMenuItem menLogin, menClear, menExit;
    private Font fnt;

    public User() {

        super("User Authentication");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");

        menLogin = new JMenuItem("Login");
        menClear = new JMenuItem("Clear");
        menExit = new JMenuItem("Exit");

        fileMenu.add(menLogin);
        fileMenu.add(menClear);
        fileMenu.addSeparator();
        fileMenu.add(menExit);

        menuBar.add(fileMenu);

        panelNorth = new JPanel();
        panelSouth = new JPanel();

        lblUsername = new JLabel("Username: ");
        lblPassword = new JLabel("Password: ");
        //lblUsername.setPreferredSize(new Dimension(50, 20)); Not sure what this does
        //lblPassword.setPreferredSize(new Dimension(50, 20));

        txtUsername = new JTextField(10);
        txtPassword = new JPasswordField(10);

        btnLogin = new JButton("Login");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        fnt = new Font("Arial", Font.BOLD | Font.ITALIC, 16);

        btnLogin.setForeground(Color.black);
        btnLogin.setBackground(Color.green);
        btnLogin.setFont(fnt);

        btnClear.setForeground(Color.black);
        btnClear.setBackground(Color.blue);
        btnClear.setFont(fnt);

        btnExit.setForeground(Color.black);
        btnExit.setBackground(Color.red);
        btnExit.setFont(fnt);
    }

    public void setGui() {

        /*this.setLayout(new GridLayout(4, 3));
        
        this.add(lblUsername);
        this.add(txtUsername);
        this.add(lblPassword);
        this.add(txtPassword);
        this.add(btnLogin);
        this.add(btnClear);
        this.add(btnExit);
         */
        lblUsername.setFont(fnt);
        txtUsername.setFont(fnt);
        lblPassword.setFont(fnt);
        txtPassword.setFont(fnt);

        panelNorth.setLayout(new GridLayout(2, 2));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblUsername);
        panelNorth.add(txtUsername);
        panelNorth.add(lblPassword);
        panelNorth.add(txtPassword);

        panelSouth.add(btnLogin);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);
        
        panelNorth.setPreferredSize(new Dimension(25, 79));
        panelSouth.setPreferredSize(new Dimension(20, 40));
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);

        menLogin.addActionListener(this);
        menClear.addActionListener(this);
        menExit.addActionListener(this);

        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

    }

    public boolean Verification(String username, String password) {
        boolean found = false;

        ArrayList<UserInfo> users = new ArrayList<>();

        users.add(new UserInfo("Natheer", "zombies"));
        users.add(new UserInfo("Zaheer", "death"));
        users.add(new UserInfo("Zeenat", "hate"));
        users.add(new UserInfo("Imraan", "marvel"));

        int i = 0;

        while (i < users.size() && !found) {
            if (username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())) {
                found = true;
            } else {
                i++;
            }
        }

        return found;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = txtUsername.getText();
        char[] password = txtPassword.getPassword();
        String sPassword = new String(password);
        //String sPassword = valueOf(password); valueOf import method to parse char[] to String

        if (e.getActionCommand().equals("Login")) {
            if (Verification(username, sPassword)) {
                JOptionPane.showMessageDialog(null, "You have logged in successfully");
            }
            else if(username.equals("") && password.equals("")){
                JOptionPane.showMessageDialog(null, "No details entered");
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect details!!!");
            }
        } else if (e.getActionCommand().equals("Clear")) {
            txtUsername.setText("");
            txtPassword.setText("");
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

}
