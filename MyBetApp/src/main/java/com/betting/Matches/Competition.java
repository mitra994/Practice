package com.betting.Matches;

public class Competition {

    private int id;
    private String name;
    private String code;
    private Area area;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private class Area{
        private String name;
        private String code;
        private String ensignUrl;

        public Area(){

        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getEnsignUrl() {
            return ensignUrl;
        }

        public void setEnsignUrl(String ensignUrl) {
            this.ensignUrl = ensignUrl;
        }
    }
}
