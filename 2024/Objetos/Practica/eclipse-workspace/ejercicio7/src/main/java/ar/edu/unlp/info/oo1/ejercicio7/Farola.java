package ar.edu.unlp.info.oo1.ejercicio7;

import java.util.*;

public class Farola {
    private boolean on;
    private List<Farola> neighbors;

    public Farola() {
        this.on = false;
        this.neighbors = new ArrayList<>();
    }

    public boolean isOn() {
        return this.on;
    }

    public void setOn() {
        this.on = true;
    }

    public void setOff() {
        this.on = false;
    }

    public boolean isOff() {
        return !this.on;
    }

    public List<Farola> getNeighbors() {
        return this.neighbors;
    }

    public void pairWithNeighbor(Farola farola) {
        if (!this.neighbors.contains(farola)) {
            this.neighbors.add(farola);
            farola.getNeighbors().add(this);
        }
    }

    public void turnOn() {
        if (!this.isOn()) {
            this.setOn();
            for (Farola f : this.neighbors) {
                f.turnOn();
            }
        }
    }

    public void turnOff() {
        if (this.isOn()) {  
            this.setOff();
            for (Farola f : this.neighbors) {
                f.turnOff();
            }
        }
    }
}
