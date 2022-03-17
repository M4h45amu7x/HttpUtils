## Description:
Http Requests utility for Java

## Features:
<ul>
  <li>Custom User-Agent as you want</li>
  <li>Headers and Contents requests</li>
  <li>All methods: GET/POST/PUT/PATCH/DELETE/HEAD/OPTIONS</li>
</ul>

## Example:
```java
private static final HttpUtils httpUtils = new HttpUtils();

public static void main(String[] args) {
  try {
    Map<String, String> headers = new HashMap<>();
    headers.put("key", "value");

    JsonObject contents = new JsonObject();
    contents.addProperty("key", "value");

    // Return as string

    // GET
    httpUtils.get("https://google.com", headers);
    httpUtils.get("https://google.com");

    // POST
    httpUtils.post("https://google.com", headers, contents.toString());
    httpUtils.post("https://google.com", headers);
    httpUtils.post("https://google.com", contents.toString());

    // PUT
    httpUtils.put("https://google.com", headers, contents.toString());
    httpUtils.put("https://google.com", headers);
    httpUtils.put("https://google.com", contents.toString());

    // PATCH
    httpUtils.patch("https://google.com", headers, contents.toString());
    httpUtils.patch("https://google.com", headers);
    httpUtils.patch("https://google.com", contents.toString());

    // DELETE
    httpUtils.delete("https://google.com", headers);
    httpUtils.delete("https://google.com");

    // HEAD
    httpUtils.head("https://google.com", headers);
    httpUtils.head("https://google.com");

    // OPTIONS
    httpUtils.options("https://google.com", headers);
    httpUtils.options("https://google.com");
  } catch (Exception e) {
    e.printStackTrace();
  }
}
```
