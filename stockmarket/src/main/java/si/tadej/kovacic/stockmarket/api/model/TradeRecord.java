package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TradeRecord {
	@NotNull
	private LocalDateTime transactionTime;
	@Positive
	private BigDecimal quantityOfShares;
	@NotNull
	private TradeType tradeType;
	@Positive
	private BigDecimal tradedPrice;
	@NotEmpty
	private String stockSymbol;

	public TradeRecord(@NotNull LocalDateTime transactionTime, @Positive BigDecimal quantityOfShares,
			@NotNull TradeType tradeType, @Positive BigDecimal tradedPrice, @NotEmpty String stockSymbol) {
		super();
		if (transactionTime.isAfter(LocalDateTime.now())) {

		}
		this.transactionTime = transactionTime;
		this.quantityOfShares = quantityOfShares;
		this.tradeType = tradeType;
		this.tradedPrice = tradedPrice;
		this.stockSymbol = stockSymbol;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public BigDecimal getQuantityOfShares() {
		return quantityOfShares;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public BigDecimal getTradedPrice() {
		return tradedPrice;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}
}
