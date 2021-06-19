package behavioral.acyclic_visitor;

import behavioral.acyclic_visitor.modem.Hayes;
import behavioral.acyclic_visitor.modem.Zoom;

/**
 * Intent
 * Allow new functions to be added to existing class hierarchies
 * without affecting those hierarchies, and without creating the troublesome dependency cycles that are inherent to the GoF Visitor Pattern.
 *
 *
 * Applicability
 * This pattern can be used:
 *
 * When you need to add a new function to an existing hierarchy without the need to alter or affect that hierarchy.
 * When there are functions that operate upon a hierarchy, but which do not belong in the hierarchy itself. e.g. the ConfigureForDOS / ConfigureForUnix / ConfigureForX issue.
 * When you need to perform very different operations on an object depending upon its type.
 * When the visited class hierarchy will be frequently extended with new derivatives of the Element class.
 * When the recompilation, relinking, retesting or redistribution of the derivatives of Element is very expensive.
 *
 *
 * https://condor.depaul.edu/dmumaugh/OOT/Design-Principles/acv.pdf
 */
public class Demo {
    public static void main(String[] args) {
        ConfigureForDosVisitor forDosVisitor = new ConfigureForDosVisitor();
        ConfigureForUnixVisitor forUnixVisitor = new ConfigureForUnixVisitor();
        Zoom zoom = new Zoom();
        Hayes hayes = new Hayes();


        zoom.accept(forDosVisitor.getZoomVisitor());
        zoom.accept(forUnixVisitor.getZoomVisitor());

        hayes.accept(forDosVisitor.getHayesVisitor());
        hayes.accept(forUnixVisitor.getHayesVisitor());
    }
}
