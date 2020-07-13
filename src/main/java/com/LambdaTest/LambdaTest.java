package com.LambdaTest;

/**
 * 推导lamdba表达式
 */
public class LambdaTest {

    // 3、静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("静态内部类");
        }
    }
    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // 4、局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("局部内部类");
            }
        }
        like = new Like3();
        like.lambda();

        // 5、匿名内部类
        like = new Like(){
            @Override
            public void lambda() {
                System.out.println("匿名内部类");
            }
        };
        like.lambda();

        // 6、lambda表达式
        like = () -> System.out.println("lambda 表达式");
        like.lambda();
    }

}

// 1、定义一个函数式接口
interface ILike{
    void lambda();
}

// 2、实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("实现类");
    }
}


