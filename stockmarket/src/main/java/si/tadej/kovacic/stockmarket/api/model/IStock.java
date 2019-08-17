package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;

import javax.validation.constraints.Positive;

public interface IStock {
	

	public String getStockSymbol();

	public BigDecimal getLastDividend();
	
	public BigDecimal getPairValue();

	public BigDecimal calculateDividendYield(@Positive BigDecimal price);
	
	public BigDecimal calculatePERation(@Positive BigDecimal price);
}
