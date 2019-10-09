package br.com.josef.desafiodrawerrecycler.adapter;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.josef.desafiodrawerrecycler.R;
import br.com.josef.desafiodrawerrecycler.interfaces.RecyclerViewOnClick;
import br.com.josef.desafiodrawerrecycler.model.Restaurantes;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolderRestaurantes> {

    private List<Restaurantes> restaurantes;
    private RecyclerViewOnClick listener;

    public RestauranteAdapter(List<Restaurantes> restaurantes, RecyclerViewOnClick listener) {
        this.restaurantes = restaurantes;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolderRestaurantes onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_restaurantes, viewGroup, false);
        return new ViewHolderRestaurantes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRestaurantes viewHolderRestaurantes, int i) {
        final Restaurantes rest = restaurantes.get(i);
        viewHolderRestaurantes.bind(rest);
        //Clicaitem
        viewHolderRestaurantes.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(rest);
            }
        });


    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }


    class ViewHolderRestaurantes extends RecyclerView.ViewHolder {
        TextView txtNomeRest;
        ImageView imgRestaurante;
        TextView txtEndRest;
        TextView txtHoraRest;

        public ViewHolderRestaurantes(View itemView) {
            super(itemView);
            txtNomeRest = itemView.findViewById(R.id.txtNomeRest);
            imgRestaurante = itemView.findViewById(R.id.imgBannerRest);
            txtEndRest = itemView.findViewById(R.id.txtEndRest);
            txtHoraRest = itemView.findViewById(R.id.txtHoraRest);
        }

        public void bind(Restaurantes restaurantes) {
            txtNomeRest.setText(restaurantes.getNome());
            Drawable iRestaurante = itemView.getResources().getDrawable(restaurantes.getImage());
            imgRestaurante.setImageDrawable(iRestaurante);
            txtEndRest.setText(restaurantes.getEndereço());
            txtHoraRest.setText(restaurantes.getHorafunc());
        }
    }
}
