package si.tadej.kovacic.stockmarket.exception;


public class StockNotFoundException extends RuntimeException {

	public StockNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StockNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StockNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StockNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
