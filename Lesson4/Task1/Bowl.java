package Task1;

public class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
            this.foodAmount = initialFood < 0 ? 0:initialFood;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public boolean feed(int amount) {
        if (amount > 0 && this.foodAmount >= amount) {
            this.foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя добавить отрицательное количество еды или ноль еды.");
        }
            this.foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Всего в миске: " + this.foodAmount);
        }
    }
