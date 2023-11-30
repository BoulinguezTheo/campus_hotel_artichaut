package com.campus.campus_hotel_artichaut_backend.service;

import com.campus.campus_hotel_artichaut_backend.dto.OptionDto;
import com.campus.campus_hotel_artichaut_backend.mapper.OptionMapper;
import com.campus.campus_hotel_artichaut_backend.model.entity.Option;
import com.campus.campus_hotel_artichaut_backend.model.repositories.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final OptionRepository optionRepository;

    private final OptionMapper optionMapper;

    public List<OptionDto> getAllOptions() {
        return optionRepository.findAll().stream()
                .map(optionMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
