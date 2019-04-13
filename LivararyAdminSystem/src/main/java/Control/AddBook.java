package Control;

import FireBase.FirebaseManager;

public class AddBook {
	
	FirebaseManager fb = FirebaseManager.getFirebasObject();
	
	public void setData(BookEntity BookInfo) {
		String barcord = BookInfo.BARCORD;
		String root = fb.getFireBaseINFO().BookINFO(BookInfo.BARCORD).barcord;
		fb.setData(root, fb.getFireBaseINFO().BookINFO(barcord).BARCORD, BookInfo.BARCORD);
		fb.setData(root, fb.getFireBaseINFO().BookINFO(barcord).AUTHOR, BookInfo.AUTHOR);
		fb.setData(root, fb.getFireBaseINFO().BookINFO(barcord).BOOKNAME, BookInfo.NAME);
		fb.setData(root, fb.getFireBaseINFO().BookINFO(barcord).RENTALFLAGE, BookInfo.RENTALFLAG);
		fb.setData(root, fb.getFireBaseINFO().BookINFO(barcord).PIRCE, BookInfo.PRICE);
		fb.setData(root, fb.getFireBaseINFO().BookINFO(barcord).PUBLICSHER, BookInfo.PUBLICSHER);
	}

}
