package Task1;

/*
Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:

Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
Каждому коту нужно добавить поле сытость
(когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true.
Считаем, что если коту мало еды в миске, то он её просто не трогает,
то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
Создать массив котов и миску с едой,
попросить всех котов покушать из этой миски и потом вывести информацию о сытости котов в консоль.
Добавить метод, с помощью которого можно было бы добавлять еду в миску
 */
public class Cat extends Animal{

    private static int count = 0;

    public Cat(String name) {
        super(200,0);
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