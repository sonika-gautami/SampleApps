package plm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
    private String locationId;
    private VehicleType supportedVehicle;
}
