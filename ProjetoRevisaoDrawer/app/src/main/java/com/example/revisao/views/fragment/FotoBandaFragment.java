package com.example.revisao.views.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.revisao.R;
import com.example.revisao.views.model.Dados;

import static com.example.revisao.views.activity.HomeActivity.DADOS_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoBandaFragment extends Fragment {

    private TextView txtNomeBanda;
    private Button btnVoltar;

    public FotoBandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto_banda, container, false);

        initView(view);

        if (!getArguments().isEmpty()){
            Dados dados =getArguments().getParcelable(DADOS_KEY);
            if ( dados != null){
                txtNomeBanda.setText(dados.getNomeBanda());
            }
        }
        //Implementar a lógica de verificação dos dados recebidos e setar o nome da banda no textView
        //Implementar a lógica de ação do botão voltar
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, new BandaFragment(), "Retornando a Fragment Banda");
                ft.commit();
                //Usando o método replace() do FragmentTransaction para voltar para a frament Banda
            }
        });
        return view;

    }

public void initView (View view){
    btnVoltar = view.findViewById(R.id.btnVoltar);
    txtNomeBanda = view.findViewById((R.id.textViewNomeBanda));
}
}
