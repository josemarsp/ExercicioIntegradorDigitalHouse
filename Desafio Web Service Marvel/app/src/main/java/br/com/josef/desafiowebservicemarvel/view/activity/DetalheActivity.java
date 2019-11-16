package br.com.josef.desafiowebservicemarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.josef.desafiowebservicemarvel.R;
import br.com.josef.desafiowebservicemarvel.model.pojos.Date;
import br.com.josef.desafiowebservicemarvel.model.pojos.Result;

import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imgBanner;
    private ImageView imgComic;
    private TextView txtTitulo;
    private TextView txtDescricao;
    private TextView txtPublished;
    private TextView txtPrice;
    private TextView txtPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        initViews();

        if (getIntent() != null) {

            Result result = getIntent().getParcelableExtra("Result");
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgComic);

             // Toast.makeText(this, result.getTitle() + " Loaded!", Toast.LENGTH_SHORT).show();
            // Picasso.get().load(result.getThumbnail().getPath()+".jpg").into(imgBanner);
            txtTitulo.setText(result.getTitle());
            txtDescricao.setText(result.getDescription());
            // txtPrice.setText(result.getPrices());
//            if(result.getThumbnail().getPath().isEmpty()){
//                txtPublished.setText("Essa merda veio vazia");
//            }

            ///   txtPages.setText(result.getPageCount());


        }

    }

    private void initViews() {
        imgBanner = findViewById(R.id.imgBanner);
        imgComic = findViewById(R.id.imgComicDetalhe);
        txtTitulo = findViewById(R.id.txtComicTitle);
        txtDescricao = findViewById(R.id.txtComicDescription);
        txtPublished = findViewById(R.id.txtPublishedInfo);
        txtPrice = findViewById(R.id.txtPriceInfo);
        txtPages = findViewById(R.id.txtPagesInfo);

    }
}
