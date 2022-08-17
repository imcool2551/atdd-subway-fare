package nextstep.path.domain.fare.discount;

public class BabyAgeDiscountApplier implements AgeDiscountApplier {
    private static final int BABY_AGE_UPPER_BOUND = 6;
    public static final int FREE_FARE = 0;

    private static class BabyAgeDiscountApplierHolder {
        private static final BabyAgeDiscountApplier INSTANCE = new BabyAgeDiscountApplier();
    }

    public static AgeDiscountApplier getInstance() {
        return BabyAgeDiscountApplierHolder.INSTANCE;
    }

    @Override
    public boolean canApply(int age) {
        return age < BABY_AGE_UPPER_BOUND;
    }

    @Override
    public int apply(int beforeFare) {
        return FREE_FARE;
    }
}
