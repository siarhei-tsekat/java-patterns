package behavioral.acyclic_visitor;

import behavioral.acyclic_visitor.modem.Hayes;
import behavioral.acyclic_visitor.modem.Zoom;

public class ConfigureForDosVisitor {

    public ModemVisitor<Zoom> getZoomVisitor() {
        return new ModemVisitor<Zoom>() {
            @Override
            public void visit(Zoom zoom) {
                System.out.println(zoom + " visited by ConfigureForDosVisitor");
            }
        };
    }

    public ModemVisitor<Hayes> getHayesVisitor() {
        return new ModemVisitor<Hayes>() {
            @Override
            public void visit(Hayes hayes) {
                System.out.println(hayes + " visited by ConfigureForDosVisitor");
            }
        };
    }
}
