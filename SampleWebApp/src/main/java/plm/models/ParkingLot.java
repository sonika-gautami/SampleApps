package plm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ParkingLot {

    List<ParkingLotLevels>
            ParkingLotLevels -> locations, rateCards, capacities

    private List<Location> locations;
    private List<Capacity> capacities;
    private List<RateCard> rateCards;

    public ParkingLot(List<Location> locations) {
        this.locations = locations;
    }

    public int getTotalCapacityOf(VehicleType vehicleType) {
        return capacities.stream()
                .filter(c -> c.getVehicleType() == vehicleType)
                .map(c -> c.getCapacity())
                .findFirst()
                .orElse(0);
    }

}
