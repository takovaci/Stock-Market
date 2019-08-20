package si.tadej.kovacic.stockmarket.trade.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import si.tadej.kovacic.stockmarket.AbstractTest;

public class TradeDaoTest extends AbstractTest{
	
	private TradeDao dao;
	
	@Before
	public void setup() {
		dao = new TradeDao();
	}

	@Test
	public void getLastTradeTest() {
		dao.save(tradeRecord);
		dao.save(tradeRecord2);
		dao.save(tradeRecord3);
		dao.save(tradeRecord4);
		dao.save(tradeRecordB);
		dao.save(tradeRecordB2);
		dao.save(tradeRecordB3);
		dao.save(tradeRecordB4);
		assertEquals(3,dao.getLastTrades(LocalDateTime.now().minusMinutes(15), stockSymbol).size());
	}
	
	@Test
	public void getTradesRecordsTest() {
		dao.save(tradeRecord);
		dao.save(tradeRecord2);
		GeometricMeanParams geometricMeanParams = dao.getAllTradeRecords();
		assertEquals(2,geometricMeanParams.getNumberOfTrades().intValue());
		assertEquals(2*Math.log(tradeRecord.getTradedPrice().doubleValue()),geometricMeanParams.getSumLogPrices().doubleValue(), 0);
	}
}
