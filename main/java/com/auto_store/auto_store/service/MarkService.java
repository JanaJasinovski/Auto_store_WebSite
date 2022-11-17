package com.auto_store.auto_store.service;

import com.auto_store.auto_store.dto.CarDTO;
import com.auto_store.auto_store.dto.MarkDTO;
import com.auto_store.auto_store.helpers.DtoConvert;
import com.auto_store.auto_store.model.Mark;
import com.auto_store.auto_store.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarkService {

    private final MarkRepository markRepository;
    private final DtoConvert dtoConvert;

    public List<MarkDTO> findAll() {
        return markRepository.findAll().stream().map(dtoConvert::convertMark).collect(Collectors.toList());
    }
}
