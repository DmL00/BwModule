package dml.bw.gui;


import dml.bw.core.InputDataParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BwStart {

    private static MyFrame myFrame;
    private static JPanel upperPanel;
    private static JTextArea pasteArea;
    private static JTextArea resultArea;
    private static JButton pasteButton;
    private static JButton fireButton;

    private static final InputDataParser inputDataParser = new InputDataParser();

    public static void main(String[] args) {
        myFrame = new MyFrame();
        upperPanel = new JPanel();
        myFrame.getContentPane().add(upperPanel, "North");

        pasteArea = new JTextArea("siema leszczu", 35, 25);
        pasteArea.setLineWrap(true);
        pasteArea.setWrapStyleWord(true);

        resultArea = new JTextArea("wynik", 35, 25);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        pasteButton = new JButton("Wklej");
        pasteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pasteArea.setText("");
                pasteArea.paste();

            }
        });

        fireButton = new JButton("Ogień");

        fireButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String data = inputDataParser.firstPhaseClean(pasteArea.getText());
                List<String> dataAfterFirstPhase = inputDataParser.secondPhaseCut(data);
                List<String> armorList = inputDataParser.toArmorList(dataAfterFirstPhase);
                System.out.println(armorList + "\nIlość: " + armorList.size());

                String resultBreakLine = "";
                List<String> result = inputDataParser.toQualityArmor(armorList);
                System.out.println(inputDataParser.bestConntecion(result).toString());

                for (int i = 0; i < result.size(); i++) {
                    resultBreakLine += result.get(i) + "\n";
                }

                resultArea.setText(resultBreakLine + "\nIlość: "
                        + armorList.size());

            }
        });

        upperPanel.add(new JScrollPane(pasteArea));
        upperPanel.add(pasteButton);
        upperPanel.add(fireButton);
        upperPanel.add(new JScrollPane(resultArea));

        myFrame.pack();
        myFrame.setVisible(true);
    }
}
