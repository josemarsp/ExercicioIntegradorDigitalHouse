package br.com.josef.desafiodrawerrecycler.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.ui.AppBarConfiguration;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.desafiodrawerrecycler.R;
import br.com.josef.desafiodrawerrecycler.adapter.RestauranteAdapter;
import br.com.josef.desafiodrawerrecycler.interfaces.RecyclerViewOnClick;
import br.com.josef.desafiodrawerrecycler.model.Restaurantes;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClick {
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    public static final String REST_KEY = "rest";
    private RecyclerView recyclerViewRest;
    private RestauranteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerViewRest = findViewById(R.id.RecyclerRest);
        adapter = new RestauranteAdapter(listaDeRestaurantes(), this);
        recyclerViewRest.setAdapter(adapter);
        recyclerViewRest.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Restaurantes> listaDeRestaurantes() {
        List<Restaurantes> rest = new ArrayList<>();

        rest.add(new Restaurantes("Tony Roma´s", "Av. Lavandisca, 717 - Indianópolis, São Paulo"
                , "Fecha às 23h00", R.drawable.tony));

        rest.add(new Restaurantes("Aoyama", "Alameda dos Arapanés, 532 - Moema"
                , "Fecha às 00h00", R.drawable.aoyama));

        rest.add(new Restaurantes("OutBack", "Av. Moaci, 187, 187 - Moema, São Paulo"
        ,"Fecha às 01h00",R.drawable.outback));

        return rest;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onClick(Restaurantes restaurantes) {
        Intent intent = new Intent(MainActivity.this, RestauranteDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(REST_KEY, restaurantes);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
