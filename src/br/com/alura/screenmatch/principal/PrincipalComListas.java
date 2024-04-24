package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar",2023);
        meuFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dog ville", 2003);
        meuFilme.avalia(10);
        Serie lost = new Serie("Lost",2020);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        //for each tradicional para iterar sobre uma lista
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            // esta condição verifica se o item da lista é um Filme e não um série
            // ser for um filme então filme tem o métod getClassificacao() que será invocado
            // é necessária a verificação com o instanceof pois série NAO tem o método
            // getClassificacao , logo evitamos de dar um erro quando i item vier a série
            // e não um filme.
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        // for each usando  expressão lambda nome -> System.out.println(nome)
        lista.forEach(nome -> System.out.println(nome));

        //for each tradicional para iterar sobre uma lista :: method reference
        //for each mais atual  fazendo a mesma coisa
        lista.forEach(System.out::println);

        // ArrayList ou somente List usando abaixo como está importará dois pacotes
        // ArrayList e List

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Rogerio corbo");
        buscaPorArtista.add("Sarah Stefany");
        buscaPorArtista.add("Ary");
        buscaPorArtista.add("Renata");
        buscaPorArtista.add("Miguel");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista); // ordena a lista ascendente String

        System.out.println(buscaPorArtista);

        System.out.println("Lista de titulos ordenados ");
        Collections.sort(lista);  //
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento)); // outra forma de ordenar usando o Comparator
        System.out.println("Ordenando por ano");
        System.out.println(lista);



    }
}
