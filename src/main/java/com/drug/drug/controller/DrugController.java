package com.drug.drug.controller;

import com.drug.drug.exception.DrugNotFoundException;
import com.drug.drug.model.Drug;
import com.drug.drug.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class DrugController {
    @Autowired
    private DrugRepository drugRepository;
    @PostMapping("/drug")
    Drug newDrug(@RequestBody Drug newDrug){
        return  drugRepository.save(newDrug);
    }


    @GetMapping("/drugs")
    List<Drug> getAllDrugs(){
        return  drugRepository.findAll();
    }

    @GetMapping("/drug/{id}")
    Drug getDrugById(@PathVariable Long id){
        return  drugRepository.findById(id).orElseThrow(()-> new DrugNotFoundException(id));
    }


    @PutMapping("/drug/{id}")
    Drug updateDrugs(@RequestBody Drug newDrug, @PathVariable Long id){
        return  drugRepository.findById(id)
                .map(drug -> {
                    if(newDrug.getDrugName() != null){
                        drug.setDrugName(newDrug.getDrugName());
                    }
                    if(newDrug.getBrandName() != null){
                        drug.setBrandName(newDrug.getBrandName());
                    }

                    if(newDrug.getStatus() != null){
                        drug.setStatus(newDrug.getStatus());
                    }

                    return  drugRepository.save(drug);
                }).orElseThrow(()-> new DrugNotFoundException(id));

    }


    @DeleteMapping("/drug/{id}")
    String deleteDrugById(@PathVariable Long id){
        if(!drugRepository.existsById(id)){
            throw  new DrugNotFoundException(id);
        }

        drugRepository.deleteById(id);

        return  "Drug with drugId " + "has been deleted successfully";
    }


}
