package group15.ltm_project.DTO;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author baoluan
 */
public class MovieServices {
    public static ArrayList<MovieResponse> getAllMovie() throws IOException{
        Document doc = Jsoup.connect("https://moveek.com/dang-chieu/").get();
        ArrayList<MovieResponse> list = new ArrayList<>();
        //System.out.println(doc);
        org.jsoup.select.Elements elements = doc.getElementsByClass("card card-xs mb-4");
        for(int i =0 ;i<elements.size();i++){
            //lay ten phim
            String name = elements.get(i).getElementsByClass("card-body border-top").first()
                                            .getElementsByTag("h3").first()
                                            .getElementsByTag("a").text();
            //System.out.println(name);
            //lay id
            String id = elements.get(i).getElementsByClass("btn-group btn-actions").first()
                                            .getElementsByTag("a").first().attr("data-id");
            //System.out.println(id);
            //lay ngay release
            String dateRelease = elements.get(i).getElementsByClass("col text-muted").text();
            //lay hinh
            String imgUrl = elements.get(i).getElementsByTag("img").first().attr("data-srcset");
            String[] imgUrlArr = imgUrl.split(",");
            String[] imgUrlX1 = imgUrlArr[0].split(" ");
            //lay url detail
            String urlDetail = elements.get(i).getElementsByClass("text-truncate h4 mb-1").first().getElementsByTag("a").attr("href");
            //System.out.println(urlDetail);
            //System.out.println(list2.get(i));
            MovieResponse movieRespone = new MovieResponse(name, imgUrlX1[0], id, dateRelease, urlDetail);
            list.add(movieRespone);
        }
        return list;
    }
    
    
    
//    private ArrayList<ShowTime> getTime(int movieId,int cinemaId) throws JSONException, IOException {
//        Document doc = Jsoup.connect("https://moveek.com/showtime/movie/"+movieId+"?cinema="+cinemaId).get();//date=2022-11-15&
//        ArrayList<ShowTime> list = new ArrayList<>();
//        org.jsoup.select.Elements elements = doc.select("div.mb-1");
//        for (int i =0 ; i<elements.size();i++) {
//            Element elementName= element.select("label").first();
//            Elements elementTime=element.select("span.time");
//            ArrayList<String> showTime=new ArrayList<>();
//            for(Element time:elementTime){
//                showTime.add(time.text());
//            }
//            ShowTime time=ShowTime.builder()
//                    .nameShowtime(elementName.text())
//                    .time(showTime)
//                    .build();
//            showTimes.add(time);
//        }
//        // System.out.println(doc);
//        return showTimes;
//    }
//
    public static ArrayList<MovieDetail> getMovieDetail(String id) throws IOException{
        Document doc = Jsoup.connect("https://moveek.com/movie/"+id).get();
        ArrayList<MovieDetail> list = new ArrayList<>();
        String description = doc.getElementsByClass("mb-3 text-justify").text();
        String type = doc.getElementsByClass("mb-0 text-muted text-truncate").text();
        String[] movieTypeName= type.split("-");
        //System.out.println(doc);
        String url=movieTypeName[0].replace(":", "").replace(" ", "_");
        String urlTomato="abc";
        String Review = doc.getElementsByClass("card card-sm card-article mb-3").first().getElementsByClass("article").text();
        String imgUrl = doc.getElementsByClass("d-none d-sm-block col-2").first().getElementsByTag("a").first().getElementsByTag("img").first().attr("data-srcset");
        String[] imgUrlArr = imgUrl.split(",");
        String[] imgUrlX1 = imgUrlArr[0].split(" ");
        String movieName = doc.getElementsByClass("mb-0 text-truncate").first().getElementsByTag("a").attr("title");
        String urLTrailer = doc.getElementsByClass("js-video youtube widescreen mb-4").first().getElementsByTag("iframe").attr("src");
        org.jsoup.select.Elements elements = doc.getElementsByClass("col-12 col-lg-5").first().getElementsByClass("mb-2");
        String actor = "";
        String director = "";
        String productor = "";
        if(elements.size() == 3){
            actor = elements.get(0).getElementsByTag("span").first().getElementsByTag("a").text();
            director = elements.get(1).getElementsByTag("span").first().getElementsByTag("a").text();
            productor = elements.get(2).getElementsByTag("span").first().getElementsByTag("a").text();
        } else if(elements.size() == 2){
            actor = elements.get(0).getElementsByTag("span").first().getElementsByTag("a").text();
            director = elements.get(1).getElementsByTag("span").first().getElementsByTag("a").text();
            productor = "";
        } else if(elements.size() == 1){
            actor = elements.get(0).getElementsByTag("span").first().getElementsByTag("a").text();
            director = "";
            productor = "";
        } 
        MovieDetail md= new MovieDetail(id, description, urlTomato, actor, director, productor, imgUrl, movieName, type, urLTrailer);
        list.add(md);
        return list;
    }

//    public List<Cineplex> getShowTime(int id) throws JSONException, IOException {
//        JSONObject json = readJsonFromUrl("https://moveek.com/showtime/movie/"+id);
//        JSONArray array = json.getJSONArray("cineplexes");
//        List<Cineplex> cineplexs=new ArrayList<>();
//        for(Object object:array) {
//            JSONObject jsonObject=(JSONObject) object;
//            JSONObject cineplexObj=jsonObject.getJSONObject("data");
//            JSONArray arrayCinema = jsonObject.getJSONArray("cinemas");
//            List<Cinema> cinemas=new ArrayList<>();
//            for(Object cinema:arrayCinema) {
//                    JSONObject jsonCinema=(JSONObject) cinema;
//                    Cinema cinemaDto=Cinema.builder()
//                                                            .cinemaName(jsonCinema.getString("name"))
//                                                            .id(jsonCinema.getInt("id"))
//                                                            .build();
//                    cinemas.add(cinemaDto);
//            }
//            Cineplex cineplex=Cineplex.builder()
//                .id(cineplexObj.getInt("id"))
//                .cineplexName(cineplexObj.getString("name"))
//                .cinemas(cinemas)
//                .build();
//            cineplexs.add(cineplex);
//        }
//        return cineplexs;
//    }
    // public 

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {

        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException{
        new MovieServices().getAllMovie();
        new MovieServices().getMovieDetail("14227");
    }
}
