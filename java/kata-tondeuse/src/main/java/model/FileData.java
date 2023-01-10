package model;

import java.util.List;

/**
 * @author Yann Ducloux
 * Défini les données du fichier.
 */
public class FileData {
    CoordinateMax coordinateMax;
    List<Mower> tondeuses;

    public void setCoordinateMax(CoordinateMax coordinateMax) {
        this.coordinateMax = coordinateMax;
    }

    public void setTondeuses(List<Mower> tondeuses) {
        this.tondeuses = tondeuses;
    }

    public CoordinateMax getCoordinateMax() {
        return coordinateMax;
    }

    public List<Mower> getTondeuses() {
        return tondeuses;
    }
}
