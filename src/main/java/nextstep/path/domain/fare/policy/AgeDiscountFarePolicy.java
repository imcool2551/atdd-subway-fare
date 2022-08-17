package nextstep.path.domain.fare.policy;

import nextstep.path.domain.fare.discount.AgeDiscountApplier;
import nextstep.path.domain.fare.discount.BabyAgeDiscountApplier;
import nextstep.path.domain.fare.discount.ChildAgeDiscountApplier;
import nextstep.path.domain.fare.discount.TeenAgeDiscountApplier;

import java.util.List;

public class AgeDiscountFarePolicy extends FarePolicy {
    private static final List<AgeDiscountApplier> ageDiscountAppliers = List.of(
            BabyAgeDiscountApplier.getInstance(),
            ChildAgeDiscountApplier.getInstance(),
            TeenAgeDiscountApplier.getInstance()
    );

    private final int age;

    public AgeDiscountFarePolicy(int age, FarePolicy nextPolicy) {
        super(nextPolicy);
        this.age = age;
    }

    @Override
    public int apply(int beforeFare) {
        int discountedFare = ageDiscountAppliers.stream()
                .filter(it -> it.canApply(age))
                .mapToInt(it -> it.apply(beforeFare))
                .min()
                .orElse(beforeFare);

        return nextPolicy.apply(discountedFare);
    }
}
