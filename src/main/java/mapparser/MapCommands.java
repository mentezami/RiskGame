package mapparser;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Continent;
import entity.Country;
import entity.Hmap;
import exception.InvalidMap;

public class MapCommands {


        private static int countryIdx = 1;


        public static boolean removeContinent(Hmap map, String continentName) {

            Continent continent = new Continent();
            continent.setName(continentName);

            for (Continent c: map.getContinents()) {
                if (c.getName().equalsIgnoreCase(continentName)) {
                    map.getContinents().remove(c);
                    map.getContinentMap().remove(continentName);

                    System.out.println("Successfully removed continent: " + continentName + " from map");

                    return true;
                }
            }

            System.out.println("Continent: " + continentName + " does not exist in map");

            return false;
        }

        public static boolean addContinent(Hmap map, String name, String ctrlValue, String color) {
            Continent continent = new Continent();

            continent.setName(name);

            try {
                continent.setValue(Integer.parseInt(ctrlValue));
            } catch (Exception e) {
                System.out.println("Exception: " + e.toString());
                return false;
            }

            continent.setColor(color);

            if (map.getContinents().contains(continent)) {
                System.out.println("The Continent with name " + name + " already exist.");
                return false;
            }

            System.out.println("The continent: " + name + " added successfully");
            map.getContinents().add(continent);
            map.getContinentMap().put(name, continent);

            return true;
        }

        public static boolean containsContinentName(final List<Continent> listContinents, final String name){
            return listContinents.stream().filter(x -> x.getName().equals(name)).findFirst().isPresent();
        }

        public static Continent updateContinent(Continent continent, Hmap map, String name, String ctrlValue) throws InvalidMap {

            if (!continent.getName().equals(name)) {

                if (containsContinentName(map.getContinents(), name)) {
                    throw new InvalidMap("The Continent with name " + name + " already exist.");
                }
                continent.setName(name);
            }

            continent.setValue(Integer.parseInt(ctrlValue));
            return continent;
        }

        public static boolean containsCountryName(final ArrayList<Country> list, final String name){
            return list.stream().filter(z -> z.getName().equals(name)).findFirst().isPresent();
        }

        public static boolean removeCountry(Hmap map, String name) {

            for (Continent continent: map.getContinents()) {
                for (Country country: continent.getCountries()) {
                    if (country.getName().equalsIgnoreCase(name)) {

                        continent.getCountries().remove(country);
                        continent.getCountryMap().remove(name);
                        map.getCountriesIdxMap().remove(name);

                        for (Country adjCountry: country.getAdjacentCountries())
                            adjCountry.getAdjacentCountries().remove(country);

                        System.out.println("Successfully removed country: " + name + " from map");

                        return true;
                    }
                }
            }

            System.out.println("Country: " + name + " does not belong to any continent");

            return false;
        }

        public static boolean addCountry(Hmap map, String name, String continentName) {

            Country country = new Country();
            Continent belongToContinent = null;

            country.setName(name);

            for (Continent c : map.getContinents()) {

                if (c.getCountries().contains(country)) {
                    System.out.println("Country with same name: " + name +
                            " already exist in continent: " + c.getName());
                    return false;
                }

                if (c.getName().equalsIgnoreCase(continentName))
                    belongToContinent = c;
            }

            if (null == belongToContinent) {
                System.out.println("Belong to continent: " + continentName + " does not exist in map");
                return false;
            }

            country.setBelongToContinent(belongToContinent);

            map.getCountriesIdxMap().put(name, countryIdx++);
            belongToContinent.getCountries().add(country);
            belongToContinent.getCountryMap().put(name, country);

            System.out.println("Country: " + name + " added to the continent: "
                    + continentName + " successfully");

            return true;
        }

        public static Country updateCountry(Country country, Hmap map, String name,String xCo, String yCo,
                                            Country adjCoun) throws InvalidMap {

            country.setxCoordinate(Integer.parseInt(xCo));
            country.setyCoordinate(Integer.parseInt(yCo));

            if (!country.getName().equals(name)) {

                ArrayList<Country> listAllCoun = new ArrayList<Country>();

                for (Continent cont : map.getContinents()) {
                    listAllCoun.addAll(cont.getCountries());
                }

                if (containsCountryName(listAllCoun, name)) {
                    throw new InvalidMap("The Country with name "+name+" already exist.");
                }
                country.setName(name);
            }

            if (adjCoun != null) {

                if (!adjCoun.getAdjacentCountries().contains(country)) {
                    adjCoun.getAdjacentCountries().add(country);
                }

                if (!country.getAdjacentCountries().contains(adjCoun)) {
                    country.getAdjacentCountries().add(adjCoun);
                }
            }

            return country;
        }

        public static boolean removeNeighborCountry(Hmap map, String countryName, String nbrCountryName) {

            boolean isCountryDel= false, isNeigborDel = false;

            if (!map.getCountriesIdxMap().containsKey(countryName)) {
                System.out.println("Exception: The country: " + countryName + " does not exist in map");
                return false;
            }

            if (!map.getCountriesIdxMap().containsKey(nbrCountryName)) {
                System.out.println("Exception: The neighbor country: " + nbrCountryName + " does not exist in map");
                return false;
            }

            for (Continent c: map.getContinents()) {
                for (Country country: c.getCountries()) {
                    if (country.getName().equalsIgnoreCase(countryName)) {

                        country.getAdjacentCountries().remove(c.getCountryMap().get(nbrCountryName));
                        country.getNeighborCountries().remove(nbrCountryName);

                        System.out.println("The neighbor country: " + nbrCountryName +
                                " removed from adjacent country: " + countryName);

                        isCountryDel = true;
                    }

                    if (country.getName().equalsIgnoreCase(nbrCountryName)) {
                        country.getAdjacentCountries().remove(c.getCountryMap().get(countryName));
                        country.getNeighborCountries().remove(countryName);
                        isNeigborDel  = true;
                    }
                }
            }

            if (isCountryDel && isNeigborDel)
                return true;

            return false;
        }

        public static boolean addNeighborCountry(Hmap map, String countryName, String nbrCountryName) {

            boolean isCountryAdded = false, isNeigborAdded = false;

            if (!map.getCountriesIdxMap().containsKey(countryName)) {
                System.out.println("Exception: The country: " + countryName + " does not exist in map");
                return false;
            }

            if (!map.getCountriesIdxMap().containsKey(nbrCountryName)) {
                System.out.println("Exception: The neighbor country: " + nbrCountryName + " does not exist in map");
                return false;
            }

            for (Continent c: map.getContinents()) {
                for (Country country: c.getCountries()) {
                    if (country.getName().equalsIgnoreCase(countryName)) {

                        if (country.getNeighborCountries().contains(nbrCountryName)) {
                            System.out.println("Exception: The neighbor country already exist");
                            return false;
                        }

                        country.getAdjacentCountries().add(c.getCountryMap().get(nbrCountryName));
                        country.getNeighborCountries().add(nbrCountryName);

                        System.out.println("The neighbor country: " + nbrCountryName +
                                " added as an adjacent country to: " + countryName);

                        isCountryAdded = true;
                    }

                    if (country.getName().equalsIgnoreCase(nbrCountryName)) {

                        if (country.getNeighborCountries().contains(countryName)) {
                            System.out.println("Exception: The neighbor country already exist");
                            return false;
                        }

                        country.getAdjacentCountries().add(c.getCountryMap().get(countryName));
                        country.getNeighborCountries().add(countryName);
                        isNeigborAdded = true;
                    }
                }
            }

            if (isCountryAdded && isNeigborAdded)
                return true;

            System.out.println("Failed to add the neighbor country: " + nbrCountryName);

            return false;
        }

        public static Continent mapCountryToContinent(Continent continent, Country country) {

            try {
                continent.getCountries().add(country);
            } catch(Exception e) {
                ArrayList<Country> list = new ArrayList<>();
                list.add(country);
                continent.setCountries(list);
            }

            return continent;
        }

        public static void mapEditorShowmap(Hmap map) {

            for (Continent c : map.getContinents()) {
                System.out.println("--------------------------------");
                System.out.println("Continent: " + c.getName() + " having following countries");

                for (Country con : c.getCountries()) {
                    System.out.print(con.getName() + ": ");
                    List<String> adjCountries = con.getNeighborCountries();

                    for (int i = 0; i < adjCountries.size(); i++) {
                        System.out.print(adjCountries.get(i));

                        if (i != adjCountries.size() - 1)
                            System.out.print(", ");
                    }
                    System.out.println();
                }
            }
            System.out.println("--------------------------------");
        }
    }