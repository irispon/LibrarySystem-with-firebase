package com.LivararyAdminSystem.web;

import com.google.firebase.database.DataSnapshot;

public abstract  class FBCallBack {

	
	
	
	public abstract  void FBMessage(DataSnapshot snapShot,int flag);
	
	/*스탭샷 데이터를 받고 메인GUI 갱신 역할 */

}
