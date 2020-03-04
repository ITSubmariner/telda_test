package ru.telda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.telda.domain.Region;
import ru.telda.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("region")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("all")
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @GetMapping
    public Region getRegion(@RequestParam Long id) {
        return regionService.getRegionById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void addRegion(@RequestBody Region region) {
        regionService.addRegion(region);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void editRegion(@RequestBody Region region) {
        regionService.editRegion(region);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteRegion(@RequestParam long id) {
        regionService.deleteRegion(id);
    }

}
