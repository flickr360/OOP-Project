package library;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {
	private JPanel contentPane;
    private JTextField textField_1;
    private JButton btnNewButton;
    private JButton restoreButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;

    private boolean isPanelCleared = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainframe frame = new mainframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


	/**
	 * Create the frame.
	 */
	public Frame() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 811, 731);

	        contentPane = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Graphics2D g2d = (Graphics2D) g;
	                int cornerRadius = 20;
	                g2d.setColor(getBackground());
	                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius));
	            }
	        };
	        contentPane.setForeground(new Color(15, 15, 15));
	        contentPane.setBackground(Color.BLACK);
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        // Initialize restoreButton
	        restoreButton = new JButton("Go Back");
	        restoreButton.setBounds(595, 628, 177, 38);
	        contentPane.add(restoreButton);
	        restoreButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                restoreOriginalState();
	            }
	        });

	        JLabel lblNewLabel = new JLabel("Music Library");
	        lblNewLabel.setForeground(new Color(43, 164, 91));
	        lblNewLabel.setBounds(20, 10, 260, 51);
	        lblNewLabel.setFont(new Font("Sonic XBd BT", Font.PLAIN, 35));
	        contentPane.add(lblNewLabel);

	        btnNewButton_7 = new JButton("Your Jam");
	        btnNewButton_7.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                clearPanel();
	                // Toggle the visibility of the "Go Back" button
	                restoreButton.setVisible(!isPanelCleared);
	            }
	        });
	        btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\Lloyd Angara\\Downloads\\top3.jpg"));
	        btnNewButton_7.setBounds(20, 71, 752, 132);
	        contentPane.add(btnNewButton_7);

	        btnNewButton = new JButton("");
	        btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lloyd Angara\\Downloads\\icons8-search-30.png"));
	        btnNewButton.addActionListener(e -> {

	        });
	        btnNewButton.setBounds(732, 18, 40, 38);
	        contentPane.add(btnNewButton);

	        textField_1 = new JTextField();
	        textField_1.setBounds(419, 18, 300, 38);
	        contentPane.add(textField_1);
	        textField_1.setColumns(10);

	        // Additional buttons initially present
	        btnNewButton_1 = new JButton("New button");
	        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Lloyd Angara\\Downloads\\360_F_641954242_LogiG7hgz8zmf92pXkJQvjisDZenNxdK.jpg"));
	        btnNewButton_1.setBounds(20, 226, 358, 132);
	        contentPane.add(btnNewButton_1);

	        btnNewButton_2 = new JButton("New button");
	        btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Lloyd Angara\\Downloads\\360_F_570542529_Ej79rCgzre7tR4wHW1Rmzz91zJpBkEzT.jpg"));
	        btnNewButton_2.setBounds(414, 226, 358, 132);
	        contentPane.add(btnNewButton_2);

	        btnNewButton_3 = new JButton("New button");
	        btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Lloyd Angara\\Downloads\\360_F_611289180_zeK9mk7ywVWNOWPdSX4eKNiBGf2vpmHn.jpg"));
	        btnNewButton_3.setBounds(20, 378, 358, 132);
	        contentPane.add(btnNewButton_3);

	        btnNewButton_4 = new JButton("New button");
	        btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Lloyd Angara\\Downloads\\360_F_626514183_6eJ8Rwk3UwCqsGsyFv5yFnOvlgMVMZMb.jpg"));
	        btnNewButton_4.setBounds(20, 534, 358, 132);
	        contentPane.add(btnNewButton_4);

	        btnNewButton_5 = new JButton("New button");
	        btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\Lloyd Angara\\Downloads\\360_F_629788727_3gLoHXlaTmmUNOJMK05y6pUMPeONJ72V.jpg"));
	        btnNewButton_5.setBounds(414, 378, 358, 132);
	        contentPane.add(btnNewButton_5);

	        btnNewButton_6 = new JButton("New button");
	        btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\Lloyd Angara\\Downloads\\360_F_331830515_CVeMxf9lXDSFOtiVD50wJCcPdnelK3ZM.jpg"));
	        btnNewButton_6.setBounds(414, 534, 358, 132);
	        contentPane.add(btnNewButton_6);
	    }

	    private void clearPanel() {
	        Component[] components = contentPane.getComponents();
	        for (Component component : components) {
	            if (component instanceof JButton && component != btnNewButton && component != btnNewButton_7) {
	                contentPane.remove(component);
	            }
	        }
	        restoreButton.setVisible(true);
	        contentPane.repaint();
	        isPanelCleared = true;
	    }

	    private void restoreOriginalState() {
	        contentPane.add(btnNewButton_1);
	        contentPane.add(btnNewButton_2);
	        contentPane.add(btnNewButton_3);
	        contentPane.add(btnNewButton_4);
	        contentPane.add(btnNewButton_5);
	        contentPane.add(btnNewButton_6);
	        
	        contentPane.setComponentZOrder(restoreButton, 0);
	        
	        restoreButton.setVisible(false);
	        contentPane.repaint();
	        isPanelCleared = false;
	    }
	}