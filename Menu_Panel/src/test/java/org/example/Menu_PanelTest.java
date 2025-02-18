package org.example;
import javax.swing.*;
import java.awt.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Menu_PanelTest {

    @Test
    public void SubmitForm() {
        Menu_Panel menuPanel = new Menu_Panel();
        menuPanel.NameInput.setText("Ali");
        menuPanel.PhoneInput.setText("07067895");
        menuPanel.EmailInput.setText("ali@gmail.com");

        menuPanel.SubmitForm();

        assertEquals("", menuPanel.NameInput.getText());
        assertEquals("", menuPanel.PhoneInput.getText());
        assertEquals("", menuPanel.EmailInput.getText());


    }

    @Test
    public void SwitchPanel() {
        Menu_Panel menuPanel = new Menu_Panel();
        menuPanel.switchPanel("ContactPanel");
        assertTrue(menuPanel.ContactPanel.isVisible());

        menuPanel.switchPanel("AboutPanel");
        assertTrue(menuPanel.AboutPanel.isVisible());
    }
}
