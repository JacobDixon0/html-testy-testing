package us.jacobdixon.html.elements.extended;

public enum ReferrerPolicy {
    NoReferrer("no-referrer"),
    NoReferrerWhenDowngrade("no-referrer-when-downgrade"),
    Origin("origin"),
    OriginWhenCrossOrigin("origin-when-cross-origin"),
    UnsafeUrl("unsafe-url");

    private final String referrerPolicy;

    ReferrerPolicy(String referrerPolicy) {
        this.referrerPolicy = referrerPolicy;
    }

    @Override
    public String toString() {
        return referrerPolicy;
    }
}
