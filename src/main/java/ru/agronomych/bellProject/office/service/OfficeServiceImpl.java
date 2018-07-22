package ru.agronomych.bellProject.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bellProject.office.dao.OfficeDao;
import ru.agronomych.bellProject.office.model.Office;
import ru.agronomych.bellProject.office.view.OfficeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OfficeServiceImpl implements OfficeService{

    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao){
        this.officeDao = officeDao;
    }

    @Override
    public List<OfficeView> offices(){
        List<Office> offices = officeDao.all();
        return offices.stream()
                .map(mapOffice())
                .collect(Collectors.toList());
    }

    @Override
    public void saveOffice(OfficeView officeView){
        Office office = new Office();
        if (officeView.isActive!=null) office.setActive(officeView.isActive);
        if (officeView.address!=null) office.setAddress(officeView.address);
        if (officeView.name!=null) office.setName(officeView.name);
        if (officeView.orgId!=null) office.setOrgId(officeView.orgId);
        if (officeView.phone!=null) office.setPhone(officeView.phone);
        officeDao.save(office);
    }

    @Override
    public void updateOffice(OfficeView officeView){
        Office office = new Office();
        if (officeView.isActive!=null) office.setActive(officeView.isActive);
        if (officeView.address!=null) office.setAddress(officeView.address);
        if (officeView.name!=null) office.setName(officeView.name);
        if (officeView.orgId!=null) office.setOrgId(officeView.orgId);
        if (officeView.phone!=null) office.setPhone(officeView.phone);
        officeDao.update(office);
    }

    @Override
    public OfficeView loadById(int id){
        Office office;
        OfficeView view = null;
        office = officeDao.loadById(id);
        if (office.getActive()!=null) view.isActive = office.getActive();
        if (office.getOrgId()!=null) view.orgId = office.getOrgId();
        if (office.getName()!=null) view.name = office.getName();
        if (office.getPhone()!=null) view.phone = office.getPhone();
        if (office.getAddress()!=null) view.address = office.getAddress();
        return view;
    }

    private Function<Office,OfficeView> mapOffice(){
        return o -> {
            OfficeView view = new OfficeView();
            view.address = o.getAddress();
            view.isActive = o.getActive();
            view.name = o.getName();
            view.orgId = o.getOrgId();
            return view;
        };
    }
}
