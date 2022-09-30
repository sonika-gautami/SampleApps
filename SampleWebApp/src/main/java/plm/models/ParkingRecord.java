package plm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class ParkingRecord {
    private String vehicleNo;
    private VehicleType vehicleType;
    private String parkinglotId;
    private String parkingLotLocation;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private double amountPaid;

    public int getDurationInHours() {
        return Double.valueOf(Math.ceil(endTime.toEpochSecond() - startTime.toEpochSecond()) / (60 * 60)).intValue();
    }

    public void markExit() {
        endTime = OffsetDateTime.now();
    }
}
