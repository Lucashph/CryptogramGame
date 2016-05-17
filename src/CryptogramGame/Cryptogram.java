package CryptogramGame;
//testing changese
public class Cryptogram {

	private String quotePerson;
	private String quote;
	
	public Cryptogram() {
		
		quotePerson = "\"Something interesting\" - Person Person";
		quote = "\"Something interesting\"";
	}
	
	public Cryptogram(String quotePerson) {
		
		this.quotePerson = quotePerson;
		for (int i = 1; i < quotePerson.length(); i++) {
			if (quotePerson.substring(i- 1, i).equals("\"")) {
				for (int j = i; !quotePerson.substring(j, j + 1).equals("\""); j++) {
					this.quote += quotePerson.substring(j, j + 1);
				}
				return;
			}
		}
	}
	
	public String getQuotePerson() {
		
		return quotePerson;
	}
	
	public String getQuote() {
		
		return quote;
	}
}
