package AnimalShelter;

public class Main {
    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Dog("Max"));
        animals.enqueue(new Cat("Aisha"));
        animals.enqueue(new Cat("Luxor"));
        animals.enqueue(new Dog("Spike"));

        System.out.println(animals.dequeueAny().getName()); // Max
        System.out.println(animals.dequeueCat().getName()); // Aisha
        System.out.println(animals.dequeueDog().getName()); // Spike
        System.out.println(animals.dequeueAny().getName()); // Luxor
    }
}
