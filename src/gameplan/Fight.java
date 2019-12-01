package gameplan;

import players.type.Knight;
import players.type.Pyromancer;
import players.type.Rogue;
import players.type.Wizard;
import players.type.Player;

public final class Fight {
    public void fight(final Player firstPlayer, final Player secondPlayer) {

        if (firstPlayer.getType() == 'K') {
            Knight.Execute firstAction = ((Knight) firstPlayer).new Execute();
            Knight.Slam secondAction = ((Knight) firstPlayer).new Slam();
            secondPlayer.accept(firstAction);
            secondPlayer.accept(secondAction);
        }
        if (firstPlayer.getType() == 'P') {
            Pyromancer.FireBlast firstAction = ((Pyromancer) firstPlayer).new FireBlast();
            Pyromancer.Ignite secondAction = ((Pyromancer) firstPlayer).new Ignite();
            secondPlayer.accept(firstAction);
            secondPlayer.accept(secondAction);
        }
        if (firstPlayer.getType() == 'R') {
            Rogue.BackStab firstAction = ((Rogue) firstPlayer).new BackStab();
            Rogue.Paralysis secondAction = ((Rogue) firstPlayer).new Paralysis();
            secondPlayer.accept(firstAction);
            secondPlayer.accept(secondAction);
        }
        if (firstPlayer.getType() == 'W') {
            Wizard.Drain firstAction = ((Wizard) firstPlayer).new Drain();
            Wizard.Deflect secondAction = ((Wizard) firstPlayer).new Deflect();
            secondPlayer.accept(firstAction);
            secondPlayer.accept(secondAction);
        }
    }
}
