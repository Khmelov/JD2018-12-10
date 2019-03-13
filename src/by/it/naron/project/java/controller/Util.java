package by.it.naron.project.java.controller;

import by.it.naron.project.java.beans.User;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Util {
    static boolean checkUser(HttpServletRequest req) {
        return findUser(req) != null;
    }

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object objUser = session.getAttribute("user");
            if (objUser != null) {
                return (User) objUser;
            }
        }
        return null;
    }


    static boolean isAdmin(HttpServletRequest req) {
        User user = Util.findUser(req);
        if (user != null) {
            return user.getRoles_Id() == 1;
        }
        return false;
    }

//    static void sendTg(String brnd, String model, int year, double price) throws IOException {
//        String url = String.format("https://api.telegram.org/bot727115180:AAHUY8LHssKtuiuN4e0Mice9f4u7S3sS_gM/sendMessage?chat_id=433820982&parse_mode=html&text=%s %s %dг. %dруб.",
//                brnd, model, year, (int) price);
//
//        URL obj = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//
//        connection.setRequestMethod("GET");
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while (( inputLine = in.readLine() ) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        System.out.println(response.toString());
//
//    }
//public static void sendGet(String brnd, String model, int year, double price) throws Exception {
//
//     final String USER_AGENT = "Mozilla/5.0";
//
//    String url = String.format("https://api.telegram.org/bot727115180:AAHUY8LHssKtuiuN4e0Mice9f4u7S3sS_gM/sendMessage?chat_id=433820982&parse_mode=html&text=%s %s %dг. %dруб.",
//            brnd, model, year, (int) price);
//
//    URL obj = new URL(url);
//    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//    // optional default is GET
//    con.setRequestMethod("GET");
//    con.setRequestProperty("User-Agent", USER_AGENT);
//    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//
//    //add request header
//    con.setRequestProperty("User-Agent", USER_AGENT);
//
//    int responseCode = con.getResponseCode();
//
//    System.out.println("\nSending 'GET' request to URL : " + url);
//    System.out.println("Response Code : " + responseCode);
//
//    BufferedReader in = new BufferedReader(
//            new InputStreamReader(con.getInputStream()));
//    String inputLine;
//    StringBuffer response = new StringBuffer();
//
//    while ((inputLine = in.readLine()) != null) {
//        response.append(inputLine);
//    }
//    in.close();
//
//    //print result
//    System.out.println(response.toString());
//
//}

    static void saveFile(HttpServletRequest req, String filename) throws IOException, ServletException {
        filename = req.getServletContext().getRealPath("/images/" + filename);
        int size = 0;
        InputStream checkNullFile = req.getPart("upload").getInputStream();
        int read = checkNullFile.read();
        checkNullFile.close();
        if (read > -1) {
            try (InputStream streamIn = req.getPart("upload").getInputStream();
                 OutputStream streamOut = new FileOutputStream(filename)) {

                byte[] buffer = new byte[100000];
                while (streamIn.available() > 0) {
                    int i = streamIn.read(buffer);
                    streamOut.write(buffer, 0, i);
                    size += i;
                }

            }
        }
//        if (size == 0) {
//            new File(filename).delete();
//        }
    }

    static void deleteFile(HttpServletRequest req, String filename) {
        filename = req.getServletContext().getRealPath("/images/" + filename);
        File file = new File(filename);
        if (file.delete()) {
            System.out.println(file + " deleted");
        }

    }

}