package com.codecool.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.codecool.game.Seed;

public class TestSeed {

    @Test
    public void testIfClassTypeIsEnum() {
        assertTrue(Seed.class.isEnum());
    }

    @Test
    public void testIfEmptyExists(){
        assertNotNull(Seed.valueOf("EMPTY"));
    }

    @Test
    public void testIfCrossExists(){
        assertNotNull(Seed.valueOf("CROSS"));
    }

    @Test
    public void testIfNoughtExists(){
        assertNotNull(Seed.valueOf("NOUGHT"));
    }
}
