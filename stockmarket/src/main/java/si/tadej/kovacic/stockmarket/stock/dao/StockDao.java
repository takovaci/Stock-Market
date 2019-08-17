package si.tadej.kovacic.stockmarket.stock.dao;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.exception.StockNotFoundException;

@Component
public class StockDao {

	private final Map<String,IStock> stockStorage = new HashMap<>();
	
	public IStock get(@NotNull String stockSymbol) {
		IStock stock = stockStorage.get(stockSymbol);
		if(stock == null) {
			throw new StockNotFoundException(stockSymbol);
		}
		return stock;
	}
	
	public void save(@NotNull IStock stock) {
		stockStorage.put(stock.getStockSymbol().toUpperCase(), stock);
	}
	
	public boolean checkStockSymbol(@NotNull String stockSymbol) {
		return stockStorage.containsKey(stockSymbol.toUpperCase());
	}
}
