package si.tadej.kovacic.stockmarket.stock.endpoint;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import si.tadej.kovacic.stockmarket.AbstractTest;
import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.api.model.StockRequest;
import si.tadej.kovacic.stockmarket.api.model.StockType;
import si.tadej.kovacic.stockmarket.stock.service.StockService;

@RunWith(MockitoJUnitRunner.class)
public class PublicStockEndpointTest extends AbstractTest{

	@Mock 
	private StockService mockStockService;
	
	@InjectMocks
	private PublicStockEndpoint testPublicStockEndpoint;
	
	@Test
	public void get() {
		when(mockStockService.get(stockSymbol)).thenReturn(commonStock);
		
		IStock iStock = testPublicStockEndpoint.get(stockSymbol);
		
		assertEquals(commonStock.getStockSymbol(), iStock.getStockSymbol());
		assertEquals(commonStock.getLastDividend(), iStock.getLastDividend());
		assertEquals(commonStock.getPairValue(), iStock.getPairValue());
		
	}
	
	@Test
	public void save() {
		StockRequest requestStock = new StockRequest();
		requestStock.setFixedDividend(fixedDividend);
		requestStock.setLastDividend(lastDividend);
		requestStock.setPairValue(pairValue);
		requestStock.setStockSymbol(stockSymbol);
		requestStock.setType(StockType.COMMON);
		testPublicStockEndpoint.createOrUpdate(requestStock);
	}
	
	@Test
	public void calculateDividendYieldTest() {
		BigDecimal dividendYield = new BigDecimal(33);
		when(mockStockService.calculateDividendYield(stockSymbol, price)).thenReturn(dividendYield);
		assertEquals(dividendYield,testPublicStockEndpoint.calculateDividendYield(stockSymbol, price));
	}
	
	@Test
	public void calculatePERatioTest() {
		BigDecimal peRatio = new BigDecimal(33);
		when(mockStockService.calculatePERatio(stockSymbol, price)).thenReturn(peRatio);
		assertEquals(peRatio,testPublicStockEndpoint.calculatePERatio(stockSymbol, price));
	}
}
