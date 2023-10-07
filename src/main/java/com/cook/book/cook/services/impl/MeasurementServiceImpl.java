package com.cook.book.cook.services.impl;

import com.cook.book.cook.dtos.MeasurementDto;
import com.cook.book.cook.models.Measurement;
import com.cook.book.cook.repositories.MeasurementRepository;
import com.cook.book.cook.services.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementRepository measurementRepository;
    @Override
    public List<MeasurementDto> getAllMeasurementDto() {
        List<MeasurementDto> result=new ArrayList<>();
        for (Measurement measurement : measurementRepository.findAll()) {
            MeasurementDto dto=new MeasurementDto();
            dto.setId(measurement.getId());
            dto.setName(measurement.getName());
            dto.setConversion_to_grams(measurement.getConversion_to_grams());
            result.add(dto);
        }
        return result;
    }
}

