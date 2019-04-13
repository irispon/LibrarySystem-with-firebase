package livraryuser.usserna.libraryusersystem.Main;

import android.content.Context;
import android.content.Intent;

import livraryuser.usserna.libraryusersystem.Rental_list.CheckView;
import livraryuser.usserna.libraryusersystem.Login.LoginView;
import livraryuser.usserna.libraryusersystem.Rental.RentalView;
import livraryuser.usserna.libraryusersystem.Search.SearchView;
import livraryuser.usserna.libraryusersystem.View.*;

public class MainControl {
    Context context;
    Intent intent;

   public MainControl(Context context){
        this.context = context;
       intent = new Intent(context, LoginView.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
       context.startActivity(intent);


   }


    public void Rental(){
        intent = new Intent(context, RentalView.class);
        context.startActivity(intent);
    }
    public void Check(){
        intent = new Intent(context, CheckView.class);
        context.startActivity(intent);
    }
    public void InOut(){
        intent = new Intent(context, InOutView.class);
        context.startActivity(intent);
    }
    public void search(){


        intent = new Intent(context, SearchView.class);
        context.startActivity(intent);
    }

}
