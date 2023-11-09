package infrastructure.unsplashImages;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class JsonObject {

    @SerializedName("results")
    public List<Result> results;
}
