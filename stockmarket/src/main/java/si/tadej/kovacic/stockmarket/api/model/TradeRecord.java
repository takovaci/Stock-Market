package si.tadej.kovacic.stockmarket.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TradeRecord {

	private LocalDateTime transactionTime;
	private BigDecimal quantityOfShares;
	private TradeType tradeType;
	private BigDecimal tradedPrice;
	private String stockSymbol;
	
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	public BigDecimal getQuantityOfShares() {
		return quantityOfShares;
	}
	public void setQuantityOfShares(BigDecimal quantityOfShares) {
		this.quantityOfShares = quantityOfShares;
	}
	public TradeType getTradeType() {
		return tradeType;
	}
	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
	public BigDecimal getTradedPrice() {
		return tradedPrice;
	}
	public void setTradedPrice(BigDecimal tradedPrice) {
		this.tradedPrice = tradedPrice;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	
	
}
