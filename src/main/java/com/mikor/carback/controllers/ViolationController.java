package com.mikor.carback.controllers;

import com.mikor.carback.data.dto.ViolationDto;
import com.mikor.carback.data.forms.violation.CreateViolationForm;
import com.mikor.carback.services.ViolationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/violation")
@CrossOrigin("http://localhost:5173/")
public class ViolationController {
    private final ViolationService violationService;

    @GetMapping()
    public List<ViolationDto> getAllViolations() {
        return violationService.getAllViolations();
    }

    @GetMapping("/{id}")
    public ViolationDto getViolationById(@PathVariable Long id) {
        return violationService.getViolation(id);
    }

    @PostMapping("/create")
    public ViolationDto createViolation(@Valid @RequestBody CreateViolationForm form) {
        return violationService.violationCreate(form);
    }

    @PutMapping("/{id}/updateViolation")
    public ViolationDto updateViolationById(@PathVariable Long id,
                                         @RequestParam("type") String type,
                                         @RequestParam("description") String description,
                                         @RequestParam("price") double price) {
        return violationService.updateViolation(id, type, description, price);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteViolationById(@PathVariable Long id) {
        violationService.deleteViolation(id);
    }

}
