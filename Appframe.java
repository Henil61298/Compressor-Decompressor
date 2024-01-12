package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Appframe implements ActionListener{
    JButton compressButton;
    JButton decompressButton;

    JFrame frame;

    Appframe(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Compress");
        compressButton.setBounds(20, 170, 100, 30);
        compressButton.addActionListener(this);
        frame.add(compressButton);

        decompressButton = new JButton("Decompress");
        decompressButton.setBounds(300, 170, 100, 30);
        decompressButton.addActionListener(this);

        frame.add(decompressButton);
        frame.setBounds(0, 0, 500, 400);
        frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
