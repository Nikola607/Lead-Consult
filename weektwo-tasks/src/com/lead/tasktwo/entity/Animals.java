package tasktwo.entity;

public class Animals implements Comparable<Animals> {
    private String type;
    private String name;

    public Animals() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Animals animals) {
        return this.name.compareTo(animals.name);
    }
}
