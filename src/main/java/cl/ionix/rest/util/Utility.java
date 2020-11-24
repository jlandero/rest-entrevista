package cl.ionix.rest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Utility {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		/**
		 * Valida formato email
		 * @param emailStr
		 * @return
		 */
		public static boolean validateEmail(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.find();
		}
		/**
		 * Valida Rut
		 * @param rut
		 * @return
		 */
		public static Boolean validaRut ( String rut ) {
			Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
			Matcher matcher = pattern.matcher(rut);
			if ( matcher.matches() == false ) return false;
			String[] stringRut = rut.split("-");
			return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
		}
		
		/**
		 * Valida DV
		 * @param rut
		 * @return
		 */
		private static String dv ( String rut ) {
			Integer M=0,S=1,T=Integer.parseInt(rut);
			for (;T!=0;T=(int) Math.floor(T/=10))
				S=(S+T%10*(9-M++%6))%11;
			return ( S > 0 ) ? String.valueOf(S-1) : "k";		
		}
		
		/**
		 * Genera String de respuesta
		 * @param responseServices
		 * @param timeTotal
		 * @return
		 */
		public static String mapeoNuevoObjeto (String responseServices, long timeTotal) {
			
			JsonObject jsonObject = JsonParser.parseString(responseServices).getAsJsonObject();			
			JsonObject resultObject = jsonObject.getAsJsonObject("result");
			jsonObject.remove("result");			
			jsonObject.addProperty("elapsedTime", timeTotal);			
			JsonObject items = new JsonObject();
			items.addProperty("registerCount", resultObject.getAsJsonArray("items").size());		
			jsonObject.add("result", items);
			return jsonObject.toString();			
		}		

}
