package livraryuser.usserna.libraryusersystem.Rental_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import livraryuser.usserna.libraryusersystem.Rental_list.Custom_Rental_list.Rental_List_Adater;
import livraryuser.usserna.libraryusersystem.Rental_list.Custom_Rental_list.Rental_List_Item;
import livraryuser.usserna.libraryusersystem.DB.FireBaseConstans;
import livraryuser.usserna.libraryusersystem.R;

/**
 * @uml.annotations
 *    uml_generalization="mmi:///#jsrctype^name=Activity[jcu^name=Activity.java[jpack^name=[jsrcroot^srcfolder=app/src/main/java[project^id=LibraryUserSystem]]]]$uml.Class"
 */
public class CheckView extends AppCompatActivity {
    private ListView mListView;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private Rental_List_Adater myAdaterr;
    private Rental_List_Item myItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_list);
        mListView = (ListView)findViewById(R.id.listView);
        myAdaterr = new Rental_List_Adater();
        dataSetting();

        mListView.setAdapter(myAdaterr);

    }



    private void dataSetting(){
try {
    databaseReference.child(FireBaseConstans.PAR_USER).child(FireBaseConstans.getUserName()).child(FireBaseConstans.B_LIST).addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            String barcord = dataSnapshot.getKey();

            Log.e("LOG", "s:" + barcord);
            itemSet(dataSnapshot);

        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            myAdaterr = new Rental_List_Adater();
            mListView.setAdapter(myAdaterr);
            itemSet(dataSnapshot);
        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

            Intent intent = new Intent(CheckView.this, CheckView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            finish();
            startActivity(intent);


        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
}catch (Throwable a){

}

}


 private void itemSet(DataSnapshot dataSnapshot){


     databaseReference.child(FireBaseConstans.PAR_BOOKS).child(dataSnapshot.getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             myItem = new Rental_List_Item();
             myItem.setbarcod(dataSnapshot.child(FireBaseConstans.BARCORD).getValue().toString());
             myItem.setauthor(dataSnapshot.child(FireBaseConstans.AUTHOR).getValue(String.class));
             myItem.setName(dataSnapshot.child(FireBaseConstans.BOOK_NAME).getValue(String.class));
             myItem.setpublisher(dataSnapshot.child(FireBaseConstans.PUBLICSHER).getValue(String.class));
             myAdaterr.addItem(myItem);
             myAdaterr.notifyDataSetChanged();
             Log.e("LOG", "�솗�씤:" + dataSnapshot.getKey());
         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {

         }
     });

 }

    }



