package onlineFoodOrder.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Hotel {

    private int hotel_Id;
    private String hotel_Name;
    private String ownerName;
    private String location;
    private List<Integer> availableFoods; 

    public static Hotel hotel = null;

    private Hotel() {
    }

    public Hotel(int hotel_Id, String hotel_Name, String ownerName, String location, List<Integer> availableFoods) {
        this.hotel_Id = hotel_Id;
        this.hotel_Name = hotel_Name;
        this.ownerName = ownerName;
        this.location = location;
        this.availableFoods = availableFoods;
    }
    
    public Hotel(int hotel_Id, String hotel_Name, String ownerName, String location){
        this.hotel_Id = hotel_Id;
        this.hotel_Name = hotel_Name;
        this.ownerName = ownerName;
        this.location = location;
    }    

    public Hotel(String hotel_Name, String ownerName, String location, List<Integer> availableFoods) {
        this.hotel_Name = hotel_Name;
        this.ownerName = ownerName;
        this.location = location;
        this.availableFoods = availableFoods; 
    }

    public static Hotel getHotelInstance() {
        if (hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
    }

    public int getHotelId() {
        return hotel_Id;
    }

    public String getHotelName() {
        return hotel_Name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLocation() {
        return location;
    }

    public List<Integer> getAvailableFoods() {
        return availableFoods;
    }

  

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------------------------------------------------\n");
        sb.append(String.format("| %-35s : %-50s|\n", "Hotel id is ", getHotelId()));
        sb.append(String.format("| %-35s : %-50s|\n", "Hotel name is", getHotelName()));
        sb.append(String.format("| %-35s : %-50s|\n", "Owner name is", getOwnerName()));
        sb.append(String.format("| %-35s : %-50s|\n", "Location is", getLocation()));
        sb.append(String.format("| %-35s : %-50s|\n", "Available foods are", getAvailableFoods().toString()));
        sb.append("--------------------------------------------------------------------------------------\n");
        return sb.toString();
    }

    
    public static String convertListToString(List<Integer> list) {
        return list.toString().replaceAll("[\\[\\] ]", "");
    }

    
    public static List<Integer> convertStringToList(String str) {
        List<Integer> list = new ArrayList<>();
        for (String s : str.split(",")) {
            list.add(Integer.parseInt(s.trim()));
        }
        return list;
    }
}

