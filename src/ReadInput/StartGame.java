package ReadInput;

import gameplan.TypeOfLand;
import fileio.implementations.FileReader;
import players.type.*;

import java.io.IOException;
import java.util.ArrayList;

public class StartGame {
     private int numberLines;
     private int numberColumns;
     private TypeOfLand game_map;
     private int participants;
     private int rounds;
     private ArrayList<Player> players = new ArrayList<>();
     private ArrayList<String> moves = new ArrayList<>();
     public int getNumberLines() {
        return numberLines;
    }

    public int getNumberColumns() {
        return numberColumns;
    }

    public TypeOfLand getGame_map() {
        return game_map;
    }

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


    public void readInput(String input) throws IOException {
         FileReader fileReader = new FileReader(input);
        numberLines = fileReader.nextInt();
        numberColumns = fileReader.nextInt();
        game_map = new TypeOfLand(numberLines,numberColumns);
        for (int i = 0; i < numberLines; i++) {

            String Type_ground = fileReader.nextWord();
            //System.out.println(Type_ground);
            for (int j = 0; j < numberColumns ; j++){
                game_map.updateMap(i, j, Type_ground.charAt(j));
            }
        }

        participants = fileReader.nextInt(); // number of players
        Player player = null ;
        PlayerFactory playercategory = new PlayerFactory();
        for(int i = 0; i < participants; i++){
            String typePlayer = fileReader.nextWord();
            player =playercategory.createPlayer(typePlayer.charAt(0));
            player.setLineMap(fileReader.nextInt());
            player.setColumnMap(fileReader.nextInt());
            players.add(player);
        }
         rounds = fileReader.nextInt(); // number of rounds
         for (int i = 0; i < rounds; i++){
             String roundMoves = fileReader.nextWord();
             moves.add(roundMoves);
         }
     }

}

