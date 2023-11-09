package infrastructure.unsplashImages;

import com.google.gson.annotations.SerializedName;


public class Result {
    @SerializedName("urls")
    public Urls urls;
    
    @SerializedName("color")
    public String color;
    
    @Override
    public String toString(){
        return urls.toString();
    }
}
