package si.tadej.kovacic.stockmarket.stock.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.api.model.TradeRecord;
import si.tadej.kovacic.stockmarket.stock.dao.StockDao;
import si.tadej.kovacic.stockmarket.trade.dao.TradeDao;

@Service
public class StockService {
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private TradeDao tradeDao;
	
	public BigDecimal calculateDividendYield(@NotNull String stockSymbol,@Positive BigDecimal price) {		
		IStock stock = stockDao.get(stockSymbol);
		return stock.calculateDividendYield(price);		
	}
	
	public BigDecimal calculatePERatio(@NotNull String stockSymbol, @Positive BigDecimal price) {
		IStock stock = stockDao.get(stockSymbol);
		return stock.calculatePERation(price);
	}
	
	public void recordTrade(TradeRecord tradeRecord) {
		tradeDao.save(tradeRecord);
	}
	
	public BigDecimal calculateVolumeWeightedStockPrice(String stockSymbol, Long minutes) {
		LocalDateTime timeFrom = LocalDateTime.now().minusMinutes(minutes);
		List<TradeRecord> lastTrades = tradeDao.getLastTrades(timeFrom, stockSymbol);
		BigDecimal tradedPriceQuantity = BigDecimal.ZERO;
		BigDecimal quantity = BigDecimal.ZERO;
		for(TradeRecord tr: lastTrades) {
			tradedPriceQuantity.add(tr.getQuantityOfShares().multiply(tr.getTradedPrice()));
			quantity.add(tr.getQuantityOfShares());
		}
		return tradedPriceQuantity.divide(quantity, new MathContext(4,RoundingMode.HALF_UP));		
	}
	
	public BigDecimal calculateGBCEShareIndex() {
		List<TradeRecord> trs = tradeDao.getAllTradeRecords();
		BigDecimal allPrices = BigDecimal.ONE;
		trs.size();
		for(TradeRecord tr:trs) {
			allPrices.multiply(tr.getTradedPrice());
		}
		// nth root of number can be calculated as 1/n power of that number 
		return new BigDecimal(Math.pow(allPrices.doubleValue(), 1/trs.size()),new MathContext(4,RoundingMode.HALF_UP));
	}
}
