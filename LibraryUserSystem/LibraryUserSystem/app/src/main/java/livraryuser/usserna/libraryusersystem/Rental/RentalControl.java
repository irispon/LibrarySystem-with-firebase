package livraryuser.usserna.libraryusersystem.Rental;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import livraryuser.usserna.libraryusersystem.DB.FireBaseConstans;

public class RentalControl {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private String barcord;



    public RentalControl(String barcord){
        this.barcord = barcord;


    }

    public void Rental(){


        ValueEventListener valueEventListener=  new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.child(FireBaseConstans.BARCORD).exists()){
//                     Log.e("데이터 검색", ""+dataSnapshot.getValue());

                    if(dataSnapshot.child(FireBaseConstans.RENTALCHECK).getValue().toString().equals("true")){

                        databaseReference.child(FireBaseConstans.PAR_USER).child(FireBaseConstans.getUserName()).child(FireBaseConstans.B_LIST).child(barcord).setValue(barcord);
                        databaseReference.child(FireBaseConstans.PAR_BOOKS).child(barcord).child(FireBaseConstans.RENTALCHECK).setValue("false");
                    }


                }
                else{

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("데이터 검색", "실패");

            }
        };

        databaseReference.child(FireBaseConstans.PAR_BOOKS).child(barcord).addListenerForSingleValueEvent(valueEventListener);

    }

}
