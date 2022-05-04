package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Tool;
import data.ToolType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DataStore {

    private static final String toolPath = "src/toolConfig.json";
    private static final String toolTypePath = "src/toolTypeConfig.json";
    private static List<Tool> tools;
    private static List<ToolType> toolTypes;

    public static void initialize(){
        try {
            Gson gson = new Gson();
            loadTools(gson);
            loadToolsTypes(gson);
        } catch (IOException e) {
            System.out.println("There was an error accessing the config file");
        }
    }

    private static void loadTools(Gson gson) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(toolPath)));
        Type type = new TypeToken<ArrayList<Tool>>() {}.getType();
        tools = gson.fromJson(content, type);
    }

    private static void loadToolsTypes(Gson gson) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(toolTypePath)));
        Type type = new TypeToken<ArrayList<ToolType>>() {}.getType();
        toolTypes = gson.fromJson(content, type);
    }

    public static Tool findTool(String toolCode){
        return tools.stream()
                .filter(tool -> tool.getToolCode().equals(toolCode))
                .findFirst()
                .orElse(null);
    }

    public static ToolType findToolType(String toolType){
        return toolTypes.stream()
                .filter(type -> type.getToolType().equals(toolType))
                .findFirst()
                .orElse(null);
    }
}
