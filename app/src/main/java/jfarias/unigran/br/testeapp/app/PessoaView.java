package jfarias.unigran.br.testeapp.app;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jfarias.unigran.br.testeapp.R;
import jfarias.unigran.br.testeapp.entidade.Pessoa;

public class PessoaView extends RecyclerView.Adapter<PessoaView.PessoaViewHolder>{

    private List<Pessoa> dados;

    public PessoaView(List<Pessoa> p){
        dados = p;
        
    }

    @NonNull
    @Override
    public PessoaView.PessoaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.campos_lista, viewGroup, false);
        PessoaViewHolder pessoaViewHolder = new PessoaViewHolder(view);
        return  pessoaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PessoaView.PessoaViewHolder viewHolder, int i) {
        if((dados!=null) && (dados.size() > 0 )) {
            Pessoa p = dados.get(i);
            viewHolder.nome.setText(p.getNome());
            viewHolder.idade.setText(p.getIdade());
        }
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class PessoaViewHolder extends RecyclerView.ViewHolder {

        public TextView nome;
        public TextView idade;

        public PessoaViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = (TextView) itemView.findViewById(R.id.idNome);
            idade = (TextView) itemView.findViewById(R.id.idIdade);
        }
    }
}
