package cn.pbx.cs2.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author BruceXu
 */
class RandomTest {

    @Test
    public void test() {
        Random random = Random.getInstance(123456);
        assertEquals("351141", random.get(6));
        assertEquals("9GC73EF0CLG817L092CLABE6", random.get(24));
    }
}
