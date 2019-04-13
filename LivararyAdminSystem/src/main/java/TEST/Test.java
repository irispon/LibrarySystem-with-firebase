package TEST;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.boot.SpringApplication;

import com.LivararyAdminSystem.web.FBCallBack;
import com.google.firebase.database.DataSnapshot;

import FireBase.FireBaseData;
import FireBase.FirebaseManager;
import GUI.MainGUI;
public class Test extends FBCallBack {
		Frame frame = new Frame("ㅎㅎㅎ");
		Button button = new Button("ㅋㅋㅋ");
		FirebaseManager fm = FirebaseManager.getFirebasObject();
		Test context = this;
		FireBaseData fireBase = new FireBaseData();
		
	

		
		public void createFrame()
		{

		
		}


		
		private class testTh extends Thread{
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//프레임에 컴포넌트 추가
				frame.add(button);
				
				//프레임 크기 지정
				frame.setSize(300, 600);
				
				//프레임 보이기
				frame.setVisible(true);
				
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
				//		fm.getData("USER/irispon/Password", context);
						button.setName("ddd");
					}
				});
				
				
				super.run();
			}
		}



		@Override
		public void FBMessage(DataSnapshot snapShot,int flag) {
			// TODO Auto-generated method stub
			button.setName(snapShot.getValue(String.class));
			button.setLabel(snapShot.getValue(String.class));
		
			
		}


	}



