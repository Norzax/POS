package group15.ltm_project.DTO;

import java.io.Serializable;

/**
 *
 * @author baoluan
 */
public class MovieDetail implements Serializable{
    private String id;
    private String description;
    private String urlTomato;
    //private ArrayList<ReviewUrl> reviewUrls;
    private String actor;
    private String director;
    private String productor;
    private String imgUrl;
    private String movieName;
    private String movieNameType;
    private String urlTrailer;

    public MovieDetail(String id, String description, String urlTomato, String actor, String director, String productor, String imgUrl, String movieName, String movieNameType, String urlTrailer) {
        this.id = id;
        this.description = description;
        this.urlTomato = urlTomato;
        this.actor = actor;
        this.director = director;
        this.productor = productor;
        this.imgUrl = imgUrl;
        this.movieName = movieName;
        this.movieNameType = movieNameType;
        this.urlTrailer = urlTrailer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlTomato() {
        return urlTomato;
    }

    public void setUrlTomato(String urlTomato) {
        this.urlTomato = urlTomato;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieNameType() {
        return movieNameType;
    }

    public void setMovieNameType(String movieNameType) {
        this.movieNameType = movieNameType;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }
    
}
