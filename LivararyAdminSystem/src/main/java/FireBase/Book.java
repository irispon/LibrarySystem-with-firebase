package FireBase;

public class  Book {
	public final String barcord;
	public final String PIRCE ="����";
	public final String RENTALFLAGE="�뿩����";
	public final String BARCORD ="���ڵ�";
	public final String AUTHOR ="����";
	public final String BOOKNAME ="å �̸�";
	public final String PUBLICSHER="���ǻ�";
	public final String BOOK = "Books";
 
	public final String RENTALFLAGPATH = "/�뿩����";
	
	
	
	public Book(String barcord) {
		
		this.barcord = BOOK+"/"+barcord;

	}
	

	
	
	 
	
}
