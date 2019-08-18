package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class StockRequest {
	@NotEmpty
	private String stockSymbol;
	@Positive
	private BigDecimal fixedDividend;
	@Positive
	private BigDecimal lastDividend;
	@Positive
	private BigDecimal pairValue;
	@NotNull
	private StockType type;

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public BigDecimal getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(BigDecimal fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public BigDecimal getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(BigDecimal lastDividend) {
		this.lastDividend = lastDividend;
	}

	public BigDecimal getPairValue() {
		return pairValue;
	}

	public void setPairValue(BigDecimal pairValue) {
		this.pairValue = pairValue;
	}

	public StockType getType() {
		return type;
	}

	public void setType(StockType type) {
		this.type = type;
	}

}
