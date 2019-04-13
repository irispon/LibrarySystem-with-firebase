package FireBase;

public class  Book {
	public final String barcord;
	public final String PIRCE ="가격";
	public final String RENTALFLAGE="대여여부";
	public final String BARCORD ="바코드";
	public final String AUTHOR ="저자";
	public final String BOOKNAME ="책 이름";
	public final String PUBLICSHER="출판사";
	public final String BOOK = "Books";
 
	public final String RENTALFLAGPATH = "/대여여부";
	
	
	
	public Book(String barcord) {
		
		this.barcord = BOOK+"/"+barcord;

	}
	

	
	
	 
	
}
