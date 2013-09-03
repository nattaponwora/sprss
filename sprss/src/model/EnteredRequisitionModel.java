package model;

import java.util.ArrayList;

import object.Item;
import object.Requisition;
import object.RequisitionList;

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
	 * @return ��������ԡ���������ѧ�������Ժ������ ���繢����Ū�Դ RequisitionList
	 * @author Nattapon Worasakdapisa
	 */
	public static RequisitionList getEnterReqList(String plant){
		RequisitionList reqList = new RequisitionList();
		Item i = new Item(70000, 1, "Item1" , "S12-01-01-02" , 1);
		Item j = new Item(70000, 2, "Item2" , "S12-01-01-03" , 2);
		Item k = new Item(70000, 3, "Item3" , "S12-03-04-03" , 1);
		Requisition r = new Requisition( 97912531, "0301", 70000 );
		r.addItem(i);
		r.addItem(j);
		r.addItem(k);
		reqList.add(r);
		i = new Item(70001, 2, "Item2" , "S12-01-01-03" , 1);
		j = new Item(70001, 3, "Item3" , "S12-03-04-03" , 1);
		k = new Item(70001, 4, "Item4" , "S12-04-01-02" , 2);
		r = new Requisition( 97912532, "0301", 70001 );
		r.addItem(i);
		r.addItem(j);
		r.addItem(k);
		reqList.add(r);
		i = new Item(70002, 1, "Item1" , "S12-01-01-02" , 4);
		j = new Item(70002, 2, "Item2" , "S12-01-01-03" , 3);
		r = new Requisition( 97912534, "0301", 70002 );
		r.addItem(i);
		r.addItem(j);
		reqList.add(r);
		return reqList;
	}
}
