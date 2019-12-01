package players.visitor;

import players.type.Knight;
import players.type.Pyromancer;
import players.type.Rogue;
import players.type.Wizard;

public interface PlayerVisitor {
    void visit(Knight player);
    void visit(Pyromancer player);
    void visit(Rogue player);
    void visit(Wizard player);
}
