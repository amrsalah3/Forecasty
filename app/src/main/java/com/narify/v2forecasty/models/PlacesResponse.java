package com.narify.v2forecasty.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlacesResponse {

    @SerializedName("geonames")
    @Expose
    public List<Geoname> geonames = null;

    public List<Geoname> getGeonames() {
        return geonames;
    }

    public void setGeonames(List<Geoname> geonames) {
        this.geonames = geonames;
    }

    @Override
    public String toString() {
        return "PlacesResponse{" +
                "geonames=" + geonames +
                '}';
    }

    public class Geoname {

        @SerializedName("adminCode1")
        @Expose
        public String adminCode1;
        @SerializedName("lng")
        @Expose
        public String lng;
        @SerializedName("distance")
        @Expose
        public String distance;
        @SerializedName("geonameId")
        @Expose
        public Long geonameId;
        @SerializedName("toponymName")
        @Expose
        public String toponymName;
        @SerializedName("countryId")
        @Expose
        public String countryId;
        @SerializedName("fcl")
        @Expose
        public String fcl;
        @SerializedName("population")
        @Expose
        public Long population;
        @SerializedName("countryCode")
        @Expose
        public String countryCode;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("fclName")
        @Expose
        public String fclName;
        @SerializedName("adminCodes1")
        @Expose
        public AdminCodes1 adminCodes1;
        @SerializedName("countryName")
        @Expose
        public String countryName;
        @SerializedName("fcodeName")
        @Expose
        public String fcodeName;
        @SerializedName("adminName1")
        @Expose
        public String adminName1;
        @SerializedName("lat")
        @Expose
        public String lat;
        @SerializedName("fcode")
        @Expose
        public String fcode;

        public String getAdminCode1() {
            return adminCode1;
        }

        public void setAdminCode1(String adminCode1) {
            this.adminCode1 = adminCode1;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public Long getGeonameId() {
            return geonameId;
        }

        public void setGeonameId(Long geonameId) {
            this.geonameId = geonameId;
        }

        public String getToponymName() {
            return toponymName;
        }

        public void setToponymName(String toponymName) {
            this.toponymName = toponymName;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getFcl() {
            return fcl;
        }

        public void setFcl(String fcl) {
            this.fcl = fcl;
        }

        public Long getPopulation() {
            return population;
        }

        public void setPopulation(Long population) {
            this.population = population;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFclName() {
            return fclName;
        }

        public void setFclName(String fclName) {
            this.fclName = fclName;
        }

        public AdminCodes1 getAdminCodes1() {
            return adminCodes1;
        }

        public void setAdminCodes1(AdminCodes1 adminCodes1) {
            this.adminCodes1 = adminCodes1;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getFcodeName() {
            return fcodeName;
        }

        public void setFcodeName(String fcodeName) {
            this.fcodeName = fcodeName;
        }

        public String getAdminName1() {
            return adminName1;
        }

        public void setAdminName1(String adminName1) {
            this.adminName1 = adminName1;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getFcode() {
            return fcode;
        }

        public void setFcode(String fcode) {
            this.fcode = fcode;
        }

        @Override
        public String toString() {
            return "Geoname{" +
                    "adminCode1='" + adminCode1 + '\'' +
                    ", lng='" + lng + '\'' +
                    ", distance='" + distance + '\'' +
                    ", geonameId=" + geonameId +
                    ", toponymName='" + toponymName + '\'' +
                    ", countryId='" + countryId + '\'' +
                    ", fcl='" + fcl + '\'' +
                    ", population=" + population +
                    ", countryCode='" + countryCode + '\'' +
                    ", name='" + name + '\'' +
                    ", fclName='" + fclName + '\'' +
                    ", adminCodes1=" + adminCodes1 +
                    ", countryName='" + countryName + '\'' +
                    ", fcodeName='" + fcodeName + '\'' +
                    ", adminName1='" + adminName1 + '\'' +
                    ", lat='" + lat + '\'' +
                    ", fcode='" + fcode + '\'' +
                    '}';
        }
    }

    public class AdminCodes1 {

        @SerializedName("ISO3166_2")
        @Expose
        public String iSO31662;

        public String getiSO31662() {
            return iSO31662;
        }

        public void setiSO31662(String iSO31662) {
            this.iSO31662 = iSO31662;
        }

        @Override
        public String toString() {
            return "AdminCodes1{" +
                    "iSO31662='" + iSO31662 + '\'' +
                    '}';
        }
    }

}
