package si.tadej.kovacic.stockmarket;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import si.tadej.kovacic.stockmarket.api.model.CommonStock;
import si.tadej.kovacic.stockmarket.api.model.PreferredStock;
import si.tadej.kovacic.stockmarket.stock.service.StockService;

@Component
public class PrefillExampleStocks {

	@Autowired
	private StockService stockService;

	// prefilling stock data
	public void run() {
		stockService.save(new CommonStock("TEA", new BigDecimal(0), new BigDecimal(100)));
		stockService.save(new CommonStock("POP", new BigDecimal(8), new BigDecimal(100)));
		stockService.save(new CommonStock("ALE", new BigDecimal(23), new BigDecimal(60)));
		stockService.save(new CommonStock("JOE", new BigDecimal(13), new BigDecimal(250)));
		stockService.save(new PreferredStock("GIN", new BigDecimal(8), new BigDecimal(100), new BigDecimal(2)));
	}
}
