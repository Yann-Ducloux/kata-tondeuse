package model;

import java.util.List;

/**
 * @author Yann Ducloux
 * Défini les données du fichier.
 */
public class FileData {
    CoordinateMax coordinateMax;
    List<Mower> mowers;

    public void setCoordinateMax(CoordinateMax coordinateMax) {
        this.coordinateMax = coordinateMax;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }

    public CoordinateMax getCoordinateMax() {
        return coordinateMax;
    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
