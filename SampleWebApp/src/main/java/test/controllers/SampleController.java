package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {

    @Value("${sample.key:default}")
    private String key;

    @Autowired
    @Qualifier("noStrs")
    private List<String> noStrs;


    @GetMapping("/testdata")
    public ResponseEntity get() {
        var list = new ArrayList<>(noStrs);
        list.add(key);

        return ResponseEntity.ok().body(list);
    }
}
