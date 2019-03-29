package atj.nbp.service;

import java.io.StringReader;
import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import atj.nbp.model.ExchangeRatesSeries;
import atj.nbp.model.Rate;

public class NBPService {
	private double mid = 0;
	private double bid = 0; //kupno
	private double ask = 0; //sprzedaz
	
	public ExchangeRatesSeries createExchangeRatesSeries(String table, String code, String topCount) {
		
		// wo³a us³ugê NBP 
		Client client = ClientBuilder.newClient();
		URI uri = URI.create("http://api.nbp.pl/api/exchangerates/rates/");		
		WebTarget webTarget = client.target(uri);
		webTarget = webTarget.path(table).path(code).path("last").path(topCount);
		
	    // pobiera kursy walut w formacie XML i JSON
		String xmlData = webTarget.request().accept(MediaType.APPLICATION_XML).get(String.class);
		//String jsonAnswer = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
	    // tworzy i zwraca obiekt ExchangeRatesSeries z pobranych danych z serwisu NBP
	    JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ExchangeRatesSeries.class);
		    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return (ExchangeRatesSeries)unmarshaller.unmarshal(new StringReader(xmlData));
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// TEXT
	public String getEverageExchangeRateTEXT(String table, String code, String topCount) {
		ExchangeRatesSeries ERS = createExchangeRatesSeries(table, code, topCount);
		List<Rate> rates = ERS.getRates().getRates();	
		int ratesSize = rates.size();

		if(table.toLowerCase().equals("c")) {
			rates.forEach(
					v-> {  bid += v.getBid();
						   ask += v.getAsk();  });	
			return "Œredni kurs kupna " + code + " z ostatnich " + ratesSize + " notowañ wynosi " + bid/ratesSize + 
						" pln, œredni kurs sprzeda¿y " + code + " z ostatnich " + ratesSize + " notowañ wynosi " + ask/ratesSize + " pln";	
			} else {
				rates.forEach(
					v-> mid += v.getMid() );
			
			mid = mid/ratesSize;
			return "Œredni kurs " + code + " (tabela " + table + ") z " + ratesSize + " ostatnich notowañ wynosi " + mid + " pln";
			}		
	}
	
	// HTML
	public String getEverageExchangeRateHTML(String table, String code, String topCount) {
		ExchangeRatesSeries ERS = createExchangeRatesSeries(table, code, topCount);
		List<Rate> rates = ERS.getRates().getRates();	
		int ratesSize = rates.size();

		if(table.toLowerCase().equals("c")) {
			rates.forEach(
					v-> {  bid += v.getBid();
						   ask += v.getAsk();  });	
			
				return	"	<!DOCTYPE html>" +
						"	<html> " +
						"		<head> " +
						"			<meta charset=\"UTF-8\">" +
						"			<title>NBP - kurs walut</title>" +
						"		</head> " +
						"		<body> " +
						"			<p>Œredni kurs <b>kupna "  + code + "</b> z ostatnich <b>" + ratesSize + "</b> notowañ wynosi <b>" +
									bid/ratesSize + "</b> pln<br /> Œredni kurs <b>sprzeda¿y " + code + "</b> z ostatnich <b>" + ratesSize + "</b> notowañ wynosi <b>" + ask/ratesSize + "</b> pln" +
						"			</p> " +
						"		</body> " +
						"	</html>";
			} else {
				rates.forEach(
					v-> mid += v.getMid() );
						
				return	"	<!DOCTYPE html>" +
						"	<html> " +
						"		<head> " +
						"			<meta charset=\"UTF-8\">" +
						"			<title>NBP - kurs walut</title>" +
						"		</head> " +
						"		<body> " +
						"			<p>Œredni kurs <b>" + code + "</b> (tabela " + table + ") z <b>" + ratesSize + "</b> ostatnich notowañ wynosi <b>" + mid/ratesSize + "</b> pln" +
						"			</p> " +
						"		</body> " +
						"	</html>";			
			
			}		
	}
	
	// XML
	public String getEverageExchangeRateXML(String table, String code, String topCount) {
		ExchangeRatesSeries ERS = createExchangeRatesSeries(table, code, topCount);
		List<Rate> rates = ERS.getRates().getRates();	
		int ratesSize = rates.size();

		if(table.toLowerCase().equals("c")) {
			rates.forEach(
					v-> {  bid += v.getBid();
						   ask += v.getAsk();  });	
			
				return	"	<?xml version=\"1.0\" encoding=\"utf-8\"?> " +
						"		<tabela> " + table + "</tabela>" +
						"		<waluta> " + code + "</waluta>" +
						"		<liczbaNotowan> " + topCount + "</liczbaNotowan>" +
						"		<sredniKursKupna> " + bid/ratesSize + " pln </sredniKursKupna>" +
						"		<sredniKursSprzedazy> " + ask/ratesSize + " pln </sredniKursSprzedazy>";
			} else {
				rates.forEach(
					v-> mid += v.getMid() );
				
				return	"	<?xml version=\"1.0\" encoding=\"utf-8\"?> " +
				"		<tabela> " + table + "</tabela>" +
				"		<waluta> " + code + "</waluta>" +
				"		<liczbaNotowan> " + topCount + "</liczbaNotowan>" +
				"		<sredniKurs> " + mid/ratesSize + " pln </sredniKurs>";
			}		
	}
	
	// JSON
	public String getEverageExchangeRateJSON(String table, String code, String topCount) {
		ExchangeRatesSeries ERS = createExchangeRatesSeries(table, code, topCount);
		List<Rate> rates = ERS.getRates().getRates();	
		int ratesSize = rates.size();

		if(table.toLowerCase().equals("c")) {
			rates.forEach(
					v-> {  bid += v.getBid();
						   ask += v.getAsk();  });	
			
				return	"	{ \"table\": \"" + table + "\"," +
						"	\"code\": \"" + code + "\"," +
						"	\"topCount\": \"" + topCount + "\"," +
						"	\"midBid\": \"" + bid/ratesSize + "\"," +
						"	\"midAsk\": \"" + ask/ratesSize + "\"}";

			} else {
				rates.forEach(
					v-> mid += v.getMid() );
				
				return	"	{ \"table\": \"" + table + "\"," +
						"	\"code\": \"" + code + "\"," +
						"	\"topCount\": \"" + topCount + "\"," +
						"	\"mid\": \"" + mid/ratesSize + "\"}";
			}		
	}
}
