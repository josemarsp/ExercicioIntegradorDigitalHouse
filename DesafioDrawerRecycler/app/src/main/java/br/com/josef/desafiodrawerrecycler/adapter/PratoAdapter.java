package br.com.josef.desafiodrawerrecycler.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.josef.desafiodrawerrecycler.R;
import br.com.josef.desafiodrawerrecycler.interfaces.RecyclerViewOnClickPratos;
import br.com.josef.desafiodrawerrecycler.model.Pratos;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolderPratos> {
    private List<Pratos> pratos;
    private RecyclerViewOnClickPratos listener;

    public PratoAdapter(List<Pratos> pratos, RecyclerViewOnClickPratos listener) {
        this.pratos = pratos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderPratos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_pratos, viewGroup, false);
        return new ViewHolderPratos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PratoAdapter.ViewHolderPratos viewHolderPratos, int i) {
        final Pratos prato = pratos.get(i);
        viewHolderPratos.bind(prato);
        viewHolderPratos.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(prato);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pratos.size();
    }

    class ViewHolderPratos extends RecyclerView.ViewHolder {
        TextView txtPrato;
        ImageView imgPrato;


        public ViewHolderPratos(@NonNull View itemView) {
            super(itemView);
            txtPrato = itemView.findViewById(R.id.txtPrato);
            imgPrato = itemView.findViewById(R.id.imgPrato);

        }

        public void bind(Pratos pratos) {
            txtPrato.setText(pratos.getNomePrato());
            Drawable iPrato = itemView.getResources().getDrawable(pratos.getImgPrato());
            imgPrato.setImageDrawable(iPrato);

        }
    }

}
