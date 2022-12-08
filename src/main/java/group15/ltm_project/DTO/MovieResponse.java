package group15.ltm_project.DTO;

import java.io.Serializable;

/**
 *
 * @author baoluan
 */
public class MovieResponse implements Serializable{
    private String movieName;
    private String imgUrl;
    private String id;
    private String dateRelease;
    private String urlDetail;

    public MovieResponse(String movieName, String imgUrl, String id, String dateRelease, String urlDetail) {
        this.movieName = movieName;
        this.imgUrl = imgUrl;
        this.id = id;
        this.dateRelease = dateRelease;
        this.urlDetail = urlDetail;
    }

    public String getUrlDetail() {
        return urlDetail;
    }

    public void setUrlDetail(String urlDetail) {
        this.urlDetail = urlDetail;
    }
    
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Override
    public String toString() {
        return "MovieResponse{" + "movieName=" + movieName + ", imgUrl=" + imgUrl + ", id=" + id + ", dateRelease=" + dateRelease + ", urlDetail=" + urlDetail + '}';
    }
}
