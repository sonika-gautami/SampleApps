package plm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import plm.models.Location;
import plm.services.ParkingService;

import java.util.Optional;


@Controller
public class PlmController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("/park/{parking_lot_id}")
    public ResponseEntity park(@PathVariable String parking_lot_id,
                               @RequestParam String vehicleType,
                               @RequestParam String vehicleNo) {

        Optional<Location> location = parkingService.park(parking_lot_id, vehicleType, vehicleNo);

        return location.map(l -> ResponseEntity.ok(l.getLocationId()))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/exit")
    public ResponseEntity exitFromParking(@RequestParam String vehicleNo) {
        var amount = parkingService.exit(vehicleNo);

        return ResponseEntity.ok(amount);
    }
}
