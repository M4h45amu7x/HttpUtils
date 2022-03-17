package xyz.mahasamut.HttpUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author M4h45amu7x
 */
public class HttpUtils {

    private String userAgent;

    public HttpUtils() {
        this.userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 Edg/99.0.1150.36";
    }

    public HttpURLConnection request(String url, String method) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);
        connection.setRequestMethod(method);
        if (userAgent != null && !userAgent.isEmpty())
            connection.addRequestProperty("User-Agent", userAgent);
        connection.setInstanceFollowRedirects(true);
        connection.setDoOutput(true);

        return connection;
    }

    public String get(String url, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = request(url, "GET");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet())
                connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        return getStringFromSteam(connection.getInputStream());
    }

    public String get(String url) throws IOException {
        return get(url, null);
    }

    public String post(String url, Map<String, String> headers, String contents) throws IOException {
        HttpURLConnection connection = request(url, "POST");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet())
                connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        if (contents != null) {
            byte[] out = contents.getBytes(StandardCharsets.UTF_8);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(out);
            outputStream.flush();
            outputStream.close();
        }

        return getStringFromSteam(connection.getInputStream());
    }

    public String post(String url, Map<String, String> headers) throws IOException {
        return post(url, headers, null);
    }

    public String post(String url, String contents) throws IOException {
        return post(url, null, contents);
    }

    public String post(String url) throws IOException {
        return post(url, null, null);
    }

    public String put(String url, Map<String, String> headers, String contents) throws IOException {
        HttpURLConnection connection = request(url, "PUT");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet())
                connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        if (contents != null) {
            byte[] out = contents.getBytes(StandardCharsets.UTF_8);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(out);
            outputStream.flush();
            outputStream.close();
        }

        return getStringFromSteam(connection.getInputStream());
    }

    public String put(String url, Map<String, String> headers) throws IOException {
        return put(url, headers, null);
    }

    public String put(String url, String contents) throws IOException {
        return put(url, null, contents);
    }

    public String put(String url) throws IOException {
        return put(url, null, null);
    }

    public String patch(String url, Map<String, String> headers, String contents) throws IOException {
        HttpURLConnection connection = request(url, "PATCH");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet())
                connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        if (contents != null) {
            byte[] out = contents.getBytes(StandardCharsets.UTF_8);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(out);
            outputStream.flush();
            outputStream.close();
        }

        return getStringFromSteam(connection.getInputStream());
    }

    public String patch(String url, Map<String, String> headers) throws IOException {
        return patch(url, headers, null);
    }

    public String patch(String url, String contents) throws IOException {
        return patch(url, null, contents);
    }

    public String patch(String url) throws IOException {
        return patch(url, null, null);
    }

    public String delete(String url, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = request(url, "DELETE");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet())
                connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        return getStringFromSteam(connection.getInputStream());
    }

    public String delete(String url) throws IOException {
        return delete(url, null);
    }

    public String head(String url, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = request(url, "HEAD");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet())
                connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        return getStringFromSteam(connection.getInputStream());
    }

    public String head(String url) throws IOException {
        return head(url, null);
    }

    public String options(String url, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = request(url, "OPTIONS");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet())
                connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        return getStringFromSteam(connection.getInputStream());
    }

    public String options(String url) throws IOException {
        return options(url, null);
    }

    public String getUserAgent() {
        return userAgent;
    }

    public HttpUtils setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public static String getStringFromSteam(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        String line = reader.readLine();

        while (line != null) {
            stringBuilder.append(line).append(System.lineSeparator());
            line = reader.readLine();
        }
        reader.close();

        return stringBuilder.toString();
    }

}