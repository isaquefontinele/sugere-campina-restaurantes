package Projeto.Janelas;

import com.teamdev.jxbrowser.Browser;
import com.teamdev.jxbrowser.BrowserFactory;
import com.teamdev.jxbrowser.BrowserType;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This sample demonstrates how to add or remove browser component into JPanel.
 */
public class AbrirBrowser {
    private Browser browser;
    private JPanel browserPanel;
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddRemoveBrowserInJPanel();
            }
        });
    }
 
    public AbrirBrowser() {
        browser = BrowserFactory.createBrowser(BrowserType.Mozilla);
 
        browserPanel = new JPanel(new BorderLayout());
 
        JPanel butonsPanel = new JPanel();
        butonsPanel.add(new JButton(new AbstractAction("Add") {
            public void actionPerformed(ActionEvent e) {
                browserPanel.add(browser.getComponent(), BorderLayout.CENTER);
                browserPanel.validate();
                browser.navigate("http://www.google.com");
            }
        }));
        butonsPanel.add(new JButton(new AbstractAction("Remove") {
            public void actionPerformed(ActionEvent e) {
                browserPanel.remove(browser.getComponent());
                browserPanel.validate();
            }
        }));
 
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.add(browserPanel, BorderLayout.CENTER);
        frame.add(butonsPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}