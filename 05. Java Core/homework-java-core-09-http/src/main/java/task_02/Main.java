package task_02;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.util.Arrays;


public class Main {

    public static final String REMOTE_SERVICE_URL = "https://api.nasa.gov/planetary/apod?api_key=LBgyjgE3Gc9JADp7QgOC5YFMQI7TQwOCh8BaLYY8";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("My Test Service")
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();


        // Создание объекта запроса с произвольными заголовками
        HttpGet request = new HttpGet(REMOTE_SERVICE_URL);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        // Отправка запроса
        CloseableHttpResponse response = httpClient.execute(request);

        // Вывод полученных заголовков
        Arrays.stream(response.getAllHeaders()).forEach(System.out::println);

//        // Чтение тела ответа
//        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
//        System.out.println(body);

        NasaPost nasaPost = mapper.readValue(
                response.getEntity().getContent(),
                NasaPost.class
        );
        System.out.println(nasaPost);

        HttpGet request2 = new HttpGet(nasaPost.getHdurl());
        CloseableHttpResponse response2 = httpClient.execute(request2);

        String[] strings = nasaPost.getHdurl().split("/");
        String fileName = null;
        for (String str : strings) {
            if (str.toLowerCase().contains(".jpg")) {
                fileName = str;
            }
        }
        System.out.println(fileName);

        HttpEntity entity = response2.getEntity();
        if (entity != null) {
            FileOutputStream fos = new FileOutputStream(fileName);
            entity.writeTo(fos);
            fos.close();
        }

        response.close();
        httpClient.close();
    }
}

