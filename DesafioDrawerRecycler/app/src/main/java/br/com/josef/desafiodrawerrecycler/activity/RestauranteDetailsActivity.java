package br.com.josef.desafiodrawerrecycler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.josef.desafiodrawerrecycler.R;
import br.com.josef.desafiodrawerrecycler.model.Restaurantes;

import static br.com.josef.desafiodrawerrecycler.activity.MainActivity.REST_KEY;

public class RestauranteDetailsActivity extends AppCompatActivity {
    private ImageView imgRest;
    private TextView txtNomeRest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_details);

        initViews();

        if (getIntent() !=null && getIntent().getExtras() !=null){

            Restaurantes rest = getIntent().getExtras().getParcelable(REST_KEY);
            Drawable drawable = getResources().getDrawable(rest.getImage());
            imgRest.setImageDrawable(drawable);
            txtNomeRest.setText(rest.getNome());

        }
    }

private void initViews(){
    imgRest = findViewById(R.id.imgBannerDetails);
    txtNomeRest = findViewById(R.id.txtNomeRestDetails);
}
}
