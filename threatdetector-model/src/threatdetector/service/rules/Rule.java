package threatdetector.service.rules;

import threatdetector.model.InputType;
import threatdetector.model.RuleHit;
import threatdetector.model.ScanItem;

/**
 * Une règle de détection. Doit être thread-safe (pas d'état mutable partagé).
 * evaluate() retourne RuleHit.none() si la règle ne se déclenche pas.
 */
public interface Rule {
    /** Cette règle s'applique-t-elle à ce type d'entrée (URL / MESSAGE) ? */
    boolean appliesTo(InputType type);

    RuleHit evaluate(ScanItem item);
}
