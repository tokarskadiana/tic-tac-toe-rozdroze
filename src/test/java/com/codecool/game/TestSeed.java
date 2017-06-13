package com.codecool.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.codecool.game.Seed;

public class TestSeed {

    @Test
    public void checkIfClassTypeIsEnum() {
        assertTrue(Seed.class.isEnum());
    }

    @Test
    public void CheckIfEmptyExists(){
        assertNotNull(Seed.valueOf("EMPTY"));
    }

    @Test
    public void CheckIfCrossExists(){
        assertNotNull(Seed.valueOf("CROSS"));
    }

    @Test
    public void CheckIfNoughtExists(){
        assertNotNull(Seed.valueOf("NOUGHT"));
    }
}
