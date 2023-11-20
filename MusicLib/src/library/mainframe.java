package library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTable;

public class mainframe extends JFrame {

    private JPanel contentPane;
    private JTextField textField_1;
    private JButton btnNewButton;
    private JButton btnPlayMusic;

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

    public mainframe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 811, 731);

        // Initialize contentPane
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
        
        btnPlayMusic = new JButton("Play Music");
        btnPlayMusic.setFont(new Font("Sonic XBd BT", Font.PLAIN, 20));
        btnPlayMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the music player
                openMusicPlayer();
            }
        });
        btnPlayMusic.setBounds(31, 137, 197, 51);
        contentPane.add(btnPlayMusic);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 260, 694);
        contentPane.add(panel);
        panel.setLayout(null);
                
        JButton btnNewButton_1 = new JButton("Home");
        btnNewButton_1.setFont(new Font("Sonic XBd BT", Font.PLAIN, 20));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setBounds(31, 223, 197, 51);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Artists");
        btnNewButton_2.setFont(new Font("Sonic XBd BT", Font.PLAIN, 20));
        btnNewButton_2.setBounds(31, 308, 197, 51);
        panel.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Albums");
        btnNewButton_3.setFont(new Font("Sonic XBd BT", Font.PLAIN, 20));
        btnNewButton_3.setBounds(31, 392, 197, 51);
        panel.add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("Songs");
        btnNewButton_4.setFont(new Font("Sonic XBd BT", Font.PLAIN, 20));
        btnNewButton_4.setBounds(31, 473, 197, 51);
        panel.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Playlists");
        btnNewButton_5.setFont(new Font("Sonic XBd BT", Font.PLAIN, 20));
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_5.setBounds(31, 558, 197, 51);
        panel.add(btnNewButton_5);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(259, 0, 538, 188);
        contentPane.add(panel_1);
    }

    private void openMusicPlayer() {
        EventQueue.invokeLater(() -> {
            try {
                SimpleMusicPlayer player = new SimpleMusicPlayer();
                player.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

class SimpleMusicPlayer extends JFrame {
	private JButton playButton;
    private JButton stopButton;
    private JButton chooseButton;
    private Clip clip;

    public SimpleMusicPlayer() {
        setTitle("Simple Music Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        playButton = new JButton("Play");
        stopButton = new JButton("Stop");
        chooseButton = new JButton("Choose File");

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });

        panel.add(playButton, BorderLayout.WEST);
        panel.add(stopButton, BorderLayout.CENTER);
        panel.add(chooseButton, BorderLayout.EAST);

        add(panel, BorderLayout.CENTER);
    }

    private void play() {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("C://Users//Lloyd Angara//Downloads//Doja Cat - Agora Hills (Lyrics)_tgUW3P_auUU.wav")));
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Audio Files", "wav", "au");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            playButton.setEnabled(true);
            stopButton.setEnabled(true);

            playSelectedFile(selectedFile);
        }
    }

    private void playSelectedFile(File file) {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }
}