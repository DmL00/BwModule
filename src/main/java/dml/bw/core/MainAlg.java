package dml.bw.core;

import java.util.List;


public class MainAlg {

    private final Sorter sorter = new Sorter();
    private final Deleter deleter = new Deleter();
    private final Marker marker = new Marker();

    public void process(List<ItemQuality> itemQualities) {
        sorter.sort(itemQualities);
        for (int i = 0; i < itemQualities.size(); i++) {
            ItemQuality tnLhs = itemQualities.get(i);
            for (int j = i + 1; j < itemQualities.size(); j++) {
                ItemQuality tnRhs = itemQualities.get(j);
                marker.process(tnLhs, tnRhs);
            }
            deleter.deleteMa​rkedItems(itemQualities);
        }

        // i jak wyjdzie z tej petli to powininien wszytskie znalesc i
        // usunac, trzeba tylko dodac miejsce gdzie ma przepisywac cos do
        // nowej kolekcji
    }
}