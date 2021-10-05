import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Bird> birds = new ArrayList<>();

        birds.add(new Bird("duck", 5.9, true, 1.2,0.9));
        birds.add(new Bird("geese", 4.6,true, 2.2,1.0));
        birds.add(new Bird("crane", 2.3,true, 6.9,2.9));
        birds.add(new Bird("ostrich", 5.3,false, 1.7,0.26));
        birds.add(new Bird("kakapo", 0.3,false, 2.4,0.29));
        birds.add(new Bird("peafowl", 6.8,true, 9.2,3.9));
        birds.add(new Bird("martlet", 1.7,true, 0.2,1.34));
        birds.add(new FlyingBird("swan", 1.2, true, 4.7,1.45));
        birds.add(new NotFlyingBird("penguin", 3.0 ,false,3.3, 1.23));

        BirdManager manager = new BirdManager();

        System.out.println("All birds:");
        birds.forEach(System.out::println);

        System.out.println("Migrate Birds");
        ArrayList<Bird> MigrateBirds = manager.searchByMigrate(birds, true);

        System.out.println("Sorting by count food asc order:");
        manager.sortByFoodInner(birds, Order.ASC);
        MigrateBirds.forEach(System.out::println);

        System.out.println("Sorting by count food desc order:");
        manager.sortByFoodAnonymous(birds, Order.DESC);
        MigrateBirds.forEach(System.out::println);

        System.out.println("Sorting by weight asc order:");
        manager.sortByWeight(birds, Order.ASC);
        MigrateBirds.forEach(System.out::println);

        System.out.println("Sorting by weight desc order:");
        manager.sortByWeightLambda(birds, Order.DESC);
        MigrateBirds.forEach(System.out::println);
    }
}

