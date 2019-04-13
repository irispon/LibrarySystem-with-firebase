package livraryuser.usserna.libraryusersystem.Search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import livraryuser.usserna.libraryusersystem.Search.Custom_Search_list.SearchAdater;
import livraryuser.usserna.libraryusersystem.DB.FireBaseConstans;
import livraryuser.usserna.libraryusersystem.R;

public class SearchView extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private SearchControl searchControl;
    private SearchAdater searchAdater;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchAdater = new SearchAdater();
        searchControl = new SearchControl(searchAdater);
        setContentView(R.layout.book_list);
        mListView = (ListView)findViewById(R.id.listView2);
        dataSetting();
        mListView.setAdapter(searchAdater);
        mListView.setTextFilterEnabled(true);

        EditText editTextFilter = (EditText)findViewById(R.id.search_input) ;
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString() ;
                ((SearchAdater)mListView.getAdapter()).getFilter().filter(filterText) ;
                Log.e("추적용",filterText);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }) ;




    }

    private void dataSetting(){
        try {
            databaseReference.child(FireBaseConstans.PAR_BOOKS).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String barcord = dataSnapshot.getKey();

                    Log.e("LOG", "s:" + barcord);
                    searchControl.itemSet(dataSnapshot);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                    Intent intent = new Intent(SearchView.this, SearchView.class);
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
}
