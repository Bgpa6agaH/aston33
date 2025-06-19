


import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
//
        System.out.println("\tзадание 1");
        printThreeWords();


        //2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
// которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
// то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
//
        System.out.println("\tзадание 2");
        checkSumSign(1, 1);
        checkSumSign(1, -1);
        checkSumSign(-1, -1);


        //3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
// Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
// если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
// если больше 100 (100 исключительно) - “Зеленый”;
//
        System.out.println("\tзадание 3");

        printColor(-100 + new Random().nextInt(200));

        //4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
// и инициализируйте их любыми значениями, которыми захотите.
// Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
//
        System.out.println("\tзадание 4");

        compareNumbers(1, 2);
        compareNumbers(1, 1);
        compareNumbers(2, 1);

        //5. Напишите метод, принимающий на вход два целых числа и проверяющий,
// что их сумма лежит в пределах от 10 до 20 (включительно),
// если да – вернуть true, в противном случае – false.
//
        System.out.println("\tзадание 5");

        System.out.println(isSumWithinRange(5, 4));
        System.out.println(isSumWithinRange(5, 5));
        System.out.println(isSumWithinRange(5, 10));
        System.out.println(isSumWithinRange(10, 10));
        System.out.println(isSumWithinRange(10, 11));


        //6. Напишите метод, которому в качестве параметра передается целое число,
// метод должен напечатать в консоль, положительное ли число передали или отрицательное.
// Замечание: ноль считаем положительным числом.
        System.out.println("\tзадание 6");

        printSignOfNumber(-1);
        printSignOfNumber(0);
        printSignOfNumber(1);

//7. Напишите метод, которому в качестве параметра передается целое число.
// Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
//    Замечание: ноль считаем положительным числом.
        System.out.println("\tзадание 7");

        System.out.println(isNegativeNumber(-1));
        System.out.println(isNegativeNumber(0));
        System.out.println(isNegativeNumber(1));

        //8. Напишите метод, которому в качестве аргументов передается строка и число,
// метод должен отпечатать в консоль указанную строку, указанное количество раз;
//
        System.out.println("\tзадание 8");

        printRepeatedString("строка", -1);

        //9. Напишите метод, который определяет, является ли год високосным,
// и возвращает boolean (високосный - true, не високосный - false).
// Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
//
        System.out.println("\tзадание 9");
        System.out.println("-4 " + isLeapYear(-4));
        System.out.println("-1 " + isLeapYear(-1));
        System.out.println("0 " + isLeapYear(0));
        System.out.println("1 " + isLeapYear(1));
        System.out.println("4 " + isLeapYear(4));
        System.out.println("99 " + isLeapYear(99));
        System.out.println("100 " + isLeapYear(100));
        System.out.println("396 " + isLeapYear(396));
        System.out.println("400 " + isLeapYear(400));
        System.out.println("401 " + isLeapYear(401));


//10. Задать целочисленный массив, состоящий из элементов 0 и 1.
// Например: [1, 1, 0, 0, 1, 0, 1, 1, 0, 0].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;
//
        System.out.println("\tзадание 10");

        int[] startArray = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] resultArray = invertBinaryArray(startArray);
        System.out.println("было  " + Arrays.toString(startArray));
        System.out.println("стало " + Arrays.toString(resultArray));

        //11. Задать пустой целочисленный массив длиной 100.
// С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
        System.out.println("\tзадание 11");
        int[] arrayTaskN11 = new int[100];
        fillArrayWithSequence(arrayTaskN11);
        System.out.println(Arrays.toString(arrayTaskN11));

//12. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]
// пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("\tзадание 12");
        int[] arrayTaskN12 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("было " + Arrays.toString(arrayTaskN12));
        doubleElementsLessThanSix(arrayTaskN12);
        System.out.println("стало" + Arrays.toString(arrayTaskN12));

//13. Создать квадратный двумерный целочисленный массив
// (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами
// (можно только одну из диагоналей, если обе сложно).
// Определить элементы одной из диагоналей можно по следующему принципу:
// индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
//
        System.out.println("\tзадание 13");

        int randomNumber = 2 + new Random().nextInt(10);
        int[][] SquareArray = createUnitDiagonalSquareArray(randomNumber);
        for (int i = 0; i < randomNumber; i++) {
            System.out.println(Arrays.toString(SquareArray[i]));
        }


        //14. Написать метод, принимающий на вход два аргумента:
// len и initialValue, и возвращающий одномерный массив типа int длиной len,
// каждая ячейка которого равна initialValue.
        System.out.println("\tзадание 14");
        System.out.println(Arrays.toString(createArrayWithInitialValue(5, 11)));

    }


    //
//1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
//
    static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    //2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
// которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
// то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
//
    static void checkSumSign(int a, int b) {
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
// Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
// если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
// если больше 100 (100 исключительно) - “Зеленый”;
//
    static void printColor(int value) {
        System.out.println("value = " + value);
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    //4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
// и инициализируйте их любыми значениями, которыми захотите.
// Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
//
    private static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }


    //5. Напишите метод, принимающий на вход два целых числа и проверяющий,
// что их сумма лежит в пределах от 10 до 20 (включительно),
// если да – вернуть true, в противном случае – false.
//
    static boolean isSumWithinRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //6. Напишите метод, которому в качестве параметра передается целое число,
// метод должен напечатать в консоль, положительное ли число передали или отрицательное.
// Замечание: ноль считаем положительным числом.
    static void printSignOfNumber(int number) {
        if (number >= 0) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }
    }


//7. Напишите метод, которому в качестве параметра передается целое число.
// Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
//    Замечание: ноль считаем положительным числом.

    static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    //8. Напишите метод, которому в качестве аргументов передается строка и число,
// метод должен отпечатать в консоль указанную строку, указанное количество раз;
//
    static void printRepeatedString(String text, int count) {
        if (count < 1) {
            System.out.println("количество строк меньше 1");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(text + " " + i + 1);
        }
    }

    //9. Напишите метод, который определяет, является ли год високосным,
// и возвращает boolean (високосный - true, не високосный - false).
// Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
//
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

//10. Задать целочисленный массив, состоящий из элементов 0 и 1.
// Например: [1, 1, 0, 0, 1, 0, 1, 1, 0, 0].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;
//

    static int[] invertBinaryArray(int[] arr) {
        if (arr == null) {
            System.out.println("Массив равен null");
            return new int[1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0 && arr[i]!=1){
                System.out.println("не валидный массив"); return arr;
            }
            result[i] = (arr[i] + 1) % 2;
        }
        return result;
    }

    //11. Задать пустой целочисленный массив длиной 100.
// С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
//
    static void fillArrayWithSequence(int[] arr) {
        if (arr == null) {
            System.out.println("Массив равен null");
            return;
        }
        for (int i = 0; i < arr.length; ) {
            arr[i++] = i;
        }
    }

    //12. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]
// пройти по нему циклом, и числа меньшие 6 умножить на 2;
//
    static void doubleElementsLessThanSix(int[] arr) {
        if (arr == null) {
            System.out.println("Массив равен null");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    //13. Создать квадратный двумерный целочисленный массив
// (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами
// (можно только одну из диагоналей, если обе сложно).
// Определить элементы одной из диагоналей можно по следующему принципу:
// индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
//
    static int[][] createUnitDiagonalSquareArray(int size) {
        if(size<1){
            System.out.println("не валидное число");
            return new int[1][1];
        }
        int[][] squareArray = new int[size][size];
        for (int i = 0, j = size - 1; i < size; i++, j--) {
            squareArray[i][i] = 1;
            squareArray[i][j] = 1;
        }
        return squareArray;
    }

    //14. Написать метод, принимающий на вход два аргумента:
// len и initialValue, и возвращающий одномерный массив типа int длиной len,
// каждая ячейка которого равна initialValue.
    static int[] createArrayWithInitialValue(int len, int initialValue) {
        if(len<0){
            System.out.println("не валидное число");
            return  new int[]{initialValue};
        }
        int[] resultArray = new int[len];
        for (int i = 0; i < len; i++) {
            resultArray[i] = initialValue;
        }
        // "Arrays.fill(resultArray, initialValue);"
        // "return IntStream.range(0, len).map(i -> initialValue).toArray();"
        return resultArray;
    }

}
