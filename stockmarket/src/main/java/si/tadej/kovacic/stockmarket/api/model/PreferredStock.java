package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PreferredStock extends Stock{
	@Positive
	private BigDecimal fixedDividend;

	public PreferredStock(@NotNull String stockSymbol, @NotNull BigDecimal lastDividend, @NotNull BigDecimal pairValue, @NotNull BigDecimal fixedDividend) {
		super(stockSymbol, lastDividend, pairValue);
		this.fixedDividend = fixedDividend;			
	}

	public BigDecimal getFixedDividend() {
		return fixedDividend;
	}

	public BigDecimal calculateDividendYield(BigDecimal price) {
		return this.getFixedDividend().multiply(this.getPairValue()).divide(price,new MathContext(4,RoundingMode.HALF_UP));
	}
	
}
