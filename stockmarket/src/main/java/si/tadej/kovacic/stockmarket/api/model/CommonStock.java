package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * extending Stock with specific method implementation for common stocks
 * 
 * @author tadej
 *
 */
public class CommonStock extends Stock {

	public CommonStock(String stockSymbol, BigDecimal lastDividend, BigDecimal pairValue) {
		super(stockSymbol, lastDividend, pairValue);
	}

	public BigDecimal calculateDividendYield(BigDecimal price) {
		if (this.getLastDividend().equals(BigDecimal.ZERO)) {
			return BigDecimal.ZERO;
		} else {
			return this.getLastDividend().divide(price, new MathContext(10, RoundingMode.HALF_UP));
		}
	}
}
