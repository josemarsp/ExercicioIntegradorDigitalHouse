package br.com.josef.desafiowebservicemarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.desafiowebservicemarvel.R;
import br.com.josef.desafiowebservicemarvel.model.pojos.Result;
import br.com.josef.desafiowebservicemarvel.view.adapter.RecyclerViewAdapter;
import br.com.josef.desafiowebservicemarvel.view.interfaces.OnClick;
import br.com.josef.desafiowebservicemarvel.viewmodel.ComicsViewModel;

public class MainActivity extends AppCompatActivity implements OnClick {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewAdapter adapter;
    private List<Result> listaComics = new ArrayList<>();
    private ComicsViewModel viewModel;
    //private int pagina = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        viewModel.getLoading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        viewModel.getAllComics();
        viewModel.getListaComics().observe(this, results -> {
            adapter.atualizaLista(results);
        });


    }

    public void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        adapter = new RecyclerViewAdapter(listaComics, this);
        viewModel = ViewModelProviders.of(this).get(ComicsViewModel.class);


    }

    @Override
    public void click(Result result) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Result", result);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
