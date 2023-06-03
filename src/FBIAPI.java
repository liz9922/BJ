

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FBIAPI {
    private OkHttpClient client;
    private String baseURL = "https://api.fbi.gov/@wanted?";

    public FBIAPI() {
        client = new OkHttpClient();
    }

    public ArrayList<Terrorist> getAllTerrorist() {
        String url = baseURL + "pageSize=20&page=1&sort_on=modified&sort_order=desc&poster_classification=terrorist";
        ArrayList<Terrorist> w = new ArrayList<>();
        Request r = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response response = client.newCall(r).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                ObjectMapper o = new ObjectMapper();
                JsonNode jsonNode = o.readTree(json);
                JsonNode terrorist = jsonNode.get("items");

                for (JsonNode terror : terrorist) {
                    JsonNode nameNode = terror.get("title");
                    JsonNode imageNode = terror.get("images").get("large");
                    JsonNode descNode = terror.get("description");

                    Terrorist t = new Terrorist();
                    if (nameNode != null && !nameNode.isNull()) {
                        t.setTitle(nameNode.asText());
                    }
                    if (imageNode != null && !imageNode.isNull()) {
                        t.setImageURL(imageNode.asText());
                    } else {
                        t.setImageURL("Saknas url");
                    }
                    if (descNode != null && !descNode.isNull()) {
                        t.setDescription(descNode.asText());
                    }
                    w.add(t);
                }
            }
            return w;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Terrorist> getAllTerroristA() {
        String url = baseURL + "pageSize=20&page=1&sort_on=modified&sort_order=desc&poster_classification=terrorist";
        ArrayList<Terrorist> terroristsList = new ArrayList<>();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(json);
                JsonNode terrorists = jsonNode.get("items");

                for (JsonNode terrorist : terrorists) {
                    JsonNode nameNode = terrorist.get("title");
                    JsonNode imagesNode = terrorist.get("images");
                    JsonNode largeImageNode = null;
                    if (imagesNode.isArray()) {
                        for (JsonNode imageNode : imagesNode) {
                            if (imageNode.has("large")) {
                                largeImageNode = imageNode.get("large");
                                break;
                            }
                        }
                    } else {
                        largeImageNode = imagesNode.get("large");
                    }
                    JsonNode descNode = terrorist.get("description");

                    Terrorist terrorist1 = new Terrorist();
                    if (nameNode != null && !nameNode.isNull()) {
                        terrorist1.setTitle(nameNode.asText());
                    }
                    if (largeImageNode != null && !largeImageNode.isNull()) {
                        terrorist1.setImageURL(largeImageNode.asText());
                    } else {
                        terrorist1.setImageURL("Saknas url");
                    }
                    if (descNode != null && !descNode.isNull()) {
                        terrorist1.setDescription(descNode.asText());
                    }

                    terroristsList.add(terrorist1);
                }
            } else {
                // Handle unsuccessful response here if needed
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return terroristsList;


    }
}
