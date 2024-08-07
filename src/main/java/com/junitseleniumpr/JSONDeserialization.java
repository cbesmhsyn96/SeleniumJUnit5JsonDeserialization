package com.junitseleniumpr;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

public class JSONDeserialization extends BaseTest{
    private static String directory = "src/main/resources";
    private static ObjectMapper mapper = new ObjectMapper();
    String searchedKey = "key2";

    private static List<File> getJsonFiles(){
        File directoryOfResourches = new File(directory);
        if (directoryOfResourches.isDirectory()){
            File[] files = directoryOfResourches.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".json");
                }
            });
            return List.of(files);
        }
        return null;
    }

    private static JsonNode getJsonNodeBySearchedKey(String searchedKey) throws IOException {
        for (File file: getJsonFiles()){
            JsonNode root = mapper.readTree(file);
            if (root.isArray()){
                for (JsonNode currentNode : root){
                    if (currentNode.get("key").asText().equals(searchedKey)){
                        return currentNode;
                    }
                }
            }
        }
        return null;
    }

    public static By getLocator(String searchedKey) throws IOException {
        switch (getJsonNodeBySearchedKey(searchedKey).get("type").asText()){
            case "css":
                return By.cssSelector(getJsonNodeBySearchedKey("value").asText());
            case "id":
                return By.id(getJsonNodeBySearchedKey("value").asText());
            case "class":
                return By.className(getJsonNodeBySearchedKey("value").asText());
            case "name":
                return By.name(getJsonNodeBySearchedKey("value").asText());
            case "tagName":
                return By.tagName(getJsonNodeBySearchedKey("value").asText());
            case "xpath":
                return By.xpath(getJsonNodeBySearchedKey("value").asText());
            case "linkText":
                return By.linkText(getJsonNodeBySearchedKey("value").asText());
        }
        return null;
    }


}
