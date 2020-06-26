package mapparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import entity.Continent;
import entity.Country;
import entity.Hmap;
import exception.InvalidMap;

/**
 * This class validates the map.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class MapVerifier {

    static String message = "";

    /**
     * This method validates the map.
     *
     * @param map map object for verifying map
     * @throws InvalidMap if map has some errors
     */
    public static void verifyMap(Hmap map) throws InvalidMap {
        if (map == null) {
            throw new InvalidMap("Input map is not valid. It's null");
        } else {
            if (map.getContinents().size() < 1) {
                throw new InvalidMap("At least one continent must be there in the map.");
            } else {

                verifyContinents(map);

                if (!isMapConnectedGraph(map))
                    throw new InvalidMap("Given map is not a connected graph formed by continents.");
                else
                    System.out.println("Given Map verified successfully. It is a connected graph");

                checkCountryBelongToOnlyOneContinent(map);
            }
        }
    }

    /**
     * This method verifies the continents.
     *
     * @param map map object to verify continents of the map
     * @throws InvalidMap throws if map has some errors
     */
    public static void verifyContinents(Hmap map) throws InvalidMap {

        for (Continent continent : map.getContinents()) {

            if (continent.getCountries().size() < 1)
                throw new InvalidMap("At least one country should be there in continent.");


            for (Country country : continent.getCountries())
                verifyCountry(country, map);

            if (!isContinentConnectedGraph(continent, map))
                throw new InvalidMap(message + "The Continent " + continent.getName() + " is not connected by its countries. A Continent should be a connected graph formed by countries in the map.");
        }
    }

    /**
     * This method checks that the continents are connected or not.
     *
     * @param continent continent to be verified
     * @param map object of the map
     * @return true if continent forms a connected map.
     */
    public static boolean isContinentConnectedGraph(Continent continent, Hmap map) {

        runDfsOnCountry(continent.getCountries().get(0), map);
        boolean returnValue = true;

        for (Country t : continent.getCountries()) {

            if (t.isVisited() == false) {
                message = t.getName() + " is not forming connected graph inside continent " + continent.getName() + ".";
                returnValue = false;
                break;
            }
        }

        for (Country t : continent.getCountries())
            t.setVisited(false);

        return returnValue;
    }

    /**
     * This method traverse the countries in BFS Manner.
     *
     * @param country country to be traversed in bfs
     * @param map map object
     */
    public static void runDfsOnCountry(Country country, Hmap map) {

        if (country.isVisited() == true)
            return;

        country.setVisited(true);

        for (Country t : country.getAdjacentCountries()) {
            if ((t.getBelongToContinent() == country.getBelongToContinent())
                    && t.isVisited() == false)
                runDfsOnCountry(t, map);
        }
    }

    /**
     * This method checks whether the country is connected or not.
     *
     * @param country country to be verified
     * @param map object of the map
     * @throws InvalidMap throws InvalidMapException if map is not valid
     */
    private static void verifyCountry(Country country, Hmap map) throws InvalidMap {
        List<Country> adjCountList = country.getAdjacentCountries();

        if ((adjCountList == null) || (adjCountList.size() < 1)) {
            throw new InvalidMap("Country: " + country.getName() + " must have atleast one adjacent country.");
        } else {
            for (Country adjCoun : adjCountList) {
                if (!adjCoun.getAdjacentCountries().contains(country))
                    adjCoun.getAdjacentCountries().add(country);
            }
        }
    }

    /**
     * This method checks that Continents form a connected graph (A Map).
     *
     * @param map object of the map
     * @return true if map is a connected graph
     */
    public static boolean isMapConnectedGraph(Hmap map) {

        if (map.getContinents().size() < 2) {
            System.out.println("There is only one continent in given map");
            return false;
        }

        runDfsContinent(map.getContinents().get(0), map);

        boolean returnValue = true;
        for (Continent continent : map.getContinents()) {

            if (continent.isVisited() == false) {
                System.out.println(continent.getName() + "xxxxxxxxxxxxxx");
                returnValue = false;
                break;
            }
        }

        for (Continent continent : map.getContinents())
            continent.setVisited(false);

        return returnValue;
    }

    /**
     * This method traverses the continents in BFS Manner.
     *
     * @param continent continent to be traversed in bfs
     * @param map map object
     */
    public static void runDfsContinent(Continent continent, Hmap map) {

        if (continent.isVisited() == true)
            return;

        continent.setVisited(true);

        for (Continent c : getAdjacentContinents(continent, map)) {

            if (c.isVisited() == false)
                runDfsContinent(c, map);
        }
    }

    /**
     * This method returns the adjacent continent as a list of particular continent.
     *
     * @param continent continent whose adjacent countries to be found
     * @param map map object
     * @return the adjacent continent as a list of particular continent.
     */
    public static List<Continent> getAdjacentContinents(Continent continent, Hmap map) {
        List<Continent> adjacentContinents = new ArrayList<Continent>();
        HashSet<Country> adjCounMasterSet = new HashSet<Country>();

        for (Country country : continent.getCountries())
            adjCounMasterSet.addAll(country.getAdjacentCountries());

        for (Continent otherCont : map.getContinents()) {

            if (!continent.equals(otherCont)) {

                if (!Collections.disjoint(adjCounMasterSet, otherCont.getCountries())) {

                    adjacentContinents.add(otherCont);
                }
            }
        }

        return adjacentContinents;
    }

    /**
     * This method checks whether country belongs to only one continent or not.
     *
     * @param map map object
     * @throws InvalidMap throws InvalidMapException if map is not valid.
     */
    public static void checkCountryBelongToOnlyOneContinent(Hmap map) throws InvalidMap {
        HashMap<Country, Integer> countryBelongToContinentCount = new HashMap<Country, Integer>();

        for (Continent continent : map.getContinents()) {

            for (Country country : continent.getCountries()) {

                if (!countryBelongToContinentCount.containsKey(country)) {
                    countryBelongToContinentCount.put(country, 1);
                } else {
                    throw new InvalidMap("Country: " + country.getName() + " must belong to only one continents.");
                }
            }
        }
    }
}


