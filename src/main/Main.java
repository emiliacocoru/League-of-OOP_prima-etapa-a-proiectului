package main;

import gameplan.LookingForPlayersInTheSameSpot;
import gameplan.Move;
import readinput.StartGame;
import fileio.implementations.FileWriter;
import players.type.Player;

import java.io.IOException;
import java.util.ArrayList;


public final class Main {
    private Main() { }

    public static void main(final String[] args) throws IOException {
        String input = args[0];
        String output = args[1];
        StartGame startGame = new StartGame(); //stricat
        startGame.readInput(input);
        FileWriter fileWriter = new FileWriter(output);
        ArrayList<Player> players = startGame.getPlayers();
        int participants = startGame.getParticipants();
        int rounds = startGame.getRounds();
        ArrayList<String> movesRounds = startGame.getMoves();
        Move moves = new Move();
        LookingForPlayersInTheSameSpot theyFight = new LookingForPlayersInTheSameSpot();
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < participants; j++) {
                if (players.get(j).getIncapacityOfMovement() == 0) {
                    moves.move(players.get(j), movesRounds.get(i).charAt(j));
                } else {
                    players.get(j).setIncapacityOfMovement(players.get(j).getIncapacityOfMovement()
                            - 1);
                }
            }
            for (int w = 0; w < participants; w++) {
                players.get(w).poisonDamage(players.get(w));
                if (players.get(w).getHp() <= 0) {
                    players.get(w).setDead(1);
                }
            }
            theyFight.lookingForPlayersInTheSameSpot(players);
            for (Player x : players) {
                x.setWasFighting(0);
            }
            }

        for (Player x : players) {
            if (x.getDead() == 0) {
                fileWriter.writeWord(x.getType() + " ");
                fileWriter.writeInt(x.getLevel());
                fileWriter.writeWord(" ");
                fileWriter.writeInt(x.getXp());
                fileWriter.writeWord(" ");
                fileWriter.writeInt(x.getHp());
                fileWriter.writeWord(" ");
                fileWriter.writeInt(x.getLineMap());
                fileWriter.writeWord(" ");
                fileWriter.writeInt(x.getColumnMap());
            } else {
                fileWriter.writeWord(x.getType() + " ");
                fileWriter.writeWord("dead");
            }
            fileWriter.writeNewLine();
        }
        fileWriter.close();
    }
}
