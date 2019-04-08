package com.designtype.factory;

/**
 * �����������ģʽ    ����Ϊ������ ��ʵ���������ڹ�����ʵ�����������������н���ʵ����
 * ʱ��:2019��2��15��
 * @author pefuxc
 *
 */
public class TestFactoryMethod {
	public static void main(String[] args) {
		Factory1 aFactory1=new Factory1();
		aFactory1.make();
		ProductMethod aProductMethod=aFactory1.get();
		aProductMethod.make();
	}
}

abstract class Factory{
	abstract ProductMethod make();
	public ProductMethod get(){
		return make();
	}
}

interface ProductMethod{
	void make();
}

class ProductMethod1 implements ProductMethod {

	@Override
	public void make() {
		System.out.println("���ɫ����");
	}
	
}

class ProductMethod2 implements ProductMethod {

	@Override
	public void make() {
		System.out.println("���ɫɫ����");
	}
	
}

class Factory1 extends Factory {

	@Override
    ProductMethod make() {
		return new ProductMethod1();
	}
	
}

class Factory2 extends Factory {

	@Override
    ProductMethod make() {
		return new ProductMethod2();
	}
	
}