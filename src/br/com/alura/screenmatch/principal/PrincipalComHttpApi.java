package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErrorDeConversaoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComHttpApi {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()  // CHAMAMOS A BIBLIOTECA GJON QUE VAI PERMITIR TRATAR A VARIAVEL JSON
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite o nome de um filme que deseja buscar: ");
            busca = leitura.nextLine();


            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=c8a75190";
            try {


                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco)).build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String json = response.body(); // PEGAMOS A RESPOSTA EM JSON E GUARDAMOS NA VARIAVEL JSON


                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class); // AQUI A VARIAVEL JSON
                // SERÁ TRANSFORMADA EM UMA CLASSE OBJETO JAVA QUE CRIEI TituloOmdb para que eu possa usar
                // os dados JSON recebidos , agora transformados em uma calsse OBJETO java
                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido para minha classe Titulo !");
                System.out.println(meuTitulo);

                // escrevemos agora em um arquivo .txt os dados do filme que buscamos
                // logo poderemos trabalhar estes dados.
//                FileWriter escrita = new FileWriter("filmes.txt");
//                escrita.write(meuTitulo.toString());
//                escrita.close();

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro :( ");
                System.out.println(e.getMessage());

                // Criamos a classe ErrorDeConexaoException nossa classe de erro
                // especifico com um retorno de uma mensagem específica nossa !

            } catch (ErrorDeConversaoException e) {
                System.out.println("Aconteceu um erro na busca :( ");
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("O programa finalizou corretamente  !");

    }
}
