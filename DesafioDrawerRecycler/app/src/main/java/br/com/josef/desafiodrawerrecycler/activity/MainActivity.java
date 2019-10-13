package br.com.josef.desafiodrawerrecycler.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.navigation.ui.AppBarConfiguration;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.desafiodrawerrecycler.R;
import br.com.josef.desafiodrawerrecycler.adapter.RestauranteAdapter;
import br.com.josef.desafiodrawerrecycler.interfaces.RecyclerViewOnClick;
import br.com.josef.desafiodrawerrecycler.model.Restaurantes;

import static br.com.josef.desafiodrawerrecycler.activity.RegistroActivity.EMAIL_KEY;
import static br.com.josef.desafiodrawerrecycler.activity.RegistroActivity.NOME_KEY;
import static br.com.josef.desafiodrawerrecycler.activity.RegistroActivity.SENHA_KEY;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClick {
    //private DrawerLayout drawer;
   // private AppBarConfiguration mAppBarConfiguration;
    public static final String REST_KEY = "rest";
    private RecyclerView recyclerViewRest;
    private RestauranteAdapter adapter;

    private String nomeBundle;
    private String emailBundle;
    private String senhaBundle;


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

        Intent intent = getIntent();

        if (getIntent() != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            nomeBundle = bundle.getString(NOME_KEY);
            emailBundle = bundle.getString(EMAIL_KEY);
            senhaBundle = bundle.getString(SENHA_KEY);
        }

    }

    private List<Restaurantes> listaDeRestaurantes() {
        List<Restaurantes> rest = new ArrayList<>();

        rest.add(new Restaurantes("Tony Roma´s", "Av. Lavandisca, 717 - Indianópolis, São Paulo"
                , "Fecha às 23h00", R.drawable.tony));

        rest.add(new Restaurantes("Aoyama", "Alameda dos Arapanés, 532 - Moema"
                , "Fecha às 00h00", R.drawable.aoyama));

        rest.add(new Restaurantes("OutBack", "Av. Moaci, 187, 187 - Moema, São Paulo"
                , "Fecha às 01h00", R.drawable.outback));

        return rest;
    }

    ///OPTION MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(NOME_KEY, nomeBundle);
            bundle.putString(EMAIL_KEY, emailBundle);
            bundle.putString(SENHA_KEY,senhaBundle);
            intent.putExtras(bundle);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    ///FIM OPTION MENU


    @Override
    public void onClick(Restaurantes restaurantes) {
        Intent intent = new Intent(MainActivity.this, RestauranteDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(REST_KEY, restaurantes);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
