package plm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RateCard {
    private int ratePerHour;
    private VehicleType vehicleType;

    public double getAmount(int durationInMillis) {
        var hours = Math.ceil(durationInMillis / (1000.0 * 60 * 60));
        return hours * ratePerHour;
    }
}
