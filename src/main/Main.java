package main;

import gameplan.LookingForPlayersInTheSameSpot;
import gameplan.Move;
import ReadInput.StartGame;
import fileio.implementations.FileWriter;
import players.type.Player;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(final String[] args) throws IOException {
        String input = args[0];
        String output = args[1];
        StartGame startGame = new StartGame();
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
                    players.get(j).setIncapacityOfMovement(players.get(j).getIncapacityOfMovement() - 1);
                }
            }
            for (int w = 0; w < participants; w++) {
                players.get(w).ExtraD(players.get(w));
                if (players.get(w).getHp() <= 0) {
                    players.get(w).setDead(1);
                }
            }
            theyFight.lookingForPlayersInTheSameSpot(players);
            for (Player x : players) {
                x.setWasFighting(0);
            }
            System.out.println();
            System.out.println("RUNDA " + i);
            for (Player x : players) {
                if (x.getDead() == 0) {
                    System.out.print(x.getType() + " ");
                    System.out.print(x.getLevel() + " ");
                    System.out.print(x.getXp() + " ");
                    System.out.print(x.getHp() + " ");
                    System.out.print(x.getLineMap() + " ");
                    System.out.print(x.getColumnMap());
                    System.out.println();
                } else {
                    System.out.print(x.getType() + " dead");
                    System.out.println();
                }
                }
            }
            System.out.println("final:");
            for (Player x : players) {
                if (x.getDead() == 0) {
                    System.out.print(x.getType() + " ");
                    System.out.print(x.getLevel() + " ");
                    System.out.print(x.getXp() + " ");
                    System.out.print(x.getHp() + " ");
                    System.out.print(x.getLineMap() + " ");
                    System.out.print(x.getColumnMap());
                    System.out.println();
                } else {
                    System.out.println(x.getType() + " " + "dead");
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
