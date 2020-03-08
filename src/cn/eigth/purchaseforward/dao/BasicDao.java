package cn.eigth.purchaseforward.dao;

import cn.eigth.purchaseforward.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasicDao {

    public ResultSet execQuery(Connection con, PreparedStatement pst,Object...params){
        ResultSet rs = null;
        try {
            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
        }



    public void execUpdate(Connection con, PreparedStatement pst, Object...params) throws SQLException {
//针对占位符
        if(params!=null){
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1,params[i]);
            }
        }
           pst.executeUpdate();
    }


    public void releaseResource(ResultSet rs,PreparedStatement pst,Connection con){
        try {
            if(rs !=null){
                rs.close();
            }
            if(pst !=null){
                pst.close();
            }
            if(con !=null){
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection con=DbPool.getConnection();
        String sql="insert user(username,password,rule,email,qq) value(?,?,?,?,?)";
        BasicDao dao=new BasicDao();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            dao.execUpdate(con,pst,"admin","123456",0,null,null);
            dao.releaseResource(null,pst,con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    }

