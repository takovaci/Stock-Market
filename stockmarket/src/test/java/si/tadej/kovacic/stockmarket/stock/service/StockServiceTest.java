package si.tadej.kovacic.stockmarket.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import si.tadej.kovacic.stockmarket.AbstractTest;
import si.tadej.kovacic.stockmarket.stock.dao.StockDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest extends AbstractTest{
	
	@Mock 
	private StockDao mockStockDao;
	
	@InjectMocks
	private StockService mockStockService;
	
	@Test
	public void getTest() {
		when(mockStockDao.get(stockSymbol)).thenReturn(commonStock);
		
		assertEquals(mockStockService.get(stockSymbol),commonStock);
	}

	@Test
	public void calculateDividendYieldTest() {
		when(mockStockDao.get(stockSymbol)).thenReturn(commonStock);
		when(mockStockDao.get(stockSymbolP)).thenReturn(preferredStock);
		assertThat(commonStock.calculateDividendYield(price),  Matchers.comparesEqualTo(mockStockService.calculateDividendYield(stockSymbol, price)));
		assertThat(preferredStock.calculateDividendYield(price),  Matchers.comparesEqualTo(mockStockService.calculateDividendYield(stockSymbolP, price)));
	}
	
	@Test
	public void calculatePERationTest() {
		when(mockStockDao.get(stockSymbol)).thenReturn(commonStock);
		when(mockStockDao.get(stockSymbolP)).thenReturn(preferredStock);
		assertThat(commonStock.calculatePERation(price),  Matchers.comparesEqualTo(mockStockService.calculatePERatio(stockSymbol, price)));
		assertThat(preferredStock.calculatePERation(price),  Matchers.comparesEqualTo(mockStockService.calculatePERatio(stockSymbolP, price)));
	}
}
