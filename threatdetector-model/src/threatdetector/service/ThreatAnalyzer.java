package threatdetector.service;

import threatdetector.model.ScanItem;
import threatdetector.model.ScanResult;

/**
 * Contrat d'un analyseur. Implémentations: RuleBasedAnalyzer (Option A),
 * plus tard un analyseur API (Option B) ou IA (bonus).
 * Les implémentations doivent être thread-safe (appelées par plusieurs threads).
 */
public interface ThreatAnalyzer {
    ScanResult analyze(ScanItem item);
}
