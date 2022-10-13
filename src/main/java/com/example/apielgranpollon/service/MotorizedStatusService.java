package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.MotorizedStatus;
import java.util.Collection;

public interface MotorizedStatusService {
    //se define los servicios para los controladores
    public abstract void insert(MotorizedStatus motorizedStatus);
    public abstract void update(MotorizedStatus motorizedStatus);
    public abstract void delete(Integer motorizedStatusId);
    public abstract MotorizedStatus findById(Integer motorizedStatusId);
    public abstract Collection<MotorizedStatus> findAll();
}