package model;

import java.util.List;
import java.util.Objects;

/**
 * The type Lown.
 *
 * @author Yann Ducloux
 * Défini les données du fichier.
 */
public class Lawn {
    Dimension dimension;
    List<Mower> mowers;

    public Lawn(Dimension dimension, List<Mower> mowers) {
        this.dimension = dimension;
        this.mowers = mowers;
    }
    public Dimension getDimension() {
        return dimension;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawn lawn = (Lawn) o;
        return Objects.equals(dimension, lawn.dimension) && Objects.equals(mowers, lawn.mowers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimension, mowers);
    }
}
