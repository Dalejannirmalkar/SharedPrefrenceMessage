package app.abhijeet.mrdhwaj.sharedprefrencemessage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText user,pass;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user= (EditText) findViewById(R.id.username);
        pass= (EditText) findViewById(R.id.password);
        button1= (Button) findViewById(R.id.save);
        button2= (Button) findViewById(R.id.Show);
        SharedPreferences sharedPreferences2=getSharedPreferences("userinfo",Context.MODE_PRIVATE);
        user.setText(sharedPreferences2.getString("username",""));
        pass.setText(sharedPreferences2.getString("password",""));

    }
    public void savedata(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",user.getText().toString());
        editor.putString("password",pass.getText().toString());
        editor.commit();

    }
    public void showdata(View view){
        SharedPreferences sharedPreferences1=getSharedPreferences("userinfo",Context.MODE_PRIVATE);
        String user1=sharedPreferences1.getString("username","");
        String pass1=sharedPreferences1.getString("password","");
        Toast.makeText(MainActivity.this,"Username :"+user1+"Password :"+pass1,Toast.LENGTH_LONG).show();


    }
}
