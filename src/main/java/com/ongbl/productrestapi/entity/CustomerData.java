package com.ongbl.productrestapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "cust_data")
public class CustomerData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data;

    @ManyToOne
    @JoinColumn(name = "batch_job_id")
    private BatchJob batchJob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BatchJob getBatchJob() {
        return batchJob;
    }

    public void setBatchJob(BatchJob batchJob) {
        this.batchJob = batchJob;
    }
}
