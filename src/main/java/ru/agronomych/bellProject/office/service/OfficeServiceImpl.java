package ru.agronomych.bellProject.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bellProject.office.dao.OfficeDao;
import ru.agronomych.bellProject.office.view.OfficeView;

import java.util.List;

public class OfficeServiceImpl implements OfficeService{

    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao){
        this.officeDao = officeDao;
    }

    @Override
    public List<OfficeView> offices(){
        List<OfficeView> offices = null;
        return offices;
    }

    @Override
    public void saveOffice(OfficeView office){

    }

    @Override
    public void updateOffice(OfficeView office){

    }

    @Override
    public OfficeView loadById(int id){
        OfficeView office = null;
        return office;
    }
}
