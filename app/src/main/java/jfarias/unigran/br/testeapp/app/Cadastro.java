package jfarias.unigran.br.testeapp.app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

import jfarias.unigran.br.testeapp.R;
import jfarias.unigran.br.testeapp.entidade.Pessoa;
import jfarias.unigran.br.testeapp.persistencia.Banco;

public class Cadastro extends AppCompatActivity {

    Banco bd;
    private SQLiteDatabase conexao;
    private Pessoa pessoa;
    private Button btSalvar;

    private EditText etNome;
    private EditText etSobrenome;
    private EditText etIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etSobrenome = findViewById(R.id.etSobrenome);
        etIdade = findViewById(R.id.etIdade);
//edição
//        pessoa = (Pessoa) getIntent().getSerializableExtra("pessoa");
//        if(pessoa!=null){
//            etNome.setText(pessoa.getNome());
//            etSobrenome.setText(pessoa.getSobrenome());
//            etIdade.setText(pessoa.getIdade());
//        }

    }

    private void inserir(){
        bd = new Banco(this);

        try {
            conexao = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("NOME", pessoa.getNome());
            values.put("SOBRENOME", pessoa.getSobrenome());
            values.put("IDADE", pessoa.getIdade());

            conexao.insertOrThrow("PESSOA", null, values);
            conexao.close();
            Toast.makeText(this, "Dados Salvos Com Sucesso!", Toast.LENGTH_SHORT).show();
        }catch (android.database.SQLException e){
            Toast.makeText(this, "Erro ao salvar dados!", Toast.LENGTH_SHORT).show();
        }
    }

    public void acSalvar(View view){

        if(pessoa == null)
            pessoa = new Pessoa();
        pessoa.setNome(etNome.getText().toString());
        pessoa.setSobrenome(etSobrenome.getText().toString());
        pessoa.setIdade(Integer.parseInt(etIdade.getText().toString()));
        inserir();
        finish();

    }
}
