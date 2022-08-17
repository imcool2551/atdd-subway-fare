package nextstep.path.domain.fare.policy;

public class NullFarePolicy extends FarePolicy {

    public NullFarePolicy() {
        super(null);
    }

    @Override
    public int apply(int beforeFare) {
        return beforeFare;
    }
}
