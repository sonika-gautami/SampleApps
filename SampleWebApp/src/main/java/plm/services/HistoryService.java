package plm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plm.models.ParkingRecord;
import plm.models.ParkingRecordLot;
import plm.models.ParkingRecords;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class HistoryService {

    @Autowired
    private Map<String, ParkingRecords> parkingRecords;

    public List<ParkingRecord> getRecordsOf(String vehicle_no) {

        return parkingRecords.entrySet().stream()
                .flatMap(e -> e.getValue().getParkingRecordsList().stream()
                        .filter(l -> l.getVehicleNo().equals(vehicle_no))
                )
                .collect(Collectors.toList());
    }
}
