package util;

import java.text.SimpleDateFormat;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

	public boolean somenteLetras(String palavra) throws Exception{
		Pattern p = Pattern.compile("[A-Z a-z]+");
		Matcher m = p.matcher(palavra);
		if(m.matches()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validaEmail(String email) throws Exception{
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);
		if (m.matches()){
			return true;
		}else{
			return false;
		}
		//ponto equivale a qualquer digito
		// duas barras+ quantidade @ servidor 
	}
	
	
	public boolean validaTelefone(String telefone) throws Exception{
		Pattern p = Pattern.compile("[0-9]{4}-[0-9]{4}");
		Matcher m = p.matcher(telefone);
		if (m.matches()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean somenteNumeros(String numeros) throws Exception{
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(numeros);
		if (m.matches()){
			return true;
		}else{
			return false;
		}
	}
}
