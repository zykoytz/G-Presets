package furnidata.details;

import org.json.JSONObject;

// source: https://github.com/kouris-h/HabboAPI/blob/master/src/main/java/gamedata/furnidata/furnidetails/FurniDetails.java
// by wiredspast & kouris
public class WallItemDetails extends FurniDetails {
    public final String mobi; // furniture identifier for enhanced identification

    public WallItemDetails(JSONObject jsonObject) {
        super(jsonObject);

        // Extract mobi identifier - prefer name, fallback to className, then id
        String mobiValue = null;
        if (jsonObject.has("name") && !jsonObject.getString("name").isEmpty()) {
            mobiValue = jsonObject.getString("name");
        } else if (jsonObject.has("classname") && !jsonObject.getString("classname").isEmpty()) {
            mobiValue = jsonObject.getString("classname");
        } else {
            mobiValue = String.valueOf(jsonObject.getInt("id"));
        }
        this.mobi = mobiValue;
    }

    public String getMobi() {
        return mobi;
    }
}