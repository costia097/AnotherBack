package com.domain.entities;

import com.domain.TestClass;
import com.domain.TestInterface;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Proxy;

@Entity
@Table(name = "test_entity")
@Data
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String value;


    public static void main(String[] args) {
        TestClass testEntity = new TestClass();
        Class<? extends TestClass> aClass = testEntity.getClass();
        TestInterface o = (TestInterface) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), (proxy, method, args1) -> {
            System.out.println("Before invoke");
            Object invoke = method.invoke(new TestClass(), args1);
            System.out.println("After invoke");
            return invoke;
        });
        o.method();
    }
}
