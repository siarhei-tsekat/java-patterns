package behavioral.acyclic_visitor.modem;

import behavioral.acyclic_visitor.ModemVisitor;

public class Hayes extends Modem<Hayes> {
    @Override
    public void accept(ModemVisitor<Hayes> modemVisitor) {
        modemVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "Hayes";
    }
}
