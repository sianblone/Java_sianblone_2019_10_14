package com.biz.exam.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.exam.domain.BBsVO;

public class BBsReadServiceImpV1 implements BBsReadService {
	
	private List<BBsVO> bbsList;
	
	public BBsReadServiceImpV1() {
		bbsList = new ArrayList<>();
	}

	@Override
	public void readBBs(String bbsFile) {
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(bbsFile);
			br = new BufferedReader(fr);
			while(true) {
				String read = br.readLine();
				if(read == null) break;
				BBsVO vo = new BBsVO();
				String[] readSplit = read.split(":");
				vo.setSeq( Integer.valueOf(readSplit[0]) );
				vo.setAuth(readSplit[1]);
				vo.setDate( Integer.valueOf(readSplit[2]) );
				vo.setSubject(readSplit[3]);
				vo.setText(readSplit[4]);
				vo.setCount( Integer.valueOf(readSplit[5]) );
				
				bbsList.add(vo);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BBsVO> getBBsList() {
		return bbsList;
	}
	
	

}
