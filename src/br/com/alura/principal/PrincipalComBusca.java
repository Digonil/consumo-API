package br.com.alura.principal;

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
        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=db6c566c";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)).build();

        HttpResponse<String> response = cliente
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

//        cliente.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
    }
}
