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

            if (secondPlayer.getType() == 'K') {
                firstAction.visit((Knight) secondPlayer);
                secondAction.visit((Knight) secondPlayer);
            }
            if (secondPlayer.getType() == 'P') {
                firstAction.visit((Pyromancer) secondPlayer);
                secondAction.visit((Pyromancer) secondPlayer);
            }
            if (secondPlayer.getType() == 'R'  && secondPlayer.getHp() > 0) {
                firstAction.visit((Rogue) secondPlayer);
                secondAction.visit((Rogue) secondPlayer);
            }
            if (secondPlayer.getType() == 'W'  && secondPlayer.getHp() > 0) {
                firstAction.visit((Wizard) secondPlayer);
                secondAction.visit((Wizard) secondPlayer);
            }
        }

        if (firstPlayer.getType() == 'P') {
            Pyromancer.FireBlast firstAction = ((Pyromancer) firstPlayer).new FireBlast();
            Pyromancer.Ignite secondAction = ((Pyromancer) firstPlayer).new Ignite();

            if (secondPlayer.getType() == 'P') {
                firstAction.visit((Pyromancer) secondPlayer);
                secondAction.visit((Pyromancer) secondPlayer);
            }
            if (secondPlayer.getType() == 'R') {
                firstAction.visit((Rogue) secondPlayer);
                secondAction.visit((Rogue) secondPlayer);
            }
            if (secondPlayer.getType() == 'W') {
                firstAction.visit((Wizard) secondPlayer);
                secondAction.visit((Wizard) secondPlayer);
            }

            if (secondPlayer.getType() == 'K') {
                firstAction.visit((Knight) secondPlayer);
                secondAction.visit((Knight) secondPlayer);
            }
        }


        if (firstPlayer.getType() == 'R') {
            Rogue.BackStab firstAction = ((Rogue) firstPlayer).new BackStab();
            Rogue.Paralysis secondAction = ((Rogue) firstPlayer).new Paralysis();

            if (secondPlayer.getType() == 'R') {
                firstAction.visit((Rogue) secondPlayer);
                secondAction.visit((Rogue) secondPlayer);
            }
            if (secondPlayer.getType() == 'K') {
                firstAction.visit((Knight) secondPlayer);
                secondAction.visit((Knight) secondPlayer);
            }
            if (secondPlayer.getType() == 'P') {
                firstAction.visit((Pyromancer) secondPlayer);
                secondAction.visit((Pyromancer) secondPlayer);
            }
            if (secondPlayer.getType() == 'W') {
                firstAction.visit((Wizard) secondPlayer);
                secondAction.visit((Wizard) secondPlayer);
            }
        }

        if (firstPlayer.getType() == 'W') {
            Wizard.Drain firstAction = ((Wizard) firstPlayer).new Drain();
            Wizard.Deflect secondAction = ((Wizard) firstPlayer).new Deflect();

            if (secondPlayer.getType() == 'W') {
                firstAction.visit((Wizard) secondPlayer);
                secondAction.visit(((Wizard) secondPlayer));
            }
            if (secondPlayer.getType() == 'P') {
                firstAction.visit((Pyromancer) secondPlayer);
                secondAction.visit((Pyromancer) secondPlayer);
            }
            if (secondPlayer.getType() == 'K') {
                firstAction.visit(((Knight) secondPlayer));
                secondAction.visit(((Knight) secondPlayer));
            }
            if (secondPlayer.getType() == 'R') {
                firstAction.visit((Rogue) secondPlayer);
                secondAction.visit((Rogue) secondPlayer);
            }
        }
    }
}
