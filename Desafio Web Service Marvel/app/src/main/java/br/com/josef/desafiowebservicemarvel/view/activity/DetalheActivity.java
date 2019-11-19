package br.com.josef.desafiowebservicemarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.josef.desafiowebservicemarvel.R;
import br.com.josef.desafiowebservicemarvel.model.pojos.Date;
import br.com.josef.desafiowebservicemarvel.model.pojos.Result;
import br.com.josef.desafiowebservicemarvel.view.interfaces.OnClick;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imgBanner;
    private ImageView imgComic;
    private TextView txtTitulo;
    private TextView txtDescricao;
    private TextView txtPublished;
    private TextView txtPrice;
    private TextView txtPages;
    private FloatingActionButton btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        initViews();

        if (getIntent() != null) {

            Result result = getIntent().getParcelableExtra("Result");
            Picasso.get().load(result.getThumbnail().getPath() + "/portrait_uncanny.jpg").into(imgComic);

            //  Toast.makeText(this, result.getTitle() + " Loaded!", Toast.LENGTH_SHORT).show();
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgBanner);
            txtTitulo.setText(result.getTitle());
            txtDescricao.setText(result.getDescription());
            // txtPrice.setText(result.getPrices());

            txtPages.setText(result.getPageCount().toString() + " pages");
            // txtPrice.setText("US$ "+result.getPrices().get(0).getPrice().toString());
            txtPrice.setText("US$ " + String.format("%.2f", result.getPrices().get(0).getPrice()));

            String dataISO = result.getDates().get(0).getDate().split("T")[0];
            String[] dates = dataISO.split("-");
            String dataUsuario = dates[2] + "/" + dates[1] + "/" + dates[0];
            //txtData.setText(dataUsuario);

            txtPublished.setText(dataUsuario);

            imgComic.setOnClickListener(v -> {
                Intent intent = new Intent(DetalheActivity.this, DetalheComic.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("Result", result);
                intent.putExtras(bundle);
                startActivity(intent);
            });

        }

            btnvoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });






    } private void initViews ()    {
        imgBanner = findViewById(R.id.imgBanner);
        imgComic = findViewById(R.id.imgComicDetalhe);
        txtTitulo = findViewById(R.id.txtComicTitle);
        txtDescricao = findViewById(R.id.txtComicDescription);
        txtPublished = findViewById(R.id.txtPublishedInfo);
        txtPrice = findViewById(R.id.txtPriceInfo);
        txtPages = findViewById(R.id.txtPagesInfo);
        btnvoltar = findViewById(R.id.floating);

    }
}




