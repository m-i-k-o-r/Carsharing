package com.mikor.carback.controllers;


import com.mikor.carback.data.dto.HistoryDto;
import com.mikor.carback.data.forms.history.CreateHistoryForm;
import com.mikor.carback.services.HistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
@CrossOrigin("http://localhost:5173/")
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping()
    public List<HistoryDto> getAllHistories() {
        return historyService.getAllHistories();
    }

    @GetMapping("/withEnd")
    public List<HistoryDto> getAllHistoriesWithEnd() {
        return historyService.getAllEndDateHistory();
    }

    @GetMapping("/byClient/{clientId}")
    public List<HistoryDto> getHistoriesByClientId(@PathVariable Long clientId) {
        return historyService.getHistoriesByClientId(clientId);
    }

    @GetMapping("/{id}")
    public HistoryDto getHistoryById(@PathVariable Long id) {
        return historyService.getHistory(id);
    }

    @PostMapping("/start")
    public HistoryDto startHistory(@Valid @RequestBody CreateHistoryForm form) {
        return historyService.startHistory(form);
    }

    @PutMapping("/{id}/end")
    public HistoryDto endHistory(@PathVariable Long id) {
        return historyService.endHistory(id);
    }

    @PutMapping("/{id}/addViolation")
    public HistoryDto addViolation(@PathVariable Long id,
                                   @RequestParam("violationId") Long violationId) {
        return historyService.addViolation(id, violationId);
    }

    @PutMapping("/{id}/removeViolation")
    public HistoryDto removeViolation(@PathVariable Long id,
                                      @RequestParam("violationId") Long violationId) {
        return historyService.removeViolation(id, violationId);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteHistory(@PathVariable Long id) {
        historyService.deleteHistory(id);
    }

}
