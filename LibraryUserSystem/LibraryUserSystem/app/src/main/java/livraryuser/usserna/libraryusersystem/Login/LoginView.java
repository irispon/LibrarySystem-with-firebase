package livraryuser.usserna.libraryusersystem.Login;



import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import livraryuser.usserna.libraryusersystem.R;


public class LoginView extends Activity {

    private String id;
    private String password;
    private EditText Id;
    private EditText Password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);
        Initialize();

    }

    private void Initialize(){


        Id =(EditText)findViewById(R.id.key);
        Password=(EditText)findViewById(R.id.value);

    }

    public void Enter(View v){

        //이 부분 나중에 리펙토링 필요할듯

        id= Id.getText().toString();
        password =  Password.getText().toString();

        Runnable r = new ConcreteRunnable();
        Thread login = new Thread(r);
        login.setDaemon(true);
        login.start();


    }

    class ConcreteRunnable implements Runnable {
        int idcheck=3;
        IdCheck idCheck= new IdCheck(id,password);
        @Override
        public void run() {


do {
    idcheck = idCheck.isCheck;
        if (idcheck == 1) {
            Message msg = mainHandler.obtainMessage();
            msg.what = 1;
            mainHandler.sendMessage(msg);
            System.out.println("11111111111"+idcheck);

        } else if (idcheck == 0) {
            Message msg = mainHandler.obtainMessage();
            msg.what = 0;
            mainHandler.sendMessage(msg);
            System.out.println("0000000"+idcheck);

        } else {
            Message msg = mainHandler.obtainMessage();

            System.out.println("123456"+idcheck);
        }


        try {
            Thread.sleep(1000);
        }catch (Throwable a){

    }
        }while (idcheck == 3);
        }


    }

    android.os.Handler mainHandler = new android.os.Handler()
    {
        public void handleMessage(Message msg)
        {
            if (msg.what == 1)
            {
                Toast.makeText(getApplicationContext(), "환영합니다!", Toast.LENGTH_LONG).show();
               finish();
            }else if(msg.what == 0){

                Toast.makeText(getApplicationContext(), Id.getText().toString() + "비밀번호가 틀렸습니다." + Password.getText().toString(), Toast.LENGTH_LONG).show();
                Id.setText("");
                Password.setText("");
            }
        };
    };

    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()== MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }
}
