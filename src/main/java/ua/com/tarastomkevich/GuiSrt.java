package ua.com.tarastomkevich;

import ua.com.tarastomkevich.util.FilterFileSubtitle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class GuiSrt extends JFrame {
    public static String newNameFile;

    public GuiSrt() throws HeadlessException {
        initFrame();
    }

    private void initFrame() {
        setSize(new Dimension(470, 80));
        setTitle("Subtitle Extractor");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Скористайтесь кнопкою Open та відкрийте один файл субтитрів.");
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
                    if(!fileChooser.getSelectedFile().getName().endsWith("srt")){
                        JOptionPane.showMessageDialog(panel,
                                new String[] {"Ви вибрали неправильний файл: ",
                                        " - спробуйте знайти файл srt"},
                                "Wrong type file",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            SimpleSrt.pathFileSrt = fileChooser.getSelectedFile().getCanonicalPath();
                            String tempNewNameFile  = fileChooser.getCurrentDirectory() + "\\new" + fileChooser.getSelectedFile().getName();
                            newNameFile = tempNewNameFile.replaceFirst(".srt", ".txt");
                            SimpleSrt.extractSrt();
                            JOptionPane.showMessageDialog(panel, new String[] {"Успішно створено новий текстовий файл, ",
                                    "у вказаній папці з субтитрами"}, "УВАГА!" , JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        panel.add(buttonOpen);
        getContentPane().add(panel);
    }
}
