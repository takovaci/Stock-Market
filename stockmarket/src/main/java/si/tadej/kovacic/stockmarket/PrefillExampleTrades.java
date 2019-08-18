package si.tadej.kovacic.stockmarket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import si.tadej.kovacic.stockmarket.api.model.TradeRecord;
import si.tadej.kovacic.stockmarket.api.model.TradeType;
import si.tadej.kovacic.stockmarket.trade.service.TradeService;

@Component
public class PrefillExampleTrades {

	@Autowired
	private TradeService tradeService;

	// prefilling trade data
	public void run() {
		tradeService.recordTrade(
				new TradeRecord(LocalDateTime.now(), new BigDecimal(1), TradeType.BUY, new BigDecimal(20), "TEA"));
		tradeService.recordTrade(
				new TradeRecord(LocalDateTime.now(), new BigDecimal(3), TradeType.BUY, new BigDecimal(20.1), "TEA"));
		tradeService.recordTrade(new TradeRecord(LocalDateTime.now().minusHours(1), new BigDecimal(3), TradeType.SELL,
				new BigDecimal(2000.1), "TEA"));
		tradeService.recordTrade(new TradeRecord(LocalDateTime.now().minusHours(1), new BigDecimal(2), TradeType.BUY,
				new BigDecimal(30), "POP"));
		tradeService.recordTrade(new TradeRecord(LocalDateTime.now().minusMinutes(1), new BigDecimal(8.2),
				TradeType.BUY, new BigDecimal(40), "ALE"));
	}
}
