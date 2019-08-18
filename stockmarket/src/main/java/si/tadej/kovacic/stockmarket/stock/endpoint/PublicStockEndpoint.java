package si.tadej.kovacic.stockmarket.stock.endpoint;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import si.tadej.kovacic.stockmarket.api.endpoint.PublicStockApi;
import si.tadej.kovacic.stockmarket.api.model.CommonStock;
import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.api.model.PreferredStock;
import si.tadej.kovacic.stockmarket.api.model.StockRequest;
import si.tadej.kovacic.stockmarket.exception.UnknownStockTypeException;
import si.tadej.kovacic.stockmarket.stock.service.StockService;

/**
 * implementation of stock endpoint, all validation is moved to interface
 * 
 * @author tadej
 *
 */
@Api
@RequestMapping(value = "/api/public/stock")
@RestController
@Validated
public class PublicStockEndpoint implements PublicStockApi {

	@Autowired
	private StockService stockService;

	@GetMapping(path = "/{stockSymbol}", produces = MediaType.APPLICATION_JSON_VALUE)
	public IStock get(String stockSymbol) {
		return stockService.get(stockSymbol.toUpperCase());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createOrUpdate(StockRequest stock) {
		/**
		 * which class have to be instantiated
		 */
		switch (stock.getType()) {
		case COMMON:
			stockService.save(new CommonStock(stock.getStockSymbol(), stock.getLastDividend(), stock.getPairValue()));
			break;
		case PREFERRED:
			stockService.save(new PreferredStock(stock.getStockSymbol(), stock.getLastDividend(), stock.getPairValue(),
					stock.getFixedDividend()));
			break;
		default:
			throw new UnknownStockTypeException();
		}
	}

	@GetMapping(path = "/calculateDividendYield/{stockSymbol}/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BigDecimal calculateDividendYield(String stockSymbol, BigDecimal price) {
		return stockService.calculateDividendYield(stockSymbol.toUpperCase(), price);
	}

	@GetMapping(path = "/calculatePERatio/{stockSymbol}/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BigDecimal calculatePERatio(String stockSymbol, BigDecimal price) {
		return stockService.calculatePERatio(stockSymbol.toUpperCase(), price);
	}

}
