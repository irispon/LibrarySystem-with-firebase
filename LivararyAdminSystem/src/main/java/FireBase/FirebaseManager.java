package FireBase;

import java.io.File;
import java.io.FileInputStream;

import com.LivararyAdminSystem.web.FBCallBack;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseManager {
	private static class SingleHolder{
		public static final FirebaseManager FIREBASEMANAGER = new FirebaseManager();}
	
	private FirebaseManager() {initiallize();}
	
	public void initiallize() {
		
			// Fetch the service account key JSON file contents
			try {
			FileInputStream serviceAccount = new FileInputStream(new File("").getAbsolutePath()+"\\account.json");
	
			// Initialize the app with a service account, granting admin privileges
			FirebaseOptions options = new FirebaseOptions.Builder()
			    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			    .setDatabaseUrl("https://librarytotalsystem.firebaseio.com")
			    .build();
			FirebaseApp.initializeApp(options);
				
			   System.out.println("���̾�̽� �ʱ�ȭ");
			}catch (Exception e) {
				// TODO: handle exception
			}
	
		
	}
	
	public static FirebaseManager getFirebasObject() {
		
		return SingleHolder.FIREBASEMANAGER;
		
	}

	
	
	//�ݹ� �Լ�. ������ �ҷ����Ⱑ �Ϸ�Ǹ� FBCallBack�� ��ӹ��� �ݹ��� �޼����� ����
	public void getData(String DBpath,FBCallBack callback,int flag) {
		
		DatabaseReference ref = FirebaseDatabase.getInstance()
			    .getReference(DBpath);
			ref.addListenerForSingleValueEvent(new ValueEventListener() {
			  @Override
			  public void onDataChange(DataSnapshot dataSnapshot) {
			    System.out.println("������ ���� �Ϸ�");
			    callback.FBMessage(dataSnapshot,flag);
			  }

			  @Override
			  public void onCancelled(DatabaseError error) {
			  }
			});
		
		
	}
	
	public void getData(String DBpath,FBCallBack callback,int flag,String Message) {
		
		DatabaseReference ref = FirebaseDatabase.getInstance()
			    .getReference(DBpath);
			ref.addListenerForSingleValueEvent(new ValueEventListener() {
			  @Override
			  public void onDataChange(DataSnapshot dataSnapshot) {
			    System.out.println("������ ���� �Ϸ�");
			    callback.FBMessage(dataSnapshot,flag);
			  }

			  @Override
			  public void onCancelled(DatabaseError error) {
			  }
			});
		
		
	}
	
	public void setData(String DBpath,String key,String value) {
		
		DatabaseReference ref = FirebaseDatabase.getInstance()
			    .getReference(DBpath);
			ref.child(key).setValueAsync(value);
			System.out.println(ref.child(key).toString());
		
		
	}
	public void delData(String DBpath,String key) {
		
		DatabaseReference ref = FirebaseDatabase.getInstance()
			    .getReference(DBpath);
			ref.child(key).removeValueAsync();
			System.out.println("�����Ϸ�");
	
		
	}	

	public FireBaseData getFireBaseINFO() {
		
		return new FireBaseData();
	}

}
