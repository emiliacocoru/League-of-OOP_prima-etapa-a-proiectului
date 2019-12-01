package players.type;

public interface PlayerVisitor {
    public void visit(Knight player);
    public void visit(Pyromancer player);
    public void visit(Rogue player);
    public void visit(Wizard player);
}
