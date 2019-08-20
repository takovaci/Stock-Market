package si.tadej.kovacic.stockmarket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import si.tadej.kovacic.stockmarket.api.model.CommonStock;
import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.api.model.PreferredStock;
import si.tadej.kovacic.stockmarket.api.model.TradeRecord;
import si.tadej.kovacic.stockmarket.api.model.TradeType;

public abstract class AbstractTest {

	protected BigDecimal lastDividend = new BigDecimal(24);
	protected BigDecimal pairValue = new BigDecimal(44);
	protected BigDecimal price = new BigDecimal(8);
	protected String stockSymbol = "AAA";
	protected String stockSymbolP = "AAAA";
	protected BigDecimal fixedDividend = new BigDecimal(3);
	
	protected IStock commonStock = new CommonStock(stockSymbol, lastDividend, pairValue);
	protected IStock preferredStock = new PreferredStock(stockSymbolP, lastDividend, pairValue, fixedDividend);
	
	protected TradeRecord tradeRecord = new TradeRecord(LocalDateTime.now(),new BigDecimal(2), TradeType.SELL, new BigDecimal(4), stockSymbol);
	protected TradeRecord tradeRecord2 = new TradeRecord(LocalDateTime.now().minusMinutes(5),new BigDecimal(2), TradeType.BUY, new BigDecimal(4), stockSymbol);
	protected TradeRecord tradeRecord3 = new TradeRecord(LocalDateTime.now().minusMinutes(12),new BigDecimal(2), TradeType.BUY, new BigDecimal(4), stockSymbol);
	protected TradeRecord tradeRecord4 = new TradeRecord(LocalDateTime.now().minusMinutes(16),new BigDecimal(2), TradeType.BUY, new BigDecimal(4), stockSymbol);
	protected TradeRecord tradeRecordB = new TradeRecord(LocalDateTime.now(),new BigDecimal(2), TradeType.SELL, new BigDecimal(4), "BBB");
	protected TradeRecord tradeRecordB2 = new TradeRecord(LocalDateTime.now().minusMinutes(5),new BigDecimal(2), TradeType.BUY, new BigDecimal(4), "BBB");
	protected TradeRecord tradeRecordB3 = new TradeRecord(LocalDateTime.now().minusMinutes(12),new BigDecimal(2), TradeType.BUY, new BigDecimal(4), "BBB");
	protected TradeRecord tradeRecordB4 = new TradeRecord(LocalDateTime.now().minusMinutes(16),new BigDecimal(2), TradeType.BUY, new BigDecimal(4), "BBB");
}
