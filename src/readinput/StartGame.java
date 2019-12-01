package readinput;

import gameplan.TypeOfLand;
import fileio.implementations.FileReader;
import players.Player;
import players.PlayerFactory;

import java.io.IOException;
import java.util.ArrayList;

public final class StartGame {
     private int numberLines;
     private int numberColumns;
     // numberLines + numberColumns = the dimensions of the map
     private TypeOfLand gameMap;
     private int participants;
     private int rounds;
     private ArrayList<Player> players = new ArrayList<>();
     private ArrayList<String> moves = new ArrayList<>();
     public int getParticipants() {
        return participants;
    }

     public int getRounds() {
        return rounds;
    }

     public ArrayList<Player> getPlayers() {
        return players;
    }

     public ArrayList<String> getMoves() {
        return moves;
    }


    public void readInput(final String input) throws IOException {
         // fetches the data from the input file
         // each variable is assigned the necessary information
         FileReader fileReader = new FileReader(input);
         numberLines = fileReader.nextInt();
         numberColumns = fileReader.nextInt();
         gameMap = new TypeOfLand(numberLines, numberColumns);
         for (int i = 0; i < numberLines; i++) {
            String typeGround = fileReader.nextWord();
            for (int j = 0; j < numberColumns; j++) {
                gameMap.updateMap(i, j, typeGround.charAt(j));
            }
         }

         participants = fileReader.nextInt(); // number of players
         Player player = null;
         PlayerFactory playerCategory = new PlayerFactory();
         for (int i = 0; i < participants; i++) {
            String typePlayer = fileReader.nextWord();
            player = playerCategory.createPlayer(typePlayer.charAt(0));
            player.setLineMap(fileReader.nextInt());
            player.setColumnMap(fileReader.nextInt());
            players.add(player);
         }
         rounds = fileReader.nextInt(); // number of rounds
         for (int i = 0; i < rounds; i++) {
             String roundMoves = fileReader.nextWord();
             moves.add(roundMoves);
         }
    }
}

