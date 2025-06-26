import java.util.Arrays;

/*
Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.+
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.+

Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.+

Если в каком-то элементе массива преобразование не удалось
(например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией,
в какой именно ячейке лежат неверные данные.

В методе main() вызвать полученный метод,
обработать возможные исключения MyArraySizeException и MyArrayDataException
и вывести результат расчета.

Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.
*/
public class Main {

    public static void main(String[] args) {
        String[][] arrayString;
        System.out.println("положительная проверка");
        arrayString = new String[][]{
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"}
        };
        int sumOfElements=0;
        try {
            sumOfElements = sum4x4StringArrayToInt(arrayString);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("результат " + sumOfElements + "\n________________");



        System.out.println("проверка MyArraySizeException колонки");
        arrayString = new String[][]{
                {"0", "1", "2", "3"},
                {"0", "1", "2"},
                {"0", "1"},
                {"0"}
        };

        try {
            sumOfElements = sum4x4StringArrayToInt(arrayString);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
            if (e.getClass().equals(MyArrayDataException.class)){
                MyArrayDataException myException = (MyArrayDataException) e;
                System.out.println("Строка: " + myException.getRow());
                System.out.println("Столбец: " + myException.getColumn());
                System.out.println("Неверное значение: " + myException.getInvalidValue());}
        }

        System.out.println("________________");

        System.out.println("проверка MyArraySizeException строки");
        arrayString = new String[][]{
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"}
        };

        try {
            sumOfElements = sum4x4StringArrayToInt(arrayString);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
            if (e.getClass().equals(MyArrayDataException.class)){
                MyArrayDataException myException = (MyArrayDataException) e;
                System.out.println("Строка: " + myException.getRow());
                System.out.println("Столбец: " + myException.getColumn());
                System.out.println("Неверное значение: " + myException.getInvalidValue());}
        }
        System.out.println("________________");


        System.out.println("проверка MyArrayDataException");
        String[][] arrayString3 = {
                {"0", "одинка", "двойка", "тройка"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"}
        };

        try {
            sumOfElements = sum4x4StringArrayToInt(arrayString3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
            if (e.getClass().equals(MyArrayDataException.class)){
                MyArrayDataException myException = (MyArrayDataException) e;
                System.out.println("Строка: " + myException.getRow());
                System.out.println("Столбец: " + myException.getColumn());
                System.out.println("Неверное значение: " + myException.getInvalidValue());}
        }
        System.out.println("________________");


    }









    static int sum4x4StringArrayToInt(String[][] arrayString) throws MyArraySizeException, MyArrayDataException {
        if (arrayString == null)  {
            throw new MyArraySizeException("пустая ссылка");
        }
        if (arrayString.length != 4) {
            throw new MyArraySizeException("количество строк отличается от требуемого значения");
        }
        //for (String[] row : arrayString) if (row.length != 4) return 0;
        for (String[] row : arrayString) {
            if (row.length != 4) {
                throw new MyArraySizeException("количество колонок отличается от требуемого значения");
            }
        }
        int sum = 0;
        for (int  row = 0; row < 4; row ++) {
            for (int  column = 0; column < 4; column++) {
                try {
                    int number = Integer.parseInt(arrayString[row][column]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(e.getMessage(), row, column, arrayString[row][column]);
                }
            }

        }
        return sum;
    }
}
