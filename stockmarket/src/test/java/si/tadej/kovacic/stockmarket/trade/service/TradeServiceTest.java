package si.tadej.kovacic.stockmarket.trade.service;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import si.tadej.kovacic.stockmarket.AbstractTest;
import si.tadej.kovacic.stockmarket.api.model.TradeRecord;
import si.tadej.kovacic.stockmarket.trade.dao.GeometricMeanParams;
import si.tadej.kovacic.stockmarket.trade.dao.TradeDao;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest extends AbstractTest {

	@Mock
	private TradeDao mockTradekDao;

	@InjectMocks
	private TradeService mockTradeService;
	
	private GeometricMeanParams gmp = new GeometricMeanParams(5, 22d);

	@Test
	public void calculateVolumeWeightedStockPriceTest() {
		List<TradeRecord> tradeRecordList = Arrays.asList(tradeRecord, tradeRecord2);
		when(mockTradekDao.getLastTrades(any(), any())).thenReturn(tradeRecordList);
		
		BigDecimal tradedPriceQuantity = BigDecimal.ZERO;
		BigDecimal quantity = BigDecimal.ZERO;
		for (TradeRecord tr : tradeRecordList) {
			tradedPriceQuantity = tradedPriceQuantity.add(tr.getQuantityOfShares().multiply(tr.getTradedPrice()));
			quantity = quantity.add(tr.getQuantityOfShares());
		}
		BigDecimal volumeWeightedStockPrice = tradedPriceQuantity.divide(quantity, new MathContext(10, RoundingMode.HALF_UP)); 
		
		assertThat(mockTradeService.calculateVolumeWeightedStockPrice(stockSymbol, 15l),  Matchers.comparesEqualTo(volumeWeightedStockPrice));
	}
	
	@Test
	public void calculateGBCEShareIndexTest() {
		when(mockTradekDao.getAllTradeRecords()).thenReturn(gmp);
		
		assertThat(mockTradeService.calculateGBCEShareIndex(), Matchers.comparesEqualTo(new BigDecimal(81.45086866, new MathContext(10, RoundingMode.HALF_UP))));
	}
}
