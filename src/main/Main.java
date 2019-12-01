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
        // start reading data from file
        StartGame startGame = new StartGame();
        startGame.readInput(input);
        ArrayList<Player> players = startGame.getPlayers();
        int participants = startGame.getParticipants();
        int rounds = startGame.getRounds();
        ArrayList<String> movesRounds = startGame.getMoves();
        Move moves = new Move();
        LookingForPlayersInTheSameSpot theyFight = new LookingForPlayersInTheSameSpot();
        // for each round, each player moves
        // a player moves if he is not under the action of a damage of movement
        // from the last round/rounds
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < participants; j++) {
                if (players.get(j).getIncapacityOfMovement() == 0) {
                    moves.makeMove(players.get(j), movesRounds.get(i).charAt(j));
                } else {
                    players.get(j).setIncapacityOfMovement(players.get(j).getIncapacityOfMovement()
                            - 1);
                }
            }
            // each player receives the damage from the last round
            // if it`s the case
            for (int w = 0; w < participants; w++) {
                players.get(w).poisonDamage(players.get(w));
                if (players.get(w).getHp() <= 0) {
                    players.get(w).setDead(1);
                }
            }
            // two players in thw same spot will fight
            theyFight.lookingForPlayersInTheSameSpot(players);
            // the wasFighting variable is to prevent a player
            // not to fight twice in a round
            // when is 0, he did not fight
            // when is 1, he fought
            for (Player x : players) {
                x.setWasFighting(0);
            }
        }

        // write data in the output file
        FileWriter fileWriter = new FileWriter(output);
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
