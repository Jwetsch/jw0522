package test;

import data.DataStore;
import data.Tool;
import data.ToolType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataStoreTest {

    @BeforeEach
    void setUp() {
        DataStore.initialize();
    }

    @Test
    void findTool_GivenCHNS_ExpectBrancStihl() {
        Tool chns = DataStore.findTool("CHNS");
        assertEquals("Stihl", chns.getBrand());
    }

    @Test
    void findToolType_GivenChainsaw_ExpectHolidayCharge() {
        ToolType chainsaw = DataStore.findToolType("Chainsaw");
        assertTrue(chainsaw.isHolidayCharge());
    }
}