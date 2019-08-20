package si.tadej.kovacic.stockmarket.trade.endpoint;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import si.tadej.kovacic.stockmarket.AbstractTest;
import si.tadej.kovacic.stockmarket.trade.service.TradeService;

@RunWith(MockitoJUnitRunner.class)
public class PublicTradeEndpointTest extends AbstractTest{
	
	@Mock 
	private TradeService mockTradeService;
	
	@InjectMocks
	private PublicTradeEndpoint testPublicTradeEndpoint;
	
	@Test
	public void recordTradeTest() {
		testPublicTradeEndpoint.recordTrade(tradeRecord);
	}
	
	@Test
	public void calculateGBEShareIndexTest() {
		BigDecimal index = new BigDecimal(3.4);
		when(mockTradeService.calculateGBCEShareIndex()).thenReturn(index);	
		assertEquals(index,testPublicTradeEndpoint.calculateGBCEAllShareIndex());
	}
	
	@Test 
	public void calculateVolumeWeightedStockPriceTest() {
		Long minutes = 15l;
		BigDecimal index = new BigDecimal(33);
		when(mockTradeService.calculateVolumeWeightedStockPrice(stockSymbol, minutes)).thenReturn(index);
		assertEquals(index,testPublicTradeEndpoint.calculateVolumeWeightedStockPrice(stockSymbol, minutes));
	}

}
