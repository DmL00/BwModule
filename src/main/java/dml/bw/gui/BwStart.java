package dml.bw.gui;


import dml.bw.core.ItemQuality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BwStart {

    private static MyFrame myFrame;
    private static JPanel upperPanel;
    private static JTextArea pasteArea;
    private static JTextArea resultArea;
    private static JButton pasteButton;
    private static JButton fireButton;
    private static List<String> armorList;

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
                String data = firstPhaseClean(pasteArea.getText());
                List<String> dataAfterFirstPhase = secondPhaseCut(data);
                List<String> armorList = toArmorList(dataAfterFirstPhase);
                System.out.println(armorList + "\nIlość: " + armorList.size());

                String resultBreakLine = "";
                List<String> result = toQualityArmor(armorList);
                System.out.println(bestConntecion(result).toString());

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

    // czyszczenie ze smieci
    public static String firstPhaseClean(String text) {
        String longReg = "Przedmiotów z tej półki nie można sprzedać ani zniszczyć. Przenieś przedmiot na półkę  lub jedną z niższych półek, aby to zrobić.";
        String reg = "SPRZEDAJ ZAZNACZONE";

        String[] splitArray = text.split(reg);

        if (splitArray.length == 3) {

            return splitArray[1].replace("EKWIPUJ", "").replace("SPRZEDAJ", "")
                    .replaceAll("[0-9]", "").replaceAll("\\)", "")
                    .replaceAll("\\(", "").replaceAll("\\+", "")
                    .replace("Półka", "").replace("Wartość:", "")
                    .replace(longReg, "").replace("ODWRÓĆ ZAZNACZENIE", "")
                    .replace("DO ZBROJOWNI KLANOWEJ", "")
                    .replace("PRZENIEŚ", "")
                    .replace("Przenieś zaznaczone na półkę", "")
                    .replace("ZAZNACZONE", "").replace("Doskonały ", "")
                    .replace("Doskonała ", "").replace("Doskonałe ", "")
                    .replace("Dobry ", "").replace("Dobre ", "")
                    .replace("Dobra ", "").replace("Legendarny", "")
                    .replace("Legendarna", "").replace("Legendarne", "")
                    .replace("\\n", "");

        } else if (splitArray.length == 1
                || (splitArray.length == 2 && splitArray[1].contains("BW"))) {
            return splitArray[0].replace("EKWIPUJ", "").replace("SPRZEDAJ", "")
                    .replaceAll("[0-9]", "").replaceAll("\\)", "")
                    .replaceAll("\\(", "").replaceAll("\\+", "")
                    .replace("Półka", "").replace("Wartość:", "")
                    .replace(longReg, "").replace("ODWRÓĆ ZAZNACZENIE", "")
                    .replace("DO ZBROJOWNI KLANOWEJ", "")
                    .replace("PRZENIEŚ", "")
                    .replace("Przenieś zaznaczone na półkę", "")
                    .replace("ZAZNACZONE", "").replace("Doskonały ", "")
                    .replace("Doskonała ", "").replace("Doskonałe ", "")
                    .replace("Dobry ", "").replace("Dobre ", "")
                    .replace("Dobra ", "").replace("Legendarny", "")
                    .replace("Legendarna", "").replace("Legendarne", "")
                    .replace("\\n", "");

        } else {

            return splitArray[1].replace("EKWIPUJ", "").replace("SPRZEDAJ", "")
                    .replaceAll("[0-9]", "").replaceAll("\\)", "")
                    .replaceAll("\\(", "").replaceAll("\\+", "")
                    .replace("Półka", "").replace("Wartość:", "")
                    .replace(longReg, "").replace("ODWRÓĆ ZAZNACZENIE", "")
                    .replace("DO ZBROJOWNI KLANOWEJ", "")
                    .replace("PRZENIEŚ", "")
                    .replace("Przenieś zaznaczone na półkę", "")
                    .replace("ZAZNACZONE", "").replace("Doskonały ", "")
                    .replace("Doskonała ", "").replace("Doskonałe ", "")
                    .replace("Dobry ", "").replace("Dobre ", "")
                    .replace("Dobra ", "").replace("Legendarny", "")
                    .replace("Legendarna", "").replace("Legendarne", "")
                    .replace("\\n", "");
        }

    }

    // ciecie po PLN
    public static List<String> secondPhaseCut(String text) {
        List<String> list = Arrays.asList(text.split("PLN"));
        return list;
    }

    // klaty
    public static List<String> toArmorList(List<String> armorList) {

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < armorList.size(); i++) {
            if (armorList.get(i).contains("Koszulka")
                    || armorList.get(i).contains("Kurtka")
                    || armorList.get(i).contains("Marynarka")
                    || armorList.get(i).contains("Kamizelka")
                    || armorList.get(i).contains("Gorset")
                    || armorList.get(i).contains("Peleryna")
                    || armorList.get(i).contains("Smoking")
                    || armorList.get(i).contains("Kolczuga")
                    || armorList.get(i).contains("Zbroja warstwowa")
                    || armorList.get(i).contains("Pełna zbroja")) {

                list.add(armorList.get(i)
                        .replace("Pełna zbroja", "Pełnazbroja")
                        .replace("Zbroja warstwowa", "Zbrojawarstwowa")
                        .replace("Skorupy żółwia", "Skorupyżółwia")
                        .replace("Siewcy Śmierci", "Siewcyśmierci").trim());

            }
        }
        Collections.sort(list);
        return list;
    }

    public static List<String> toQualityArmor(List<String> qualityArmor) {

        List<String> list = new ArrayList<String>();
        Map<String, String> armorPrefix;
        Map<String, String> armorBase;
        Map<String, String> armorSuffix;

        armorPrefix = new HashMap<>();
        armorPrefix.put("Wzmocniona", "1");
        armorPrefix.put("Wzmocniony", "1");
        armorPrefix.put("Ćwiekowana", "2");
        armorPrefix.put("Ćwiekowany", "2");
        armorPrefix.put("Władcza", "3");
        armorPrefix.put("Władczy", "3");
        armorPrefix.put("Lekka", "4");
        armorPrefix.put("Lekki", "4");
        armorPrefix.put("Łuskowa", "5");
        armorPrefix.put("Łuskowy", "5");
        armorPrefix.put("Płytowa", "6");
        armorPrefix.put("Płytowy", "6");
        armorPrefix.put("Bojowa", "7");
        armorPrefix.put("Bojowy", "7");
        armorPrefix.put("Giętka", "8");
        armorPrefix.put("Giętki", "8");
        armorPrefix.put("Krwawa", "9");
        armorPrefix.put("Krwawy", "9");
        armorPrefix.put("Łowiecka", "10");
        armorPrefix.put("Łowiecki", "10");
        armorPrefix.put("Szamańska", "11");
        armorPrefix.put("Szamański", "11");
        armorPrefix.put("Kuloodporna", "12");
        armorPrefix.put("Kuloodporny", "12");
        armorPrefix.put("Tygrysia", "13");
        armorPrefix.put("Tygrysi", "13");
        armorPrefix.put("Elfia", "14");
        armorPrefix.put("Elfi", "14");
        armorPrefix.put("Runiczna", "15");
        armorPrefix.put("Runiczny", "15");
        armorPrefix.put("Śmiercionośna", "16");
        armorPrefix.put("Śmiercionośny", "16");

        armorBase = new HashMap<>();
        armorBase.put("Koszulka", "1");
        armorBase.put("Kurtka", "2");
        armorBase.put("Marynarka", "3");
        armorBase.put("Kamizelka", "4");
        armorBase.put("Gorset", "5");
        armorBase.put("Peleryna", "6");
        armorBase.put("Smoking", "7");
        armorBase.put("Kolczuga", "8");
        armorBase.put("Zbrojawarstwowa", "9");
        armorBase.put("Pełnazbroja", "10");

        armorSuffix = new HashMap<>();
        armorSuffix.put("Złodzieja", "1");
        armorSuffix.put("Adepta", "2");
        armorSuffix.put("Strażnika", "3");
        armorSuffix.put("Siłacza", "4");
        armorSuffix.put("Narkomana", "5");
        armorSuffix.put("Szermierza", "6");
        armorSuffix.put("Zabójcy", "7");
        armorSuffix.put("Gwardzisty", "8");
        armorSuffix.put("Kobry", "9");
        armorSuffix.put("Skorupyżółwia", "10");
        armorSuffix.put("Uników", "11");
        armorSuffix.put("Grabieżcy", "12");
        armorSuffix.put("Mistrza", "13");
        armorSuffix.put("Adrenaliny", "14");
        armorSuffix.put("Centuriona", "15");
        armorSuffix.put("Odporności", "16");
        armorSuffix.put("Kaliguli", "17");
        armorSuffix.put("Siewcyśmierci", "18");
        armorSuffix.put("Szybkości", "19");
        armorSuffix.put("Orchidei", "20");

        for (int i = 0; i < qualityArmor.size(); i++) {
            String suffix;
            String prefix;
            String base;
            String[] item = qualityArmor.get(i).split("\\s");

            if (item.length == 1) {
                prefix = "0";
                base = armorBase.get(item[0]);
                suffix = "0";
            } else if (item.length == 2 && (armorPrefix.containsKey(item[0]))) {
                prefix = armorPrefix.get(item[0]);
                base = armorBase.get(item[1]);
                suffix = "0";
            } else if (item.length == 2 && (armorSuffix.containsKey(item[1]))) {
                prefix = "0";
                base = armorBase.get(item[0]);
                suffix = armorSuffix.get(item[1]);
            } else {
                prefix = armorPrefix.get(item[0]);
                base = armorBase.get(item[1]);
                suffix = armorSuffix.get(item[2]);
            }

            // list.add(prefix + "," + base + "," + suffix);

            list.add(prefix
                    + ","
                    + base
                    + ","
                    + suffix
                    + "     "
                    + qualityArmor.get(i)
                    .replace("Pełnazbroja", "Pełna zbroja")
                    .replace("Zbrojawarstwowa", "Zbroja warstwowa")
                    .replace("Skorupyżółwia", "Skorupy żółwia")
                    .replace("Siewcyśmierci", "Siewcy Śmierci"));

        }

        return list;
    }

    // koniec klat
    // czapy
    public static List<String> toHelmetList(List<String> helmetList) {

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < helmetList.size(); i++) {
            if (helmetList.get(i).contains("Czapka")
                    || helmetList.get(i).contains("Kask")
                    || helmetList.get(i).contains("Hełm")
                    || helmetList.get(i).contains("Maska")
                    || helmetList.get(i).contains("Obręcz")
                    || helmetList.get(i).contains("Kominiarka")
                    || helmetList.get(i).contains("Kapelusz")
                    || helmetList.get(i).contains("Opaska")
                    || helmetList.get(i).contains("Bandana")
                    || helmetList.get(i).contains("Korona")) {
                list.add(helmetList.get(i).trim());
            }
        }

        return list;
    }

    // koniec czap

    public static List<String> bestConntecion(List<String> list) {

        List<String> result = new ArrayList<String>();

		/*
         * for (int i = 0; i < list.size(); i++) { String[] quality0 =
		 * list.get(0).split("\\,");
		 *
		 * String[] quality1 = list.get(i).split("\\,");
		 *
		 * int prefixResult = Integer.parseInt(quality0[0]) -
		 * Integer.parseInt(quality1[0]); int suffixResult =
		 * Integer.parseInt(quality1[2]) - Integer.parseInt(quality0[2]);
		 *
		 * if (prefixResult == suffixResult) { result.add(list.get(i) + " + " +
		 * list.get(i + 1)); System.out.println(list.get(i) + " + " + list.get(i
		 * + 1)); //list.remove(i); //list.remove(i+1); //i=0; } }
		 */

        // wersja dzialajaca w 90%
		/*
		 * for (int i = 0; i < list.size(); i++) { for (int k = 0; k <
		 * list.size(); k++) { if (list.get(i) != list.get(k)) {
		 *
		 * String[] quality0 = list.get(i).split("\\,"); String[] quality1 =
		 * list.get(k).split("\\,"); quality0[2] = quality0[2].split("\\s")[0];
		 * quality1[2] = quality1[2].split("\\s")[0]; int prefixResult =
		 * Integer.parseInt(quality0[0]) - Integer.parseInt(quality1[0]); int
		 * suffixResult = Integer.parseInt(quality1[2]) -
		 * Integer.parseInt(quality0[2]);
		 *
		 * if ((prefixResult == suffixResult) && (prefixResult != 0) &&
		 * (suffixResult != 0) && (prefixResult == 3)) { result.add(list.get(i)
		 * + " + " + list.get(k)); System.out.println("Łaczenie: " + list.get(i)
		 * + " + " + list.get(k)); list.remove(k); list.remove(i);
		 *
		 * i = 0; k = 1;
		 *
		 * } } }
		 *
		 * }
		 */
        for (int i = 0; i < list.size(); i++) {


            String[] quality = list.get(i).split("\\,");
            quality[2] = quality[2].split("\\s")[0];
            ItemQuality itemQuality = new ItemQuality(
                    Integer.parseInt(quality[0]), Integer.parseInt(quality[1]),
                    Integer.parseInt(quality[2]), list.get(i), false);
        }

        System.out.println("Reszta: " + list.toString());
        // przyklad od Manka - jak dostac sie do 2 elementu
		/*
		 * for (Iterator<String> iterator = list.iterator();
		 * iterator.hasNext();) { String element1 = iterator.next();
		 *
		 * System.out.println(element1);
		 *
		 * if (element1.equals("7,1,5")) {
		 * System.out.println("\\ncos dziala\\n"); // Remove the current element
		 * from the iterator and the list. iterator.remove(); } }
		 */

        return result;
    }
}
