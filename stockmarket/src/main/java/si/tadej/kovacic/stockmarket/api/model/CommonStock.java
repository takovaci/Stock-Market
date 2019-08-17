package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.validation.constraints.NotNull;

public class CommonStock extends Stock{

	public CommonStock(@NotNull String stockSymbol, @NotNull BigDecimal lastDividend, @NotNull BigDecimal pairValue) {
		super(stockSymbol, lastDividend, pairValue);
	}

	public BigDecimal calculateDividendYield(BigDecimal price) {
		return this.getLastDividend().divide(price,new MathContext(4,RoundingMode.HALF_UP));
	}
}
