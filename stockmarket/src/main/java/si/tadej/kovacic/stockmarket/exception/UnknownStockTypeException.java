package si.tadej.kovacic.stockmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Unknown Stock type")
public class UnknownStockTypeException extends RuntimeException {

}
