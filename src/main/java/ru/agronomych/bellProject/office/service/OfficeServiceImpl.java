package ru.agronomych.bellProject.office.service;

import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bellProject.office.dao.OfficeDao;
import ru.agronomych.bellProject.office.model.Office;
import ru.agronomych.bellProject.office.view.OfficeView;
import ma.glasnost.orika.*;

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
        officeDao.save(ViewToOffice(officeView));
    }

    @Override
    public void updateOffice(OfficeView officeView){
        officeDao.update(ViewToOffice(officeView));
    }

    @Override
    public OfficeView loadById(int id){
        return OfficeToView(officeDao.loadById(id));
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

    private Office ViewToOffice(OfficeView view){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OfficeView.class,Office.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(view,Office.class);
    }

    private OfficeView OfficeToView(Office office){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OfficeView.class,Office.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(office,OfficeView.class);
    }
}
