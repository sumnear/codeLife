package com.commons.utils;//package utilss;
//
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import java.util.*;
//
///**
// * @author near
// */
//public class JsonUtil {
//
//    // JSON转对象类型list
//    @SuppressWarnings("unchecked")
//    public static <T> List<T> jsonToList(String jsonStr, Class<T> targetOb) {
//        String json = jsonStr;
//        JSONArray jsonarray = JSONArray.fromObject(json);
//        List<T> list = (List<T>) JSONArray.toCollection(jsonarray, targetOb);
//        return list;
//    }
//
//    // json转map
//    @SuppressWarnings("unchecked")
//    public static Map<String, Object> parseJSON2Map(String jsonStr) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        // 最外层解析
//        JSONObject json = JSONObject.fromObject(jsonStr);
//        for (Object k : json.keySet()) {
//            Object v = json.get(k);
//            // 如果内层还是数组的话，继续解析
///*            if (v instanceof JSONArray) {
//                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//                Iterator<JSONObject> it = ((JSONArray) v).iterator();
//                while (it.hasNext()) {
//                    JSONObject json2 = it.next();
//                    list.add(parseJSON2Map(json2.toString()));
//                }
//                map.put(k.toString(), list);
//            }*/
//            if (v instanceof JSONArray) {
//            	try{
//            		Iterator<JSONObject> it = ((JSONArray) v).iterator();
//            		 List<Map<String, Object>> list = new ArrayList<>();
//            		 while (it.hasNext()) {
//                         JSONObject jsonObj = it.next();
//                         list.add(parseJSON2Map(jsonObj.toString()));
//                     }
//                     map.put(k.toString(), list);
//            	}catch(Exception e){
//            		Iterator<String> it = ((JSONArray) v).iterator();
//            		 List<String> list = new ArrayList<>();
//            		 while (it.hasNext()) {
//                         String jsonObj = it.next();
//                         list.add(jsonObj);
//                     }
//                     map.put(k.toString(), list);
//            	}
//            }
//            else if(v instanceof JSONObject){
//            	map.put(k.toString(), parseJSON2Map(v.toString()));
//            }else{
//            	map.put(k.toString(), v);
//            }
//        }
//        return map;
//    }
//
//    // jsonArray转list<Map<String,String>>
//    @SuppressWarnings("unchecked")
//    public static List<Map<String, Object>> parseJSON2List(String jsonStr) {
//        JSONArray jsonArr = JSONArray.fromObject(jsonStr);
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        Iterator<JSONObject> it = jsonArr.iterator();
//        while (it.hasNext()) {
//            JSONObject json2 = it.next();
//            list.add(parseJSON2Map(json2.toString()));
//        }
//        return list;
//    }
//
//    public static void main(String[] args) {
//
////         String a ="{\"employees\": [{ \"firstName\":\"John\" , \"lastName\":\"Doe\" },{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" },{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" }]}";
//        		 //         "{\"message\": \"\",\"result\": {\"token\":\"rPeDS7jzftEMuNTaaimKk4fRiIvANIICpqD8aysTtWBx+SB6OfaREESzx0ejxgiukWwGe/l2vys=\" },\"errorCode\": 1}";
////        		 "{\"message\": \"\",\"result\":\"rPeDS7jzftEMuNTaaimKk4fRiIvANIICpqD8aysTtWBx+SB6OfaREESzx0ejxgiukWwGe/l2vys=\",\"errorCode\": 1}";
////         Map map = parseJSON2Map(a);
////         Map map2 = parseJSON2Map(map.get("result").toString());
////         System.out.println(((Map)map.get("result")).get("token"));
////        System.out.println(dateCompare("2014-03-22", "2014-03-23"));
//    }
//
////    public static boolean dateCompare(String date, String lastdate) {
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////        try {
////            Date date1 = sdf.parse(date);
////            Date date2 = sdf.parse(lastdate);
////            int i = date1.compareTo(date2);
////            return i > 0;
////
////        } catch (ParseException e) {
////            // e.printStackTrace();
////            return false;
////        }
////    }
////
////    public static String replaceBlank(String str) {
////        String dest = "";
////        if (str != null) {
////            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
////            Matcher m = p.matcher(str);
////            dest = m.replaceAll("");
////        }
////        return dest;
////    }
//}
