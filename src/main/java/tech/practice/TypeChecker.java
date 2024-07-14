package tech.practice;

public class TypeChecker {
	public static String checkTpye(Object value) {
		if(value instanceof String)
			return "String";
		else if(value instanceof Integer)
			return "Integer";
		else if(value instanceof Double)
			return "Double";
		else if(value instanceof Boolean)
			return "Boolean";
		else if(value instanceof Float)
			return "Float";
		else if(value instanceof Long)
			return "Long";
		else
			return "Unkonwn";
	}
}
