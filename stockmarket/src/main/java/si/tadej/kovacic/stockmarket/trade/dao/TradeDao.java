package si.tadej.kovacic.stockmarket.trade.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import si.tadej.kovacic.stockmarket.api.model.TradeRecord;

/**
 * Dao class which is taking care of storing and retrieving trade data
 * 
 * @author tadej
 *
 */
@Component
public class TradeDao {
	// map is used to group trades by stock symbol
	// TreeMap is used to sort trades by time
	private final Map<String, TreeMap<LocalDateTime, TradeRecord>> tradeRecordStore = new HashMap<>();

	private Integer numberOfTrades = 0;
	private Double sumLogPrices = 0d;

	/**
	 * before trade is save, number of trades in increased and price multiplied with
	 * previous prices for calculating geometric mean
	 * 
	 * @param tradeRecord
	 */
	public void save(TradeRecord tradeRecord) {
		numberOfTrades++;
		sumLogPrices += Math.log(tradeRecord.getTradedPrice().doubleValue());
		TreeMap<LocalDateTime, TradeRecord> treeMap = getTreeMapForStock(tradeRecord.getStockSymbol());
		treeMap.put(tradeRecord.getTransactionTime(), tradeRecord);
	}

	/**
	 * 
	 * @param timeFrom
	 * @param stockSymbol
	 * @return all trades for specific stock symbol from provided timestamp
	 */
	public List<TradeRecord> getLastTrades(LocalDateTime timeFrom, String stockSymbol) {
		if (!tradeRecordStore.containsKey(stockSymbol)) {
			return new ArrayList<>();
		} else {
			SortedMap<LocalDateTime, TradeRecord> result = tradeRecordStore.get(stockSymbol).tailMap(timeFrom);
			return new ArrayList<>(result.values());
		}
	}

	public GeometricMeanParams getAllTradeRecords() {
		return new GeometricMeanParams(numberOfTrades, sumLogPrices);

	}

	/**
	 * this method is extracted for easier readability
	 * 
	 * @param stockSymbol
	 * @return
	 */
	private TreeMap<LocalDateTime, TradeRecord> getTreeMapForStock(String stockSymbol) {
		/*
		 * If we don't have any record for that stock, we have to create new entry in
		 * Map.
		 */
		if (!tradeRecordStore.containsKey(stockSymbol)) {
			TreeMap<LocalDateTime, TradeRecord> treeMap = new TreeMap<>();
			tradeRecordStore.put(stockSymbol, treeMap);
			return treeMap;
		} else {
			return tradeRecordStore.get(stockSymbol);
		}
	}
}
