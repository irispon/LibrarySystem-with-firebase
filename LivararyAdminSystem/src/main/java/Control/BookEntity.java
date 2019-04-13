package Control;

public class BookEntity {
	
	public String PRICE="";
	public String AUTHOR="";
	public String NAME="";
	public String PUBLICSHER="";
	public String BARCORD="";
	public String RENTALFLAG="true";
	
	public void setData(String PRICE,String AUTHOR,String NAME,String PUBLICSHER,String BARCORD) {
		this.PRICE= PRICE;
		this.AUTHOR =AUTHOR;
		this.NAME =NAME;
		this.BARCORD =BARCORD;
		this.PUBLICSHER =PUBLICSHER;
	}
	public String[] getData() {
		String[] bookinfo = {PRICE,AUTHOR,NAME,PUBLICSHER,BARCORD,RENTALFLAG};

		return bookinfo;
	}
	
}
