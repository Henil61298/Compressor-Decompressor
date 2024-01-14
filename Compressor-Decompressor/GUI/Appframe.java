package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class Appframe implements ActionListener{
    JButton compressButton;
    JButton decompressButton;

    JPanel panel;
    JFrame frame;

    Appframe(){
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(150, 0, 0, 0));

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Compress");
//        compressButton.setBounds(0, 0, 100, 30);
        compressButton.addActionListener(this);
        panel.add(compressButton);
        compressButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        decompressButton = new JButton("Decompress");
//        decompressButton.setBounds(300, 170, 100, 30);
        decompressButton.addActionListener(this);
        panel.add(decompressButton);
        decompressButton.setBorderPainted(true);
        decompressButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panel.setBackground(Color.BLACK);

        frame.add(panel);


        frame.setBounds(0, 0, 500, 400);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(fileChooser);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                } catch (Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if (e.getSource()==decompressButton) {
                    JFileChooser fileChooser = new JFileChooser();
                    int response = fileChooser.showSaveDialog(fileChooser);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                        try{
                            decompressor.method(file);
                        } catch (Exception ee){
                            JOptionPane.showMessageDialog(null, ee.toString());
                        }
                }
    }
}
}