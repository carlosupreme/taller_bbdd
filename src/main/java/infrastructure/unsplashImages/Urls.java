package infrastructure.unsplashImages;

import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("small")
    public String small;

    @SerializedName("raw")
    public String raw;

    @Override
    public String toString() {
        return "{\n\"raw\": \"" + raw + "\",\n\"small\": \"" + small + "\"}";
    }
}
