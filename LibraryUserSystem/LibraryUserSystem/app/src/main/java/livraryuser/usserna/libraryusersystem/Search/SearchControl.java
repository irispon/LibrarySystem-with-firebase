package livraryuser.usserna.libraryusersystem.Search;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import livraryuser.usserna.libraryusersystem.Search.Custom_Search_list.SearchAdater;
import livraryuser.usserna.libraryusersystem.Search.Custom_Search_list.SearchItem;
import livraryuser.usserna.libraryusersystem.DB.FireBaseConstans;

public class SearchControl {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private SearchItem searchItem;
    private SearchAdater searchAdater;

    public SearchControl(SearchAdater searchAdater){

        this.searchAdater = searchAdater;

    }

    public void itemSet(DataSnapshot dataSnapshot){


        databaseReference.child(FireBaseConstans.PAR_BOOKS).child(dataSnapshot.getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                searchItem = new SearchItem();
                searchItem.setbarcod(dataSnapshot.child(FireBaseConstans.BARCORD).getValue().toString());
                searchItem.setauthor(dataSnapshot.child(FireBaseConstans.AUTHOR).getValue(String.class));
                searchItem.setName(dataSnapshot.child(FireBaseConstans.BOOK_NAME).getValue(String.class));
                searchItem.setpublisher(dataSnapshot.child(FireBaseConstans.PUBLICSHER).getValue(String.class));
                Log.e("LOG", "확인:" +dataSnapshot.child(FireBaseConstans.PRICE).getValue(String.class));
                searchItem.setPrice(dataSnapshot.child(FireBaseConstans.PRICE).getValue(String.class));
                searchItem.setrental_Check(dataSnapshot.child(FireBaseConstans.RENTALCHECK).getValue().toString());

                searchAdater.addItem(searchItem);
                searchAdater.notifyDataSetChanged();
                Log.e("LOG", "확인:" + dataSnapshot.getKey());
                Log.e("LOG", "확인:" + dataSnapshot.getKey());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
