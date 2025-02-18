package org.example;
import javax.swing.*;
import java.awt.*;

public class Menu_Panel {
    JFrame frame;
    JMenuBar MenuBar;
    JMenu Menu;
    JMenuItem Home, Contact, About;
    JPanel Mainpanel, HomePanel, AboutPanel, ContactPanel;
    JLabel Name,Email,Phone;
    JTextField NameInput,PhoneInput,EmailInput;
    JButton Submit;
    JTextArea aboutText;

    public Menu_Panel() {
        frame = new JFrame();
        frame.setTitle("Menu");
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar = new JMenuBar();
        Menu = new JMenu("Menu");

        Home = new JMenuItem("Home Panel");
        Contact = new JMenuItem("Contact Us");
        About = new JMenuItem("About Us");
        Contact.setForeground(Color.CYAN);
        Home.setForeground(Color.PINK);

        Menu.add(Home);
        Menu.add(Contact);
        Menu.add(About);
        MenuBar.add(Menu);
        frame.setJMenuBar(MenuBar);

        Mainpanel = new JPanel(new CardLayout());

        HomePanel = new JPanel();
        HomePanel.add(new JLabel("<html><h2>Welcome to Home Panel</h2></html>"));

        ContactPanel = new JPanel();
        ContactPanel.setLayout(new GridLayout(4, 2, 10, 10));

        Name = new JLabel("Name");
        ContactPanel.add(Name);
        NameInput = new JTextField(5);
        ContactPanel.add(NameInput);


        Phone = new JLabel("Phone");
        ContactPanel.add(Phone);
        PhoneInput = new JTextField(5);
        ContactPanel.add(PhoneInput);

        Email = new JLabel("Email");
        ContactPanel.add(Email);
        EmailInput = new JTextField(5);
        ContactPanel.add(EmailInput);

        Submit = new JButton("Sumbit");
        ContactPanel.add(Submit);

        Submit.addActionListener(e -> SubmitForm());


        AboutPanel = new JPanel();
        AboutPanel.setLayout(new BorderLayout());
        AboutPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        JLabel titleLabel = new JLabel("<html><h2>About Us</h2></html>");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        AboutPanel.add(titleLabel, BorderLayout.NORTH);

        aboutText = new JTextArea("We are a team of passionate developers who created this app to make life easier...\n\n"
                + "Our app helps users to manage their tasks and stay organized.");

        aboutText.setFont(new Font("Arial", Font.PLAIN, 14));
        AboutPanel.add(aboutText, BorderLayout.CENTER);

        JPanel contactInfoPanel = new JPanel();
        contactInfoPanel.setLayout(new GridLayout(3, 1));

        JLabel emailLabel = new JLabel("Email: Mustaphamouliid@gmail.com");
        JLabel phoneLabel = new JLabel("Phone: +252615988376");
        JLabel websiteLabel = new JLabel("Website: www.IUEA.com");

        contactInfoPanel.add(emailLabel);
        contactInfoPanel.add(phoneLabel);
        contactInfoPanel.add(websiteLabel);

        AboutPanel.add(contactInfoPanel, BorderLayout.SOUTH);
        AboutPanel.setBackground(Color.WHITE);

        Mainpanel.add(HomePanel, "HomePanel");
        Mainpanel.add(ContactPanel, "ContactPanel");
        Mainpanel.add(AboutPanel, "AboutPanel");

        Home.addActionListener(e -> switchPanel("HomePanel"));
        Contact.addActionListener(e -> switchPanel("ContactPanel"));
        About.addActionListener(e -> switchPanel("AboutPanel"));

        frame.add(Mainpanel);
        frame.setVisible(true);

    }

    public void SubmitForm(){
        String Name = NameInput.getText();
        String Phone = PhoneInput.getText();
        String Email = EmailInput.getText();

        if(Name.isEmpty() || Phone.isEmpty() || Email.isEmpty()){
            JOptionPane.showMessageDialog(frame, "Please fill in all the Inputs", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        System.out.println("Name: " + Name);
        System.out.println("Phone: " + Phone);
        System.out.println("Email: " + Email);


        NameInput.setText("");
        PhoneInput.setText("");
        EmailInput.setText("");
    }

    void switchPanel(String panelName) {
        CardLayout cl = (CardLayout) Mainpanel.getLayout();
        cl.show(Mainpanel, panelName);
    }

}
