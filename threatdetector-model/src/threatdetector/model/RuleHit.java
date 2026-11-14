package threatdetector.model;

/** Résultat d'une règle: points ajoutés + raison. Immuable. */
public final class RuleHit {
    private static final RuleHit NONE = new RuleHit(0, "");

    private final int points;
    private final String reason;

    public RuleHit(int points, String reason) {
        this.points = points;
        this.reason = reason == null ? "" : reason;
    }

    /** Règle non déclenchée (0 point). */
    public static RuleHit none() { return NONE; }

    public boolean isHit() { return points > 0; }
    public int getPoints() { return points; }
    public String getReason() { return reason; }

    @Override
    public String toString() {
        return "RuleHit{+" + points + ", " + reason + "}";
    }
}
