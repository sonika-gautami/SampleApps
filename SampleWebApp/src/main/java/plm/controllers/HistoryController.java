package plm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import plm.services.HistoryService;

import java.util.Collections;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/history/vehicles/{vehicle_no}")
    public ResponseEntity park(@PathVariable String vehicle_no) {
        var data = historyService.getRecordsOf(vehicle_no);

        return ResponseEntity.ok(data);
    }
}
