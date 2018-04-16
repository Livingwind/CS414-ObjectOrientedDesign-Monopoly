package com.cs414.monopoly.entities;


import com.cs414.monopoly.game.TestGameState;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    TestLotProperty.class,
    TestRailroadProperty.class,
    TestUtilityProperty.class,
    TestGameState.class,
})
public class MonopolyTestSuite {
}
