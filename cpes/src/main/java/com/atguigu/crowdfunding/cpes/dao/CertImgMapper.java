package com.atguigu.crowdfunding.cpes.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crowdfunding.cpes.bean.CertAcc;
import com.atguigu.crowdfunding.cpes.bean.CertImg;
import com.atguigu.crowdfunding.cpes.bean.Datas;

public interface CertImgMapper {

	int getTotalCount();

	List<CertImg> getAllPaged(Map<String, Object> paraMetersMap);

	void insert(CertImg certImg);

	CertImg getCertImg(@Param("certId")Integer certId);

	void update(CertImg certImg);

	void delete(Datas datas);

	List<CertImg> getAll();

	void deleteCertAccRelation(Map<String, Object> pMap);

	void insertCertAccRelation(Map<String, Object> pMap);

	List<CertAcc> getAsignedCerts();

}
