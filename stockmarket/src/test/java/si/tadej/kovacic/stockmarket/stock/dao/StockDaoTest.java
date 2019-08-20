package si.tadej.kovacic.stockmarket.stock.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import si.tadej.kovacic.stockmarket.AbstractTest;
import si.tadej.kovacic.stockmarket.api.model.IStock;

public class StockDaoTest extends AbstractTest{
	
	private StockDao dao;
	
	@Before
	public void setup() {
		dao = new StockDao();
	}
	
	@Test
	public void saveGetTest(){
		dao.save(commonStock);
		IStock result = dao.get(commonStock.getStockSymbol());
		
		assertEquals(commonStock.getLastDividend(), result.getLastDividend());
		assertEquals(commonStock.getPairValue(), result.getPairValue());
		assertEquals(commonStock.getStockSymbol(), result.getStockSymbol());
	}
	
	@Test
	public void checkStockSymbol() {
		dao.save(commonStock);
		
		assertTrue(dao.checkStockSymbol(commonStock.getStockSymbol()));
	}
}
