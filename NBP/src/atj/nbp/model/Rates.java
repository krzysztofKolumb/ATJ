package atj.nbp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Rates")
public class Rates {

	@XmlElement(name="Rate")
	private List<Rate> Rates;
	
	public Rates() {}
	
	public Rates(List<Rate> rates) {
		Rates = rates;
	}

	public List<Rate> getRates() {
		return Rates;
	}

	public void setRates(List<Rate> rates) {
		Rates = rates;
	}
	
	
	
}
