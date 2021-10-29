package frame;

public class JSONParser {
    private static JSONParser jsonParser;
//
//    public String getValueFromJson(String file, String field){
//        return
//    }





    public synchronized JSONParser jsonParser(){
        if(jsonParser == null){
            jsonParser = new JSONParser();
        }
        return jsonParser;
    }
}
