package util;

public class StringUtil {

	//�ж��Ƿ�Ϊ��
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {    //trim()ȥ���ַ������˿ո�
			return true;
		}else {
			return false;
		}
	}
	
	//�ж��Ƿ�Ϊ��
	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
}
