package model;

import java.util.ArrayList;

import object.Item;
import object.Requisition;
import object.RequisitionList;
import object.User;

public class EnteredRequisitionModel {
	
	/**������Ѻ Query �����ż��ӡ����Ժ������ҡ��ѧ� plant ����ͧ��� 
	 * @param String ����к� plant ����ͧ�����ª��ͼ�����Ժ������ �� 0301 
	 * @return ArrayList �������ª��ͧ͢���������ö��Ժ�����ҡ��ѧ � plant ����Ѻ������� input
	 * @author Nattapon Worasakdapisan
	 */
	public static ArrayList<User> getPicker( String plant, String storeroom ){
		ArrayList<User> picker = new ArrayList<User>();
		
//////////////////////////////////////////////////////////////////////////////
		int id = 1;
		String firstname = "�Ѱ��" ;
		String lastname = "���ѡ�Ҿ����";
		String empID = "97912531";
		String email = "nattapon_wora@hotmail.com";
		String usergroup = "admin";
		picker.add( new User( id, firstname, lastname, empID, email, usergroup, plant, storeroom ) ) ;
		
		id = 2;
		firstname = "�ҹ�" ;
		lastname = "��˹";
		empID = "97912532";
		email = "mana_painhi@hotmail.com";
		usergroup = "picker";
		picker.add( new User( id, firstname, lastname, empID, email, usergroup, plant, storeroom ) ) ;
		
		id = 3;
		firstname = "����" ;
		lastname = "�෾������";
		empID = "97912533";
		email = "little_angle@hotmail.com";
		picker.add( new User( id, firstname, lastname, empID, email, usergroup, plant, storeroom ) ) ;
		
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
		Item i = new Item(70000, 1, "Item1" , "S12-01-01-02" , 1 , 97912531);
		Item j = new Item(70000, 2, "Item2" , "S12-01-01-03" , 2 , 97912531);
		Item k = new Item(70000, 3, "Item3" , "S12-03-04-03" , 1 , 97912531);
		Requisition r = new Requisition( 97912531, "0301", 70000 );
		r.addItem(i);
		r.addItem(j);
		r.addItem(k);
		reqList.add(r);
		i = new Item(70001, 2, "Item2" , "S12-01-01-03" , 1 , 97912532);
		j = new Item(70001, 3, "Item3" , "S12-03-04-03" , 1 , 97912532);
		k = new Item(70001, 4, "Item4" , "S12-04-01-02" , 2 , 97912532);
		r = new Requisition( 97912532, "0301", 70001 );
		r.addItem(i);
		r.addItem(j);
		r.addItem(k);
		reqList.add(r);
		i = new Item(70002, 1, "Item1" , "S12-01-01-02" , 4 , 97912534);
		j = new Item(70002, 2, "Item2" , "S12-01-01-03" , 3 , 97912534);
		r = new Requisition( 97912534, "0301", 70002 );
		r.addItem(i);
		r.addItem(j);
		reqList.add(r);
		return reqList;
	}

}
