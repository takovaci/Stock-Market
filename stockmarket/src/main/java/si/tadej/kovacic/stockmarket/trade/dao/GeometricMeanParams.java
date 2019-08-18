package si.tadej.kovacic.stockmarket.trade.dao;

public class GeometricMeanParams {

	private Integer numberOfTrades;
	private Double multipliedPrices;

	public GeometricMeanParams(Integer numberOfTrades, Double multipliedPrices) {
		super();
		this.numberOfTrades = numberOfTrades;
		this.multipliedPrices = multipliedPrices;
	}

	public Integer getNumberOfTrades() {
		return numberOfTrades;
	}

	public void setNumberOfTrades(Integer numberOfTrades) {
		this.numberOfTrades = numberOfTrades;
	}

	public Double getMultipliedPrices() {
		return multipliedPrices;
	}

	public void setMultipliedPrices(Double multipliedPrices) {
		this.multipliedPrices = multipliedPrices;
	}

}
