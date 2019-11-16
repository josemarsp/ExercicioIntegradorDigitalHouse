package br.com.josef.desafiowebservicemarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.com.josef.desafiowebservicemarvel.R;
import br.com.josef.desafiowebservicemarvel.model.pojos.Result;

public class DescrTeste extends AppCompatActivity {

    private  ImageView imgComic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descr_teste);

        imgComic = findViewById(R.id.imgTeste);

        if (getIntent() != null && getIntent().getExtras() != null) {


            Result result = getIntent().getParcelableExtra("Result");
            Toast.makeText(this, result.getTitle() + " Loaded!", Toast.LENGTH_SHORT).show();

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgComic);

        }
    }
}
