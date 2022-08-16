package nextstep.path.domain.fare;

public abstract class FarePolicy {
    protected final FarePolicy nextPolicy;

    FarePolicy(FarePolicy nextPolicy) {
        this.nextPolicy = nextPolicy;
    }

    public abstract int apply(int beforeFare);

}
