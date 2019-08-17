package si.tadej.kovacic.stockmarket.trade.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import si.tadej.kovacic.stockmarket.api.model.TradeRecord;

@Component
public class TradeDao {

	private final Map<String, TreeMap<LocalDateTime, TradeRecord>> tradeRecordStore = new HashMap<>();

	public void save(TradeRecord tradeRecord) {
		TreeMap<LocalDateTime, TradeRecord> treeMap = getTreeMapForStock(tradeRecord.getStockSymbol());
		treeMap.put(tradeRecord.getTransactionTime(), tradeRecord);
	}

	public List<TradeRecord> getLastTrades(LocalDateTime timeFrom, String stockSymbol) {
		if(!tradeRecordStore.containsKey(stockSymbol)) {
			return new ArrayList<>();
		} else {
			SortedMap<LocalDateTime, TradeRecord> result = tradeRecordStore.get(stockSymbol).headMap(timeFrom); // tailMap
			return new ArrayList<>(result.values());
		}
	}
	
	public List<TradeRecord> getAllTradeRecords(){
		//first we have to get values of top level map, then values of tree map and then we have to flatten arrays of arrays
		return tradeRecordStore.values().stream().collect(Collectors.toList()).stream().map(x -> new ArrayList<>(x.values())).flatMap(List::stream)
		        .collect(Collectors.toList());
	}

	private TreeMap<LocalDateTime, TradeRecord> getTreeMapForStock(String stockSymbol) {
		/*
		 * If we don't have any record for that stock, we have to create new entry in Map.
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
