package com.atguigu.crowdfunding.cpes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.cpes.bean.CertAcc;
import com.atguigu.crowdfunding.cpes.bean.CertImg;
import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.dao.CertImgMapper;
import com.atguigu.crowdfunding.cpes.service.i.CertImgService;

@Service
public class CertImgServiceImpl implements CertImgService{
	@Autowired
	private CertImgMapper certImgMapper ;

	@Override
	public Page<CertImg> getPagedCertImgs(Map<String, Object> paraMetersMap) {
		Page<CertImg> page = new Page<>();
		//查询数量
		int totalCounts = certImgMapper.getTotalCount();
		//查询分页数据
		List<CertImg> certImgs = certImgMapper.getAllPaged(paraMetersMap);
		
		//为page的各个属性(DataTable要求的属性)赋值
		int index = 1;
		for (CertImg certImg : certImgs) {
			certImg.setIndex(index++);
		}
		
		page.setRecordsFiltered(totalCounts);
		page.setData(certImgs);
		page.setRecordsFiltered(totalCounts);
		return page;
	}

	@Override
	public void insert(CertImg certImg) {
		certImgMapper.insert(certImg);
		
	}

	@Override
	public CertImg getCertImgById(Integer certId) {
		CertImg certImg = certImgMapper.getCertImg(certId);
		return certImg;
	}

	@Override
	public void update(CertImg certImg) {
		certImgMapper.update(certImg);
	}

	@Override
	public void delete(Datas datas) {
		certImgMapper.delete(datas);
		
	}

	@Override
	public List<CertImg> getAllCertImgs() {
		List<CertImg> certImgs = certImgMapper.getAll();
		return certImgs;
	}

	@Override
	public void insertCertImg(Map<String, Object> pMap) {
		certImgMapper.insertCertAccRelation(pMap);
	}

	@Override
	public void deleteCertImg(Map<String, Object> pMap) {
		certImgMapper.deleteCertAccRelation(pMap);
	}

	@Override
	public List<CertAcc> getAsignedCerts() {
		List<CertAcc> certImgs = certImgMapper.getAsignedCerts();
		return certImgs;
	}
	
}
