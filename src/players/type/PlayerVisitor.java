package players.type;

public interface PlayerVisitor {
    void visit(Knight player);
    void visit(Pyromancer player);
    void visit(Rogue player);
    void visit(Wizard player);
}
