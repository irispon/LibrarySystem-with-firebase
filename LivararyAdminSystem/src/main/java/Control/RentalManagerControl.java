package Control;

import java.awt.Component;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.LivararyAdminSystem.web.FBCallBack;
import com.google.firebase.database.DataSnapshot;

import FireBase.Book;
import FireBase.FirebaseManager;

public class RentalManagerControl extends FBCallBack {
	
	FirebaseManager fb = FirebaseManager.getFirebasObject();
	final int SETTING =0;
	final int MAPPING =1;
	final int RENTAL = 2;
	final int CHECK =3;
	
	private JTable table;
    
    private Vector value;
	private Vector colum;
	private DefaultTableModel model;
	private String id;
	private String barcord;
	private boolean idExist;
	public RentalManagerControl(JTable table) {
		
		value= new Vector();
		idExist= false;

		 this.table=table;

	}
	
	
	public void settingList(String id) {
		 clear();
		fb.getData(fb.getFireBaseINFO().user.getRENTALLIST(id), this, SETTING);
		
		
		
	}
	
	public void RentalBook(String barcord,String id) {
		if(idExist == false) {
			this.id =id;
			this.barcord=barcord;
			Checkid();
			
		}else {
			
			fb.getData(fb.getFireBaseINFO().BookINFO(barcord).barcord, this, RENTAL);
			this.id =id;
			this.barcord=barcord;
			idExist=false;
			
		}
		
	}
	
	
	public void Delete(String id,int low) {
		String value;
		value=model.getValueAt(low, 2).toString();
		System.out.println(value);
		fb.delData(fb.getFireBaseINFO().user.getRENTALLIST(id),value);
		fb.setData(fb.getFireBaseINFO().BookINFO(barcord).barcord,fb.getFireBaseINFO().BookINFO(barcord).RENTALFLAGE ,"true");
		settingList(id);
		
		
	}
	private void Checkid() {
		
		fb.getData(fb.getFireBaseINFO().user.toString(), this, CHECK);
	}
	
	private void MappingData(String barcord) {
		
		fb.getData(fb.getFireBaseINFO().BookINFO(barcord).barcord, this, MAPPING);
		

		
	}
	
	
	private void SetInfo() {
	
		  model= new DefaultTableModel(value,colum);
		table.setModel(model);
		TableColumnModel columnModel = table.getColumnModel();
		
		/*체크*/
		
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
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
		if(flag == SETTING) {
			Iterator<DataSnapshot> iter = snapShot.getChildren().iterator();

			for(DataSnapshot snap;iter.hasNext();) {
				snap = iter.next();
			System.out.println(snap.getValue());
			MappingData(snap.getValue().toString());
				
			}
			

			
		}
		else if(flag == MAPPING) {
		
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
		else if(flag ==RENTAL) {
			
			String rflag = snapShot.child(fb.getFireBaseINFO().BookINFO(barcord).RENTALFLAGE).getValue().toString();
			System.out.println(rflag);
			if(snapShot.exists()&&!id.equals("")&&rflag.equals("true")) {
			System.out.println(snapShot.exists()+id+barcord);
			fb.setData(fb.getFireBaseINFO().user.getRENTALLIST(id), barcord, barcord);
			fb.setData(fb.getFireBaseINFO().BookINFO(barcord).barcord,fb.getFireBaseINFO().BookINFO(barcord).RENTALFLAGE ,"false");
			settingList(id);
			}
			
		}
		else if(flag ==CHECK) {
			
			System.out.println(snapShot.child(id));
			if(snapShot.exists()) {
				
				idExist =true;
				RentalBook(barcord, id);
			}else {
				idExist =false;
			}
		}
		
	
		
		
	}

	
	
	
	
}
