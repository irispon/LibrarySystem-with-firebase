package Control;

import com.LivararyAdminSystem.web.FBCallBack;
import com.google.firebase.database.DataSnapshot;
import javax.swing.JOptionPane;
import FireBase.FirebaseManager;

public class JoinControl extends FBCallBack {
	private String id;
	private String password;
	
	FirebaseManager fbManager = FirebaseManager.getFirebasObject();
	
	public void join(String id, String password ) {
		this.id = id;
		this.password = password;
		fbManager.getData(fbManager.getFireBaseINFO().user.toString(), this, 1);
		
	}
	
	
	
	
	
	@Override
	public void FBMessage(DataSnapshot snapShot,int flag) {
		// TODO Auto-generated method stub
		
		System.out.println(snapShot.child("/"+id).exists());
		if(snapShot.child("/"+id).exists()) {
			new JOptionPane().showMessageDialog(null, "이미 있는 아이디입니다.");
			
		}else {
			new JOptionPane().showMessageDialog(null, "가입 성공!");
			fbManager.setData(fbManager.getFireBaseINFO().user.toString()+"/"+id,"ID",id);
			fbManager.setData(fbManager.getFireBaseINFO().user.toString()+"/"+id,"Password",password);
		}
		
	}

}
