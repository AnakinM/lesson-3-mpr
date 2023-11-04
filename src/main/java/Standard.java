public enum Standard {
    PREMIUM(4),
    COMMON(2),
    BUDGET(1);

    public final int multiplier;

    private Standard(int multiplier) {
        this.multiplier = multiplier;
    }
}
