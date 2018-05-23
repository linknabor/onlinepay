package com.eshequ.rollingservice.service.liquidate.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eshequ.rollingservice.service.liquidate.LiquidateService;
import com.eshequ.rollingservice.util.FtpUtil;
import com.eshequ.rollingservice.vo.HuifuFile;

@Service
public class HuifuLiquidateImpl implements LiquidateService{

	@Override
	public void startLiquidate(String liquidateDate) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 获取要清算的文件,解析成相应的实体对象
	 * @return
	 */
	private String[] getLiquidateFile() {
		
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.new FtpParams("www.e-shequ.com", "21", "", "ftp-huifu", "Abcd1234", null, null);
		String[]filePath = ftpUtil.get("e:\\ftpFiles\\", "/ftp-huifu");;
		System.out.println(filePath[0]);
		
//		List<HuifuFile> fileList = new ArrayList<>();
//		
//		for (String path : filePath) {
//			
//			HuifuFile huifuFile = parseFile(path);
//			fileList.add(huifuFile);
//			
//		}
//		return fileList;
		return filePath;
		
	}
	
	private HuifuFile parseFile(String localFilePath) {
		
		File csv = new File(localFilePath);  // CSV文件路径
	    BufferedReader br = null;
	    try{
	        br = new BufferedReader(new FileReader(csv));
	    } catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    String line = "";
	    String everyLine = "";
	    try {
	            List<String> allString = new ArrayList<>();
	            while ((line = br.readLine()) != null)  //读取到的内容给line变量
	            {
	                everyLine = line;
	                System.out.println(everyLine);
	                allString.add(everyLine);
	            }
	            System.out.println("csv表格中所有行数："+allString.size());
	    } catch (IOException e)
	    {
	        e.printStackTrace();
	    }

		return null;
	}
	
	private void doLiquidate(String liquidateDate) {

		
		
		
	}
	

}
