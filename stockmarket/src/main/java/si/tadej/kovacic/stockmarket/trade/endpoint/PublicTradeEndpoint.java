package si.tadej.kovacic.stockmarket.trade.endpoint;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import si.tadej.kovacic.stockmarket.api.endpoint.PublicTradeApi;
import si.tadej.kovacic.stockmarket.api.model.TradeRecord;
import si.tadej.kovacic.stockmarket.trade.service.TradeService;

/**
 * implementation of trade endpoint, all validation is moved to interface
 * 
 * @author tadej
 *
 */

@Api
@RequestMapping(value = "/api/public/trade")
@RestController
@Validated
public class PublicTradeEndpoint implements PublicTradeApi {

	@Autowired
	private TradeService tradeService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void recordTrade(TradeRecord tradeRecord) {
		tradeService.recordTrade(tradeRecord);

	}

	@GetMapping(path = "/calculateVolumeWeightedStockPrice/{stockSymbol}/{minutes}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BigDecimal calculateVolumeWeightedStockPrice(String stockSymbol, Long minutes) {
		return tradeService.calculateVolumeWeightedStockPrice(stockSymbol.toUpperCase(), minutes);
	}

	@GetMapping(path = "/calculateGBCEAllShareIndex", produces = MediaType.APPLICATION_JSON_VALUE)
	public BigDecimal calculateGBCEAllShareIndex() {
		return tradeService.calculateGBCEShareIndex();
	}

}
