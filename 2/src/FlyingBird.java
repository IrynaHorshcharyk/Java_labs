public class FlyingBird extends Bird{
    private String type;
    @Override
    public String toString() {
        return "Bird { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isFlying=" + isMigrate +
                ", weight=" + weight +
                ", countFood=" + countFood +
                ", type=" + type +
                " }";
    }

    public FlyingBird(String name, Double age, boolean isMigrate,Double weight,Double countFood) {
        this.name = name;
        this.age = age;
        this.isMigrate = isMigrate;
        this.type="flying";
        this.weight=weight;
        this.countFood=countFood;
    }
}
