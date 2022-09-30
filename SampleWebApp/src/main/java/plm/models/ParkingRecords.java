package plm.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ParkingRecords {
    private List<ParkingRecord> parkingRecordsList = new ArrayList<>();

    public List<ParkingRecord> addRecord(ParkingRecord r) {
        parkingRecordsList.add(r);
        return parkingRecordsList;
    }
}
