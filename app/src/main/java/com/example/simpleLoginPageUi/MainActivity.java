package com.example.simpleLoginPageUi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogIn, btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogIn = findViewById(R.id.btnLogIn);
        btnReset = findViewById(R.id.btnReset);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainPage = new Intent(MainActivity.this, mainPage.class);

                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()){
                    if (username.isEmpty()){
                        edtUsername.requestFocus();
                        edtUsername.setError("Please enter username");
                        return;
                    }
                    edtPassword.requestFocus();
                    edtPassword.setError("Please enter password");
                    return;
                }

                if (username.matches("[a-zA-Z0-9_]+")){
                    if (    (username.equals("admin") && password.equals("1234")) ||
                            (username.equals("mdsalauddin") && password.equals("Mdsalauddin@1")) ||
                            (username.equals("toumik") && password.equals("Toumik@1")) ||
                            (username.equals("md_sahadat") && password.equals("mdsalauddin")) ||
                            (username.equals("sakil1905") && password.equals("Sakil@1"))
                    ){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Enter valid username or password", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else {
                    edtUsername.requestFocus();
                    edtUsername.setError("Special characters are not allowed except '_'");
                    return;
                }

                mainPage.putExtra("username", username);

                startActivity(mainPage);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUsername.setText("");
                edtPassword.setText("");

                edtUsername.setError(null);
                edtPassword.setError(null);
            }
        });
    }
}