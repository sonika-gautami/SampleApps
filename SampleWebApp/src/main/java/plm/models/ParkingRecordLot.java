package plm.models;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ParkingRecordLot {
    private List<ParkingRecord> parkingRecord;
    private String pl;
}
