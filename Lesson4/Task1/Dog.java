package Task1;

public class Dog extends Animal{

    private static int count = 0;

    public Dog(String name) {
        super(500,10);
        this.name = name;
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }



    @Override
    void run(int distance) {
        if(distance > runDistanceLimit){distance = runDistanceLimit;}
        System.out.printf("%s пробежал %s м.",name, distance);
    }

    @Override
    void swim(int distance) {
        if(distance > swimDistanceLimit){distance = swimDistanceLimit;}
        System.out.printf("%s пробежал %s м.",name, distance);
    }
}
