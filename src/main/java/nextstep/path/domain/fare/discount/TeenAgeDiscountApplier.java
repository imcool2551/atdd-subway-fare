package nextstep.path.domain.fare.discount;

public class TeenAgeDiscountApplier implements AgeDiscountApplier{
    private static final int TEEN_AGE_LOWER_BOUND = 13;
    private static final int TEEN_AGE_UPPER_BOUND = 19;
    private static final double TEEN_DISCOUNT_AMOUNT = 0.2d;

    private static class TeenAgeDiscountApplierHolder {
        private static final TeenAgeDiscountApplier INSTANCE = new TeenAgeDiscountApplier();
    }

    public static TeenAgeDiscountApplier getInstance() {
        return TeenAgeDiscountApplierHolder.INSTANCE;
    }

    private TeenAgeDiscountApplier() {
    }

    @Override
    public boolean canApply(int age) {
        return age >= TEEN_AGE_LOWER_BOUND && age < TEEN_AGE_UPPER_BOUND;
    }

    @Override
    public int apply(int beforeFare) {
        return (int) (beforeFare - beforeFare * TEEN_DISCOUNT_AMOUNT);
    }
}
