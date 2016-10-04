package dml.bw.core;

import dml.bw.core.Deleter;
import dml.bw.core.ItemQuality;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleterTest {

    @Test
    public void shouldRemoveElement() {
        //given
        ItemQuality itemQuality1 = new ItemQuality(1, 1, 1, "a", true);
        List<ItemQuality> itemQualities = new ArrayList<>();
        itemQualities.add(itemQuality1);
        //when
        Deleter deleter = new Deleter();
        deleter.deleteMa​rkedItems(itemQualities);

        //then
        assertThat(itemQualities).isEmpty();
    }

    @Test
    public void shouldNotRemoveElement() {
        //given
        ItemQuality itemQuality1 = new ItemQuality(1, 1, 1, "a", false);
        List<ItemQuality> itemQualities = new ArrayList<>();
        itemQualities.add(itemQuality1);

        //when
        Deleter deleter = new Deleter();
        deleter.deleteMa​rkedItems(itemQualities);

        //then
        assertThat(itemQualities).hasSize(itemQualities.size()).containsAll(itemQualities);
    }
}