package si.tadej.kovacic.stockmarket;

import java.math.BigDecimal;

import si.tadej.kovacic.stockmarket.api.model.CommonStock;
import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.api.model.PreferredStock;

public abstract class AbstractTest {

	protected BigDecimal lastDividend = new BigDecimal(24);
	protected BigDecimal pairValue = new BigDecimal(44);
	protected BigDecimal price = new BigDecimal(8);
	protected String stockSymbol = "AAA";
	protected BigDecimal fixedDividend = new BigDecimal(3);
	
	protected IStock commonStock = new CommonStock(stockSymbol, lastDividend, pairValue);
	protected IStock preferredStock = new PreferredStock(stockSymbol, lastDividend, pairValue, fixedDividend);
	
}
