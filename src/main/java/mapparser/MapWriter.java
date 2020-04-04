package mapparser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import entity.Continent;
import entity.Country;
import entity.Hmap;

public class MapWriter {

        private String parseHmapAndGetString(Hmap map) {
            StringBuilder mapAttrContent = new StringBuilder();
            mapAttrContent = parseMapAttribute(map);
            mapAttrContent.append(parseContinent(map));
            mapAttrContent.append(parseCountries(map));
            mapAttrContent.append(parseBorders(map));
            return mapAttrContent.toString();
        }

        public void writeMapFile(Hmap map, File file) {

            FileWriter fileWriter;

            try {
                if (map == null) {
                    System.out.println("Map Object is NULL!");
                    return;
                }

                String content = parseHmapAndGetString(map);
                fileWriter = new FileWriter(file, false);
                fileWriter.write(content);
                fileWriter.close();

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        private StringBuilder parseMapAttribute(Hmap map) {
            StringBuilder mapAttribute = new StringBuilder();
            mapAttribute.append("[files]");
            mapAttribute.append("\n");

            for (Entry<String, String> keymap : map.getMapData().entrySet()) {
                mapAttribute.append(keymap.getKey() + " " + keymap.getValue());
                mapAttribute.append("\n");
            }

            return mapAttribute;
        }

        private StringBuilder parseContinent(Hmap map) {
            StringBuilder continentData = new StringBuilder();
            continentData.append("\n");
            continentData.append("[continents]");
            continentData.append("\n");

            for (Continent continent : map.getContinents()) {

                String color = continent.getColor();

                if (null != color)
                    continentData.append(continent.getName() + " " + continent.getValue() + " " + continent.getColor());
                else
                    continentData.append(continent.getName() + " " + continent.getValue());

                continentData.append("\n");
            }

            return continentData;
        }

        private StringBuilder parseCountries(Hmap map) {
            StringBuilder countryData = new StringBuilder();

            countryData.append("\n");
            countryData.append("[countries]");
            countryData.append("\n");

            for (Continent continent : map.getContinents()) {
                List<Country> countriesList = continent.getCountries();
                if (countriesList != null) {
                    for (Country country : countriesList) {
                        int continentIdx = map.getContinents().indexOf(country.getBelongToContinent()) + 1;

                        countryData.append(map.getCountriesIdxMap().get(country.getName()) + " " + country.getName() + " "
                                + continentIdx  + " " + country.getxCoordinate()
                                + " " + country.getyCoordinate());
                        countryData.append("\n");
                    }
                }
            }

            return countryData;
        }

        private StringBuilder parseBorders(Hmap map) {
            StringBuilder borderData = new StringBuilder();
            borderData.append("\n");
            borderData.append("[borders]");
            borderData.append("\n");

            for (Continent continent: map.getContinents()) {

                List<Country> countriesList = continent.getCountries();
                if (countriesList != null) {
                    for (Country country : countriesList) {
                        borderData.append(map.getCountriesIdxMap().get(country.getName()));

                        for (Country adjacentCountries : country.getAdjacentCountries()) {
                            borderData.append(" ");
                            borderData.append(map.getCountriesIdxMap().get(adjacentCountries.getName()));
                        }
                        borderData.append("\n");
                    }
                }
            }

            return borderData;
        }
    }






