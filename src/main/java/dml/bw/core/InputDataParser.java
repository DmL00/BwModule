package dml.bw.core;

import java.util.*;

import static java.lang.Integer.parseInt;

public class InputDataParser {
    private String replace(String s, String longReg) {
        return s.replace("EKWIPUJ", "").replace("SPRZEDAJ", "")
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

    // czyszczenie ze smieci
    public String firstPhaseClean(String text) {
        String longReg = "Przedmiotów z tej półki nie można sprzedać ani zniszczyć. Przenieś przedmiot na półkę  lub jedną z niższych półek, aby to zrobić.";
        String reg = "SPRZEDAJ ZAZNACZONE";

        String[] splitArray = text.split(reg);

        if (splitArray.length == 3) {
            return replace(splitArray[1], longReg);
        } else if (splitArray.length == 1
                || (splitArray.length == 2 && splitArray[1].contains("BW"))) {
            return replace(splitArray[0], longReg);
        }
        return replace(splitArray[1], longReg);
    }

    // ciecie po PLN
    public List<String> secondPhaseCut(String text) {
        List<String> list = Arrays.asList(text.split("PLN"));
        return list;
    }

    // klaty
    public List<String> toArmorList(List<String> armorList) {

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

    public List<String> toQualityArmor(List<String> qualityArmor) {

        List<String> list = new ArrayList<String>();
        Map<String, String> armorBase;
        Map<String, String> armorSuffix;

        Map<String, String> armorPrefix = new HashMap<>();
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
    public List<String> toHelmetList(List<String> helmetList) {

        List<String> list = new ArrayList<String>();
//haset contains get i
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

    public List<String> bestConntecion(List<String> list) {

        List<String> result = new ArrayList<String>();

        List<ItemQuality> itemQualities = new ArrayList<ItemQuality>();

        MainAlg mainAlg = new MainAlg();
        mainAlg.process(itemQualities);

        for (int i = 0; i < list.size(); i++) {

            String[] quality1 = list.get(i).split("\\,");
            String[] nextQuality = quality1[2].split("\\s");
            String itemName = nextQuality[1] + " " + nextQuality[2] + " " + nextQuality[3];

            itemQualities.add(new ItemQuality(parseInt(quality1[0]), parseInt(quality1[1]), parseInt(nextQuality[0]), itemName, false));


        }
        return result;
    }
}
