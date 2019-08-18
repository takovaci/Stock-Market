package si.tadej.kovacic.stockmarket.stock.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.exception.StockNotFoundException;

/**
 * Dao class which is taking care of storing and retrieving stock data
 * 
 * @author tadej
 *
 */
@Component
public class StockDao {

	private final Map<String, IStock> stockStorage = new HashMap<>();

	public IStock get(String stockSymbol) {
		IStock stock = stockStorage.get(stockSymbol);
		if (stock == null) {
			throw new StockNotFoundException();
		}
		return stock;
	}

	public void save(IStock stock) {
		stockStorage.put(stock.getStockSymbol().toUpperCase(), stock);
	}

	public boolean checkStockSymbol(String stockSymbol) {
		return stockStorage.containsKey(stockSymbol.toUpperCase());
	}
}
