package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public abstract class Stock implements IStock{
	@NotNull
	private String stockSymbol;
	@Positive
	private BigDecimal lastDividend;
	@NotNull
	private BigDecimal pairValue;
		
	public Stock(String stockSymbol,BigDecimal lastDividend, BigDecimal pairValue) {
		super();
		this.stockSymbol = stockSymbol.toUpperCase();
		this.lastDividend = lastDividend;
		this.pairValue = pairValue;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public BigDecimal getLastDividend() {
		return lastDividend;
	}
	
	public BigDecimal getPairValue() {
		return pairValue;
	}
	
	public BigDecimal calculatePERation(@Positive BigDecimal price) {
		return price.divide(lastDividend, new MathContext(4,RoundingMode.HALF_UP));
	}
}
