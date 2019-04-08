package com.designtype.factory;
/**
 * ʱ��:2019��2��15��
 * @author pefuxc
 *
 */
public class TestSimpleFactory {

	public static void main(String[] args) {
		SimpleFactory aSimpleFactory=new SimpleFactory();
		//�����ɫ������
		Product aProduct=aSimpleFactory.createObject(1);
		aProduct.make();
	}
}

/**
 * �򵥹���ģʽ      ����һ���ӿ� ���ڹ����ڲ�����ʵ����
 * ʱ��:2019��2��15��
 * @author pefuxc
 *
 */
class SimpleFactory{
	public Product createObject(int type){
		if(type==1){
			return new Object1();
		}else if(type==2){
			return new Object2();
		}else if(type==3){
			return new Object3();
		}
		return null;
	}
}

/**
 * ���ӽӿ�
 * ʱ��:2019��2��15��
 * @author pefuxc
 *
 */
interface Product{
	//�����ӷ���
	public void make();
}

/**
 * ��ɫ������
 * ʱ��:2019��2��15��
 * @author pefuxc
 *
 */
class Object1 implements Product {

	@Override
	public void make() {
		System.out.println("��һ����ɫ����");
	}
	
}

/**
 * ��ɫ������
 * ʱ��:2019��2��15��
 * @author pefuxc
 *
 */
class Object2 implements Product {

	@Override
	public void make() {
		System.out.println("��һ����ɫ����");
	}
	
}

/**
 * ��ɫ������
 * ʱ��:2019��2��15��
 * @author pefuxc
 *
 */
class Object3 implements Product {

	@Override
	public void make() {
		System.out.println("��һ����ɫ����");
	}
	
}
