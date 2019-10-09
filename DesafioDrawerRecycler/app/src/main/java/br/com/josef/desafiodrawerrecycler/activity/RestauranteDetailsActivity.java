package br.com.josef.desafiodrawerrecycler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.josef.desafiodrawerrecycler.R;
import br.com.josef.desafiodrawerrecycler.adapter.PratoAdapter;
import br.com.josef.desafiodrawerrecycler.interfaces.RecyclerViewOnClickPratos;
import br.com.josef.desafiodrawerrecycler.model.Pratos;
import br.com.josef.desafiodrawerrecycler.model.Restaurantes;

import static br.com.josef.desafiodrawerrecycler.activity.MainActivity.REST_KEY;

public class RestauranteDetailsActivity extends AppCompatActivity implements RecyclerViewOnClickPratos {
    private ImageView imgRest;
    private TextView txtNomeRest;
    private RecyclerView recyclerViewPratos;
    private PratoAdapter adapter;
    public static final String PRATO_KEY = "prato";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_details);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {

            Restaurantes rest = getIntent().getExtras().getParcelable(REST_KEY);
            Drawable drawable = getResources().getDrawable(rest.getImage());
            imgRest.setImageDrawable(drawable);
            txtNomeRest.setText(rest.getNome());
        }

        recyclerViewPratos = findViewById(R.id.RecyclerPratos);
        adapter = new PratoAdapter(listaDePratos(),this);
        recyclerViewPratos.setAdapter(adapter);
        recyclerViewPratos.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private List<Pratos> listaDePratos() {
        List<Pratos> prat = new ArrayList<>();

        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));
        prat.add(new Pratos("Cuzcuz de Camarão", R.drawable.aoyama,"Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis."));


        return prat;
    }


    private void initViews() {
        imgRest = findViewById(R.id.imgBannerDetails);
        txtNomeRest = findViewById(R.id.txtNomeRestDetails);
    }

    @Override
    public void onClick(Pratos pratos) {
        Intent intent = new Intent(getBaseContext(), PratoDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PRATO_KEY, pratos);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
