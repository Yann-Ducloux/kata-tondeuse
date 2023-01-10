package model;

import java.util.List;

public class FileData {
    CoordinateMax coordinateMax;
    List<Tondeuse> tondeuses;

    public void setCoordinateMax(CoordinateMax coordinateMax) {
        this.coordinateMax = coordinateMax;
    }

    public void setTondeuses(List<Tondeuse> tondeuses) {
        this.tondeuses = tondeuses;
    }

    public CoordinateMax getCoordinateMax() {
        return coordinateMax;
    }

    public List<Tondeuse> getTondeuses() {
        return tondeuses;
    }
}
