package org.example;

import javax.swing.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Menu_PanelIntegrationTest {

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

        assertFalse(menuPanel.ContactPanel.isVisible());
        assertFalse(menuPanel.AboutPanel.isVisible());

        menuPanel.switchPanel("ContactPanel");

        assertTrue(menuPanel.ContactPanel.isVisible());
        assertFalse(menuPanel.AboutPanel.isVisible());

        menuPanel.switchPanel("AboutPanel");

        assertTrue(menuPanel.AboutPanel.isVisible());
        assertFalse(menuPanel.ContactPanel.isVisible());
    }

    @Test
    public void FormSubmitAndPanelSwitch() {
        Menu_Panel menuPanel = new Menu_Panel();

        menuPanel.NameInput.setText("Ali");
        menuPanel.PhoneInput.setText("07067895");
        menuPanel.EmailInput.setText("ali@gmail.com");

        menuPanel.SubmitForm();

        assertEquals("", menuPanel.NameInput.getText());
        assertEquals("", menuPanel.PhoneInput.getText());
        assertEquals("", menuPanel.EmailInput.getText());

        menuPanel.switchPanel("ContactPanel");

        assertTrue(menuPanel.ContactPanel.isVisible());

        menuPanel.switchPanel("AboutPanel");

        assertTrue(menuPanel.AboutPanel.isVisible());
        assertFalse(menuPanel.ContactPanel.isVisible());
    }
}
