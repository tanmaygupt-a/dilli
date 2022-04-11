package com.delhiexmp.dilli;

public class Place {
    private String name;
    private int photoResourceId;
    private String timings;
    private String location;
    String locationURL;
    String description;


    public Place(String name, String timings, String location, int photoResourceId, String locationURL, String description) {
        this.name = name;
        this.photoResourceId = photoResourceId;
        this.timings = timings;
        this.location = location;
        this.locationURL = locationURL;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPhotoResourceId() {
        return photoResourceId;
    }

    public String getTimings() {
        return timings;
    }

    public String getLocation() {
        return location;
    }

    public String getLocationURL() {
        return locationURL;
    }

    public String getDescription() {
        return description;
    }

}
