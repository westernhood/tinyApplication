package tinyApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Instrument {
	private String label;
	private String source;
	private String market;
	private boolean tradable;
	private Date tradingDate;
	private Date deliveryDate;
	private Map<String, String> alternateIds = new HashMap<String, String>();

	public Instrument(Builder builder) {
		this.label = builder.label;
		this.source = builder.source;
		this.market = builder.market;
		this.tradable = builder.tradable;
		this.tradingDate = builder.tradingDate;
		this.deliveryDate = builder.deliveryDate;
		this.alternateIds = builder.alternateIds;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public boolean isTradable() {
		return tradable;
	}

	public void setTradable(boolean tradable) {
		this.tradable = tradable;
	}

	public Date getTradingDate() {
		return tradingDate;
	}

	public void setTradingDate(Date tradingDate) {
		this.tradingDate = tradingDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Map<String, String> getAlternateIds() {
		return alternateIds;
	}

	public void setAlternateIds(Map<String, String> alternateIds) {
		this.alternateIds = alternateIds;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String label;
		private String source;
		private String market;
		private Date tradingDate;
		private Date deliveryDate;
		private boolean tradable = true;
		private Map<String, String> alternateIds = new HashMap<>();

		public Builder tradable(boolean tradable) {
			this.tradable = tradable;
			return this;
		}

		public Builder withLabel(String label) {
			this.label = label;
			return this;
		}

		public Builder withSource(String exchange) {
			this.source = exchange;
			return this;
		}

		public Builder withMarket(String market) {
			this.market = market;
			return this;
		}

		public Builder withTradingDate(Date tradingDate) {
			this.tradingDate = tradingDate;
			return this;
		}

		public Builder withDeliveryDate(Date deliveryDate) {
			this.deliveryDate = deliveryDate;
			return this;
		}

		public Builder withAlternateIds(Map<String, String> alternateIds) {
			this.alternateIds = alternateIds;
			return this;
		}

		public Instrument build() {
			return new Instrument(this);
		}

		public Builder withAlternateId(String id, String value) {
			alternateIds.put(id, value);
			return this;
		}
	}

	public String toString() {
		return "Instrument [label=" + label + ", source=" + source + ", market=" + market + ", tradable=" + tradable + ", "
				+ "tradingDate=" + tradingDate + ", deliveryDate=" + deliveryDate+ ", alternateIds=" + alternateIds + "]";
	}
}
