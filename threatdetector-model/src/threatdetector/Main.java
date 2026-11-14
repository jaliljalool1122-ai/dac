package threatdetector;

import threatdetector.model.InputType;
import threatdetector.model.ScanItem;

/**
 * Point d'entrée. Pour l'instant: test sans interface.
 * Ordre: d'abord le scan marche en console, ensuite on branche l'UI.
 */
public class Main {
    public static void main(String[] args) {
        ScanItem url = new ScanItem(1, InputType.URL, "http://192.168.1.5/login");
        ScanItem msg = new ScanItem(2, InputType.MESSAGE, "Urgent! send your password");
        System.out.println(url);
        System.out.println(msg);
        // TODO: RuleBasedAnalyzer analyzer = new RuleBasedAnalyzer(...);
        // TODO: System.out.println(analyzer.analyze(url));
    }
}
