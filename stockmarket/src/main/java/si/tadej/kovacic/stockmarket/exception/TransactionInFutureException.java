package si.tadej.kovacic.stockmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Transaction in future")
public class TransactionInFutureException extends RuntimeException {

}
