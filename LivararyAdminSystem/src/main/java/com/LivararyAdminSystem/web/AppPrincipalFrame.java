package com.LivararyAdminSystem.web;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.boot.CommandLineRunner;

public class AppPrincipalFrame extends JFrame implements CommandLineRunner{

private JPanel contentPane;

@Override
public void run(String... arg0) throws Exception {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                AppPrincipalFrame frame = new AppPrincipalFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}
}