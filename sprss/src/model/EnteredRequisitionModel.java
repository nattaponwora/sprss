package model;

import java.util.ArrayList;

import object.Item;
import object.Requisition;

public class EnteredRequisitionModel {
	
	/**������Ѻ Query �����ż��ӡ����Ժ������ҡ��ѧ� plant ����ͧ��� 
	 * @param String ����к� plant ����ͧ�����ª��ͼ�����Ժ������ �� 0301 
	 * @return ArrayList �������ª��ͧ͢���������ö��Ժ�����ҡ��ѧ � plant ����Ѻ������� input
	 * @author Nattapon Worasakdapisan
	 */
	public static ArrayList<String> getPicker( String plant ){
		ArrayList<String> picker = new ArrayList<String>(); 
		picker.add("�ҹ�  ��˹");
		picker.add("����  ෾������");
		picker.add("�����ѹ  �ѹ����ͧ");
		return picker;
	}
	
	/**Query ��������ԡ����������ʶҹ��� Entered ������
	 * 
	 * @param plant ==> String ����к� plant ����ͧ�����Ժ������
	 * @param storeroom ==> String ����к� storeroom ����ͧ�����Ժ������ 
	 * @return ��������ԡ���������ѧ�������Ժ������ ���繢����Ū�Դ ArrayList<Requisition>
	 * @author Nattapon Worasakdapisan
	 */
	public static ArrayList<Requisition> getEnterReqList(String plant){
		ArrayList<Requisition> reqList = new ArrayList<Requisition>();
		Item i = new Item(1, "Item1" , "S12-01-01-02" , 1);
		Item j = new Item(2, "Item2" , "S12-01-01-03" , 2);
		Item k = new Item(2, "Item3" , "S12-03-04-03" , 1);
		//reqList.add();
		Requisition r = new Requisition(null, 0, null, 0);
		return reqList;
	}
}
