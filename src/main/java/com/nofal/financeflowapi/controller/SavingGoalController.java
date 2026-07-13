package com.nofal.financeflowapi.controller;

import com.nofal.financeflowapi.entity.SavingGoal;
import com.nofal.financeflowapi.service.SavingGoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/savingGoals")

public class SavingGoalController {
    private final SavingGoalService savingGoalService;
    public SavingGoalController(SavingGoalService savingGoalService){
        this.savingGoalService = savingGoalService;
    }

    @GetMapping
    public ResponseEntity<List<SavingGoal>> getAllSavingGoals(){
        return ResponseEntity.ok(savingGoalService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SavingGoal> findById(@PathVariable Long id){
        return ResponseEntity.ok(savingGoalService.findById(id));
    }
    @PostMapping
    public ResponseEntity<SavingGoal> saveSavingGoal(@RequestBody SavingGoal savingGoal){
        SavingGoal savedSavingGoal = savingGoalService.save(savingGoal);
        URI location = URI.create("/savingGoals/" + savedSavingGoal.getId());
        return ResponseEntity.created(location).body(savedSavingGoal);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        savingGoalService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<SavingGoal> updateSavingGoal(@PathVariable Long id, @RequestBody SavingGoal savingGoal){
        SavingGoal updatedSavingGoal = savingGoalService.update(id, savingGoal);
        return ResponseEntity.ok(updatedSavingGoal);
    }
}
