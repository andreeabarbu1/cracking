package AnimalShelter;

import java.util.LinkedList;

/*
    an animal shelter who operates on a FIFO basis, it stores
    the animals based on arrival time
    You can select "the oldest" cat or dog or animal (it doesn't
    matter if it is a cat or a dog)
 */
public class AnimalQueue {
    private LinkedList<Animal> dogs, cats;
    private int order;

    AnimalQueue() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Cat) {
            cats.add(animal);
        } else if (animal instanceof Dog) {
            dogs.add(animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        }

        return dogs.peek().getOrder() < cats.peek().getOrder() ?
                dogs.poll() : cats.poll();
    }

    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            return null;
        }
        return (Dog)dogs.poll();
    }

    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            return null;
        }
        return (Cat)cats.poll();
    }
}
