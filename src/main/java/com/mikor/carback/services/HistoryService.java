package com.mikor.carback.services;

import com.mikor.carback.data.dto.HistoryDto;
import com.mikor.carback.data.mappers.HistoryMapper;
import com.mikor.carback.exceptions.NotFoundException;
import com.mikor.carback.models.History;
import com.mikor.carback.models.Violation;
import com.mikor.carback.repos.CarRepository;
import com.mikor.carback.repos.ClientRepository;
import com.mikor.carback.repos.HistoryRepository;
import com.mikor.carback.repos.ViolationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final ViolationRepository violationRepository;

    public HistoryDto startHistory(Long clientId, Long carId) {
        return HistoryMapper.INSTANCE.toDto(historyRepository.save(History.builder()
                .client(clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException("Client with this id not found")))
                .car(carRepository.findById(carId).orElseThrow(() -> new NotFoundException("Car with this id not found")))
                .startDate(LocalDateTime.now())
                .build()));
    }

    public HistoryDto endHistory(Long id) {
        History history = historyRepository.findById(id).orElseThrow(() -> new NotFoundException("History with this id not found"));
        history.setEndDate(LocalDateTime.now());
        history = historyRepository.save(history);
        return HistoryMapper.INSTANCE.toDto(history);
    }

    public HistoryDto addViolation(Long id, Long violationId) {
        History history = historyRepository.findById(id).orElseThrow(() -> new NotFoundException("History with this id not found"));
        Set<Violation> violations = history.getViolation();
        violations.add(violationRepository.findById(violationId).orElseThrow(() -> new NotFoundException("Violation with this id not found")));
        history.setViolation(violations);
        history = historyRepository.save(history);
        return HistoryMapper.INSTANCE.toDto(history);
    }

    public HistoryDto removeViolation(Long id, Long violationId) {
        History history = historyRepository.findById(id).orElseThrow(() -> new NotFoundException("History with this id not found"));
        Set<Violation> violations = history.getViolation();
        violations.remove(violationRepository.findById(violationId).orElseThrow(() -> new NotFoundException("Violation with this id not found")));
        history.setViolation(violations);
        history = historyRepository.save(history);
        return HistoryMapper.INSTANCE.toDto(history);
    }

    public HistoryDto getHistory(Long id) {
        return HistoryMapper.INSTANCE.toDto(historyRepository.findById(id).orElseThrow(() -> new NotFoundException("History with this id not found")));
    }

    public List<HistoryDto> getAllHistories() {
        return HistoryMapper.INSTANCE.toDto(historyRepository.findAll());
    }

    public List<HistoryDto> getHistoriesByClientId(Long clientId) {
        List<History> listAllHistory = historyRepository.findAll();
        List<History> listFindHistory = new ArrayList<>();
        for (History h : listAllHistory) {
            if (h.getClient().getId() == clientId) listFindHistory.add(h);
        }
        return HistoryMapper.INSTANCE.toDto(listFindHistory);
    }

    public List<HistoryDto> getAllEndDateHistory() {
        List<History> listAllHistory = historyRepository.findAll();
        List<History> listAllEndHistory = new ArrayList<>();
        for (History h : listAllHistory) {
            if (h.getEndDate() != null) listAllEndHistory.add(h);
        }
        return HistoryMapper.INSTANCE.toDto(listAllEndHistory);
    }

    public void deleteHistory(Long id) {
        historyRepository.delete(historyRepository.findById(id).orElseThrow(() -> new NotFoundException("History with this id not found")));
    }
}
