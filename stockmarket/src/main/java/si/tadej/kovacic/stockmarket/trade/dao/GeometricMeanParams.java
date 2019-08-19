package si.tadej.kovacic.stockmarket.trade.dao;

public class GeometricMeanParams {

	private Integer numberOfTrades;
	private Double sumLogPrices;

	public GeometricMeanParams(Integer numberOfTrades, Double sumLogPrices) {
		super();
		this.numberOfTrades = numberOfTrades;
		this.sumLogPrices = sumLogPrices;
	}

	public Integer getNumberOfTrades() {
		return numberOfTrades;
	}

	public void setNumberOfTrades(Integer numberOfTrades) {
		this.numberOfTrades = numberOfTrades;
	}

	public Double getSumLogPrices() {
		return sumLogPrices;
	}

	public void setSumLogPrices(Double sumLogPrices) {
		this.sumLogPrices = sumLogPrices;
	}

}
