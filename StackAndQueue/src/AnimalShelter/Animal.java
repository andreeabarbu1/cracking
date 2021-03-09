package AnimalShelter;

public abstract class Animal {
    private int order;
    private String name;

    Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }
}