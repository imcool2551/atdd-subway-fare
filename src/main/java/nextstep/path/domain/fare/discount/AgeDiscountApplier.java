package nextstep.path.domain.fare.discount;

public interface AgeDiscountApplier {
    boolean canApply(int age);

    int apply(int beforeFare);
}
