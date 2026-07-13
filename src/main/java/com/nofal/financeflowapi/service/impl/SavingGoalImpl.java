package com.nofal.financeflowapi.service.impl;

import com.nofal.financeflowapi.entity.SavingGoal;
import com.nofal.financeflowapi.repository.SavingGoalRepository;
import com.nofal.financeflowapi.service.SavingGoalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingGoalImpl implements SavingGoalService {

    public final SavingGoalRepository savingGoalRepository;

    public SavingGoalImpl(SavingGoalRepository savingGoalRepository){
        this.savingGoalRepository = savingGoalRepository;
    }

    @Override
    public SavingGoal save(SavingGoal savingGoal){
        return savingGoalRepository.save(savingGoal);
    }
    @Override
    public List<SavingGoal> findAll(){
        return  savingGoalRepository.findAll();
    }
    @Override
    public SavingGoal findById(Long id){
        return savingGoalRepository.findById(id).orElseThrow(() -> new RuntimeException("Saving Goal not found"));
    }
    @Override
    public void delete(Long id){
        savingGoalRepository.deleteById(id);
    }
    @Override
    public SavingGoal update(Long id, SavingGoal savingGoal){
        SavingGoal existingSavingGoal = savingGoalRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Saving Goal not found.")
        );
        existingSavingGoal.setTitle(savingGoal.getTitle());
        existingSavingGoal.setTargetAmount(savingGoal.getTargetAmount());
        existingSavingGoal.setCurrentAmount(savingGoal.getCurrentAmount());
        existingSavingGoal.setTargetDate(savingGoal.getTargetDate());

        return savingGoalRepository.save(existingSavingGoal);
    }


}
