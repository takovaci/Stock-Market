package si.tadej.kovacic.stockmarket.trade.endpoint;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import si.tadej.kovacic.stockmarket.api.model.TradeRecord;
import si.tadej.kovacic.stockmarket.api.model.TradeType;
import si.tadej.kovacic.stockmarket.trade.service.TradeService;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PublicTradeEndpointTest {
	
	private TradeRecord tradeRecord = new TradeRecord(LocalDateTime.now(),new BigDecimal(2), TradeType.SELL, new BigDecimal(4), "abc");
	
	@Mock 
	private TradeService mockTradeService;
	
	@InjectMocks
	private PublicTradeEndpoint testPublicTradeEndpoint;
	
	@Test
	public void recordTrade() {
		
		testPublicTradeEndpoint.recordTrade(tradeRecord);
	}
	
	@Test
	public void recordTradeNull() {
		//testPublicTradeEndpoint.recordTrade();
	}

}
