package br.com.alura.principal;

import br.com.alura.exception.ErroDeConversaoDeAnoException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");

        var busca = scanner.nextLine();
        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=db6c566c";
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println("Titulo: " + meuTituloOmdb);

//        try{
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Acontecue um erro");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Título já convertido");
        } catch (IllegalArgumentException e) {
            System.out.println("Algum erro de argumento na busca, verifique o endereço!");
        }catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        }
        System.out.println("O programa finalizou corretamente!");


    }
}
