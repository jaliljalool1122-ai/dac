package threatdetector.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Résultat final d'un scan. Immuable => thread-safe. */
public final class ScanResult {
    private final ScanItem item;
    private final RiskLevel level;
    private final int score;
    private final List<String> reasons;
    private final ScanStatus status;

    public ScanResult(ScanItem item, RiskLevel level, int score,
                      List<String> reasons, ScanStatus status) {
        this.item = item;
        this.level = level;
        this.score = score;
        this.reasons = Collections.unmodifiableList(
                reasons == null ? new ArrayList<>() : new ArrayList<>(reasons));
        this.status = status;
    }

    /** Résultat normal: le niveau est déduit du score. */
    public static ScanResult done(ScanItem item, int score, List<String> reasons) {
        return new ScanResult(item, RiskLevel.fromScore(score), score, reasons, ScanStatus.DONE);
    }

    /** Échec / impossible de vérifier => NOT_VERIFIED (jamais LOW/Safe). */
    public static ScanResult notVerified(ScanItem item, String reason) {
        List<String> r = new ArrayList<>();
        r.add(reason == null || reason.isBlank() ? "Unable to verify" : reason);
        return new ScanResult(item, RiskLevel.NOT_VERIFIED, 0, r, ScanStatus.FAILED);
    }

    public ScanItem getItem() { return item; }
    public RiskLevel getLevel() { return level; }
    public int getScore() { return score; }
    public List<String> getReasons() { return reasons; }
    public ScanStatus getStatus() { return status; }

    @Override
    public String toString() {
        return "ScanResult{item=" + item.getId() + ", level=" + level + ", score=" + score
                + ", status=" + status + ", reasons=" + reasons + "}";
    }
}
