package com.challenge.pet.love.infra.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PositionStackLocationDTOTest {

    @Test
    void testPositionStackLocationDTOBuilder() {
        double latitude = 40.7128;
        double longitude = -74.0060;
        String type = "address";
        double distance = 10.5;
        String name = "123 Main St";
        String number = "123";
        String postalCode = "10001";
        String street = "Main St";
        double confidence = 0.95;
        String region = "New York";
        String regionCode = "NY";
        String county = "New York County";
        String locality = "New York City";
        String administrativeArea = null;
        String neighbourhood = "Midtown";
        String country = "United States";
        String countryCode = "USA";
        String continent = "North America";
        String label = "123 Main St, New York City, NY, USA";

        PositionStackLocationDTO dto = PositionStackLocationDTO.builder()
                .latitude(latitude)
                .longitude(longitude)
                .type(type)
                .distance(distance)
                .name(name)
                .number(number)
                .postalCode(postalCode)
                .street(street)
                .confidence(confidence)
                .region(region)
                .regionCode(regionCode)
                .county(county)
                .locality(locality)
                .administrativeArea(administrativeArea)
                .neighbourhood(neighbourhood)
                .country(country)
                .countryCode(countryCode)
                .continent(continent)
                .label(label)
                .build();

        assertEquals(latitude, dto.getLatitude());
        assertEquals(longitude, dto.getLongitude());
        assertEquals(type, dto.getType());
        assertEquals(distance, dto.getDistance());
        assertEquals(name, dto.getName());
        assertEquals(number, dto.getNumber());
        assertEquals(postalCode, dto.getPostalCode());
        assertEquals(street, dto.getStreet());
        assertEquals(confidence, dto.getConfidence());
        assertEquals(region, dto.getRegion());
        assertEquals(regionCode, dto.getRegionCode());
        assertEquals(county, dto.getCounty());
        assertEquals(locality, dto.getLocality());
        assertNull(dto.getAdministrativeArea());
        assertEquals(neighbourhood, dto.getNeighbourhood());
        assertEquals(country, dto.getCountry());
        assertEquals(countryCode, dto.getCountryCode());
        assertEquals(continent, dto.getContinent());
        assertEquals(label, dto.getLabel());
    }

    @Test
    void testPositionStackLocationDTOSettersAndGetters() {
        PositionStackLocationDTO dto = new PositionStackLocationDTO();

        dto.setLatitude(41.8781);
        dto.setLongitude(-87.6298);
        dto.setType("address");
        dto.setDistance(5.2);
        dto.setName("Chicago Cultural Center");
        dto.setNumber("78");
        dto.setPostalCode("60601");
        dto.setStreet("E Washington St");
        dto.setConfidence(0.98);
        dto.setRegion("Illinois");
        dto.setRegionCode("IL");
        dto.setCounty("Cook County");
        dto.setLocality("Chicago");
        dto.setAdministrativeArea(null);
        dto.setNeighbourhood("The Loop");
        dto.setCountry("United States");
        dto.setCountryCode("USA");
        dto.setContinent("North America");
        dto.setLabel("78 E Washington St, Chicago, IL 60601, USA");

        assertEquals(41.8781, dto.getLatitude());
        assertEquals(-87.6298, dto.getLongitude());
        assertEquals("address", dto.getType());
        assertEquals(5.2, dto.getDistance());
        assertEquals("Chicago Cultural Center", dto.getName());
        assertEquals("78", dto.getNumber());
        assertEquals("60601", dto.getPostalCode());
        assertEquals("E Washington St", dto.getStreet());
        assertEquals(0.98, dto.getConfidence());
        assertEquals("Illinois", dto.getRegion());
        assertEquals("IL", dto.getRegionCode());
        assertEquals("Cook County", dto.getCounty());
        assertEquals("Chicago", dto.getLocality());
        assertNull(dto.getAdministrativeArea());
        assertEquals("The Loop", dto.getNeighbourhood());
        assertEquals("United States", dto.getCountry());
        assertEquals("USA", dto.getCountryCode());
        assertEquals("North America", dto.getContinent());
        assertEquals("78 E Washington St, Chicago, IL 60601, USA", dto.getLabel());
    }

    @Test
    void testPositionStackLocationDTOAllArgsConstructor() {
        PositionStackLocationDTO dto = new PositionStackLocationDTO(42.3601, -71.0589, "address", 2.7, "Faneuil Hall", "1", "02109", "Faneuil Hall Sq", 0.99, "Massachusetts", "MA", "Suffolk County", "Boston", null, "Downtown", "United States", "USA", "North America", "1 Faneuil Hall Sq, Boston, MA 02109, USA");

        assertEquals(42.3601, dto.getLatitude());
        assertEquals(-71.0589, dto.getLongitude());
        assertEquals("address", dto.getType());
        assertEquals(2.7, dto.getDistance());
        assertEquals("Faneuil Hall", dto.getName());
        assertEquals("1", dto.getNumber());
        assertEquals("02109", dto.getPostalCode());
        assertEquals("Faneuil Hall Sq", dto.getStreet());
        assertEquals(0.99, dto.getConfidence());
        assertEquals("Massachusetts", dto.getRegion());
        assertEquals("MA", dto.getRegionCode());
        assertEquals("Suffolk County", dto.getCounty());
        assertEquals("Boston", dto.getLocality());
        assertNull(dto.getAdministrativeArea());
        assertEquals("Downtown", dto.getNeighbourhood());
        assertEquals("United States", dto.getCountry());
        assertEquals("USA", dto.getCountryCode());
        assertEquals("North America", dto.getContinent());
        assertEquals("1 Faneuil Hall Sq, Boston, MA 02109, USA", dto.getLabel());
    }
}