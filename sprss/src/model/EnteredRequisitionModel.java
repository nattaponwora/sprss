package model;

import java.util.ArrayList;

public class EnteredRequisitionModel {
	
	/**������Ѻ Query �����ż��ӡ����Ժ������ҡ��ѧ� plant ����ͧ��� 
	 * @param String ����к� plant ����ͧ�����ª��ͼ�����Ժ������ �� 0301 
	 * @return ArrayList �������ª��ͧ͢���������ö��Ժ�����ҡ��ѧ � plant ����Ѻ������� input
	 */
	public static ArrayList<String> getPicker( String plant ){
		ArrayList<String> picker = new ArrayList<String>(); 
		picker.add("�ҹ�  ��˹");
		picker.add("����  ෾������");
		picker.add("�����ѹ  �ѹ����ͧ");
		return picker;
	}
}
