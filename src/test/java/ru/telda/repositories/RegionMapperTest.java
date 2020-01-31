package ru.telda.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.telda.TeldaApplication;
import ru.telda.signatures.Region;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TeldaApplication.class)
public class RegionMapperTest {

    @Autowired private RegionMapper regionMapper;

    @Test
    public void getRegion() {
        Region region = regionMapper.getRegion(1L);
        assert region.getName().equals("Moscow");
    }

    @Test
    public void createRegion() {
        Region region = new Region("Smolensk", "SMK");
        regionMapper.addRegion(region);
        assert regionMapper.getRegionByName("Smolensk").getTitle().equals("SMK");
    }

    @Test
    public void editRegion() {
        Region region = regionMapper.getRegionByName("Smolensk");
        region.setName("Kazan");
        region.setTitle("KZ");
        regionMapper.updateRegion(region);
        assert regionMapper.getRegion(region.getId()).getName().equals("Kazan");
    }

    @Test
    public void deleteRegion() {
        Region region = new Region("Murmansk", "MRSK");
        regionMapper.addRegion(region);
        long id = regionMapper.getRegionByName("Murmansk").getId();
        regionMapper.deleteRegion(id);
        assert regionMapper.getRegion(id)==null;
    }

}