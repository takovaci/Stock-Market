package si.tadej.kovacic.stockmarket.trade.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import si.tadej.kovacic.stockmarket.api.model.TradeRecord;
import si.tadej.kovacic.stockmarket.trade.dao.GeometricMeanParams;
import si.tadej.kovacic.stockmarket.trade.dao.TradeDao;

@Service
public class TradeService {

	@Autowired
	private TradeDao tradeDao;

	public void recordTrade(TradeRecord tradeRecord) {
		tradeDao.save(tradeRecord);
	}

	/**
	 * Calculating Volume Weighted Stock Price, first we get all trades for provided
	 * time period, then all traded price multiplied with quantity and all quantity.
	 * At the end we divide both values
	 * 
	 * @param stockSymbol
	 * @param minutes
	 * @return Volume Weighted Stock Price
	 */
	public BigDecimal calculateVolumeWeightedStockPrice(String stockSymbol, Long minutes) {
		LocalDateTime timeFrom = LocalDateTime.now().minusMinutes(minutes);
		List<TradeRecord> lastTrades = tradeDao.getLastTrades(timeFrom, stockSymbol);
		BigDecimal tradedPriceQuantity = BigDecimal.ZERO;
		BigDecimal quantity = BigDecimal.ZERO;
		for (TradeRecord tr : lastTrades) {
			tradedPriceQuantity = tradedPriceQuantity.add(tr.getQuantityOfShares().multiply(tr.getTradedPrice()));
			quantity = quantity.add(tr.getQuantityOfShares());
		}
		return tradedPriceQuantity.divide(quantity, new MathContext(10, RoundingMode.HALF_UP));
	}

	/**
	 * this method is returning GBCE All Share Index using the geometric mean of
	 * prices for all stocks first we get records of all trades and then we
	 * calculate Geometric Mean
	 */
	public BigDecimal calculateGBCEShareIndex() {
		GeometricMeanParams allTradeRecords = tradeDao.getAllTradeRecords();
		/**
		 * nth root of number can be calculated as 1/n power of that number if we divide
		 * 1 with another integer we always get 0, that is why we need 1.0 so result is
		 * decimal value
		 */
		return new BigDecimal(Math.exp(allTradeRecords.getSumLogPrices() / allTradeRecords.getNumberOfTrades()),
				new MathContext(10, RoundingMode.HALF_UP));

	}

}
