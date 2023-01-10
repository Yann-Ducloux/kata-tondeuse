package model;

import java.util.List;

/**
 * The type File data.
 *
 * @author Yann Ducloux
 * Défini les données du fichier.
 */
public class FileData {
    /**
     * The Coordinate max.
     */
    CoordinateMax coordinateMax;
    /**
     * The Mowers.
     */
    List<Mower> mowers;

    /**
     * Sets coordinate max.
     *
     * @param coordinateMax the coordinate max
     */
    public void setCoordinateMax(CoordinateMax coordinateMax) {
        this.coordinateMax = coordinateMax;
    }

    /**
     * Sets mowers.
     *
     * @param mowers the mowers
     */
    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }

    /**
     * Gets coordinate max.
     *
     * @return the coordinate max
     */
    public CoordinateMax getCoordinateMax() {
        return coordinateMax;
    }

    /**
     * Gets mowers.
     *
     * @return the mowers
     */
    public List<Mower> getMowers() {
        return mowers;
    }
}
