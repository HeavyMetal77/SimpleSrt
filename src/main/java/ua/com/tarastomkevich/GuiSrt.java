package ua.com.tarastomkevich;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import ua.com.tarastomkevich.util.*;


public class GuiSrt extends JFrame {
    public GuiSrt() throws HeadlessException {
        initFrame();
    }

    private void initFrame() {
        setSize(new Dimension(600, 120));
        setTitle("Subtitle Extractor");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Скористайтесь кнопкою Open та відкрийте один файл субтитрів. Вивід буде здійснений у консоль.");
        panel.add(label);
        JButton buttonOpen = new JButton("Open");
        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("D:\\"));
                fileChooser.setFileFilter(new FilterFileSubtitle());
                int ret = fileChooser.showDialog(panel, "Open file subtitle");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if(!fileChooser.getSelectedFile().getName().endsWith("srt")){
                        JOptionPane.showMessageDialog(panel,
                                new String[] {"Ви вибрали неправильний файл: ",
                                        " - спробуйте знайти файл srt"},
                                "Wrong type file",
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        try {
                            SimpleSrt.pathFileSrt = file.getCanonicalPath();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        SimpleSrt.extractSrt();
                    }
                }
            }
        });
        panel.add(buttonOpen);
        getContentPane().add(panel);
    }
}
