package si.tadej.kovacic.stockmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StockmarketApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication
				.run(StockmarketApplication.class, args);
		// to prefill example stocks
		PrefillExampleStocks stocks = configurableApplicationContext.getBean(PrefillExampleStocks.class);
		stocks.run();
		// to prefill example trades
		PrefillExampleTrades trades = configurableApplicationContext.getBean(PrefillExampleTrades.class);
		trades.run();
	}

}
