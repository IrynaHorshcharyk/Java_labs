import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

enum Order {
    ASC,
    DESC
}

public class BirdManager {
    void sortByFoodAnonymous(ArrayList<Bird> birds, Order order) {
        Comparator<Bird> comparator = new Comparator<Bird>() {
            @Override
            public int compare(Bird b1, Bird b2) {
                return Double.compare(b1.countFood, b2.getCountFood());
            }
        };

        if (order.name().equals("ASC")) {
            birds.sort(comparator);
        } else {
            birds.sort(comparator.reversed());
        }
    }

    void sortByFoodInner(ArrayList<Bird> birds, Order order) {
        Bird bird = new Bird();
        Bird.InnerComparator comparator = bird.new InnerComparator();

        if (order.name().equals("ASC")) {
            birds.sort(comparator);
        } else {
            birds.sort(comparator.reversed());
        }
    }

    void sortByWeight(ArrayList<Bird> birds, Order order) {
        if (order.name().equals("ASC")) {
            birds.sort(new Bird.StaticInnerComparator());
        } else {
            birds.sort(new Bird.StaticInnerComparator().reversed());
        }
    }

    void sortByWeightLambda(ArrayList<Bird> birds, Order order) {
        if (order.name().equals("ASC")) {
            birds.sort((a, b) -> a.weight.compareTo(b.getWeight()));
        } else {
            birds.sort((a, b) -> a.getWeight().compareTo(b.getWeight()) * -1);
        }
    }

    ArrayList<Bird> searchByMigrate(ArrayList<Bird> birds, boolean isMigrate ) {
        return birds
                .stream()
                .filter(x -> x.getIsFlying() == isMigrate)
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
