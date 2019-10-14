package com.biz.exam.exec;

import java.util.Scanner;

import com.biz.exam.service.BBsReadServiceImpV1;
import com.biz.exam.service.BBsViewServiceImpV1;

public class BBsEx_01 {

	public static void main(String[] args) {
		BBsReadServiceImpV1 br = new BBsReadServiceImpV1();
		BBsViewServiceImpV1 bv = new BBsViewServiceImpV1();
		Scanner scan = new Scanner(System.in);
		String bbsFile = "src/com/biz/exam/bbs.txt";
		
		br.readBBs(bbsFile);
		bv.setBBsList(br.getBBsList());
		
		while(true) {
			System.out.println("====================================================================");
			System.out.println("게시판 관리 시스템 v1");
			System.out.println("====================================================================");
			System.out.println("1.전체  2.제목  3.날짜  4.정렬  0.종료");
			System.out.println("--------------------------------------------------------------------");
			System.out.print("업무선택 >>");
			
			String check = scan.nextLine(); 
			if(check.equals("1")) {
				bv.viewBBS();
			} else if(check.equals("2")) {
				System.out.print("검색할 제목을 입력해주세요 >>");
				check = scan.nextLine();
				bv.viewBBS(check);
			} else if(check.equals("3")) {
				System.out.print("검색할 시작 날짜를 입력해주세요 >>");
				check = scan.nextLine();
				int sDate = Integer.valueOf(check);
				System.out.print("검색할 마지막 날짜를 입력해주세요 >>");
				check = scan.nextLine();
				int eDate = Integer.valueOf(check);
				bv.viewBBS(sDate, eDate);
			} else if(check.equals("4")) {
				System.out.print("1.오름차순 정렬  2.내림차순 정렬 >>");
				check = scan.nextLine();
				if(check.equals("1"))
					bv.viewBBS(true);
				else if(check.equals("2"))
					bv.viewBBS(false);
			} else if(check.equals("0")) {
				System.out.println("검색을 종료합니다");
				break;
			}
			
		}
		

	}

}
