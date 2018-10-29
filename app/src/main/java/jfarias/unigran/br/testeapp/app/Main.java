package jfarias.unigran.br.testeapp.app;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import jfarias.unigran.br.testeapp.R;
import jfarias.unigran.br.testeapp.entidade.Pessoa;
import jfarias.unigran.br.testeapp.persistencia.Banco;

public class Main extends AppCompatActivity {

    Banco bd;
/*   Usado com lista antiga listview
   private ListView lista;*/
    private SQLiteDatabase conexao;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lista antiga
        //lista = findViewById(R.id.listDados);
        conexaoBD();
//        acoes();

        recyclerView = (RecyclerView) findViewById(R.id.listadados);
        RecyclerView.LayoutManager mymanag = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mymanag);
        PessoaView pessoaView = new PessoaView(lista());
        recyclerView.setAdapter(pessoaView);

    }

    //lista antiga //listview
//    private void acoes() {
////        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Intent it = new Intent(Main.this, Cadastro.class);
//                Pessoa pessoa =  (Pessoa)adapterView.getItemAtPosition(position);
//                it.putExtra("pessoa", pessoa);
//                startActivity(it);
//            }
//        });
//    }

    private void conexaoBD() {
        try {
            bd = new Banco(this);
            Toast.makeText(this, "Conexão Ok!", Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Erro");
            msg.setMessage("Erro ao conectar ao Banco");
            msg.setNeutralButton("Ok",null);
            msg.show();
        }
    }
    private List lista(){
        conexao = bd.getWritableDatabase();
        List pessoa =  new LinkedList();
        Cursor res = conexao.rawQuery("SELECT * FROM PESSOA", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                Pessoa p = new Pessoa();
                p.setNome(res.getString(res.getColumnIndexOrThrow("NOME")));
                p.setSobrenome(res.getString(res.getColumnIndexOrThrow("SOBRENOME")));
                p.setIdade(res.getInt(res.getColumnIndexOrThrow("IDADE")));
                pessoa.add(p);
            }while (res.moveToNext());
        }
        return pessoa;
    }

    public void acCad(View view){
        Intent it = new Intent(Main.this, Cadastro.class);
        startActivity(it);
    }

    public void acSair(View view){
        finish();
    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        ArrayAdapter<Pessoa> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, lista());
//        lista.setAdapter(arrayAdapter);
//    }
}
