package si.tadej.kovacic.stockmarket.api.endpoint;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonFormat;

import si.tadej.kovacic.stockmarket.api.model.TradeRecord;

public interface PublicTradeApi extends PublishableEndpoint {

	void recordTrade(@Valid @RequestBody TradeRecord tradeRecord);

	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT) // adding json formatter properties, for converting bigDecimal to
														// json
	BigDecimal calculateVolumeWeightedStockPrice(@NotEmpty @PathVariable String stockSymbol,
			@Positive @PathVariable Long minutes);

	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT) // adding json formatter properties, for converting bigDecimal to
														// json
	BigDecimal calculateGBCEAllShareIndex();

}
