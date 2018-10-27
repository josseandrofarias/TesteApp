package jfarias.unigran.br.testeapp.persistencia;

import java.util.LinkedList;
import java.util.List;

import jfarias.unigran.br.testeapp.entidade.Pessoa;

public class DAO {
    // não é necessário poissó quando é salvo em lista
    private static List lista;
    private static int indice;

    public static void salvar(Pessoa pessoa) {
        if(lista.contains(pessoa))
            lista.set(lista.indexOf(pessoa), pessoa);
        else{
            pessoa.setId(indice);
            lista.add(pessoa);
            indice++;
        }
    }

    public static List getLista(){

        if(lista == null){
            lista = new LinkedList();
            indice = 0;
        }
        return lista;
    }

}
