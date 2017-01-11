package com.atguigu.crowdfunding.cpes.service.i;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.cpes.bean.CertAcc;
import com.atguigu.crowdfunding.cpes.bean.CertImg;
import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;

public interface CertImgService {

	Page<CertImg> getPagedCertImgs(Map<String, Object> paraMetersMap);

	void insert(CertImg certImg);

	CertImg getCertImgById(Integer certId);

	void update(CertImg certImg);

	void delete(Datas datas);

	List<CertImg> getAllCertImgs();

	void insertCertImg(Map<String, Object> pMap);

	void deleteCertImg(Map<String, Object> pMap);

	List<CertAcc> getAsignedCerts();

}
