package com.cs414.monopoly.ui.dialog;

import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.spaces.Tax;
import com.cs414.monopoly.spaces.TaxType;
import org.junit.Test;

public class TestTaxDialog extends TestGame {

  private TaxDialog taxDialog1;
  private TaxDialog taxDialog2;
  private Tax tax1;
  private Tax tax2;



  @Test
  public void setUp() {
    tax1 = new Tax("assets/board_original/%s/04.png", 4, config.get(4), TaxType.INCOME);
    tax2 = new Tax("assets/board_original/%s/38.png", 38, config.get(38), TaxType.LUXURY);

    taxDialog1 = new TaxDialog("Income", TaxType.INCOME);
    taxDialog2 = new TaxDialog("Luxury", TaxType.LUXURY);
  }

}
