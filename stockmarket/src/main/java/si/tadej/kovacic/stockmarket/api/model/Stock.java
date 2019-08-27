package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.validation.constraints.Positive;

/**
 * general stock class with implementation of general method calculatePERation
 * 
 * @author tadej
 *
 */
public abstract class Stock implements IStock {

	private String stockSymbol;

	private BigDecimal lastDividend;

	private BigDecimal pairValue;

	public Stock(String stockSymbol, BigDecimal lastDividend, BigDecimal pairValue) {
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

	public BigDecimal calculatePERation(BigDecimal price) {
		if (lastDividend.equals(BigDecimal.ZERO)) {
			return BigDecimal.ZERO;
		} else {
			return price.divide(lastDividend, new MathContext(10, RoundingMode.HALF_UP));
		}
	}
}
