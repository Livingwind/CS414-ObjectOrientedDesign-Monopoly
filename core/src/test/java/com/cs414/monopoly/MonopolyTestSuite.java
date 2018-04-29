package com.cs414.monopoly;


import com.cs414.monopoly.entities.TestLotProperty;
import com.cs414.monopoly.entities.TestRailroadProperty;
import com.cs414.monopoly.entities.TestUtilityProperty;
import com.cs414.monopoly.game.*;
import com.cs414.monopoly.spaces.*;
import com.cs414.monopoly.stages.TestGameScreen;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    TestLotProperty.class,
    TestRailroadProperty.class,
    TestUtilityProperty.class,
    TestGameState.class,
    TestHelpers.class,
    TestChance.class,
    TestChest.class,
    TestGo.class,
    TestJail.class,
    TestLot.class,
    TestRailroad.class,
    TestSpaceFactory.class,
    TestTax.class,
    TestToJail.class,
    TestUtility.class,
    TestMonopoly.class,
    TestPostRollState.class,
    TestInJail.class,
    TestGameScreen.class
})
public class MonopolyTestSuite {
}
