package infrastructure.unsplashImages;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageService {

    public static void setImage(String search, JPanel panel) {

        try {
            String query = "https://api.unsplash.com/search/photos?page=1&query="
                    + slug(search)
                    + "&orientation=landscape&lang=es&per_page=1"
                    + "&client_id=-ZI5c4hJKA2hz647kD4BH25vkSYl2BvoR3SQPc0t-DE";
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest getRequest = HttpRequest.newBuilder().uri(new URI(query)).build();

            HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            String imageURL = jsonObject.results.get(0).urls.small + "&h=400";

            panel.setBackground(Color.decode(jsonObject.results.get(0).color));

            panel.add(new JLabel(new ImageIcon(ImageIO.read(new URI(imageURL).toURL()))));

        } catch (JsonSyntaxException | IOException | InterruptedException | NumberFormatException | URISyntaxException | IndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
            panel.setBackground(Color.white);
        }
    }

    public static String slug(String input) {
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            sb.append("+").append(word);
        }

        return sb.toString();
    }

}
