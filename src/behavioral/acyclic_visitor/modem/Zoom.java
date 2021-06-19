package behavioral.acyclic_visitor.modem;

import behavioral.acyclic_visitor.ModemVisitor;

public class Zoom extends Modem<Zoom> {

    @Override
    public void accept(ModemVisitor<Zoom> modemVisitor) {
        modemVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "Zoom";
    }
}
