package com.pokidin.a.weatherapplication.model;

import com.google.android.gms.maps.model.LatLng;

public class Place {


    public static Place newInstance(){
        return new Place();
    }

    public LatLng getCoord() {
        return coord;
    }

    public void setCoord(LatLng coord) {
        this.coord = coord;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    private LatLng coord;
    private Double lat;
    private Double lng;


}
