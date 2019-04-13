package TEST;

import com.LivararyAdminSystem.web.FBCallBack;
import com.google.firebase.database.DataSnapshot;

import FireBase.FirebaseManager;

public class CallbackTest extends FBCallBack{

	public CallbackTest() {
		// TODO Auto-generated constructor stub
		FirebaseManager fm = FirebaseManager.getFirebasObject();
		//fm.getData("USER/irispon/Password", this);
		
	}
	
	
	
	@Override
	public void FBMessage(DataSnapshot snapShot,int flag) {
		// TODO Auto-generated method stub
		
		System.out.println(snapShot.getValue());
		
	}

}
