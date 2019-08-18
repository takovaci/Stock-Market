package si.tadej.kovacic.stockmarket.api.endpoint;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonFormat;

import si.tadej.kovacic.stockmarket.api.model.IStock;
import si.tadej.kovacic.stockmarket.api.model.StockRequest;

public interface PublicStockApi extends PublishableEndpoint {

	IStock get(@NotEmpty @PathVariable String stockSymbol);

	void createOrUpdate(@Valid @RequestBody StockRequest stock);

	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT) // adding json formatter properties, for converting bigDecimal to
														// json
	BigDecimal calculateDividendYield(@PathVariable @NotEmpty String stockSymbol,
			@PathVariable @Positive BigDecimal price);

	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT) // adding json formatter properties, for converting bigDecimal to
														// json
	BigDecimal calculatePERatio(@PathVariable @NotEmpty String stockSymbol, @PathVariable @Positive BigDecimal price);
}
