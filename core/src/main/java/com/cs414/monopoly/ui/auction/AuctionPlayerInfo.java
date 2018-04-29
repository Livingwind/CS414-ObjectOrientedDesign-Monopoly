package com.cs414.monopoly.ui.auction;


import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;

import java.util.ArrayList;

public class AuctionPlayerInfo {
  private GameState state = GameState.getInstance();
  protected ArrayList<Player> playerList = state.playerList;
  protected ArrayList<Integer> bids = new ArrayList<>();
  private int highBidIndex = 0;
  private int currBidIndex = 1;

  public AuctionPlayerInfo(){
    for (int i=0; i< playerList.size(); i++) {
      bids.add(0);
    }
    //placeholder for initial state
    playerList.add(0, null);
    bids.add(0);
  }
  public String playerInfo(){
    String playerInfo = "Current Bidder: " + playerList.get(currBidIndex).name + "\n\n";
    for(int i=1; i< playerList.size(); i++){
      playerInfo += playerList.get(i).name + ": \t$" + bids.get(i) + "\n";
    }
    return playerInfo;
  }

  public Player highestBidder(){
    return playerList.get(highBidIndex);
  }
  public Player currentBidder(){
    return playerList.get(currBidIndex);
  }

  public int highestBid(){
    return bids.get(highBidIndex);
  }

  public void nextPlayer(){
    int next = (currBidIndex+1) % playerList.size();
    currBidIndex = ((next == 0) ? 1 : next);
  }
  public boolean checkValidBid(int currentBid){
    return (currentBid > bids.get(highBidIndex));
  }
  public void newHighestBidder(int currentBid){
      highBidIndex = currBidIndex;
      bids.set(currBidIndex, currentBid);
  }
  public boolean checkIfOver(){
    return currBidIndex == highBidIndex;
  }
}
