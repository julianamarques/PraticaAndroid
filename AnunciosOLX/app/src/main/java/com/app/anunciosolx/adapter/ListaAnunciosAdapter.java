package com.app.anunciosolx.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.app.anunciosolx.CadastroActivity;
import com.app.anunciosolx.R;
import com.app.anunciosolx.model.Anuncio;

import java.util.List;

import io.objectbox.Box;

/**
 * Created by Juliana on 12/02/2018.
 */

public class ListaAnunciosAdapter extends RecyclerView.Adapter<ListaAnunciosAdapter.ViewHolder> {
    private Context context;
    private List<Anuncio> anuncios;
    private Box<Anuncio> anuncioBox;

    public ListaAnunciosAdapter(Context context, List<Anuncio> anuncios, Box<Anuncio> anuncioBox) {
        this.context = context;
        this.anuncios = anuncios;
        this.anuncioBox = anuncioBox;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDescricao;
        private TextView txtValor;
        private TextView txtLocal;
        private TextView txtData;

        public ViewHolder(View itemView) {
            super(itemView);

            txtDescricao = itemView.findViewById(R.id.txt_descricao);
            txtValor = itemView.findViewById(R.id.txt_valor);
            txtLocal = itemView.findViewById(R.id.txt_local);
            txtData = itemView.findViewById(R.id.txt_data);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_anuncio, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Anuncio anuncio = this.anuncios.get(position);

        viewHolder.txtDescricao.setText(anuncio.getDescricao());
        viewHolder.txtValor.setText("R$ " + anuncio.getValor());
        viewHolder.txtLocal.setText(anuncio.getLocal());
        viewHolder.txtData.setText(anuncio.getData());

        configurarClick(viewHolder.itemView, anuncio, position);
    }

    @Override
    public int getItemCount() {
        return this.anuncios.size();
    }

    private void configurarClick(View itemView, Anuncio anuncio, int position) {
        itemView.setOnLongClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                if(item.getItemId() == R.id.editar) {
                    editar(itemView, anuncio, position);
                }

                else if(item.getItemId() == R.id.remover) {
                    remover(itemView, anuncio, position);
                }

                return false;
            });

            popupMenu.show();

            return true;
        });
    }

        private void editar(View view, Anuncio anuncio, int position) {
            Intent intent = new Intent(context, CadastroActivity.class);

            intent.putExtra("idAnuncio",anuncio.getId());
            context.startActivity(intent);
            notifyItemChanged(position);
        }

        private void remover(View view, final Anuncio anuncio, final int position) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);

            builder.setTitle("Anuncios OLX");
            builder.setMessage("Deseja remover " + anuncio.getDescricao() + " da lista de anuncios?");

            builder.setPositiveButton("SIM", (dialog, which) -> {
                this.anuncios.remove(anuncio);
                this.anuncioBox.remove(anuncio);

                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
                Toast.makeText(context, "Anuncio removido com sucesso!", Toast.LENGTH_SHORT).show();
            });

            builder.setNegativeButton("NÃO", (dialog, which) -> {
               Toast.makeText(context, "Anuncio não removido.", Toast.LENGTH_SHORT).show();
            });

            builder.create().show();
        }
}
