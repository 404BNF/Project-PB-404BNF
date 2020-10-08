package com.example.myapplication.model;

public class MainModel {
        private String name;
        private String rute;

        public MainModel(String name, String rute) {
            this.name = name;
            this.rute = rute;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRute() {
            return rute;
        }

        public void setRute(String rute) {
            this.rute = rute;
        }
    }

