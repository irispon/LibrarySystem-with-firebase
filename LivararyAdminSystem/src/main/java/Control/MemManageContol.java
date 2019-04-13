package Control;



import java.awt.Component;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.LivararyAdminSystem.web.FBCallBack;
import com.google.firebase.database.DataSnapshot;

import FireBase.FirebaseManager;
import java.util.Vector;

public class MemManageContol extends FBCallBack{
	final int SETTING = 0;
	
	private JTable table;
	private FirebaseManager fb = FirebaseManager.getFirebasObject();

	
	
	public MemManageContol(JTable table) {
		
		this.table = table;
		
		
	}
	
	
	public void settingData() {
		
		fb.getData(fb.getFireBaseINFO().user.toString(), this, SETTING);
		
	}
	
	
	private void setting(DataSnapshot snapShot) {
		
		Iterator<DataSnapshot> par = snapShot.getChildren().iterator();
		Iterator<DataSnapshot> child;
		Iterator<DataSnapshot> Dchild;
	    Vector colum=new Vector();  
	    Vector value= new Vector();
	    Vector childValue;
	    
	    colum.add("아이디");
	    colum.add("비밀번호");
	    colum.add("대여목록");
	    
		for(DataSnapshot data;par.hasNext();) {
			data = par.next();
			System.out.println(data);
			childValue = new Vector();
			child = data.getChildren().iterator();
			for(DataSnapshot subData;child.hasNext() ;) {
				subData = child.next();
	
				if(subData.hasChildren()) {
					Dchild= subData.getChildren().iterator();
					String rentalList="";
					for(DataSnapshot DsubData; Dchild.hasNext();) {
						DsubData = Dchild.next();
						rentalList =rentalList+DsubData.getValue().toString()+"  ";
						
					}
					
					System.out.println("렌탈리스트"+rentalList);
					childValue.add(rentalList);
				}else {
					System.out.println(subData+"서브데이터"+"\n subData.getValue():"+subData.getValue()+"\n");
					childValue.add(subData.getValue());
				}
			
				
			}
				
			value.add(childValue);
			
		}
        DefaultTableModel model= new DefaultTableModel(value,colum);
		table.setModel(model);
		TableColumnModel columnModel = table.getColumnModel();
		
		
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
	
	public void delete(int low) {
		
		
		if(low>=0) {
			DefaultTableModel model =(DefaultTableModel)table.getModel();
			String id;
			id =model.getValueAt(low, 0).toString();

			fb.delData(fb.getFireBaseINFO().user.toString(),id );
			model.removeRow(low);
		}
		
		
		
		
	}
	public void change(int low) {
		
		
		if(low>=0) {
	
			DefaultTableModel model =(DefaultTableModel)table.getModel();
			String id;
			String password;
			id =model.getValueAt(low, 0).toString();
			password =model.getValueAt(low, 1).toString();
			System.out.println("실행됨?"+password);
			fb.setData(fb.getFireBaseINFO().user.Userinfo(id),fb.getFireBaseINFO().user.PASSWORD, password);

		}
		
		
		
		
	}

	@Override
	public void FBMessage(DataSnapshot snapShot, int flag) {
		// TODO Auto-generated method stub
		if(flag==SETTING) {
			setting(snapShot);
		//	System.out.println(snapShot.toString());
		}
		
	}
	
}
