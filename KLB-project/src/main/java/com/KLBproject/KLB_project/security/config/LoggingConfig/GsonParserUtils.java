package com.KLBproject.KLB_project.security.config.LoggingConfig;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class GsonParserUtils {

    private static final Gson gson = new Gson();

    public static String parseObjectToString(Object object) {
        if (object == null) {
            return "null";
        }
        return gson.toJson(object);
    }

    public static <T> T parseStringToObject(String json, Class<T> classObject) {
        try {
            return new Gson().fromJson(json, classObject);
        } catch (Exception e) {
            return null;
        }
    }
}

//
//import com.google.gson.Gson;
//import com.google.gson.JsonSyntaxException;
//
///**
// * Utility class for converting objects to JSON and vice versa using Gson.
// */
//public class GsonParserUtils {
//
//    // Reuse a single Gson instance for performance and consistency
//    private static final Gson GSON = new Gson();
//
//    /**
//     * Converts an object to its JSON representation.
//     *
//     * @param object The object to convert to JSON.
//     * @return The JSON representation of the object, or "null" if the object is null.
//     */
//    public static String parseObjectToString(Object object) {
//        if (object == null) {
//            return "null";
//        }
//        return GSON.toJson(object);
//    }
//
//    /**
//     * Converts a JSON string to an object of the specified class.
//     *
//     * @param json The JSON string to convert.
//     * @param classOfT The class of the object to return.
//     * @param <T> The type of the object to return.
//     * @return The object of type T represented by the JSON string, or null if the JSON is invalid.
//     */
//    public static <T> T parseStringToObject(String json, Class<T> classOfT) {
//        try {
//            return GSON.fromJson(json, classOfT);
//        } catch (JsonSyntaxException e) {
//            // Log the exception or handle it as appropriate
//            System.err.println("Failed to parse JSON: " + e.getMessage());
//            return null;
//        }
//    }
//}
