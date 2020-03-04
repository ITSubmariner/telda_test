package ru.telda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.telda.domain.Region;
import ru.telda.repository.RegionMapper;

import java.util.List;

@Service
public class RegionService {
    private final RegionMapper regionMapper;

    @Autowired
    public RegionService(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    @Cacheable(value = "regions")
    public List<Region> getAll() {
        return regionMapper.getAll();
    }

    @Cacheable(value = "regions")
    public Region getRegionById(long id) {
        return regionMapper.getRegion(id);
    }

    @CacheEvict(value = "regions", allEntries = true)
    public void addRegion(@RequestBody Region region) {
        regionMapper.addRegion(region);
    }

    @CacheEvict(value = "regions", allEntries = true)
    public void editRegion(@RequestBody Region region) {
        regionMapper.updateRegion(region);
    }

    @CacheEvict(value = "regions", allEntries = true)
    public void deleteRegion(@RequestParam long id) {
        regionMapper.deleteRegion(id);
    }
}
