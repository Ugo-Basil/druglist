package com.drug.drug.model;

import com.drug.drug.enums.DrugStatus;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  Long id;

    @Column
    @NonNull
    private String drugName;

    @Column
    @NonNull
    private  String brandName;

    @Column
    @Enumerated(EnumType.STRING)
    @NonNull
    private DrugStatus status;

    public Drug() {
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @NonNull
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(@NonNull String drugName) {
        this.drugName = drugName;
    }

    @NonNull
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(@NonNull String brandName) {
        this.brandName = brandName;
    }

    @NonNull
    public DrugStatus getStatus() {
        return status;
    }

    public void setStatus(@NonNull DrugStatus status) {
        this.status = status;
    }
}
