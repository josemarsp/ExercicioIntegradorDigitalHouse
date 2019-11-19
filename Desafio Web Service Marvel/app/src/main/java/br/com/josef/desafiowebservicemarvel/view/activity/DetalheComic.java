package br.com.josef.desafiowebservicemarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import br.com.josef.desafiowebservicemarvel.R;
import br.com.josef.desafiowebservicemarvel.model.pojos.Image;
import br.com.josef.desafiowebservicemarvel.model.pojos.Result;

public class DetalheComic extends AppCompatActivity {

    private ImageView comic;
    private FloatingActionButton btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_comic);

        comic = findViewById(R.id.imageComicActivity);
        btnvoltar = findViewById(R.id.floatingFechar);

        Result result = getIntent().getParcelableExtra("Result");
        Picasso.get().load(result.getThumbnail().getPath()+".jpg").into(comic);

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




    }
}
