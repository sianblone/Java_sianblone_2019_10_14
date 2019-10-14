package com.biz.exam.service;

import java.util.Collections;
import java.util.List;

import com.biz.exam.domain.BBsVO;

public class BBsViewServiceImpV1 implements BBsViewService {
	
	private List<BBsVO> bbsList;

	@Override
	public void setBBsList(List<BBsVO> bbsList) {
		this.bbsList = bbsList;
	}

	@Override
	public void viewBBS() {
		this.viewHeader();
		for(BBsVO vo : bbsList) {
			System.out.printf("%d\t%-15s\t%-40s\t%-10s\t%d\t%d\n",
					vo.getSeq(),
					vo.getSubject(),
					vo.getText(),
					vo.getAuth(),
					vo.getDate(),
					vo.getCount());
		}
	}

	@Override
	public void viewBBS(String subject) {
		this.viewHeader();
		for(BBsVO vo : bbsList) {
			if(vo.getSubject().contains(subject)) {
				System.out.printf("%d\t%-15s\t%-40s\t%-10s\t%d\t%d\n",
							vo.getSeq(),
							vo.getSubject(),
							vo.getText(),
							vo.getAuth(),
							vo.getDate(),
							vo.getCount());
			}
		}
		
	}

	@Override
	public void viewBBS(int sDate, int eDate) {
		this.viewHeader();
		for(BBsVO vo : bbsList) {
			if(vo.getDate() >= sDate && vo.getDate() <= eDate) {
				System.out.printf("%d\t%-15s\t%-40s\t%-10s\t%d\t%d\n",
							vo.getSeq(),
							vo.getSubject(),
							vo.getText(),
							vo.getAuth(),
							vo.getDate(),
							vo.getCount());
			}
		}
	}

	@Override
	public void viewBBS(boolean sort) {
		this.viewHeader();
		Collections.sort(bbsList);
		if(!sort) Collections.reverse(bbsList);
		for(BBsVO vo : bbsList) {
			 {
				System.out.printf("%d\t%-15s\t%-40s\t%-10s\t%d\t%d\n",
							vo.getSeq(),
							vo.getSubject(),
							vo.getText(),
							vo.getAuth(),
							vo.getDate(),
							vo.getCount());
			}
		}
		
	}
	
	private void viewHeader() {
		System.out.println("===================================================================================================================================");
		System.out.printf("%s\t%-15s\t%-50s\t%-10s\t%s\t%s\n", "번호","제목","내용","작성자","작성일자","조회수");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
	}

}
