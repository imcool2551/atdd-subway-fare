package nextstep.path.domain.fare.policy;

public abstract class FarePolicy {
    protected final FarePolicy nextPolicy;

    public FarePolicy(FarePolicy nextPolicy) {
        this.nextPolicy = nextPolicy;
    }

    public abstract int apply(int beforeFare);

}
