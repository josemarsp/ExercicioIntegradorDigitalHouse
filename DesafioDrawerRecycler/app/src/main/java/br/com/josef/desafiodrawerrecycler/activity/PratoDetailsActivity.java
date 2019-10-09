package br.com.josef.desafiodrawerrecycler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.josef.desafiodrawerrecycler.R;
import br.com.josef.desafiodrawerrecycler.model.Pratos;

import static br.com.josef.desafiodrawerrecycler.activity.RestauranteDetailsActivity.PRATO_KEY;

public class PratoDetailsActivity extends AppCompatActivity {
    private TextView nomePrato;
    private TextView descrPrato;
    private ImageView imgPrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prato_details);

        initViews();

        if (getIntent() !=null && getIntent().getExtras() !=null){
            Pratos prato = getIntent().getExtras().getParcelable(PRATO_KEY);
            Drawable drawable = getResources().getDrawable(prato.getImgPrato());
            imgPrato.setImageDrawable(drawable);
            nomePrato.setText(prato.getNomePrato());
            descrPrato.setText(prato.getDescrPrato());

        }
    }

    private void initViews(){
        nomePrato = findViewById(R.id.txtNomePratoDetails);
        descrPrato = findViewById(R.id.txtDescrPratoDetails);
        imgPrato = findViewById(R.id.imgPratoDetails);
    }
}
