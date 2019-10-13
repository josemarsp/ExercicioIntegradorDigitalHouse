package br.com.josef.desafiodrawerrecycler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.security.PublicKey;

import br.com.josef.desafiodrawerrecycler.R;

public class RegistroActivity extends AppCompatActivity {
    private TextInputLayout txtEmail;
    private TextInputLayout txtNome;
    private TextInputLayout txtSenha;
    private TextInputLayout txt2xSenha;
    private Button btnRegistro;

    public static final String NOME_KEY = "NOME";
    public static final String EMAIL_KEY = "EMAIL";
    public static final String SENHA_KEY = "SENHA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        initViews();

        Intent intent = getIntent();

        if (getIntent() != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            String senha = bundle.getString(SENHA_KEY);
            String email = bundle.getString(EMAIL_KEY);
            String nome = bundle.getString(NOME_KEY);
            txtEmail.getEditText().setText(email);
            txtSenha.getEditText().setText(senha);
            txtNome.getEditText().setText(nome);
            txt2xSenha.getEditText().setText(senha);
        }

        if (txtNome.getEditText().getText().toString().isEmpty()){
            btnRegistro.setText("Finalizar Registro");
        }

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaDados();
            }

        });

    }

    private void validaDados() {
        String nome = txtNome.getEditText().getText().toString();
        String email = txtEmail.getEditText().getText().toString();
        String senha1 = txtSenha.getEditText().getText().toString();
        String senha2 = txt2xSenha.getEditText().getText().toString();

        txtNome.setError(null);
        txtEmail.setError(null);
        txtSenha.setError(null);
        txt2xSenha.setError(null);

        int ValidaEmail = email.indexOf("@");

        if (nome.isEmpty()) {
            txtNome.setError("O nome não pode ser branco");
            return;
        }

        if (email.isEmpty()) {
            txtEmail.setError("Email não pode ser vazio");
            return;
        } else if (ValidaEmail <= 0) {
            txtEmail.setError("Email precisa ter @");
            return;
        }

        if (senha1.isEmpty()) {
            txtSenha.setError("Senha não pode ser branca");
            return;
        } else if (senha1.length() < 6) {
            txtSenha.setError("A senha precisa ter 6 caracteres ou mais");
            return;
        }

        if (senha2.isEmpty()) {
            txt2xSenha.setError("Senha não pode ser branca");
            return;
        } else if (senha2.length() < 6) {
            txt2xSenha.setError("A senha precisa ter 6 caracteres ou mais");
            return;
        }


        if (!senha1.equals(senha2)) {
            txtSenha.setError("As senhas precisam ser iguais");
            txt2xSenha.setError("As senhas precisam ser iguais");
            return;
        }

        if (!nome.isEmpty() && !email.isEmpty() && !senha1.isEmpty() && !senha2.isEmpty()) {
            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(NOME_KEY, nome);
            bundle.putString(EMAIL_KEY, email);
            bundle.putString(SENHA_KEY, senha1);
            intent.putExtras(bundle);
            startActivity(intent);
        }


    }

    private void initViews() {
        txtNome = findViewById(R.id.txtRegNome);
        txtEmail = findViewById(R.id.txtRegEmail);
        txtSenha = findViewById(R.id.txtRegPassword);
        txt2xSenha = findViewById(R.id.txtRepetePassword);
        btnRegistro = findViewById(R.id.btnRegistro);

    }
}
