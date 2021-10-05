public class NotFlyingBird extends Bird{
    private String type;
    @Override
    public String toString() {
        return "Bird { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMigrate=" + isMigrate +
                ", weight=" + weight +
                ", countFood=" + countFood +
                ", type=" + type +
                " }";
    }

    public NotFlyingBird(String name, Double age, boolean isMigrate,Double weight,Double countFood) {
        this.name = name;
        this.age = age;
        this.isMigrate = isMigrate;
        this.type="not flying";
        this.weight=weight;
        this.countFood=countFood;
    }
}
