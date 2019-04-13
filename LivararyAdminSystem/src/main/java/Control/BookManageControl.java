package Control;

import java.awt.Component;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.LivararyAdminSystem.web.FBCallBack;
import com.google.firebase.database.DataSnapshot;

import FireBase.Book;
import FireBase.FirebaseManager;

public class BookManageControl extends FBCallBack {

	private final int SETTING = 0;
	private final int MAPPING = 1;
    private Vector value;
	private Vector colum;
	private DefaultTableModel model;
	
	JTable bookList;
	FirebaseManager fb = FirebaseManager.getFirebasObject();
	public BookManageControl(JTable bookList) {
		this.bookList = bookList;
		value = new Vector<>();
		
	}
	
	public void settingList() {
		clear();
		fb.getData(fb.getFireBaseINFO().BookINFO("").BOOK, this, SETTING);
		
		
		
	}
	public void delete(int low) {
//		clear();
		String value;
		value=model.getValueAt(low, 2).toString();
		System.out.println(value);
		fb.delData(fb.getFireBaseINFO().BookINFO(value).BOOK,value);

		settingList();
		
		
		
	}
	private void MappingData(String barcord) {
	
		fb.getData(fb.getFireBaseINFO().BookINFO(barcord).barcord, this, MAPPING);
	}

	
	private void SetInfo() {
		System.out.println(value.toString());
		System.out.println(colum.toString());
		  model= new DefaultTableModel(value,colum);
		  bookList.setModel(model);
		TableColumnModel columnModel = bookList.getColumnModel();
		
		/*체크*/
		
	    for (int column = 0; column < bookList.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < bookList.getRowCount(); row++) {
	            TableCellRenderer renderer = bookList.getCellRenderer(row, column);
	            Component comp = bookList.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
	
	
	
	private void clear() {
		if(model!=null)
		model.setRowCount(0);
		
	}
	
	
	
	
	
	@Override
	public void FBMessage(DataSnapshot snapShot, int flag) {
		// TODO Auto-generated method stub
	
		if(flag ==SETTING) {
			Iterator<DataSnapshot> iter = snapShot.getChildren().iterator();
			for(DataSnapshot snap;iter.hasNext();) {
				snap = iter.next();
			System.out.println(snap.getKey());
			MappingData(snap.getKey().toString());
				
			}

		}else if(flag==MAPPING) {
			
			Iterator<DataSnapshot> iter = snapShot.getChildren().iterator();
			 Vector childValue=new Vector();
			 colum = new Vector<>();
			for(DataSnapshot snap;iter.hasNext();) {
	
				snap = iter.next();
				System.out.println(snap.toString()+"확인입니다.");
				colum.add(snap.getKey());
				childValue.add(snap.getValue());
			}
			value.add(childValue);
			SetInfo();
			
			
		}
		
		
		
		
	}
	
}
