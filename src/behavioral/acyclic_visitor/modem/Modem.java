package behavioral.acyclic_visitor.modem;

import behavioral.acyclic_visitor.ModemVisitor;

public abstract class Modem<T> {
    public abstract void accept(ModemVisitor<T> modemVisitor);
}


