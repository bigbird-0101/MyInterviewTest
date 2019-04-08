package com.designtype.factory;

/**
 * 抽象工厂模式   
 * 抽象工厂是批量生产产品  而工厂方法设计模式，是生产单个的产品 
 * 工厂抽象类中定义了多个抽象方法而已
 * 时间:2019年2月15日
 * @author pefuxc
 *
 */
public class TestAbstractFactory {
	public static void main(String[] args) {
		//创建黑色轮子 和白色轮子  尺码都为1的
		AbstractFactory aAbstractFactory=new TestAbstractFactory().new AbstractFactory1();
		AbstractProduct1 aAbstractProduct1=aAbstractFactory.makeAbstractProduct1();
		aAbstractProduct1.make();
		AbstractProduct2 aAbstractProduct2=aAbstractFactory.makeAbstractProduct2();
		aAbstractProduct2.make();
	}
	//白色轮子 大小不一
	private class AbstractProduct1{
		public void make(){
        }
	}
	//黑色轮子
    private class AbstractProduct2{
    	public void make(){
        }
	}
    class Product1 extends AbstractProduct1{
         @Override
		 public void make(){
        	 System.out.println("生产白色轮子  尺码为1");
         }
    }
    class Product2 extends AbstractProduct1{
    	 @Override
		 public void make(){
        	 System.out.println("生产白色轮子  尺码为2");
         }
    }
	class Product3 extends AbstractProduct2{
		@Override
		public void make(){
       	 System.out.println("生产黑色轮子  尺码为1");
        }
	}
	class Product4 extends AbstractProduct2{
		@Override
		public void make(){
	       	 System.out.println("生产黑色轮子  尺码为2");
	    }
	}
	abstract class AbstractFactory{
		abstract AbstractProduct1 makeAbstractProduct1();
		abstract AbstractProduct2 makeAbstractProduct2();
	}
	
	/** 建白色轮子 尺码 为1   建黑色轮子 尺码为1
	 * 时间:2019年2月15日
	 * @author pefuxc
	 *
	 */
	class AbstractFactory1 extends AbstractFactory{

		@Override
		AbstractProduct1 makeAbstractProduct1() {
			return new Product1();
		}

		@Override
		AbstractProduct2 makeAbstractProduct2() {
			return new Product3();
		}
		
	}
	
	/**
	 * 建白色轮子 尺码 为2   建黑色轮子 尺码为2
	 * 时间:2019年2月15日
	 * @author pefuxc
	 *
	 */
	class AbstractFactory2 extends AbstractFactory{

		@Override
		AbstractProduct1 makeAbstractProduct1() {
			return new Product2();
		}

		@Override
		AbstractProduct2 makeAbstractProduct2() {
			return new Product4();
		}
		
	}
	
}
