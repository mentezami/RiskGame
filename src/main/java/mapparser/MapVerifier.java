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

public class MapVerifier {

    static String message = "";

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

    public static boolean isContinentConnectedGraph(Continent continent, Hmap map) {

        runDfsOnCounty(continent.getCountries().get(0), map);
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


    public static void runDfsOnCounty(Country country, Hmap map) {

        if (country.isVisited() == true)
            return;

        country.setVisited(true);

        for (Country t : country.getAdjacentCountries()) {
            if ((t.getBelongToContinent() == country.getBelongToContinent())
                    && t.isVisited() == false)
                runDfsOnCounty(t, map);
        }
    }


    private static void verifyCountry(Country country, Hmap map) throws InvalidMap {
        List<Country> adjCounList = country.getAdjacentCountries();

        if ((adjCounList == null) || (adjCounList.size() < 1)) {
            throw new InvalidMap("Country: " + country.getName() + " must have atleast one adjacent country.");
        } else {
            for (Country adjCoun : adjCounList) {
                if (!adjCoun.getAdjacentCountries().contains(country))
                    adjCoun.getAdjacentCountries().add(country);
            }
        }
    }


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


    public static void runDfsContinent(Continent continent, Hmap map) {

        if (continent.isVisited() == true)
            return;

        continent.setVisited(true);

        for (Continent c : getAdjacentContinents(continent, map)) {

            if (c.isVisited() == false)
                runDfsContinent(c, map);
        }
    }


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


