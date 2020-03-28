package entity;

public class Continent {
    private String name;
    private int value;
    private String color;

    private boolean isVisited = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public boolean equals(Object input_obj) {

        if (!(input_obj instanceof Continent)) {
            return false;
        }
        if (input_obj == this) {
            return true;
        }
        Continent continent = (Continent) input_obj;

        return continent.getName().equalsIgnoreCase(name);
    }
}
