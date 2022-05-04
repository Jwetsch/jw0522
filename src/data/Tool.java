package data;

import java.util.Objects;

public class Tool {

    private String toolCode;
    private String toolType;
    private String brand;

    public String getToolCode() {
        return toolCode;
    }

    public Tool setToolCode(String toolCode) {
        this.toolCode = toolCode;
        return this;
    }

    public String getToolType() {
        return toolType;
    }

    public Tool setToolType(String toolType) {
        this.toolType = toolType;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Tool setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return toolCode.equals(tool.toolCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toolCode);
    }
}
