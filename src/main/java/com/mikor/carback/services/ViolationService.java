package com.mikor.carback.services;

import com.mikor.carback.data.dto.ViolationDto;
import com.mikor.carback.data.mappers.ViolationMapper;
import com.mikor.carback.exceptions.NotFoundException;
import com.mikor.carback.models.Violation;
import com.mikor.carback.repos.HistoryRepository;
import com.mikor.carback.repos.ViolationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViolationService {
    private final ViolationRepository violationRepository;
    private final HistoryRepository historyRepository;

    public ViolationDto violationCreate(String type, String description, double price, Long historyId) {
        return ViolationMapper.INSTANCE.toDto(violationRepository.save(Violation.builder()
                .type(type)
                .description(description)
                .price(price)
                .history(historyRepository.findById(historyId).orElseThrow(() -> new NotFoundException("History with this id not found")))
                .build()));
    }

    public ViolationDto updateViolation(Long id, String type, String description, double price) {
        Violation violation = violationRepository.findById(id).orElseThrow(() -> new NotFoundException("Violation with this id not found"));
        violation.setType(type);
        violation.setDescription(description);
        violation.setPrice(price);
        violation = violationRepository.save(violation);
        return ViolationMapper.INSTANCE.toDto(violation);
    }

    public ViolationDto getViolation(Long id) {
        return ViolationMapper.INSTANCE.toDto(violationRepository.findById(id).orElseThrow(() -> new NotFoundException("Violation with this id not found")));
    }

    public List<ViolationDto> getAllViolations() {
        return ViolationMapper.INSTANCE.toDto(violationRepository.findAll());
    }

    public void deleteViolation(Long id) {
        violationRepository.delete(violationRepository.findById(id).orElseThrow(() -> new NotFoundException("Violation with this id not found")));
    }
}
