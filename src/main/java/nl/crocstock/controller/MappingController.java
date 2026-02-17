package nl.crocstock.controller;

import nl.crocstock.mapper.JsonMapper;
import nl.crocstock.model.Mapping;
import nl.crocstock.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    @Autowired
    private MappingService mappingService;

    @PostMapping(value = "/mappings/save")
    public ResponseEntity<HttpStatus> saveMapping(@RequestBody Mapping mapping) {
        if (mappingService.saveMapping(mapping)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/mappings")
    public String getMappings() {
        return JsonMapper.toJsonString(mappingService.getMappings());
    }

    @PostMapping(value = "/mappings/reset")
    public boolean resetMappings() {
        return mappingService.reset();
    }

    @DeleteMapping(value = "/mappings/remove")
    public boolean deleteMapping(@RequestBody Mapping mappingToRemove) {
        return mappingService.remove(mappingToRemove);
    }
}
