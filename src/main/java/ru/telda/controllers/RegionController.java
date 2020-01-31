package ru.telda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.telda.repositories.RegionMapper;
import ru.telda.signatures.Region;

import java.util.List;

@RestController
@RequestMapping("region")
public class RegionController {

    @Autowired private RegionMapper regionMapper;

    @GetMapping("all")
    @Cacheable(value = "regions")
    public List<Region> getAll() {
        return regionMapper.getAll();
    }

    @GetMapping
    @Cacheable(value = "regions")
    public Region getRegion(@RequestParam long id) {
        return regionMapper.getRegion(id);
    }

    @PostMapping
    @CacheEvict(value = "regions", allEntries = true)
    public ResponseEntity addRegion(@RequestBody Region region) {
        try {
            regionMapper.addRegion(region);
            return ResponseEntity.ok().build();
        } catch (Exception exception) { return ResponseEntity.status(500).build(); }
    }

    @PutMapping
    @CacheEvict(value = "regions", allEntries = true)
    public ResponseEntity editRegion(@RequestBody Region region) {
        try {
            regionMapper.updateRegion(region);
            return ResponseEntity.ok().build();
        } catch (Exception exception) { return ResponseEntity.status(500).build(); }
    }

    @DeleteMapping
    @CacheEvict(value = "regions", allEntries = true)
    public ResponseEntity deleteRegion(@RequestParam long id) {
        try {
            regionMapper.deleteRegion(id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) { return ResponseEntity.status(500).build(); }
    }

}
