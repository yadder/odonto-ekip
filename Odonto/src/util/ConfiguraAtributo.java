package util;

import java.text.SimpleDateFormat;

public class ConfiguraAtributo {
	
	public java.sql.Date dataStringParaDataSql(String data){
		// PARA GRAVAR NO BANCO
		java.sql.Date dataSQL = null;
		try{
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
	        java.util.Date dataUtil = df.parse(data);
	        dataSQL = new java.sql.Date(dataUtil.getTime());  
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return dataSQL;
	}
	
	public String dataSqlParaDataString(java.util.Date dataUtil){
		// BUSCA DO BANCO
		String dataString = null;
		try{
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
			dataString = df.format(dataUtil);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return dataString;
	}

}
