package com.ongbl.productrestapi.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "batch_job")
public class BatchJob {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "batchJob", cascade = CascadeType.MERGE)
    private List<CustomerData> custDataList;

    private String jobRelatedData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CustomerData> getCustDataList() {
        return custDataList;
    }

    public void setCustDataList(List<CustomerData> custDataList) {
        this.custDataList = custDataList;
    }

    public String getJobRelatedData() {
        return jobRelatedData;
    }

    public void setJobRelatedData(String jobRelatedData) {
        this.jobRelatedData = jobRelatedData;
    }
}
