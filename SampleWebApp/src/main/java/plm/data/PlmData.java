package plm.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import plm.models.*;

import java.util.List;
import java.util.Map;

@Configuration
public class PlmData {

    @Bean
    public Map<String, ParkingLot> parkingLots() {
        ParkingLotIde -> "name", "level"

        return Map.of(
                "p1", new ParkingLot(locationsInPL(),
                        capacityData(3, 2, 1),
                        rateCard(3, 2, 1)),
                "p1-l1", new ParkingLot(locationsInPL(),
                        capacityData(3, 2, 1),
                        rateCard(3, 2, 1))
        );
    }

    @Bean
    public Map<String, ParkingRecords> parkingRecords() {
        return Map.of(
                "p1", new ParkingRecords(),
                "p2", new ParkingRecords()
        );
    }

    private List<RateCard> rateCard(int twoV, int hatch, int suv) {
        return List.of(
                new RateCard(twoV, VehicleType.TWO_WHEELER),
                new RateCard(hatch, VehicleType.HATCHBACK_CAR),
                new RateCard(suv, VehicleType.SUV_CAR)
        );
    }

    private List<Location> locationsInPL() {
        return List.of(
                new Location("1-1", VehicleType.TWO_WHEELER),
                new Location("1-2", VehicleType.TWO_WHEELER),
                new Location("1-3", VehicleType.TWO_WHEELER),
                new Location("2-1", VehicleType.HATCHBACK_CAR),
                new Location("2-2", VehicleType.HATCHBACK_CAR),
                new Location("3-1", VehicleType.SUV_CAR)
        );
    }

    private List<Capacity> capacityData(int twoV, int hatch, int suv) {
        return List.of(
                new Capacity(twoV, VehicleType.TWO_WHEELER),
                new Capacity(hatch, VehicleType.HATCHBACK_CAR),
                new Capacity(suv, VehicleType.SUV_CAR)
        );
    }
}
