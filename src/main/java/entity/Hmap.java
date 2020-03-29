package entity;

import java.io.*;
import java.util.*;

public class Hmap {

    private List<Continent> continents;
    private HashMap<String, Continent> continentMap;
    private HashMap<String, Integer> countriesIdxMap;
    private HashMap<String, String> filesAttribute;

    public Hmap() {
        filesAttribute = new HashMap <String, String>();
        continents = new ArrayList <Continent>();
        continentMap = new HashMap <String,Continent>();
        countriesIdxMap = new HashMap <String,Integer>();
    }

    public Hmap(Hmap newMap) {
        filesAttribute = new HashMap <String, String>(newMap.filesAttribute);
        continents = new ArrayList <Continent>(newMap.continents);
        continentMap = new HashMap <String,Continent>(newMap.continentMap);
        countriesIdxMap = new HashMap <String,Integer>(newMap.countriesIdxMap);
    }

    public HashMap <String, String> getMapData() {
        return filesAttribute;
    }

    public void setMapData(HashMap <String, String> mapData) {
        this.filesAttribute = mapData;
    }

    public List <Continent> getContinents() {
        return continents;
    }

    public void setContinents(List <Continent> continents) {
        this.continents = continents;
    }

    public HashMap <String, Integer> getCountriesIdxMap() {
        return countriesIdxMap;
    }

    public void setCountriesIdxMap(HashMap <String, Integer> countriesIdxMap) {
        this.countriesIdxMap = countriesIdxMap;
    }

    public HashMap <String, Continent> getContinentMap() {
        return continentMap;
    }

    public void setContinentMap(HashMap <String, Continent> continentMap) {
        this.continentMap = continentMap;
    }

    public void setChangedForMap() {
    }

    public String toString() {
        return "Hmap [ mapData = " + filesAttribute + ", continents = " + continents + ", continentMap = " + continentMap + "]";
    }

    public Object clone() throws CloneNotSupportedException {
        ObjectOutputStream output_obj = null;
        ObjectInputStream input_obj = null;
        Hmap clonedMap = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            output_obj = new ObjectOutputStream(bos);
            output_obj.writeObject(this);
            output_obj.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            input_obj = new ObjectInputStream(bin);
            clonedMap = (Hmap) input_obj.readObject();
        } catch (Exception e) {
            System.out.println("Exception in ObjectCloner = " + e.toString());
        } finally {
            try {
                output_obj.close();
                input_obj.close();
            } catch (IOException e) {

                System.out.println("Exception: " + e.toString());
            }
        }
        return clonedMap;
    }
}

