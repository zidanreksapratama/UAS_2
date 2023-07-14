package UAS_2;

import org.json.JSONArray;
import org.json.JSONObject;

public class UAS_2{

    public class Main {
        public static void main(String[] args) {
            String jsonStr = "{\"menu\":{\"id\":\"file\",\"value\":\"file\",\"popup\":{\"menuitem\":[{\"value\":\"New\",\"onclick\":\"CreateNewDoc()\"},{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"},{\"value\":\"Close\",\"onclick\":\"CloseDoc()\"}]}}}";

            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONObject menu = jsonObject.getJSONObject("menu");
            JSONArray menuItems = menu.getJSONObject("popup").getJSONArray("menuitem");

            for (int i = 0; i < menuItems.length(); i++) {
                JSONObject menuItem = menuItems.getJSONObject(i);
                String value = menuItem.getString("value");
                String onclick = menuItem.getString("onclick");

                System.out.println("Menu Item:");
                System.out.println("Value: " + value);
                System.out.println("OnClick: " + onclick);
                System.out.println();
            }
        }
    }

}
