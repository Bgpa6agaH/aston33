package Task2;

@FunctionalInterface
interface Formula {
    double calculate(double ... value);
}