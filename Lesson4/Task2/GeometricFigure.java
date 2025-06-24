package Task2;

interface GeometricFigure {
    double calculatePerimeter();
    double calculateArea();

    default double calculate(Formula formula, double ... values) {
        if (formula == null) {
            throw new IllegalArgumentException("Formula cannot be null.");
        }
        return formula.calculate(values);

    }

}


