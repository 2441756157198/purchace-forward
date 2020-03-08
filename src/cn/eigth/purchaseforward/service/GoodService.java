package cn.eigth.purchaseforward.service;

import cn.eigth.purchaseforward.pojo.Good;

import java.util.List;

public interface GoodService {
   boolean addGood(Good good);
   List<Good> findGoodByCriteria(Good good);
   List<Good> findGoodAll(int pageNow,int pageSize);
   int findTotalRecord();
   boolean modifyGood(Good good);
   boolean removeGood(int id);
}
