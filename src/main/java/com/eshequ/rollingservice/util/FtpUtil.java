/**
 * 
 */
package com.eshequ.rollingservice.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.eshequ.rollingservice.exception.AppSysException;
import com.eshequ.rollingservice.exception.BusinessException;

/**
 * @author huym
 *
 */
public class FtpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(FtpUtil.class);
	private final static String DEFAULT_ENCODING = "UTF-8";
	
	private FTPClient ftpClient;
	private FtpParams ftpParams;
	
	public FtpUtil() {
		super();
	}
	
	/**
	 * 获取FTPClient 实例
	 * @param params
	 * @return
	 */
	private void initNewFtpInstance() {
		
		try {
			
			ftpClient = new FTPClient();
			int timeout = StringUtils.isEmpty(ftpParams.getTimeout())?3000:Integer.parseInt(ftpParams.getTimeout());
			ftpClient.setConnectTimeout(timeout);
			ftpClient.connect(ftpParams.getAddr(), Integer.parseInt(ftpParams.getPort()));
			ftpClient.login(ftpParams.getUsername(), ftpParams.getPassword());
			ftpClient.setControlEncoding(StringUtils.isEmpty(ftpParams.getEncoding())?DEFAULT_ENCODING:ftpParams.getEncoding());
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			int reply = ftpClient.getReplyCode();
			
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				throw new BusinessException("未连接到FTP，用户名或密码错误。");
			}
			logger.info("FTP连接成功。");
//			client.changeWorkingDirectory("/");//切换到根目录
		
		} catch (Exception e) {
			throw new AppSysException(e);
		}
		
	}
	
	/**
	 * FTP获取文件
	 * @param localDir
	 * @param remoteDir
	 * @param likeName
	 * @return
	 */
	public String[] get(String localDir, String remoteDir) {
		
		FTPFile[]ftpFiles = getFile(remoteDir);
		return writeFile(ftpFiles, localDir);
		
	}
	
	/**
	 * FTP获取文件
	 * @param localDir
	 * @param remoteDir
	 * @param likeName
	 * @return
	 */
	public String[] get(String localDir, String remoteDir, String likeName) {
		
		FTPFile[]ftpFiles = getFile(remoteDir);
		List<FTPFile> writeFiles = new ArrayList<>();
		for (FTPFile ftpFile : ftpFiles) {
			if (ftpFile.getName().contains(likeName)) {
				writeFiles.add(ftpFile);
			}
		}
		return writeFile(writeFiles.toArray(new FTPFile[0]), localDir);
		
	}
	
	/**
     * 下载链接配置
     * @param f
     * @param localBaseDir 本地目录
     * @param remoteBaseDir 远程目录
     * @throws Exception
     */
    private FTPFile[] getFile(String remoteDir ) {
        
    	FTPFile[] files = null; 
    	if (ftpClient!=null) {
            try {
                boolean changedir = ftpClient.changeWorkingDirectory(remoteDir); 
                if (changedir) { 
                    files = ftpClient.listFiles();
                    
                } 
            } catch (Exception e) { 
                throw new AppSysException(e);
            } 
        }else{
            throw new BusinessException("connect failed ! ");
        }
    	
        return files;
        
        
    }
	
	
    /**
     * 下载文件
     * @param ftpFiles
     * @param localDir
     */
    private String[] writeFile(FTPFile[]ftpFiles, String localDir) {
    	
    	String[]retFilePaht = new String[ftpFiles.length];
    	List<String> list = new ArrayList<>();
    	for (FTPFile ftpFile : ftpFiles) {
			
		 if (ftpFile.isFile()) {
        	OutputStream outputStream = null; 
            try { 
            	File entryDir = new File(localDir);
				//如果文件夹路径不存在，则创建文件夹
				if (!entryDir.exists() || !entryDir.isDirectory())
				{
					entryDir.mkdirs();
				}
				String filePath = localDir+ ftpFile.getName();
                File locaFile= new File(filePath); 
                //判断文件是否存在，存在则返回 
                if(locaFile.exists()){
                	//do nothing
                }else{ 
                    outputStream = new FileOutputStream(filePath); 
                    ftpClient.retrieveFile(ftpFile.getName(), outputStream); 
                    outputStream.flush(); 
                    outputStream.close(); 
                }
                list.add(filePath);
                
            } catch (Exception e) {
            	throw new AppSysException(e);

            } finally { 
                try { 
                    if (outputStream != null){ 
                        outputStream.close();
                    }
                } catch (IOException e) { 
                   throw new AppSysException(e);
                } 
            }  
        }
    		
	}
		return list.toArray(retFilePaht);
    	
    	
       
    }
	
	public class FtpParams {
		
		private String addr;
		private String port;
		private String encoding;
		private String username;
		private String password;
		private String ftpMode;
		private String timeout;
		
		/**
		 * 
		 * @param addr	访问地址
		 * @param port	访问端口	
		 * @param encoding	字符集，默认UTF-8
		 * @param username	登录用户名
		 * @param password	登录密码
		 * @param ftpMode	模式，暂时不填写
		 * @param timeout	超时，默认3000
		 */
		public FtpParams(String addr, String port, String encoding, String username, String password, String ftpMode,
				String timeout) {
			super();
			this.addr = addr;
			this.port = port;
			this.encoding = encoding;
			this.username = username;
			this.password = password;
			this.ftpMode = ftpMode;
			this.timeout = timeout;
			
			ftpParams = this;
	    	initNewFtpInstance();

		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public String getEncoding() {
			return encoding;
		}

		public void setEncoding(String encoding) {
			this.encoding = encoding;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFtpMode() {
			return ftpMode;
		}

		public void setFtpMode(String ftpMode) {
			this.ftpMode = ftpMode;
		}

		public String getTimeout() {
			return timeout;
		}

		public void setTimeout(String timeout) {
			this.timeout = timeout;
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.new FtpParams("www.e-shequ.com", "21", "", "ftp-huifu", "Abcd1234", null, null);
		String[]filePath = ftpUtil.get("e:\\ftpFiles\\", "/ftp-huifu", "20180419");
		System.out.println(filePath[0]);
		
	}

}
