package br.com.josef.desafiodrawerrecycler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import br.com.josef.desafiodrawerrecycler.R;

public class LoginActivity extends AppCompatActivity {


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
        txtEmail = findViewById(R.id.txtLEmailLogin);
        txtSenha = findViewById(R.id.txtLPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void validaDados() {
        String email = txtEmail.getEditText().getText().toString();
        String senha = txtSenha.getEditText().getText().toString();

        txtEmail.setError(null);
        txtSenha.setError(null);

        int ValidaEmail = email.indexOf("@");

        if (email.isEmpty()) {
            txtEmail.setError("Email não pode ser vazio");
            return;
        } else if (ValidaEmail <= 0) {
            txtEmail.setError("Email precisa ter @");
            return;
        }


        if (senha.isEmpty()) {
            txtSenha.setError("Senha não pode ser branca");
            return;
        } else if (senha.length() < 6) {
            txtSenha.setError("A senha precisa ter 6 caracteres ou mais");
            return;
        }

        if (!email.isEmpty() && !senha.isEmpty()) {
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("EMAIL", email);
            bundle.putString("SENHA", senha);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }


}

