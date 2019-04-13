package livraryuser.usserna.libraryusersystem.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import livraryuser.usserna.libraryusersystem.R;

public class MainView extends AppCompatActivity {
MainControl mainControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);

        ImageView btn1 = (ImageView) findViewById(R.id.borrowBook);
        ImageView btn2 = (ImageView) findViewById(R.id.Check);
        ImageView btn3 = (ImageView) findViewById(R.id.InOut);
        ImageView btn4 = (ImageView) findViewById(R.id.search);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.borrowBook: //책 빌리기
                        mainControl.Rental();
                        break;
                    case R.id.Check://리스트 불러오기
                        mainControl.Check();
                        break;
                    case R.id.InOut: //작성
//                        mainControl.InOut();
                        break;
                    case R.id.search: //작성
                        mainControl.search();
                        break;

                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);

        mainControl = new MainControl(getApplicationContext());
    }


        public void onBackPressed() {
       android.os.Process.killProcess(android.os.Process.myPid());
        return;
    }
}
