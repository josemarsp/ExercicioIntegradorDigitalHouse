package br.com.josef.desafiodrawerrecycler.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import br.com.josef.desafiodrawerrecycler.R;

public class LoginActivity extends AppCompatActivity {

    public static final String EMAIL_KEY = "email";
    public static final String SENHA_KEY = "senha";

    private TextInputLayout txtEmail;
    private TextInputLayout txtSenha;
    private Button btnLogin;
    private Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaDados();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        txtEmail = findViewById(R.id.txtLEmail);
        txtSenha = findViewById(R.id.txtLPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void validaDados() {
        String email = txtEmail.getEditText().getText().toString();
        String senha = txtSenha.getEditText().getText().toString();

//        if (!email.isEmpty()) {
//            txtEmail.setError("Email não pode ser vazio");
//            return;
//        }
//
//        if (!senha.isEmpty()) {
//            txtSenha.setError("Senha não pode ser branca");
//            return;
//        }

        if (!email.isEmpty() && !senha.isEmpty()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(EMAIL_KEY, email);
            bundle.putString(SENHA_KEY, senha);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }


}

