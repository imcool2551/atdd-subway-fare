package nextstep.path.domain.fare.discount;

public class ChildAgeDiscountApplier implements AgeDiscountApplier {
    private static final int CHILD_AGE_LOWER_BOUND = 6;
    private static final int CHILD_AGE_UPPER_BOUND = 13;
    private static final double CHILD_DISCOUNT_AMOUNT = 0.5d;

    private static class ChildAgeDiscountApplierHolder {
        private static final ChildAgeDiscountApplier INSTANCE = new ChildAgeDiscountApplier();
    }

    public static ChildAgeDiscountApplier getInstance() {
        return ChildAgeDiscountApplierHolder.INSTANCE;
    }

    private ChildAgeDiscountApplier() {
    }

    @Override
    public boolean canApply(int age) {
        return age >= CHILD_AGE_LOWER_BOUND && age < CHILD_AGE_UPPER_BOUND;
    }

    @Override
    public int apply(int beforeFare) {
        return (int) (beforeFare - beforeFare * CHILD_DISCOUNT_AMOUNT);
    }
}
