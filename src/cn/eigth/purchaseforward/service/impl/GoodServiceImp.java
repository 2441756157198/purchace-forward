package cn.eigth.purchaseforward.service.impl;

import cn.eigth.purchaseforward.dao.GoodDao;
import cn.eigth.purchaseforward.pojo.Good;
import cn.eigth.purchaseforward.service.GoodService;

import java.util.List;

public class GoodServiceImp implements GoodService {
    private GoodDao goodDao=new GoodDao();
    @Override
    public boolean addGood(Good good) {
        return goodDao.insertGood(good);
    }

    @Override
    public List<Good> findGoodByCriteria(Good good) {
        return goodDao.queryGoodByCriteria(good);
    }

    @Override
    public List<Good> findGoodAll(int pageNow, int pageSize) {
        return goodDao.queryGoodAll(pageNow,pageSize);
    }

    @Override
    public int findTotalRecord() {
        return goodDao.findTotalRecord();
    }

    @Override
    public boolean modifyGood(Good good) {
        return goodDao.updateGood(good);
    }

    @Override
    public boolean removeGood(int id) {
        return goodDao.deleteGood(id);
    }
}
