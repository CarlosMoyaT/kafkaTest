package com.example.demo.dto;

import lombok.Data;

@Data
public class ObservationDTO {

        private String type;
        private String timestamp;
        private double temperature;
        private double latitude;
        private double longitude;


        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getTimestamp() {
                return timestamp;
        }

        public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
        }

        public double getTemperature() {
                return temperature;
        }

        public void setTemperature(double temperature) {
                this.temperature = temperature;
        }

        public double getLatitude() {
                return latitude;
        }

        public void setLatitude(double latitude) {
                this.latitude = latitude;
        }

        public double getLongitude() {
                return longitude;
        }

        public void setLongitude(double longitude) {
                this.longitude = longitude;
        }
}
