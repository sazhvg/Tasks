package com.ua.sazhyn.volodymyr.springtask.service;

import com.ua.sazhyn.volodymyr.springtask.exception.DataRegistrationException;
import com.ua.sazhyn.volodymyr.springtask.repository.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonService {

    public void register(Data data){
        if (Data.getData().contains(data)){
            throw new DataRegistrationException(
                    String.format("Інформація повторно не зберігається.", data));
        }
        Data.add(data);
    }
}
