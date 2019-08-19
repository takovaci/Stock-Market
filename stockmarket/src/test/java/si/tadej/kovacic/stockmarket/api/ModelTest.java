package si.tadej.kovacic.stockmarket.api;

import static org.junit.Assert.assertEquals;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import pl.pojo.tester.api.assertion.Method;
import si.tadej.kovacic.stockmarket.AbstractTest;
import si.tadej.kovacic.stockmarket.api.model.CommonStock;
import si.tadej.kovacic.stockmarket.api.model.PreferredStock;
import si.tadej.kovacic.stockmarket.api.model.Stock;
import si.tadej.kovacic.stockmarket.api.model.StockRequest;
import si.tadej.kovacic.stockmarket.api.model.TradeRecord;

@RunWith(MockitoJUnitRunner.class)
public class ModelTest extends AbstractTest{

	private static final List<Class<?>> instances = new ArrayList<>();

	@Before
	public void setup() {
		instances.add(CommonStock.class);
		instances.add(PreferredStock.class);
		instances.add(Stock.class);
		instances.add(TradeRecord.class);
		instances.add(StockRequest.class);
	}

	@Test
	public void modelTest() {
		for (Class<?> instace : instances) {
			assertPojoMethodsFor(instace).testing(Method.CONSTRUCTOR, Method.GETTER, Method.TO_STRING, Method.SETTER);
		}
	}

	@Test
	public void testCalculateCommonStockTest() {
		assertEquals(commonStock.calculateDividendYield(price), lastDividend.divide(price));
		assertEquals(commonStock.calculatePERation(price),
				price.divide(lastDividend, new MathContext(10, RoundingMode.HALF_UP)));
	}

	@Test
	public void testCalculatePreferredStockTest() {
		assertEquals(preferredStock.calculateDividendYield(price), fixedDividend.multiply(pairValue)
				.divide(price, new MathContext(10, RoundingMode.HALF_UP)).divide(new BigDecimal(100)));
		assertEquals(preferredStock.calculatePERation(price),
				price.divide(lastDividend, new MathContext(10, RoundingMode.HALF_UP)));
	};
}
