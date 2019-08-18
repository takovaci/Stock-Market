package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * extending Stock with specific method implementation for preferred stocks
 * 
 * @author tadej
 *
 */
public class PreferredStock extends Stock {

	private BigDecimal fixedDividend;

	public PreferredStock(String stockSymbol, BigDecimal lastDividend, BigDecimal pairValue, BigDecimal fixedDividend) {
		super(stockSymbol, lastDividend, pairValue);
		this.fixedDividend = fixedDividend;
	}

	public BigDecimal getFixedDividend() {
		return fixedDividend;
	}

	public BigDecimal calculateDividendYield(BigDecimal price) {
		if (this.getFixedDividend().equals(BigDecimal.ZERO)) {
			return BigDecimal.ZERO;
		} else {
			return this.getFixedDividend().multiply(this.getPairValue())
					.divide(price, new MathContext(10, RoundingMode.HALF_UP)).divide(new BigDecimal(100)); // divide
																											// with 100
																											// to get
																											// percentage
																											// for fixed
																											// dividend
		}
	}

}
