package livraryuser.usserna.libraryusersystem.Login;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import livraryuser.usserna.libraryusersystem.DB.FireBaseConstans;


public class IdCheck {

   private String id;
   private String DB_password;
   private  String password;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    public int isCheck=3;


    public IdCheck(final String id, final String password) {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        this.id = id;
        this.password =password;
        readData(new MyCallback() {
            @Override
            public void onCallback(String value) {
                if(password.equals(value)) {
                    Log.e("데이터 검색", ":" +value +isCheck+ ":");
                    isCheck = 1;
                    FireBaseConstans.setUserName(id);
                } else {
                    isCheck = 0;
                    Log.e("데이터 검색??", ":" +value +isCheck+ ":");

                }

            }
        });

    }



    private void readData(final MyCallback myCallback) {
      ValueEventListener valueEventListener=  new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DB_password = dataSnapshot.child(FireBaseConstans.PASSWORD).getValue(String.class);
                myCallback.onCallback(DB_password);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("데이터 검색", "실패");

            }
        };


        databaseReference.child(FireBaseConstans.PAR_USER).child(id).addListenerForSingleValueEvent(valueEventListener);


    }


    public interface MyCallback {
        void onCallback(String value);
    }

}
