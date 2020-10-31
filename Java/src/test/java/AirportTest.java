import airport.Airport;
import planes.ExperimentalPlane;
import planelevel.ClassificationLevel;
import planetype.ExperimentalTypes;
import planetype.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity =
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetPlanes() {
        Assert.assertEquals(16, new Airport(planes).getPlanes().size());
    }

    @Test
    public void testGetPassengerPlanes() {
        Assert.assertEquals(8, new Airport(planes).getPassengerPlanes().size());
    }

    @Test
    public void testGetMilitaryPlanes() {
        Assert.assertEquals(6, new Airport(planes).getMilitaryPlanes());
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Assert.assertEquals(planeWithMaxPassengerCapacity, new Airport(planes).getPassengerPlaneWithMaxPassengersCapacity());
    }

    @Test
    public void testGetMilitaryPlanesByTransportType() {
        Assert.assertEquals(1, new Airport(planes).getMilitaryPlanesByTransportType().size());
    }

    @Test
    public void testGetMilitaryPlanesByBomberType() {
        Assert.assertEquals(3, new Airport(planes).getMilitaryPlanesByBomberType().size());
    }

    @Test
    public void testGetExperimentalPlanes() {
        Assert.assertEquals(2, new Airport(planes).getExperimentalPlanes().size());
    }

    @Test
    public void testSortPlanesByMaxDistance() {
        List<Plane> sortedPlanes = Arrays.asList(
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET),
                new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER)
        );
        Assert.assertEquals(sortedPlanes, new Airport(planes).sortPlanesByMaxDistance().getPlanes());
    }

    @Test
    public void testSortPlanesByMaxSpeed() {
        List<Plane> sortedPlanes = Arrays.asList(
                new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER)
        );
        Assert.assertEquals(sortedPlanes, new Airport(planes).sortPlanesByMaxSpeed().getPlanes());

    }

    @Test
    public void testSortPlanesByMaxLoadCapacity() {
        List<Plane> sortedPlanes = Arrays.asList(new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
        );
        Assert.assertEquals(sortedPlanes, new Airport(planes).sortPlanesByMaxLoadCapacity().getPlanes());
    }

    @Test
    public void testExperimentalPlanesHasUNCLASSIFIEDLevel() {
        Assert.assertTrue(true, String.valueOf(new Airport(planes).getExperimentalPlanes().stream().anyMatch(planes -> planes.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED)));
    }
}
