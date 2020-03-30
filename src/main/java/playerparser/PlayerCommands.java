package playerparser;
import java.util.*;

import entity.Continent;
import entity.Country;
import entity.Hmap;
import entity.Player;
import config.Config;

public class PlayerCommands {



        private ArrayList<Country> countryList;
        private HashMap<String, Country> countryMap;

        private ArrayList<Player> playersList;
        private static int[] numOfArmies = { Config.CONFIG_ARMIES_TWO_PLAYER, Config.CONFIG_ARMIES_THREE_PLAYER,
                Config.CONFIG_ARMIES_FOUR_PLAYER, Config.CONFIG_ARMIES_FIVE_PLAYER, Config.CONFIG_ARMIES_SIX_PLAYER };

        Player currentPlayer;

        public PlayerCommands() {
            this.playersList = new ArrayList<Player>();
            this.countryList = new ArrayList<Country>();
            this.countryMap = new HashMap<String, Country>();
        }

        public void setCountryMap(HashMap<String, Country> countryMap) {
            this.countryMap = countryMap;
        }

        public HashMap<String, Country> getCountryMap() {
            return countryMap;
        }

        public ArrayList<Country> getCountryList() {
            return countryList;
        }

        public void setCountryList(ArrayList<Country> countryList) {
            this.countryList = countryList;
        }

        public Player getCurrentPlayer() {
            return currentPlayer;
        }

        public void setCurrentPlayer(Player player) {
            currentPlayer = player;
        }

        public ArrayList<Country> getCountryList(Hmap map) {

            for (Continent c : map.getContinents()) {
                for (Country country : c.getCountries()) {
                    countryList.add(country);
                }
            }

            return countryList;
        }

        public ArrayList<Player> getPlayersList() {
            return playersList;
        }

        public void setPlayersList(ArrayList<Player> playersList) {
            this.playersList = playersList;
        }

        public boolean removePlayer(String playerName) {

            for (Player player : playersList) {
                if (player.getName().equalsIgnoreCase(playerName)) {
                    playersList.remove(player);
                    System.out.println("Player: " + playerName + " removed from the game");
                    return true;
                }
            }

            System.out.println("Player: " + playerName + " does not exist in the game");

            return false;
        }

        public boolean createPlayer(String playerName) {

            int id = playersList.size();

            if (id >= 6) {
                System.out.println("Exception: Maximum number of players = 6. Can't create more players");
                return false;
            }

            Player newPlayer = new Player(id + 1, playerName);

            if (playersList.contains(newPlayer)) {
                System.out.println("Exception: Player: " + playerName + " already exists in the game");
                return false;
            }

            playersList.add(newPlayer);
            System.out.println("Player: " + playerName + " is added in the game");

            return true;
        }

        public boolean assignArmiesToPlayers() {
            int armiesCount = 0;
            int numPlayers = playersList.size();

            if (numPlayers >= 2) {

                armiesCount = numOfArmies[numPlayers - 2];

                for (Player player : playersList)
                    player.setArmies(armiesCount);

                System.out.println("Assigned " + armiesCount + " armies to " + numPlayers + " players");

                return true;
            } else {
                System.out.println("Please create atleast 2 players to play the game.");
            }

            return false;
        }

        public void placeAll() {

            for (Player p : getPlayersList()) {

                System.out.println("Placing armies for player: " + p.getName());
                while (p.getArmies() > 0) {

                    Country con = p.getAssignedCountry().get(getRandomNumber(p.getAssignedCountry().size() - 1));
                    con.setArmy(con.getArmy() + 1);
                    p.setArmies(p.getArmies() - 1);
                }
            }
        }

        public static int getRandomNumber(int number) {
            return new Random().nextInt(number + 1);
        }

        public boolean placeArmy(String countryName) {

            int playerArmies = currentPlayer.getArmies();

            if (!isCountryBelongToPlayer(currentPlayer, countryName)) {
                return false;
            }

            if (playerArmies <= 0) {
                System.out.println("The player: " + currentPlayer.getName() + " does not have any army left");
                return false;
            }

            for (Country c : currentPlayer.getAssignedCountry()) {
                if (c.getName().equalsIgnoreCase(countryName)) {
                    c.setArmy(c.getArmy() + 1);
                    currentPlayer.setArmies(playerArmies - 1);
                    System.out.println(currentPlayer.getName() + ": assigned 1 Army to " + c.getName());
                    return true;
                }
            }

            return false;
        }

        public boolean isAllPlayersArmiesExhausted() {

            for (Player p : getPlayersList()) {
                if (p.getArmies() != 0) {
                    return false;
                }
            }
            System.out.println("----------------------------------");
            System.out.println("All players have placed armies.");
            return true;
        }

        public void populateCountries(Hmap map) {

            ArrayList<Country> countriesList = getCountryListFromMap(map);
            int playerNum = 0;

            while (countriesList.size() != 0) {

                int chooseCountry = new Random().nextInt(countriesList.size());
                Country countryAssigned = countriesList.get(chooseCountry);

                currentPlayer = getPlayersList().get(playerNum);
                currentPlayer.setAssignedCountry(countryAssigned);
                playerNum = (playerNum + 1) % getPlayersList().size();

                countriesList.remove(chooseCountry);

                for (Country c : getCountryList()) {
                    if (c.getName().equalsIgnoreCase(countryAssigned.getName()))
                        c.setPlayer(currentPlayer);
                }
            }
        }

        public ArrayList<Country> getCountryListFromMap(Hmap map) {
            ArrayList<Country> countryListfromMap = new ArrayList<Country>();

            for (Continent c : map.getContinents()) {
                for (Country cont : c.getCountries()) {
                    countryListfromMap.add(cont);
                }
            }

            return countryListfromMap;
        }

        public void gamePlayShowmap() {

            System.out.println("----------------------------------");
            for (Country c : getCountryList()) {
                System.out.println(c.getBelongToContinent().getName() + ": " + c.getName() + ": Army count: " + c.getArmy()
                        + ", Player: " + c.getPlayer().getName() + ", Adjacent Countries: " + c.getAdjacentCountries());
            }
            System.out.println("----------------------------------");
        }

        public int countReinforcementArmies(Player player) {
            int currentArmies = player.getArmies();
            int countryCount = player.getAssignedCountry().size();
            System.out.println("Number of Countires for Player : " + player.getName() + " = " + countryCount);
            if (countryCount < 9) {
                currentArmies = currentArmies + 3;
            } else {
                currentArmies += Math.floor(countryCount / 3);
            }
            System.out.println("After reinforcement, current number of Armies for Player : " + player.getName()
                    + " = " + currentArmies);

            return currentArmies;
        }

        public void intitializeArmiesForAllCountries() {

            for (Country c : getCountryList()) {
                c.setArmy(c.getArmy() + 1);
                c.getPlayer().setArmies(c.getPlayer().getArmies() - 1);
            }
        }

        public boolean reinforceArmiesForCurrentPlayer(String countryName, int numberOfArmies) {

            int currentArmies = getCurrentPlayer().getArmies();

            if (currentArmies < numberOfArmies) {
                System.out.println(
                        "You dont have enough army to reinforce: Your armies count = " + getCurrentPlayer().getArmies());
                return false;
            }

            for (Country c : getCurrentPlayer().getAssignedCountry()) {
                if (c.getName().equalsIgnoreCase(countryName)) {
                    c.setArmy(c.getArmy() + numberOfArmies);
                    getCurrentPlayer().setArmies(currentArmies - numberOfArmies);
                }
            }

            if (getCurrentPlayer().getArmies() == 0) {
                System.out.println("Reinforcement has been completed. You can now do fortify once.");
                return true;
            }

            return false;
        }

        public void assignReinforceArmiesToPlayers() {

            for (Player p : getPlayersList()) {
                int reinforeArmies = countReinforcementArmies(p);
                p.setArmies(reinforeArmies);
            }
        }

        public void changeCurrentPlayer() {
            int currentPlayerIdx = getPlayersList().indexOf(getCurrentPlayer());
            int totalPlayers = getPlayersList().size();
            setCurrentPlayer(getPlayersList().get((currentPlayerIdx + 1) % totalPlayers));
        }

        public boolean fortifyCurrentPlayer(String fromCountry, String toCountry, int armiesCount) {

            int fromCountryArmyCount = getCountryMap().get(fromCountry).getArmy();
            int toCountryArmyCount = getCountryMap().get(toCountry).getArmy();

            if (!isCountryBelongToPlayer(getCurrentPlayer(), fromCountry))
                return false;

            if (!isCountryBelongToPlayer(getCurrentPlayer(), toCountry))
                return false;

            if (armiesCount > fromCountryArmyCount) {
                System.out.println("Exception: Given army count should be less than fromCountry: " + fromCountry
                        + "'s current armies which is = " + fromCountryArmyCount);
                return false;
            }

            if (isCountriesAdjacent(fromCountry, toCountry)) {

                for (Country c : getCountryList()) {
                    if (c.getName().equalsIgnoreCase(toCountry))
                        c.setArmy(toCountryArmyCount + armiesCount);

                    if (c.getName().equalsIgnoreCase(fromCountry))
                        c.setArmy(fromCountryArmyCount - armiesCount);
                }

                getCountryMap().get(toCountry).setArmy(toCountryArmyCount + armiesCount);
                getCountryMap().get(fromCountry).setArmy(fromCountryArmyCount - armiesCount);

                return true;

            } else {
                System.out.println(
                        "Exception: fromCountry: " + fromCountry + " toCountry: " + toCountry + " are not adjacent.");
            }

            return false;
        }

        public boolean isCountryBelongToPlayer(Player currentPlayer, String country) {

            if (getCountryMap().get(country) == null) {
                System.out.println("Exception: Given country " + country + " does not exist in map");
                return false;
            }

            if (getCountryMap().get(country).getPlayer().getName().equalsIgnoreCase(currentPlayer.getName()))
                return true;

            System.out.println(
                    "Exception: Given country " + country + " does not belong to player: " + getCurrentPlayer().getName());
            return false;
        }

        public boolean isCountriesAdjacent(String fromCountry, String toCountry) {

            if (getCountryMap().get(fromCountry).getNeighborCountries().contains(toCountry)) {
                if (getCountryMap().get(toCountry).getNeighborCountries().contains(fromCountry))
                    return true;
            }

            return false;
        }

        public HashMap<String, Country> getCountryMapFromList(ArrayList<Country> countryList) {
            HashMap<String, Country> countryMap = new HashMap<String, Country>();

            for (Country c : countryList)
                countryMap.put(c.getName(), c);

            return countryMap;
        }

        public boolean isLastPlayer(Player currentPlayer) {

            String lastPlayerName = getPlayersList().get(getPlayersList().size() - 1).getName();

            if (currentPlayer.getName().equalsIgnoreCase(lastPlayerName))
                return true;

            return false;
        }
    }


