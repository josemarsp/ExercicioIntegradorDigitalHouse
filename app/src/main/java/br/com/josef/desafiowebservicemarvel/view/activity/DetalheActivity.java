package br.com.josef.desafiowebservicemarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.com.josef.desafiowebservicemarvel.R;
import br.com.josef.desafiowebservicemarvel.model.pojos.Date;
import br.com.josef.desafiowebservicemarvel.model.pojos.Result;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        ImageView imgBanner = findViewById(R.id.imgBanner);
        ImageView imgComic = findViewById(R.id.imgComicDetalhe);
        TextView txtTitulo = findViewById(R.id.txtComicTitle);
        TextView txtDescricao = findViewById(R.id.txtComicDescription);
        TextView txtPublished = findViewById(R.id.txtPublishedInfo);
        TextView txtPrice = findViewById(R.id.txtPriceInfo);
        TextView txtPages = findViewById(R.id.txtPagesInfo);

        if (getIntent() != null) {

            Result result = getIntent().getExtras().getParcelable("Result");
            Toast.makeText(this, result.getTitle() + " Loaded!", Toast.LENGTH_SHORT).show();

            Picasso.get().load(result.getThumbnail().getPath()).into(imgComic);
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
}
