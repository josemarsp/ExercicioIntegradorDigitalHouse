package br.com.josef.desafiowebservicemarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.josef.desafiowebservicemarvel.R;
import br.com.josef.desafiowebservicemarvel.model.pojos.Result;
import br.com.josef.desafiowebservicemarvel.view.interfaces.OnClick;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Result> comicsList;
    private OnClick listener;

    public RecyclerViewAdapter(List<Result> comicsList, OnClick listener) {
        this.comicsList = comicsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Result result = comicsList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(v -> listener.   click(result));

    }

    @Override
    public int getItemCount() {
        return comicsList.size();
    }

    public void atualizaLista(List<Result> novaLista) {
        if (this.comicsList.isEmpty()) {
            this.comicsList = novaLista;
        } else {
            this.comicsList.addAll(novaLista);
        }
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageComic;
        private TextView txtTitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageComic = itemView.findViewById(R.id.imgComic);
            txtTitulo = itemView.findViewById(R.id.txtComic);
        }

        public void onBind(Result result) {

            txtTitulo.setText(result.getTitle());

         Picasso.get().load(result.getThumbnail().getPath()+"/portrait_uncanny.jpg").into(imageComic);
         // Picasso.get().load(result.getImages().get(0).getPath()+".jpg").into(imageComic);
            //Picasso.get().load(result.getThumbnail().getPath()+"/portrait_xlarge.jpg").into(imageComic);
        }
    }
}
