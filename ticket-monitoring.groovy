import java.text.MessageFormat
def baseUrl = new URL('http://booking.uz.gov.ua/en/purchase/search/')
def connection = baseUrl.openConnection()

def from = '2200001'
def to = '2218020'
def date = '13.10.2017'

// connection.setRequestProperty("Cookie", cookie);
// connection.setRequestProperty("GV-Token", token);
connection.setRequestProperty("GV-Ajax", "1");
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
connection.setRequestProperty("Referer", "http://booking.uz.gov.ua/en/");
connection.setRequestMethod("POST");
String queryString = MessageFormat.format("station_id_from={0}&station_id_till={1}&date_dep={2}" +
                                            "&time_dep=00:00&time_dep_till=24:00", from, to, date);
connection.setDoOutput(true);

connection.with {
  doOutput = true
  requestMethod = 'POST'
  outputStream.withWriter { writer ->
    writer << queryString
  }
  println content.text
}

// static void fetchHtml() {
//     try {
//         URL url = new URL("http://booking.uz.gov.ua/");
//         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//         conn.setRequestMethod("GET");
//         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//         headers = conn.getHeaderFields();
//         String line;
//         while ((line = rd.readLine()) != null) {
//             html += line;
//         }
//         rd.close();
//     } catch (Exception e) {
//         error = e.getMessage();
//     }
// }
//
// static void parseCookie() {
//     List<String> cookies = headers.get("Set-Cookie");
//     for (String current_cookie : cookies) {
//         if (current_cookie.startsWith("_gv_sessid")) {
//             cookie = current_cookie;
//             break;
//         }
//     }
// }
//
// static void parseToken() {
//     String adapter = "var token;localStorage={setItem:function(key, value){if(key==='gv-token')token=value}};";
//     Pattern pattern = Pattern.compile("\\$\\$_=.*~\\[\\];.*\"\"\\)\\(\\)\\)\\(\\);");
//     Matcher matcher = pattern.matcher(html);
//     if (matcher.find()) {
//         String obfuscated = matcher.group(0);
//         ScriptEngineManager factory = new ScriptEngineManager();
//         ScriptEngine engine = factory.getEngineByName("JavaScript");
//         try {
//             engine.eval(adapter + obfuscated);
//         } catch (ScriptException e) {
//             error = e.getMessage();
//         }
//         token = engine.get("token").toString();
//     }
// }
//
// static String getStationId(String name) {
//     String json = "";
//     try {
//         URL url = new URL("http://booking.uz.gov.ua/en/purchase/station/" + name + "/");
//         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//         conn.setRequestMethod("GET");
//         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//         String line;
//         while ((line = rd.readLine()) != null) {
//             json += line;
//         }
//         rd.close();
//     } catch (Exception e) {
//         error = e.getMessage();
//     }
//     ScriptEngineManager factory = new ScriptEngineManager();
//     ScriptEngine engine = factory.getEngineByName("JavaScript");
//     engine.put("json", json);
//     try {
//         engine.eval("var station_id = JSON.parse(json).value[0].station_id");
//     } catch (ScriptException e) {
//         error = e.getMessage();
//     }
//     return engine.get("station_id").toString();
// }
//
// static String getData(String fromName, String toName, String date) {
//     fetchHtml();
//     parseCookie();
//     parseToken();
//     String from = getStationId(fromName);
//     String to = getStationId(toName);
//     String json = "";
//     try {
//         URL url = new URL("http://booking.uz.gov.ua/en/purchase/search/");
//         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//         conn.setRequestProperty("Cookie", cookie);
//         conn.setRequestProperty("GV-Token", token);
//         conn.setRequestProperty("GV-Ajax", "1");
//         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//         conn.setRequestProperty("Referer", "http://booking.uz.gov.ua/en/");
//         conn.setRequestMethod("POST");
//         String urlParameters = MessageFormat.format("station_id_from={0}&station_id_till={1}&date_dep={2}" +
//                                                     "&time_dep=00:00&time_dep_till=24:00", from, to, date);
//         conn.setDoOutput(true);
//         DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
//         wr.writeBytes(urlParameters);
//         wr.flush();
//         wr.close();
//         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//         String line;
//         while ((line = rd.readLine()) != null) {
//             json += line;
//         }
//         rd.close();
//     } catch (Exception e) {
//         error = e.getMessage();
//     }
//     return json;
// }
//
// static String getData(String fromName, String toName) {
//     return getData(fromName, toName, new SimpleDateFormat("MM.dd.yyyy").format(new Date()));
// }

//
// station_id_from=2200001&station_id_till=2218020&station_from=%D0%9A%D0%B8%D1%97%D0%B2&station_till=%D0%9A%D0%BE%D0%B2%D0%B5%D0%BB%D1%8C-%D0%9F%D0%B0%D1%81.&date_dep=13.10.2017&time_dep=00%3A00&time_dep_till=&another_ec=0&search=
