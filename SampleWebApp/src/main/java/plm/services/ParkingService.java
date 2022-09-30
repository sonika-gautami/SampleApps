package plm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plm.models.*;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ParkingService {

    @Autowired
    private Map<String, ParkingRecords> parkingRecords;

    @Autowired
    private Map<String, ParkingLot> parkingLots;


    public Optional<Location> park(String parking_lot_id,
                                   String vehicleType,
                                   String vehicleNo) {

        ParkingLot parkingLot = parkingLots.get(parking_lot_id);
        ParkingRecords list = parkingRecords.get(parking_lot_id);

        VehicleType vType = VehicleType.valueOf(vehicleType);


        var total = parkingLot.getTotalCapacityOf(vType);

        var allocated = list.getParkingRecordsList().stream()
                .filter(r -> Objects.nonNull(r.getEndTime()))
                .filter(r -> r.getVehicleType() == vType)
                .collect(Collectors.toList());

        if (allocated.size() >= total) {
            return Optional.empty();
        }


        var locations = allocated.stream()
                .map(r -> r.getParkingLotLocation())
                .collect(Collectors.toList());

        var allocatedLocation = parkingLot.getLocations().stream()
                .filter(l -> l.getSupportedVehicle() == vType)
                .filter(l -> !locations.contains(l.getLocationId()))
                .findAny()
                .get();

        list.addRecord(
                new ParkingRecord(vehicleNo, vType,
                        parking_lot_id, allocatedLocation.getLocationId(),
                        OffsetDateTime.now(), null, 0.0
                ));

        return Optional.of(allocatedLocation);
    }

    public double exit(String vehicleNo) {
        Optional<ParkingRecord> parkingRecord = parkingRecords.entrySet().stream()
                .map(e ->
                        e.getValue().getParkingRecordsList().stream()
                                .filter(l -> Objects.isNull(l.getEndTime()))
                                .filter(l -> l.getVehicleNo().equals(vehicleNo))
                                .findFirst()
                                .get()
                )
                .findAny();

        parkingRecord.ifPresent(p -> p.markExit());

        return parkingRecord.map(p -> {
            var amot = parkingLots.get(p.getParkinglotId())
                    .getRateCards().stream().filter(r -> r.getVehicleType() == p.getVehicleType())
                    .map(r -> r.getRatePerHour())
                    .findAny().orElse(0);

            return p.getDurationInHours() * amot;
        })
                .orElse(0);

    }
}
