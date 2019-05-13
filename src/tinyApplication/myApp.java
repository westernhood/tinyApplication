package tinyApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class myApp {
	private static final Logger logger = LoggerFactory.getLogger(myApp.class);
	
	public static void main(String[] args) {
		Instrument.Builder builder = new Instrument.Builder();
		
		Instrument instrument = builder.withDeliveryDate(myApp.fromString("17-03-2018"))
				.withTradingDate(myApp.fromString("15-03-2018")).withMarket("PB").withLabel("Lead 13 March 2018")
				.withSource("LME").withAlternateId("INSTRUMENT_CODE", "PB_03_2018").build();
		
		Instrument lmeinstrument = new Instrument.Builder().withDeliveryDate(myApp.fromString("17-03-2018"))
				.withTradingDate(myApp.fromString("15-03-2018")).withMarket("PB").withLabel("Lead 13 March 2018")
				.withSource("LME").withAlternateId("LME_CODE", "PB_03_2018").withAlternateId("LME", "PB_03_2018").build();

		Instrument primeInstrument = new Instrument.Builder().withDeliveryDate(myApp.fromString("17-03-2018"))
				.withTradingDate(myApp.fromString("15-03-2018")).withMarket("LME_PB").withLabel("Lead 13 March 2018")
				.withSource("PRIME").withAlternateId("EXCHANGE_CODE", "PRIME_PB_03_2018").tradable(false).build();

		logger.info("{}", instrument);
		logger.info("{}", lmeinstrument);
		logger.info("{}", primeInstrument);
	}

	public static Date fromString(String date) {
		try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
		}
		return null;
	}
}
