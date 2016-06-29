package com.zeljkopratezina.myfirstapp_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static EditText username, password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public void LoginButton(){
        //first need to cast our variables
        username = (EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        attempts = (TextView)findViewById(R.id.textView_attempt_count);
        login_btn = (Button)findViewById(R.id.button_login);
        //counter - number of attempts are converted into text
        attempts.setText(Integer.toString(attempt_counter));
        //adding button click event
        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(username.getText().toString().equals("user")&&
                                password.getText().toString().equals("pass")){
                            //here we perform action with Toast
                            // - condition if user and password are correct
                            Toast.makeText(Login.this,"User and Password are correct",
                                    Toast.LENGTH_SHORT).show();
                            //if user and password are correct, Intent lead us to second page
                            Intent intent = new Intent("com.zeljkopratezina.myfirstapp_login.User");
                            startActivity(intent);
                        }
                        //Here we reduce number of counter
                        else{
                            Toast.makeText(Login.this,"User and Password are not correct",
                                    Toast.LENGTH_SHORT).show();
                            attempt_counter--;//reducing number of counter
                            //after reducing counter, we want to see again number of attempts
                            attempts.setText(Integer.toString(attempt_counter));
                            if(attempt_counter == 0){           //when counter become 0,
                                login_btn.setEnabled(false);    // button for login will be disabled
                            }
                        }

                    }
                }
        );


    }
}
