/*Создать классы Собака и Кот с наследованием от класса Животное.
Все животные могут бежать и плыть.
В качестве параметра каждому методу передается длина препятствия.
 */
public abstract class Animal {
    protected  String name;
    final int runDistanceLimit;
    final int swimDistanceLimit;

    protected Animal(int runDistanceLimit, int swimDistanceLimit) {
        this.runDistanceLimit = runDistanceLimit;
        this.swimDistanceLimit = swimDistanceLimit;
    }


    abstract void run(int distance);
    abstract void swim(int distance);

    abstract public int getCount();

    public String getName() {
        return name;
    }
}

