package src.com.yx.lesson;

import java.awt.event.*; 
import javax.swing.*; 
 
public class Demo extends Thread { 
        private JFrame frm = new JFrame("Demo"); 
        private JButton btnPause = new JButton("Pause"); 
        private JLabel lblTest = new JLabel("0"); 
        private boolean isPaused = false; 
        private int seconds = 0; 
 
        public void run () { 
                while (true) { 
                        while (isPaused); 
                        seconds ++; 
                        lblTest.setText(seconds + ""); 
                        try { 
                                sleep(200); 
                        } catch (InterruptedException ie) {} 
                } 
        } 
 
        public Demo () { 
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                frm.setResizable(false); 
                frm.setLayout(null); 
                frm.setSize(150, 200); 
                frm.setLocationRelativeTo(null); 
 
                lblTest.setBounds(20, 50, 100, 25); 
 
                btnPause.setBounds(20, 120, 100, 30); 
                btnPause.addActionListener(new ActionListener() { 
                        public void actionPerformed (ActionEvent ae) { 
                                if (isPaused) { 
                                        btnPause.setText("Pause"); 
                                        isPaused = false; 
                                } else { 
                                        btnPause.setText("Resume"); 
                                        isPaused = true; 
                                } 
                        } 
                }); 
 
                frm.add(lblTest); 
                frm.add(btnPause); 
                frm.setVisible(true); 
                start(); 
        } 
 
        public static void main (String args[]) { 
                new Demo(); 
        } 
}