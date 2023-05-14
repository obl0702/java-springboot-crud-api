package com.ongbl.productrestapi.bootstrap;

import com.ongbl.productrestapi.entity.BatchJob;
import com.ongbl.productrestapi.entity.CustomerData;
import com.ongbl.productrestapi.repositories.BatchJobRepository;
import com.ongbl.productrestapi.repositories.CustomerDataRepository;
import com.ongbl.productrestapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoad implements CommandLineRunner {

    @Autowired
    ProductService productService;

    @Autowired
    private CustomerDataRepository customerDataRepository;

    @Autowired
    private BatchJobRepository batchJobRepository;


    @Override
    public void run(String... args) throws Exception {

        productService.getAllProducts(0,100,"code")
                .stream().forEach(System.out::println);

        CustomerData c1 = new CustomerData();
        c1.setData("1111");
        customerDataRepository.save(c1);

        CustomerData c2 = new CustomerData();
        c2.setData("2222");
        customerDataRepository.save(c2);

        CustomerData c3 = new CustomerData();
        c3.setData("2222");
        customerDataRepository.save(c3);

        List<CustomerData> customerDataList = customerDataRepository.findALlByData("2222");

        BatchJob bb = new BatchJob();
        bb.setJobRelatedData("DDDFFF");
        batchJobRepository.save(bb);

        for(CustomerData data: customerDataList){
            data.setBatchJob(bb);
            customerDataRepository.save(data);
        }

    }
}
