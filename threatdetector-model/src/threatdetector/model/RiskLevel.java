package threatdetector.model;

/** Niveau de risque. NOT_VERIFIED ≠ safe: jamais afficher "Safe" pour un élément non vérifié. */
public enum RiskLevel {
    LOW,          // vert
    MEDIUM,       // orange
    HIGH,         // rouge
    NOT_VERIFIED; // gris

    /** Score 0-29 LOW, 30-59 MEDIUM, 60+ HIGH. */
    public static RiskLevel fromScore(int score) {
        if (score >= 60) return HIGH;
        if (score >= 30) return MEDIUM;
        return LOW;
    }
}
