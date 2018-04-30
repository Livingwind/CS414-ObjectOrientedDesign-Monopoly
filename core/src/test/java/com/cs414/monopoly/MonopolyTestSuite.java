package com.cs414.monopoly;


import com.cs414.monopoly.entities.TestGetOutOfJailFree;
import com.cs414.monopoly.entities.TestLotProperty;
import com.cs414.monopoly.entities.TestRailroadProperty;
import com.cs414.monopoly.entities.TestUtilityProperty;
import com.cs414.monopoly.game.*;
import com.cs414.monopoly.spaces.*;
import com.cs414.monopoly.stages.TestGameScreen;
import com.cs414.monopoly.stages.TestSetupScreen;
import com.cs414.monopoly.ui.auction.TestAuctionDisplay;
import com.cs414.monopoly.ui.auction.TestAuctionGroup;
import com.cs414.monopoly.ui.debug.TestDebugConsole;
import com.cs414.monopoly.ui.dialog.*;
import com.cs414.monopoly.ui.setup.TestSetupDialog;
import com.cs414.monopoly.ui.trade.TestTradePropertyButton;
import com.cs414.monopoly.ui.trade.TestTradeTable;
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
    TestPreRollState.class,
    TestGameScreen.class,
    TestLotDialog.class,
    TestRailroadDialog.class,
    TestUtilityDialog.class,
    TestPopupDialog.class,
    TestAuctionDisplay.class,
    TestSetupDialog.class,
    TestDebugConsole.class,
    TestTradeTable.class,
    TestTradePropertyButton.class,
    TestTradeDialog.class,
    TestAuctionGroup.class,
    TestDebugDialog.class,
    TestTradeDialogError.class,
    TestSetupScreen.class,
    TestGameScreen.class,
    TestGetOutOfJailFree.class

})
public class MonopolyTestSuite {
}
