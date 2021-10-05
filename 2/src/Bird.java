import java.util.Comparator;
public class Bird {
    protected String name;
    protected Double age;
    protected Double weight;
    protected Double countFood;
    protected boolean isMigrate;

    @Override
    public String toString() {
        return "Bird { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMigrate=" + isMigrate +
                ", weight=" + weight +
                ", countFood=" + countFood +
                " }";
    }

    static class StaticInnerComparator implements Comparator<Bird> {

        @Override
        public int compare(Bird b1, Bird b2) {
            return b1.weight.compareTo(b2.getWeight());
        }
    }
    class InnerComparator implements Comparator<Bird> {

        @Override
        public int compare(Bird b1, Bird b2) {
            return Double.compare(b1.countFood, b2.getCountFood());
        }
    }
    public Bird(String name, Double age, boolean isMigrate,Double weight,Double countFood) {
        this.name = name;
        this.age = age;
        this.isMigrate = isMigrate;
        this.weight=weight;
        this.countFood=countFood;
    }

    public Double getAge() {
        return age;
    }

    public void setCapacity(double birdAge) {
        this.age = birdAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsFlying() {
        return isMigrate;
    }

    public void setIsFluing(boolean isMigrate) {
        this.isMigrate = isMigrate;
    }
    public Double getWeight() {
        return weight;
    }
    public Double getCountFood() {
        return countFood;
    }
    public Bird() {
    }

}
