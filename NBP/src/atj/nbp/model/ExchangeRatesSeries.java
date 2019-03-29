package atj.nbp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ExchangeRatesSeries")  
public class ExchangeRatesSeries {
	
	@XmlElement(name="Table")
	private String Table;
	
	@XmlElement(name="Currency")
	private String Currency;
	
	@XmlElement(name="Code")
	private String Code;
	
	@XmlElement(name="Rates")
	private Rates Rates;

	public ExchangeRatesSeries() {}

	public ExchangeRatesSeries(String table, String currency, String code, Rates rates) {
		super();
		Table = table;
		Currency = currency;
		Code = code;
		Rates = rates;
	}

	public String getTable() {
		return Table;
	}

	public void setTable(String table) {
		Table = table;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}
	
	public Rates getRates(){
		return Rates;
	}
	
}
