package com.codegym.service.city;

import com.codegym.model.City;
import com.codegym.model.dto.CityDTO;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface ICityService extends IGeneralService<City> {
    List<CityDTO> getAllCityDTO();

    List<City> findAllByDeletedIsFalse();
}
