package si.tadej.kovacic.stockmarket.stock.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.stock.dao.StockDao;

/**
 * service for handling all business logic for working with stocks
 * 
 * @author tadej
 *
 */
@Service
public class StockService {

	@Autowired
	private StockDao stockDao;

	public IStock get(String stockSymbol) {
		return stockDao.get(stockSymbol);
	}

	public void save(IStock stock) {
		stockDao.save(stock);
	}

	public BigDecimal calculateDividendYield(String stockSymbol, BigDecimal price) {
		IStock stock = stockDao.get(stockSymbol);
		return stock.calculateDividendYield(price);
	}

	public BigDecimal calculatePERatio(String stockSymbol, BigDecimal price) {
		IStock stock = stockDao.get(stockSymbol);
		return stock.calculatePERation(price);
	}

}
