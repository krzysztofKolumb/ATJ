package atj.nbp.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Rate")
public class Rate {
	
	@XmlElement(name="No")
	private String No;
	
	@XmlElement(name="EffectiveDate")
	private String EffectiveDate;
	
	@XmlElement(name="Mid")
	private Double Mid;
	
	@XmlElement(name="Bid")
	private Double Bid;
	
	@XmlElement(name="Ask")
	private Double Ask;
	
	public Rate() {}

	public Rate(String no, String effectiveDate, Double mid) {
		No = no;
		EffectiveDate = effectiveDate;
		Mid = mid;
	}
	
	public Rate(String no, String effectiveDate, Double bid, Double ask) {
		No = no;
		EffectiveDate = effectiveDate;
		Bid = bid;
		Ask = ask;

	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		EffectiveDate = effectiveDate;
	}

	public Double getMid() {
		return Mid;
	}

	public void setMid(Double mid) {
		Mid = mid;
	}
	
	public Double getBid() {
		return Bid;
	}

	public void setBid(Double bid) {
		Bid = bid;
	}
	
	public Double getAsk() {
		return Ask;
	}

	public void setAsk(Double ask) {
		Ask = ask;
	}
		
}
