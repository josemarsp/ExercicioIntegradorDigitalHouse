package br.com.josef.desafiodrawerrecycler.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import br.com.josef.desafiodrawerrecycler.R;

public class RegistroActivity extends AppCompatActivity {
    private TextInputLayout txtEmail;
    private TextInputLayout txtNome;
    private TextInputLayout txtSenha;
    private TextInputLayout txt2xSenha;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        initViews();

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nome = txtNome.getEditText().getText().toString();
               String email = txtEmail.getEditText().getText().toString();
               String senha = txtSenha.getEditText().getText().toString();
               String dsenha = txt2xSenha.getEditText().getText().toString();

                if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !dsenha.isEmpty()){
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void initViews(){
        txtNome = findViewById(R.id.txtRegNome);
        txtEmail = findViewById(R.id.txtRegEmail);
        txtSenha = findViewById(R.id.txtRegPassword);
        txt2xSenha = findViewById(R.id.txtRepetePassword);
        btnRegistro = findViewById(R.id.btnRegistro);

    }
}
