package dml.bw.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by Christopher on 2016-10-08.
 */
public class MainAlgTest {
    @Test
    public void shouldNotRemoveElements() {
        //given
        List<ItemQuality> itemQualities = new ArrayList<ItemQuality>();

        ItemQuality itemQuality1 = new ItemQuality(1, 1, 1, "a", false);
        ItemQuality itemQuality2 = new ItemQuality(2, 1, 3, "b", false);
        ItemQuality itemQuality3 = new ItemQuality(5, 1, 9, "c", false);
        ItemQuality itemQuality4 = new ItemQuality(10, 4, 5, "d", false);
        ItemQuality itemQuality5 = new ItemQuality(15, 3, 2, "f", false);

        itemQualities.add(itemQuality1);
        itemQualities.add(itemQuality2);
        itemQualities.add(itemQuality3);
        itemQualities.add(itemQuality4);
        itemQualities.add(itemQuality5);


        //when
        MainAlg mainAlg = new MainAlg();
        mainAlg.process(itemQualities);

        //then
        assertThat(itemQualities).hasSize(itemQualities.size()).containsAll(itemQualities);

    }

    @Test
    public void shouldRemoveElements() {
        //given
        List<ItemQuality> itemQualities = new ArrayList<ItemQuality>();

        ItemQuality itemQuality1 = new ItemQuality(1, 1, 4, "a", false);
        ItemQuality itemQuality2 = new ItemQuality(4, 1, 1, "b", false);
        ItemQuality itemQuality3 = new ItemQuality(5, 1, 9, "c", false);
        ItemQuality itemQuality4 = new ItemQuality(10, 4, 5, "d", false);
        ItemQuality itemQuality5 = new ItemQuality(15, 3, 5, "f", false);
        ItemQuality itemQuality6 = new ItemQuality(18, 3, 2, "g", false);

        itemQualities.add(itemQuality1);
        itemQualities.add(itemQuality2);
        itemQualities.add(itemQuality3);
        itemQualities.add(itemQuality4);
        itemQualities.add(itemQuality5);
        itemQualities.add(itemQuality6);

        //when
        MainAlg mainAlg = new MainAlg();
        mainAlg.process(itemQualities);

        //then
        assertThat(itemQualities).hasSize(3);

    }

}